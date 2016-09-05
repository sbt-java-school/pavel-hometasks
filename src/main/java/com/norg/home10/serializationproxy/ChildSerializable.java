package com.norg.home10.serializationproxy;

import com.norg.home10.serializationproxy.parent.NotSerializable;

import java.io.InvalidObjectException;
import java.io.Serializable;

/**
 * Class with Serialization proxy
 */
public class ChildSerializable extends NotSerializable implements Serializable {
    private String name;

    public ChildSerializable(int id, String name) {
        super(id);
    }

    private Object writeReplace() {
        return new SerializationProxy(this);
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
            return new ChildSerializable(id, name);
        }
    }
}
