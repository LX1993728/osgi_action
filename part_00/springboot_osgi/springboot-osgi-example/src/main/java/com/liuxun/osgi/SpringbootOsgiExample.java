package com.liuxun.osgi;

import com.liuxun.osgi.utils.BundleUtils;
import org.osgi.framework.launch.Framework;
import org.osgi.framework.launch.FrameworkFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

@SpringBootApplication
public class SpringbootOsgiExample {

    public static void main(String[] args) throws Exception{

        /**
         * 这是一套统一的规范，不管使用了什么依赖进行的实现，这个都不变
         */
        ServiceLoader<FrameworkFactory> ffs = ServiceLoader.load(FrameworkFactory.class);
        FrameworkFactory ff = ffs.iterator().next();
        Map<String,String> config = new HashMap<>();
        // add some params to config ...
        Framework fwk = ff.newFramework(config);
        fwk.init();
        fwk.start();
        BundleUtils.framework = fwk;

        SpringApplication.run(SpringbootOsgiExample.class, args);
    }
}
