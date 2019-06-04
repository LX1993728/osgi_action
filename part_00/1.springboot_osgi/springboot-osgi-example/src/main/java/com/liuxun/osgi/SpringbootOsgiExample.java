package com.liuxun.osgi;

import com.liuxun.osgi.controller.ControllerConfig;
import com.liuxun.osgi.utils.BundleUtils;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;


@Import(ControllerConfig.class)
@SpringBootConfiguration
@EnableAutoConfiguration
public class SpringbootOsgiExample implements BundleActivator {
    ConfigurableApplicationContext appContext;

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        Thread.currentThread().setContextClassLoader(this.getClass().getClassLoader());
        BundleUtils.bundleContext = bundleContext;
        appContext = SpringApplication.run(SpringbootOsgiExample.class);
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        SpringApplication.exit(appContext, () -> 0);
    }
}
