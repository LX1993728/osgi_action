package com.liuxun.hello.main;

import com.liuxun.service.Greeting;
import org.apache.felix.framework.Felix;
import org.osgi.framework.*;

import javax.xml.ws.Service;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static Felix m_framework;

    public static void main(String[] args) throws Exception {
        try {
            final Map configMap = new HashMap();
            configMap.put(Constants.FRAMEWORK_STORAGE_CLEAN, "onFirstInit");
            m_framework = new Felix(configMap);
            m_framework.init();

            final BundleContext context = m_framework.getBundleContext();

            Bundle provider = context.installBundle("file:/Users/liuxun/Downloads/test/bundles/com.service.hello-1.0.jar");
            Bundle consumer = context.installBundle("file:/Users/liuxun/Downloads/test/bundles/com.liuxun.service.client-1.0.jar");

            m_framework.start();

            provider.start();

            ServiceReference[] registeredServices = provider.getRegisteredServices();
            System.out.println("services= " + registeredServices.length);

            ServiceReference reference = context.getServiceReference(Greeting.class.getName());
//            System.out.println(Greeting.class.getName()+" ++++++ "+reference.);
//            ((Greeting)context.getService(reference)).sayHello(" Maven build B ");



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
