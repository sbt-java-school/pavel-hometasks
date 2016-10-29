package com.norg.home10.singletonserialization;

import java.io.Serializable;

/**
 * Правильный сериализуемый синглтон
 */
public class SerializableSingleton implements Serializable {
    private static SerializableSingleton instance = new SerializableSingleton(); //инициализация при загрузке класса. Если сделать ленивую, то
    // придется разруливать multithreading, чтобы нельзя было второй инстанс создать

    private SerializableSingleton() {

    }

    public static SerializableSingleton getInstance() {
        return instance;
    }

    private Object readResolve() {
        return getInstance();
    }
}
