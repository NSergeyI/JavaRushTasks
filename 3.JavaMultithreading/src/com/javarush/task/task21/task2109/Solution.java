package com.javarush.task.task21.task2109;

/* 
Запретить клонирование
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        @Override
        protected A clone() throws CloneNotSupportedException {
            A cloneA = new A(this.i, this.j);
            return cloneA;
        }

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof A)) return false;

            A a = (A) o;

            if (i != a.i) return false;
            return j == a.j;
        }

        @Override
        public int hashCode() {
            int result = i;
            result = 31 * result + j;
            return result;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }

    public static class B extends A {

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof B)) return false;
            if (!super.equals(o)) return false;

            B b = (B) o;

            return name != null ? name.equals(b.name) : b.name == null;
        }

        @Override
        public int hashCode() {
            int result = super.hashCode();
            result = 31 * result + (name != null ? name.hashCode() : 0);
            return result;
        }

        @Override
        protected B clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }

        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }


        @Override
        protected C clone() throws CloneNotSupportedException {
            C cloneC = new C(this.getI(),this.getJ(),this.getName());
            return cloneC;
        }

        public static void main(String[] args) throws CloneNotSupportedException {
            A a = new A(1, 1);
            A a1 = (A) a.clone();
            System.out.println(a);
            System.out.println(a1);
            C c = new C(3, 4, "Dima");
            C c1 = (C) c.clone();
            System.out.println(c);
            System.out.println(c1);
            B b = new B(1, 2, "Vasya");
//            B b1 = (B) b.clone();
            System.out.println(b);
//            System.out.println(b1);

        }
    }
}
