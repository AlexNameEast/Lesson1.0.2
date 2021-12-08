package ru.geekbrainsLessonOne.lesson_1.Leson10;

import java.util.ArrayList;

public class Sample01 {
    public static void main(String[] args) {

        Cat cat01 = new Cat("Персик");
        ArrayList<Cat> cats = new ArrayList<>();

        cats.add(new Cat("Барсик"));
        cats.add(cat01);
        cats.add(cat01);
        cats.add(1, new Cat("Мурзик"));

        for(Cat cat: cats){
            System.out.println(cat);
        }
        System.out.println("***");

        System.out.println("Коллекция содержит " + cats.size() + " элемента");

    }
}
