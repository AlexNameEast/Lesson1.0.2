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

        Cats cat1 = new Cats("Мурзик1");
        Cats cat2 = new Cats("Мурзик2");
        Cats cat3 = new Cats("Мурзик3");
        Cats cat4 = new Cats("Мурзик4");
        Dogs dog1 = new Dogs("Барсик1", 100, 20);
        cat1.run(50);
        cat1.swim(20);
        dog1.run(520);
        dog1.swim(5);

        dog1.run(200);
        dog1.swim(15);

        System.out.println();
        System.out.println("Было создано " + Cats.counter + " котов");
        System.out.println("Было создано " + Dogs.counter + " собак");
        System.out.println("Было создано " + Animals.counter + " животных");


    }
}


abstract class Animals implements Runnable {
    static int counter;
    protected String name;
    private int maxRun;
    private int maxSwim;

    public Animals(String name, int maxRun, int maxSwim) {
        this.name = name;
        this.maxRun = maxRun;
        this.maxSwim = maxSwim;
        counter++;
    }

    public void run(int distance) {
        if (distance <= maxRun) {
            System.out.printf("%s пробежал %d метров\n", name, distance);
        } else System.out.printf("%s не смог пробежать %d метров\n", name, distance);
    }

    public void swim(int distance) {
        if (distance <= maxSwim) {
            System.out.printf("%s проплыл %d метров\n", name, distance);
        } else System.out.printf("%s не смог проплыть %d метров\n", name, distance);
    }
}

interface Runnable {
    void run(int dist);

    void swim(int dist);


}

class Dogs extends Animals {

    static int counter;
    Dogs(String name, int maxRun, int maxSwim) {
        super(name, maxRun, maxSwim);
        counter++;
    }
}

class Cats extends Animals {

    static int counter;

    Cats(String name) {
        super(name, 200, 0);
        counter++;
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать!");
    }
}
