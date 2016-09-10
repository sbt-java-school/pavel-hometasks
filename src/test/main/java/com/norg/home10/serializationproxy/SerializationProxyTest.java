package com.norg.home10.serializationproxy;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;

/**
 * Тест сериализационного прокси
 */

public class SerializationProxyTest {
    @Test
    public void serializationWithProxyTest() throws IOException, ClassNotFoundException {
        ChildSerializable child1 = new ChildSerializable(1, "Odin");
        System.out.println("Before: " + child1 + "  ");
        System.out.println("Starting serialization...  ");
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream objOut = new ObjectOutputStream(byteOut);
        objOut.writeObject(child1);

        System.out.println("Starting DE-serialization...  ");
        ObjectInputStream objIn = new ObjectInputStream(new ByteArrayInputStream(byteOut.toByteArray()));
        ChildSerializable child2 = (ChildSerializable) objIn.readObject();
        System.out.println("After: " + child2 + "  ");
        Assert.assertEquals(child1, child2);
    }
}
