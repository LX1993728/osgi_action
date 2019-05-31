package com.liuxun.osgi.controller;

//import com.liuxun.osgi.utils.BundleUtils;
//import com.liuxun.service.Greeting;
import com.liuxun.osgi.utils.BundleUtils;
import com.liuxun.service.Greeting;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.launch.Framework;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class TestController {


    @GetMapping("/test")
    public String test() throws Exception {

        BundleContext context = BundleUtils.bundleContext;

        ServiceReference<Greeting> serviceReference = context.getServiceReference(Greeting.class);
        Greeting service = context.getService(serviceReference);
        service.sayHello("today time is "+ (new Date()));

        return "测试是否能正常运行";
    }

}
