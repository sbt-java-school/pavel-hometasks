package com.norg.home10.serializationproxy.parent;

/**
 * Parent without default constructor breaks down default serialization
 */
public abstract class NotSerializable {
    protected final int id;

    protected NotSerializable(int id) {
        this.id = id;
    }
}
