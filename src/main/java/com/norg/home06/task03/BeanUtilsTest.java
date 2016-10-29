package com.norg.home06.task03;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Norg on 24.08.2016.
 */
public class BeanUtilsTest {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        TestClass from = new TestClass("from", 1);
        TestClass to = new TestClass("to", 2);

//        to.setId(from.getId());
        BeanUtils.assign(to, from);
    }

    static class TestClass {
        private String name;
        private Number id;

        public TestClass(String name, Number id) {
            this.name = name;
            this.id = id;
        }

        public String getName() {

            return name;
        }

        public void setName(String name) {
            this.name = name;
            System.out.println("Setter setName() is invoked!");
        }

        public Long getId() {
            return id.longValue();
        }

        public void setId(Number id) {
            this.id = id;
            System.out.println("Setter setId() is invoked!");
        }
    }
}
