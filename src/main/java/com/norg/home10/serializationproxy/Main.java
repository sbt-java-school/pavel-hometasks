package com.norg.home10.serializationproxy;

import com.norg.representer.Representable;

import java.io.*;

/**
 * Serialization Proxy Pattern Demo
 */
public class Main implements Representable {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ChildSerializable child1 = new ChildSerializable(1, "Odin");
        System.out.println("Before: " + child1);
        System.out.println("Starting serialization...");
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream objOut = new ObjectOutputStream(byteOut);
        objOut.writeObject(child1);

        System.out.println("Starting DE-serialization...");
        ObjectInputStream objIn = new ObjectInputStream(new ByteArrayInputStream(byteOut.toByteArray()));
        ChildSerializable child2 = (ChildSerializable) objIn.readObject();
        System.out.println("After: " + child2);
    }

    @Override
    public void represent(OutputStream outputStream) throws Exception {
        /*Выводы:
        * 1. readResolve() и writeReplace() позволяют подменить объект при сериализации-десериализации*/
    }


}
