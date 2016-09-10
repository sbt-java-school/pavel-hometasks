package com.norg.home10.serializationproxy;

import com.norg.home10.serializationproxy.parent.NotSerializable;

import java.io.*;

/**
 * Class with Serialization proxy
 */
public class ChildSerializable extends NotSerializable implements Serializable {
    private String name;

    public ChildSerializable(int id, String name) {
        super(id);
        this.name = name;
    }

    private Object writeReplace() {
        System.out.println("Enclosing writeReplace()  ");
        return new SerializationProxy(this);
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        System.out.println("Enclosing writeObject()  ");
        name = new StringBuilder(name).reverse().toString();
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        System.out.println("Enclosing readObject()  ");
        in.defaultReadObject();
        name = new StringBuilder(name).reverse().toString();
    }

    private Object readResolve() throws InvalidObjectException {
        throw new InvalidObjectException("Use serialization proxy instead.");
    }

    private static class SerializationProxy implements Serializable {
        private int id;
        private String name;

        public SerializationProxy(ChildSerializable enclosing) {
            this.name = enclosing.name;
            this.id = enclosing.id;
        }

        private Object readResolve() {
            System.out.println("Proxy readResolve()  ");
            return new ChildSerializable(id, name);
        }

        private void writeObject(ObjectOutputStream out) throws IOException {
            System.out.println("Proxy writeObject()  ");
            name = new StringBuilder(name).reverse().toString();
            out.defaultWriteObject();
        }

        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
            System.out.println("Proxy readObject()  ");
            in.defaultReadObject();
            name = new StringBuilder(name).reverse().toString();
        }
    }

    @Override
    public String toString() {
        return "ChildSerializable{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                '}';
    }
}
