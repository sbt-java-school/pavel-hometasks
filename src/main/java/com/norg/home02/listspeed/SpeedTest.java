package com.norg.home02.listspeed;

import com.sun.corba.se.impl.orbutil.ObjectUtility;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Norg on 12.08.2016.
 */
public class SpeedTest {
    public static final long COUNT = 1_000_000;
    private static TestObject testObject = new TestObject();

    public static void main(String[] args) {
        List<TestObject> arrayList = new ArrayList<>();
        System.out.println(String.format("Adding %d same Test Object to the end of ArrayList...", COUNT));
        long start = System.currentTimeMillis();
        for (long i = 0; i<COUNT; i++) {
            arrayList.add(testObject);
        }
        int arrayListEnd = (int) (System.currentTimeMillis() - start);
        System.out.println("" + arrayListEnd + " ms");

        arrayList.clear();
        //эта операция займет значительно больше времени, порядка нескольких минут!
        System.out.println(String.format("Adding %d same Test Object to the beginning of ArrayList...", COUNT));
        start = System.currentTimeMillis();
        for (long i = 0; i<COUNT; i++) {
            arrayList.add(0, testObject);
        }
        int arrayListBeginning = (int) (System.currentTimeMillis() - start);
        System.out.println("" + arrayListBeginning + " ms");

        LinkedList<TestObject> linkedList = new LinkedList<>();
        System.out.println(String.format("Adding %d same Test Object to the end of LinkedList...", COUNT));
        start = System.currentTimeMillis();
        for (long i = 0; i<COUNT; i++) {
            linkedList.add(testObject);
        }
        int linkedListEnd = (int) (System.currentTimeMillis() - start);
        System.out.println("" + linkedListEnd + " ms");

        linkedList.clear();
        System.out.println(String.format("Adding %d same Test Object to the beginning of LinkedList...", COUNT));
        start = System.currentTimeMillis();
        for (long i = 0; i<COUNT; i++) {
            linkedList.add(0, testObject);
        }
        int linkedListBeginning = (int) (System.currentTimeMillis() - start);
        System.out.println("" + linkedListBeginning + " ms");

        System.out.println(String.format("Accessing %d element in ArrayList...", (int)(COUNT/2)));
        start = System.currentTimeMillis();
        arrayList.get((int)(COUNT/2));
        int arrayListAccess = (int) (System.currentTimeMillis() - start);
        System.out.println("" + arrayListAccess + " ms");

        System.out.println(String.format("Accessing %d element in LinkedList...", (int)(COUNT/2)));
        start = System.currentTimeMillis();
        linkedList.get((int)(COUNT/2));
        int linkedListAccess = (int) (System.currentTimeMillis() - start);
        System.out.println("" + linkedListAccess + " ms");

        System.out.println(String.format("Accessing %d element in LinkedList using ListIterator...", (int)(COUNT/2)));
        start = System.currentTimeMillis();
        ListIterator<TestObject> listIterator = arrayList.listIterator((int)(COUNT/2));
        listIterator.next();
        int linkedListIteratorAccess = (int) (System.currentTimeMillis() - start);
        System.out.println("" + linkedListIteratorAccess + " ms");


    }
}
