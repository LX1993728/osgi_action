package com.liuxun.osgi.controller;

import com.liuxun.osgi.utils.BundleUtils;
//import com.service.api.Greeting;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import scr.ds.api.MyAnnotitationService;

import java.util.Date;

@RestController
public class TestController {


//    @GetMapping("/test")
//    public String test() throws Exception {
//
//        BundleContext context = BundleUtils.bundleContext;
//
//        ServiceReference<Greeting> serviceReference = context.getServiceReference(Greeting.class);
//        Greeting service = context.getService(serviceReference);
//        service.sayHello("today time is "+ (new Date()));
//
//        return "测试是否能正常运行";
//    }

    @GetMapping("/test1")
    public String test1() throws Exception {
        BundleContext context = BundleUtils.bundleContext;
//
        ServiceReference<MyAnnotitationService> serviceReference = context.getServiceReference(MyAnnotitationService.class);
        MyAnnotitationService service = context.getService(serviceReference);
        String dateStr = service.getPatternDateStr(new Date());
        return dateStr;
    }

}
