package ru.geekbrainsLessonOne.lesson_1.Leson6;
//        Создать классы Собака и Кот с наследованием от класса Животное.
//        Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия.
//        Результатом выполнения действия будет печать в консоль.
//        (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
//        У каждого животного есть ограничения на действия
//        (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
//        * Добавить подсчет созданных котов, собак и животных.

public class Home_work {
    public static void main(String[] args) {

        //тут не совсем понимаю какого типа нужно создавать переменную, вы на уроке делали
        //Runable / Animals / Cats ... если несложно оставьте комментарий. спасибо.
        Cats cat1 = new Cats("Мурзик1");
        Cats cat2 = new Cats("Мурзик2");
        Cats cat3 = new Cats("Мурзик3");
        Cats cat4 = new Cats("Мурзик4");
        Dogs dog1 = new Dogs("Барсик1");
        cat1.run(50);
        cat1.swim(20);
        dog1.run(520);
        dog1.swim(5);

        dog1.run(200);
        dog1.swim(15);
        cat1.info();

    }
}


abstract class Animals {
    protected String name;
    protected static int counter = 0;
    protected static int counterCats = 0;
    protected static int counterDogs = 0;


    public Animals(String name) {
        this.name = name;
        counter++;
    }
    void info() {
        System.out.printf("\nВсего животных:%d  Котов:%d  Собак:%d", counter, counterCats, counterDogs);
    }
}


interface Runnable {
    void run(int dist);

    void swim(int dist);


}

class Dogs extends Animals implements Runnable {

    public Dogs(String name) {
        super(name);
        counterDogs++;
    }

    private int maxDistRun = 500;
    private int maxDistSwim = 10;

    @Override
    public void run(int dist) {
        if (dist < maxDistRun) System.out.printf("%s пробежал %d м.\n", name, dist);
        else System.out.println("Слишком большое расстояние!");
    }

    @Override
    public void swim(int dist) {
        if (dist < maxDistSwim) System.out.printf("%s проплыл %d м.\n", name, dist);
        else System.out.println("Слишком большое расстояние!");
    }
}

class Cats extends Animals implements Runnable {


    public Cats(String name) {
        super(name);
        counterCats++;
    }

    private int maxDistRun = 200;

    @Override
    public void run(int dist) {
        if (dist < maxDistRun) System.out.printf("%s пробежал %d м.\n", name, dist);
        else System.out.println("Слишком большое расстояние!");
    }

    @Override
    public void swim(int d) {
        System.out.printf("%s плавать не умеет!\n", name);
    }
}