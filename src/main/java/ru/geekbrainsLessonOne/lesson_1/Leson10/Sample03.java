package ru.geekbrainsLessonOne.lesson_1.Leson10;

import java.util.*;

public class Sample03 {
    public static void main(String[] args) {

        String[] students = {
                "Кира 4 5 7",
                "Артём 2 5 1",
                "Алёна 7 5 7",
                "Стефания 1 5 7",
                "Илья 4 4 7",
                "Марьям 4 6 2",
                "Аделина 5 5 7",
                "Даниил 7 5 7",
                "Филипп 4 5 7",
                "Алина 6 5 7",
                "Александр 4 5 7",
                "Владимир 9 5 3",
                "Марк 4 9 7",
                "Софья 3 4 7",
                "Константин 4 1 7"
        };

        processStatistics(students);


    }

    static void processStatistics(String[] students) {

        HashMap<Float, ArrayList<Student>> statistics = new HashMap<>();

        for (String s : students) {
            String[] parts = s.split(" ");
            int a = Integer.parseInt(parts[2]);
            int b = Integer.parseInt(parts[3]);
            int c = Integer.parseInt(parts[4]);
            float r = (float) (a + b + c) / 3;

            if (statistics.containsKey(r)){
                statistics.get(r).add(new Student(parts[1], parts[0], r));
            }
            else{
                ArrayList<Student> lst = new ArrayList<>();
                lst.add(new Student(parts[1], parts[0], r));
                statistics.put(r,lst);
            }

        }

        TreeMap<Float, ArrayList<Student>> sortedStatistics = new TreeMap<>(statistics);

        System.out.println("Топ 3 худших средних баллов среди учеников : ");

        int counter =1;
        for(Map.Entry<Float, ArrayList<Student>> item: sortedStatistics.entrySet()){
            System.out.printf("\n%d место - средний балл %f\n\n", counter, item.getKey());
            for (Student s: item.getValue()){
                System.out.printf("%s %s\n", s.getSurname(), s.getName());
            }
            counter++;

            if(counter>3) break;;
        }



    }
}


class Student {
    String name;
    String surname;
    float rating;

    public Student(String name, String surname, float rating) {
        this.name = name;
        this.surname = surname;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public float getRating() {
        return rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}

