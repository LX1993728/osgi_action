package com.liuxun.osgi.controller;

import com.liuxun.osgi.utils.BundleUtils;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.launch.Framework;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @GetMapping("/test")
    public String test() throws Exception{
        final Framework framework = BundleUtils.framework;
        BundleContext context = framework.getBundleContext();

        Bundle provider = context.installBundle("file:////Users/liuxun//Downloads/test/bundles/com.liuxun.hello-1.0.jar");
        Bundle consumer = context.installBundle("file:////Users/liuxun/Downloads/test/bundles/com.liuxun.hello.client-1.0.jar");

        consumer.loadClass("com.liuxun.hello.client.Client").newInstance();
        return "测试是否能正常运行";
    }

}