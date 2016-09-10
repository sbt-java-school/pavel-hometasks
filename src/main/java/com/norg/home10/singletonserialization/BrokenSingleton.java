package com.norg.home10.singletonserialization;

import java.io.Serializable;

/**
 * Сломанный синглтон: после десериализации появляется еще один инстанс
 */
public class BrokenSingleton implements Serializable {
    private static BrokenSingleton instance = new BrokenSingleton(); //инициализация при загрузке класса. Если сделать ленивую, то
    // придется разруливать multithreading, чтобы нельзя было второй инстанс создать

    private BrokenSingleton() {

    }

    public static BrokenSingleton getInstance() {
        return instance;
    }

}
