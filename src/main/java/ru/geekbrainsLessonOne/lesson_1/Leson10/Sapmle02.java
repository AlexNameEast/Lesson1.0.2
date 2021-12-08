package ru.geekbrainsLessonOne.lesson_1.Leson10;

import java.util.HashSet;

public class Sapmle02 {
    public static void main(String[] args) {

        Cat cat01 = new Cat("Персик");

        HashSet<Cat> cats = new HashSet<>();
        cats.add(new Cat("Барсик"));
        System.out.println(cats.add(cat01));
        System.out.println(cats.add(cat01));

        cats.add(new Cat("Мурзик"));

        for(Cat cat: cats){
            System.out.println(cat);
        }
        System.out.println("***");

        System.out.println("Коллекция содержит " + cats.size() + " элемента");
    }
}
