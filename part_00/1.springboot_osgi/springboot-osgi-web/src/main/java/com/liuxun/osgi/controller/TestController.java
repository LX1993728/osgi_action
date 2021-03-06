package com.liuxun.osgi.controller;

import com.liuxun.osgi.utils.BundleUtils;
//import com.service.api.Greeting;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import scr.ds.api.MyAnnotitationService;

import java.util.*;

@RestController
public class TestController {


    @GetMapping("/test")
    public String test() throws Exception {
        // 测试OSGI服务动态选择
        MyAnnotitationService service = BundleUtils.findServiceDynamic(MyAnnotitationService.class);
        if (service != null) {
            String dateStr = service.getPatternDateStr(new Date());
            System.out.println(dateStr);
            return dateStr;
        }
        return null;
    }

    @GetMapping("/test1")
    public Object test1() throws Exception {
        // 测试根据Service的Metadata属性进行服务查找
        Map<String, Object> meta = new HashMap<>();
        meta.put("version", "1.0");
        MyAnnotitationService service = BundleUtils.findServiceByComponentAttr(MyAnnotitationService.class, meta);
        if (service != null) {
            String dateStr = service.getPatternDateStr(new Date());
            System.out.println(dateStr);
            return dateStr;
        }
        return null;
    }

    @GetMapping("/test2")
    public Object test2(String version) throws Exception {
        // 测试根据Bundle version属性查找需要的service实现
        BundleContext context = BundleUtils.bundleContext;
        String bundleVersion = version == null ? "1.0" : version;
        MyAnnotitationService service = BundleUtils.findServiceByBundleVersion(MyAnnotitationService.class, bundleVersion);

        if (service != null) {
            String dateStr = service.getPatternDateStr(new Date());
            System.out.println(dateStr);
            return dateStr;
        }
        return null;
    }


}
