package ru.geekbrainsLessonOne.lesson_1.Lesson5;

import java.util.Random;

public class home_work_oop {

    public static void main(String[] args) {
        /*
        * Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
Конструктор класса должен заполнять эти поля при создании объекта.
Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
Создать массив из 5 сотрудников.
Пример:
Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
* // потом для каждой ячейки массива задаем объект
persArray[1] = new Person(...);
...
persArray[4] = new Person(...);
С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
*/

        Сollaborator[] pesArray = new Сollaborator[5];
        Random random = new Random();
        pesArray[0] = new Сollaborator("Alex Ivanov", "CEO", "ivanov@gmail.com",
                "+105500235", 2000, random.nextInt(100));
        pesArray[1] = new Сollaborator("Petr Petrov", "MG", "petrov@gmail.com",
                "+145857562", 3000, random.nextInt(100));
        pesArray[2] = new Сollaborator("Artur Smile", "CFO", "smile@gmail.com",
                "+125487531", 4000, random.nextInt(100));
        pesArray[3] = new Сollaborator("Roman Romanov", "CVO", "romanov@gmail.com",
                "+111225544", 1000, random.nextInt(100));
        pesArray[4] = new Сollaborator("Anton Antonov", "COO", "antonov@gmail.com",
                "+100000000", 80000, random.nextInt(100));

        for (int i = 0; i < pesArray.length; i++) {
            if (pesArray[i].getAge() > 40) pesArray[i].info();
        }
    }
}
