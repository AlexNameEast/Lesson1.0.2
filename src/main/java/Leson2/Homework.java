package Leson2;

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
        task4(5);
//** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);


//** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true, если
// в массиве есть место, в котором сумма левой и правой части массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
// checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.


//**** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
// при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично. Для усложнения задачи
// нельзя пользоваться вспомогательными массивами. Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1]
// при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг можете выбирать сами.
    }

    private static void task4(int size) {
        int[][] arr4 = new int[size][size];
        for (int i = 0; i < arr4.length; i++) {
            for (int j = 0; j<arr4.length; j++){
                if( i == j) arr4[i][j] = 1;
                if ( i + j == arr4.length -1) arr4[i][j] = 1;
            }
        }
        System.out.println("\nTask 4:");

        for (int i = 0; i < arr4.length; i++) {
            System.out.println("\n");
            for (int j = 0; j<arr4.length; j++){
                System.out.print(arr4[i][j] + "  ");
            }
        }
       // System.out.println("\nTask 4:\n" + Arrays.deepToString(arr4));
    }

    private static void task3() {
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] > 6) {
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
