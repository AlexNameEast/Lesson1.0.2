package ru.geekbrainsLessonOne.lesson_1.Lesson1;

//        1.Создать пустой проект в IntelliJ IDEA и прописать метод main().
//        2.Создать переменные всех пройденных типов данных и инициализировать их значения.
//        3.Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
//        где a, b, c, d – аргументы этого метода, имеющие тип float.
//        4.Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах от 10 до 20
//        (включительно), если да – вернуть true, в противном случае – false.
//        5.Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль,
//        положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.
//        6.Написать метод, которому в качестве параметра передается целое число. Метод должен вернуть true, если число
//        отрицательное, и вернуть false если положительное.
//        7.Написать метод, которому в качестве параметра передается строка, обозначающая имя. Метод должен вывести в
//        консоль сообщение «Привет, указанное_имя!».
//        8.*Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль. Каждый 4-й
//        год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.


public class homework {
    public static void main(String[] args) {
        int i = 1;
        short sh = 1;
        long lon = 20000000000L;
        float fl = 15.5f;
        double d1 = 12.6;
        boolean bl = true;
        System.out.println(calc(3, 5.5f, 20, 5));
        System.out.println(limit(5, 90));
        compare(-8);
        System.out.println(boolCompare(5));
        hello("Алексей");
        years(2056);


    }

    static void years(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
            System.out.println("Год высокосный");
        else System.out.println("Год не высокосный");
    }

    static void hello(String name) {
        System.out.println("Привет, " + name + "!");
    }

    static boolean boolCompare(int x) {
        return x < 0;
    }

    static void compare(int x) {
        if (x >= 0)
            System.out.println("Число положительное");
        else
            System.out.println("Число отрицательное");
    }

    static boolean limit(int a, int b) {
        return 10 <= a + b & a + b <= 20; // ^ исключающее или

    }

    static float calc(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }
}
