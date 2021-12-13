package ru.geekbrainsLessonOne.lesson_1.Home11;

import java.util.ArrayList;
import java.util.Arrays;

public class Sample01 {
    public static void main(String[] args) {


        Pr pr = new Pr();
        Integer[] arr01 = {2, 1, 1, 5, 6};
        ArrayList<Integer> arrayList01 = Pr.toArrayList(arr01);
        String[] arr02 = {"aaa0", "sss"};

        System.out.println(Arrays.toString(changeElement(arr01, 1, 4)));

        ArrayList<String> arrayList02 = Pr.toArrayList(arr02);
        System.out.println(arrayList01);
        System.out.println(arrayList02);

        Orange orange = new Orange();
        Apple apple = new Apple();
        Box<Orange> box = new Box(orange);
        System.out.println(orange.getWeight());
        box.add(new Orange());
        box.add(new Orange());
        box.add(new Orange());
        Box<Orange> box01 = new Box(orange);

        Box<Apple> box02 = new Box(apple);
        System.out.println(box.kolFruit.size() + 1);
        box.toBox(box01);
        box01.add(new Orange());
        System.out.println(box.kolFruit.size() + " " + (box01.kolFruit.size() + 1));


    }

    public static <T> T[] changeElement(T[] arr, int i, int y) {
        T temp = arr[i];
        arr[i] = arr[y];
        arr[y] = temp;
        return arr;
    }

    static class Pr {
        public static <T> ArrayList<T> toArrayList(T[] arr) {
            return new ArrayList<>(Arrays.asList(arr));
        }
    }

    public static abstract class Fruit {
        private float weight;

        public Fruit(float weight) {
            this.weight = weight;
        }

        public float getWeight() {
            return weight;
        }
    }

    public static class Apple extends Fruit {

        public Apple() {
            super(1.5f);
        }
    }

    public static class Orange extends Fruit {

        public Orange() {
            super(1.0f);
        }
    }

    public static class Box<T extends Fruit> {
        private ArrayList<T> kolFruit;

        public Box(T obj) {
            kolFruit = new ArrayList<T>();
        }

        float getWeight() {
            return kolFruit.size() * kolFruit.get(0).getWeight();
        }

        public void add(T obj) {
            kolFruit.add(obj);
        }

        boolean compare(T obj) {
            return this.getWeight() == obj.getWeight();
        }

        void toBox(Box<T> obj) {
            obj.kolFruit.addAll(this.kolFruit);
            this.kolFruit.removeAll(kolFruit);
        }
    }
}
