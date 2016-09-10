package com.norg.home11;

import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandlerFactory;

/**
 * Created by Norg on 10.09.2016.
 */

public class PluginLoader extends URLClassLoader {

    public PluginLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    public PluginLoader(URL[] urls) {
        super(urls);
    }

    public PluginLoader(URL[] urls, ClassLoader parent, URLStreamHandlerFactory factory) {
        super(urls, parent, factory);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        try {
            return findClass(name);
        }catch (ClassNotFoundException e) {
            return super.loadClass(name);
        }
    }
}
