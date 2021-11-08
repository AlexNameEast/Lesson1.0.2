package ru.geekbrainsLessonOne.lesson_1.Leson2;

import java.util.Arrays;

public class Homework {
    public static void main(String[] args) {
//        Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
//        С помощью цикла и условия заменить 0 на 1, 1 на 0;
        task1();
//        Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        task2();
//        Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
        task3();
//        Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью
//        цикла(-ов) заполнить его диагональные элементы единицами;
        task4(15);
//** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        task5();


//** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true, если
// в массиве есть место, в котором сумма левой и правой части массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
// checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.
        int[] arr1= {2,2,2,2,8,16};
        System.out.println("\nTask 6:\n" + task6(arr1) + "\n");


//**** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
// при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично. Для усложнения задачи
// нельзя пользоваться вспомогательными массивами. Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1]
// при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг можете выбирать сами.
        int[] arr= {2,3,4,5,8,16};
        int n = -1;
        task7(arr, n);
    }

    private static void task7(int[] array, int n) {
        System.out.println("Task 7 :\nn = " + n + "\noriginal array: " + Arrays.toString(array));
        if(n<0) n=n+array.length;
        for(int j=0; j<n; j++) {
            int tmp = array[0];
            for (int i = 0; i < array.length - 1; i++) {
                array[i] = array[i + 1];
            }
            array[array.length-1] = tmp;
          }
        System.out.println("\n" + Arrays.toString(array));
    }

    private static boolean task6(int[] arr) {
        float summa = 0;
        for (int i = 0; i < arr.length; i++){
            summa += arr[i];
        }
        float temp = 0;
        summa = summa / 2;
        for(int i = 0; i < arr.length-1; i++){
            temp += arr[i];
            if (temp == summa) {
                return true;
            }
        }
        return false;
    }

    private static void task5() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        int tempmax = arr[0];
        int tempmin = arr[0];
        for(int i=0; i<arr.length; i++){
            if (tempmax < arr[i])
            {
                tempmax = arr[i];
            }
            if (tempmin > arr[i])
            {
                tempmin = arr[i];
            }
        }
        System.out.printf("\n\nTask 5:\nMax - %d\nMin - %d\n", tempmax, tempmin);
        System.out.println(Arrays.toString(arr));
    }



    private static void task4(int size) {
        int[][] arr = new int[size][size];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j<arr.length; j++){
                if( i == j) arr[i][j] = 1;
                if ( i + j == arr.length -1) arr[i][j] = 1;
            }
        }
        System.out.println("\nTask 4:");

        for (int i = 0; i < arr.length; i++) {
            System.out.println("\n");
            for (int j = 0; j<arr.length; j++){
                System.out.print(arr[i][j] + "  ");
            }
        }
       // System.out.println("\nTask 4:\n" + Arrays.deepToString(arr4));
    }

    private static void task3() {
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] < 6) {
                arr3[i] = arr3[i] * 2;
            }
        }
        System.out.println("\nTask 3:\n" + Arrays.toString(arr3));
    }

    private static void task2() {
        int[] arr1 = new int[8];
        for (int i = 0, x = 0; i < arr1.length; i++, x += 3) {
            arr1[i] = x;
        }
        System.out.println("\nTask 2:\n" + Arrays.toString(arr1));
    }

    private static void task1() {
        int[] arr = {1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1};
        System.out.println("Task 1:\n" + Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            //System.out.print(arr[i]);
            if (arr[i] == 1) arr[i] = 0;
            else arr[i] = 1;
        }
        System.out.println(Arrays.toString(arr));
    }
}
