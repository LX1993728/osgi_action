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
    public Object test1() throws Exception {

        Map<String, Object> meta = new HashMap<>();
        meta.put("version","1.0");
        MyAnnotitationService service = BundleUtils.findServiceByComponentAttr(MyAnnotitationService.class, meta);
        if (service != null){
            String dateStr = service.getPatternDateStr(new Date());
            System.out.println(dateStr);
            return  dateStr;
        }
        return null;
    }

    @GetMapping("/test2")
    public Object test2(String version) throws Exception {
        BundleContext context = BundleUtils.bundleContext;

        String bundleVersion = version == null ? "1.0" : version;
        MyAnnotitationService service = BundleUtils.findServiceByBundleVersion(MyAnnotitationService.class, bundleVersion);

        if (service != null){
            String dateStr = service.getPatternDateStr(new Date());
            System.out.println(dateStr);
            return  dateStr;
        }
        return null;
    }


}
