package com.norg.home11.testplugins;

import com.norg.home11.Plugin;

/**
 * Один из плагинов
 */

public class TestPlugin implements Plugin {
    @Override
    public void doUseful() {
        System.out.println("Загружен внутренний класс.");
    }
}
