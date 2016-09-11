package com.norg.home11;

import com.norg.home11.testplugins.TestPlugin;
import org.junit.Test;

/**
 *
 */
public class PluginManagerTest {

    public static final String PLUGIN_DIRECTORY = "file:///temp/";

    @Test
    public void loadPluginTest() throws Exception {
        new TestPlugin().doUseful();
        PluginManager manager = new PluginManager(PLUGIN_DIRECTORY);
        Plugin testPlugin = manager.load("testPlugin", "com.norg.home11.testplugins.TestPlugin");
        testPlugin.doUseful();
    }
}
