package ru.geekbrainsLessonOne.lesson_1.Leson7;

public class Saple03 {
    public static void main(String[] args) {
        //StringBuilder StringBuffer
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hello ");
        stringBuilder.append("GeekBrains");

       // StringBuilder stringBuilder1 = new StringBuilder("hello");

        stringBuilder.insert(5,',');
        stringBuilder.insert(17,'!');
//        stringBuilder.delete(0,7);
//        stringBuilder.deleteCharAt(10);

        String subStr = stringBuilder.substring(7,17);

        stringBuilder.replace(7,17, "World");

        stringBuilder.indexOf("World");



        System.out.println(stringBuilder);
    }
}
