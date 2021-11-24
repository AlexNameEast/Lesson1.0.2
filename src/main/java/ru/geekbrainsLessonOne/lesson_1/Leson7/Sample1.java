package ru.geekbrainsLessonOne.lesson_1.Leson7;

public class Sample1 {
    public static void main(String[] args) {
        String str2 = new String();
        String str3 = new String(new char[]{'h', 'e', 'l', 'l', 'o'});

        System.out.println("Длинна строки -  " + str3.length());

        System.out.println("Первый символ" + str3.charAt(0));

        char[] arr =str3.toCharArray();
    }
}
