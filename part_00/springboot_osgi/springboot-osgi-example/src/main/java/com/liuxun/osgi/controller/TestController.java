package com.liuxun.osgi.controller;

import com.liuxun.osgi.utils.BundleUtils;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.launch.Framework;
import org.osgi.framework.launch.FrameworkFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

@RestController
public class TestController {



    @GetMapping("/test")
    public String test() throws Exception{
        ServiceLoader<FrameworkFactory> ffs = ServiceLoader.load(FrameworkFactory.class);
        FrameworkFactory ff = ffs.iterator().next();
        Map<String,String> config = new HashMap<>();
        // add some params to config ...
        Framework fwk = ff.newFramework(config);
        fwk.init();
        fwk.start();
        BundleUtils.framework = fwk;


//        final Framework framework = BundleUtils.framework;
//        BundleContext context = framework.getBundleContext();
//
//        Bundle provider = context.installBundle("file:/Users/liuxun//Downloads/test/bundles/springdm-provider-test-1.0.jar");
//        provider.start();
//        ServiceReference<?>[] registeredServices = provider.getRegisteredServices();
//        System.out.println(registeredServices.length);
//        provider.stop();
        return "测试是否能正常运行";
    }

}
