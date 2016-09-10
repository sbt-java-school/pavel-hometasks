package com.norg.home11;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Менеджер плагинов
 */
public class PluginManager {
    private final String pluginRootDirectory;

    public PluginManager(String pluginRootDirectory) {
        this.pluginRootDirectory = pluginRootDirectory;
    }

    public Plugin load(String pluginName, String pluginClassName) throws MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        PluginLoader pluginLoader = new PluginLoader(new URL[]{new URL(pluginRootDirectory + pluginName + "/")});
        return (Plugin) pluginLoader.loadClass(pluginClassName).newInstance();
    }


}

