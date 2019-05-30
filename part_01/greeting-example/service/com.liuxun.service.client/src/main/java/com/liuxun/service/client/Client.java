package com.liuxun.service.client;

import com.liuxun.service.Greeting;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

/**
 * @author liuxun
 */
public class Client implements BundleActivator {
    public void start(BundleContext bundleContext) throws Exception {
        ServiceReference<?> reference = bundleContext.getServiceReference(Greeting.class.getName());
        System.out.println(Greeting.class.getName()+" ++++++ "+reference);
        ((Greeting)bundleContext.getService(reference)).sayHello(" Maven build BUndle");
    }

    public void stop(BundleContext bundleContext) throws Exception {

    }
}
