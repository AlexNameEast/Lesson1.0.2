package ru.geekbrainsLessonOne.lesson_1.Lesson3;




import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class ClassWork {
    public static void main(String[] args) throws IOException {
/*  *//*      int[] arr = {21,43,76,21,1,2,2,4,6};
        //  Arrays.sort(arr);
        int[] arr1 = {21,43,76,21,1,2,2,4,6};
   *//*     System.out.println(arr == arr1);//false
  //      System.out.println(Arrays.equals(arr, arr1));// сравнивает массивы
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.binarySearch(arr, 76));
//        Arrays.fill(arr,76);// заполнить массив значением
//        String[] arr = {"Abc", "ghkrj", "ejngktjgneg", "kjngkjrnbnrkg", "fgf"};
//        Arrays.sort(arr, (s1,s2) -> s1.length() - s2.length());
//        System.out.println(Arrays.toString(arr));*/

       // scannerExample();

        Random random = new Random();

//        System.out.println(random.nextInt(100) + 400);
        System.out.println(random.nextInt(200) - 100);


    }

    private static void scannerExample() throws IOException {
        Scanner scanner = new Scanner(System.in);
       /* System.out.println("Please enter the name to greet >>> ");
        String name = scanner.nextLine();
        System.out.println("Hello " + name);*/

//        System.out.println("enter some int");
//        int a = scanner.nextInt();
//        System.out.println("a = " + a);
//
//        System.out.println("enter some float");
//        scanner.useLocale(Locale.ENGLISH);
//
//        float b = scanner.nextFloat();
//        System.out.println("b = " + b);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter the name to greet >>> ");
        String name = reader.readLine();
        System.out.println("Hello " + name);

        scanner.close();
    }


}
