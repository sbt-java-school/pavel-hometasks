package com.norg.home04;

/**
 * Created by Norg on 13.08.2016.
 */
public class Truck {
    private long id;
    private int capacity;

    public Truck(long id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "id=" + id +
                ", capacity=" + capacity +
                '}';
    }
}
