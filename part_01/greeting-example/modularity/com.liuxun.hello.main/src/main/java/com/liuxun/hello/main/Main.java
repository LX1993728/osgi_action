package com.liuxun.hello.main;

import org.apache.felix.framework.Felix;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static Felix m_framework;

    public static void main(String[] args) throws Exception{
        try {
            final Map configMap = new HashMap();
            configMap.put(Constants.FRAMEWORK_STORAGE_CLEAN,"onFirstInit");
            m_framework = new Felix(configMap);
            m_framework.init();

            final BundleContext context = m_framework.getBundleContext();

            Bundle provider = context.installBundle("file:bundles/com.liuxun.hello-1.0.jar");
            Bundle consumer = context.installBundle("file:bundles/com.liuxun.hello.client-1.0.jar");

            m_framework.start();

            consumer.loadClass("com.liuxun.hello.client.Client").newInstance();

            m_framework.stop();

        }catch (Exception e){
            e.printStackTrace();
            System.exit(0);
        }
    }
}
