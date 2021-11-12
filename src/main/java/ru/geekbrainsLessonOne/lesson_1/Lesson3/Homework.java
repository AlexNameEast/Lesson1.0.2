package ru.geekbrainsLessonOne.lesson_1.Lesson3;

import java.util.Random;
import java.util.Scanner;

public class Homework {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        for (; ; ) {
            System.out.print("1 - Task1");
            System.out.println("\t2 - Task2");
            System.out.print("Введите номер задачи (0 - выход из программы): ");

            if (scanner.hasNextInt()) {
                int menu = scanner.nextInt();
                scanner.nextLine();
                switch (menu) {
                    case 0:
                        System.out.println("Программа завершена!");
                        return;
                    case 1:
                        task1();
                        break;
                    case 2:
                        task2();
                        break;
                    default:
                        System.out.println("\nНеверный вариант, повторите попытку!\n");
                }
            }
        }
    }

    public static void task1() {
          /*Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3 попытки угадать это
        число. При каждой попытке компьютер должен сообщить, больше ли указанное пользователем число, чем загаданное,
        или меньше. После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»
        (1 – повторить, 0 – нет).
         */
        int flag = 1;
        for (; ; ) {
            Random random = new Random();
            int hiddenNumber = random.nextInt(10);
            for (int i = 0; i < 3; i++) {
                System.out.println("Попробуй угадать число! ( 0 - 9 ): ");
                if (scanner.hasNextInt()) {
                    int number = scanner.nextInt();
                    System.out.println(hiddenNumber);
                    if (hiddenNumber == number) {
                        System.out.println("Поздравляю!!! Вы выиграли!!!");
                        i = 3;
                    }
                    if (hiddenNumber > number) {
                        System.out.println("Загаданное число больше");
                    }
                    if (hiddenNumber < number) {
                        System.out.println("Загаданное число меньше");
                    }

                }

            }
            //region
            System.out.println("Повторить игру еще раз?\n1 – да / 0 – нет");
            if (scanner.hasNextInt()) {
                flag = scanner.nextInt();
                if (flag == 0) break;
                else {
                    if (flag != 1) {
                        System.out.println("Вы ввели некорректный ответ! Попробуйте еще раз (1 – да / 0 – нет)");
                        break;
                    }
                }

            }
            //endregion
        }
    }

    public static void task2() {
        /* Создать массив из слов
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
        "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
        "pepper", "pineapple", "pumpkin", "potato"}.
                При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя, сравнивает его с
                загаданным словом и сообщает, правильно ли ответил пользователь. Если слово не угадано, компьютер
                показывает буквы, которые стоят на своих местах.
        apple – загаданное
        apricot - ответ игрока
        ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
        Для сравнения двух слов посимвольно можно пользоваться:
        String str = "apple";
        char a = str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
        Играем до тех пор, пока игрок не отгадает слово.
        Используем только маленькие буквы.*/

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"};
        Random random = new Random();
        int hiddeWord = random.nextInt(words.length);



    }
}
