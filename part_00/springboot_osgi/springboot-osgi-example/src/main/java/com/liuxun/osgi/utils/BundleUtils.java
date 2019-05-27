package com.liuxun.osgi.utils;

import org.osgi.framework.BundleContext;
import org.osgi.framework.launch.Framework;

public class BundleUtils {
    public static Framework framework;

    public static BundleContext getBundleContext(){
        if (framework != null){
            return framework.getBundleContext();
        }
        return null;
    }
}
