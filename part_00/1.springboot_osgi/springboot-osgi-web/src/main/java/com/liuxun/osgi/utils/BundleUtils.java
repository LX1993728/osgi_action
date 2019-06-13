package com.liuxun.osgi.utils;

import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class BundleUtils {
    public static BundleContext bundleContext;

    /**
     * @apiNote 由OSGI自动的选择一个存在的service引用实现（根据Rank等一些权重值，一般在只存在单独版本时使用此方法）
     * @param serviceClass  服务类的class类型
     * @param <T>   服务类的对象类型
     * @return  返回服务类对象
     */
    public static <T> T findServiceDynamic(Class<T> serviceClass){
        final ServiceReference<T> reference = bundleContext.getServiceReference(serviceClass);
        if (reference != null){
            T service = bundleContext.getService(reference);
            return service;
        }
        return null;
    }

    /**
     * @param serviceClass  服务的接口类的class
     * @param bundleVersion 服务实现类所在bundle的版本
     * @param <T>           服务接口类型
     * @return 将首先找到符合条件的服务对象返回
     * @apiNote 根据Bundle即jar包的版本号找出对应的service实现
     */
    public static <T> T findServiceByBundleVersion(Class<T> serviceClass, String bundleVersion) {
        if (serviceClass == null || bundleVersion == null) {
            return null;
        }
        try {
            Collection<ServiceReference<T>> references = bundleContext.getServiceReferences(serviceClass, null);
            for (ServiceReference<T> ref : references) {
                final String bundleVer = ref.getBundle().getHeaders().get(Constants.BUNDLE_VERSION);
                if (bundleVersion != null && bundleVer.equals(bundleVersion)) {
                    final T service = bundleContext.getService(ref);
                    return service;
                }
            }
        } catch (InvalidSyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param serviceClass 服务的接口类的class
     * @param metadata     服务组件的的属性必须包含此map的所有键值对
     * @param <T>          服务接口类型
     * @return 注意：如果有多个符合条件，只将符合的第一个服务实现返回
     * @apiNote 根据服务组件的元数据属性进行服务查找
     */
    public static <T> T findServiceByComponentAttr(Class<T> serviceClass, Map<String, Object> metadata) {
        if (serviceClass == null || metadata == null || metadata.isEmpty()) {
            return null;
        }

        StringBuffer filterBuffer = new StringBuffer("(&");
        for (Map.Entry<String, Object> entry : metadata.entrySet()) {
            filterBuffer.append("(").append(entry.getKey()).append("=").append(entry.getValue()).append(")");
        }
        filterBuffer.append(")");
        String filterStr = filterBuffer.toString();
        System.out.println("filterStr= " + filterStr);
        final Collection<ServiceReference<T>> references;
        try {
            references = bundleContext.getServiceReferences(serviceClass, filterStr);
            for (ServiceReference<T> ref : references) {
                T service = bundleContext.getService(ref);
                return service;
            }
        } catch (InvalidSyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }
}
