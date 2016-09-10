package com.norg.home10.singletonserialization;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;

/**
 * Тест сериализации синглтона
 */
public class SingletonSerializationTest {

    @Test
    public void failedSerializationTest() throws IOException, ClassNotFoundException {
        BrokenSingleton firstInstance = BrokenSingleton.getInstance();
        System.out.println(firstInstance);
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream objOut = new ObjectOutputStream(byteOut);
        objOut.writeObject(firstInstance);

        ObjectInputStream objIn = new ObjectInputStream(new ByteArrayInputStream(byteOut.toByteArray()));
        BrokenSingleton secondInstance = (BrokenSingleton) objIn.readObject();
        System.out.println(secondInstance);
        System.out.println(firstInstance==secondInstance);
        Assert.assertNotSame(firstInstance, secondInstance);

    }

    @Test
    public void correctSerializationTest() throws IOException, ClassNotFoundException {

        SerializableSingleton theOneInstance1 = SerializableSingleton.getInstance();
        System.out.println(theOneInstance1);
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream objOut = new ObjectOutputStream(byteOut);
        objOut.writeObject(theOneInstance1);

        ObjectInputStream objIn = new ObjectInputStream(new ByteArrayInputStream(byteOut.toByteArray()));
        SerializableSingleton theOneInstance2 = (SerializableSingleton) objIn.readObject();
        System.out.println(theOneInstance2);
        System.out.println(theOneInstance1==theOneInstance2);
        Assert.assertSame(theOneInstance1, theOneInstance2);
    }
}
