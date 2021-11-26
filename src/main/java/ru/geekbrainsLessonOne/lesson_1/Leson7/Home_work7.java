package ru.geekbrainsLessonOne.lesson_1.Leson7;

public class Home_work7 {
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