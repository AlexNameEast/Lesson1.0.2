package ru.geekbrainsLessonOne.lesson_1.Leson6;
//        Создать классы Собака и Кот с наследованием от класса Животное.
//        Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия.
//        Результатом выполнения действия будет печать в консоль.
//        (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
//        У каждого животного есть ограничения на действия
//        (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
//        * Добавить подсчет созданных котов, собак и животных.

public class Home_work {
}

class Animals {
    protected String name;
    protected int counter = 0;

    public Animals(String name) {
        this.name = name;
    }

}

interface Runnable {
    void run(int dist);

    void swim(int dist);
}

class Dogs extends Animals implements Runnable {
    public Dogs(String name) {
        super(name);
    }

    private int maxDistRun = 500;
    private int maxDistSwim = 10;

    @Override
    public void run(int dist) {
        if (maxDistRun < dist) System.out.printf("%s пробежал %d м.\n", name, dist);
        else System.out.println("Слишком большое расстояние!");
    }

    @Override
    public void swim(int dist) {
        if(maxDistSwim < dist) System.out.printf("%s проплыл %d м.\n", name, dist);
        else System.out.println("Слишком большое расстояние!");
    }
}

class Cats extends Animals implements Runnable {
    public Cats(String name) {
        super(name);
    }

    private int maxDistRun = 200;

    @Override
    public void run(int dist) {
        if (maxDistRun < dist) System.out.printf("%s пробежал %d м.\n", name, dist);
        else System.out.println("Слишком большое расстояние!");
    }

    @Override
    public void swim(int d) {
        System.out.printf("%s плавать не умеет!\n", name);
    }
}