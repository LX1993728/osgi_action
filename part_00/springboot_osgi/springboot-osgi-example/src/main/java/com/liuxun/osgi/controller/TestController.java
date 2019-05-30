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

@RestController
public class TestController {


    @GetMapping("/test")
    public String test() throws Exception {

        BundleContext context = BundleUtils.bundleContext;

//        Bundle provider = context.installBundle("file:/c:/Users/Administrator/Desktop/bundles/springdm-provider-test-1.0.jar");
//        Bundle provider = context.installBundle("file:/Users/liuxun//Downloads/test/bundles/springdm-osgi-example-1.0.0.jar");

//        Bundle provider = context.installBundle("file:/Users/liuxun//Downloads/test/bundles/com.service.hello-1.0.jar");
//        Bundle provider = context.installBundle("file:/c:/Users/Administrator/Desktop/bundles/com.service.hello-1.0.jar");

//        Bundle provider = context.installBundle("file:/Users/liuxun//Downloads/test/bundles/OSGiDmHelloWorldProvider-1.0.jar");

//        provider.start();
//        ServiceReference<?>[] registeredServices = provider.getRegisteredServices();
//        System.out.println(registeredServices.length);

//        ServiceReference<Greeting> serviceReference = context.getServiceReference(Greeting.class);
//        Greeting service = context.getService(serviceReference);

        ServiceReference<?> reference = context.getServiceReference(Greeting.class.getName());
        System.out.println(Greeting.class.getName()+" ++++++ "+reference);
        ((Greeting)context.getService(reference)).sayHello(" Maven build BUndle");

//        provider.stop();
        return "测试是否能正常运行";
    }

}
