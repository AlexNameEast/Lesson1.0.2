package ru.geekbrainsLessonOne.lesson_1.Home11;

import java.util.ArrayList;

public class Sample01 {
    public static void main(String[] args) {

        Pr pr = new Pr();
        Integer[] arr01 =  {2, 1, 1, 5, 6};
        pr.toArrayList(arr01);
        System.out.println(arr01);

    }

    public <T> void changeElement(T[] arr, int i, int y) {
        T temp = arr[i];
        arr[i] = arr[y];
        arr[y] = temp;
    }

    static class Pr {

        public static <T> T toArrayList(T[] arr) {
            ArrayList<T> arrList01 = new ArrayList<>();
            for (T array : arr) {
                arrList01.add(array);
            }
            return (T) arrList01;
        }

        
    }
}
