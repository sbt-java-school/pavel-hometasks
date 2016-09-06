package com.norg.home10.serializationproxy;

import com.norg.representer.Representable;

import java.io.*;

/**
 * Serialization Proxy Pattern Demo
 */
public class Main implements Representable {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
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
    }

    @Override
    public void represent(OutputStream outputStream) throws Exception {
        /*Выводы:
        * 1. readResolve() и writeReplace() позволяют подменить объект при сериализации-десериализации
        * 2. writeReplace() вызывается у сериализуемого объекта, readResolve() - у объекта внутреннего прокси-класса
        * (если только при сериализации объект не был сериализован без участия прокси)
        * 3. При сериализации первым вызывается writeReplace() (и наоборот для readResolve())
        * 4. readObject() и writeObject() вызываются у объекта, который фактически пишется в/читается из Object Stream*/
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        writer.write("********\n");
        writer.write("# Домашнее задание 10\n");
        writer.write("### Сериализующий прокси + readObject()/writeObject()\n");
        writer.flush();
        PrintStream stdOut = System.out;
        System.setOut(new PrintStream(outputStream));
        main(null);
        System.setOut(stdOut);
        writer.flush();
        writer.write("\n\n  ");
    }


}
