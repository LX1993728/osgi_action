package com.liuxun.hello.main;

import com.liuxun.service.impl.GreetingImpl;
import org.osgi.framework.*;
import org.osgi.framework.launch.Framework;
import org.osgi.framework.launch.FrameworkFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

/**
 * @author liuxun
 */
public class Main {
    static Framework m_framework;

    public static void main(String[] args) throws Exception {
        try {
            ServiceLoader<FrameworkFactory> ffs = ServiceLoader.load(FrameworkFactory.class);
            FrameworkFactory frameworkFactory = ffs.iterator().next();
            Map<String,String> config = new HashMap<>();
            m_framework= frameworkFactory.newFramework(config);
            m_framework.init();
            m_framework.start();

            final BundleContext context = m_framework.getBundleContext();

            Bundle provider = context.installBundle("file:/Users/liuxun/Downloads/test/bundles/com.service.hello-1.0.jar");
            Bundle consumer = context.installBundle("file:/Users/liuxun/Downloads/test/bundles/com.liuxun.service.client-1.0.jar");

            m_framework.start();

            provider.start();

            ServiceReference[] registeredServices = provider.getRegisteredServices();
            System.out.println("services= " + registeredServices.length);


//            ServiceReference reference = context.getServiceReference(Greeting.class.getName());
//            System.out.println(Greeting.class.getName()+" ++++++ "+reference);
//            ((Greeting)context.getService(reference)).sayHello(" Maven build B ");


            BundleContext bundleContext = FrameworkUtil.getBundle(GreetingImpl.class).getBundleContext();
            ServiceReference<Greeting> serviceReference = bundleContext.getServiceReference(Greeting.class);
            Greeting service = bundleContext.getService(serviceReference);

            consumer.start();
            consumer.stop();
            provider.stop();

            m_framework.stop();

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}
