package com.liuxun.service.impl;

import com.liuxun.service.Greeting;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {
    @Override
    public void start(BundleContext bundleContext) throws Exception {
        bundleContext.registerService(Greeting.class.getName(),
                new GreetingImpl(), null);
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {

    }
}
