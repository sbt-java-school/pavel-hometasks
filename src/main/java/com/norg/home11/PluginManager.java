package com.norg.home11;

import com.norg.home11.testplugins.TestPlugin;
import com.norg.representer.Representable;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Менеджер плагинов
 */
public class PluginManager implements Representable {
    private final String pluginRootDirectory;

    public PluginManager(String pluginRootDirectory) {
        this.pluginRootDirectory = pluginRootDirectory;
    }

    public Plugin load(String pluginName, String pluginClassName) throws MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        PluginLoader pluginLoader = new PluginLoader(new URL[]{new URL(pluginRootDirectory + pluginName + "/")});
        return (Plugin) pluginLoader.loadClass(pluginClassName).newInstance();
    }


    @Override
    public void represent(OutputStream outputStream) throws Exception {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        writer.write("********\n");
        writer.write("# Домашнее задание 11\n");
        writer.write("### Загрузчик плагинов\n");
        writer.write("В папке temp лежит скомпиленный плагин.  " +
                "Пример использования - в тестах.");
        writer.flush();
        PrintStream stdOut = System.out;
        System.setOut(new PrintStream(outputStream));
        new TestPlugin().doUseful();
        PluginManager manager = new PluginManager("file:///temp/");
        Plugin testPlugin = manager.load("testPlugin", "com.norg.home11.testplugins.TestPlugin");
        testPlugin.doUseful();
        System.setOut(stdOut);
        writer.flush();
        writer.write("\n\n  ");
        System.out.println("### Выводы:  \n" +
                "При наличии интерфейса, загруженного системным класс-лоадером, можно " +
                "загружать классы из других мест своим класс-лоадером, приводить к интерфейсу и использовать.  \n\n");
    System.out.println("### Вопросы:  \n" +
                "Есть ли возможность подменить загрузчик своим, не используя параметры консоли? Чтобы даже когда я " +
                "впервые пишу `new AdBlock()`, класс AdBlock грузился бы из плагинов, а не из моего джарника?");
    }
}

