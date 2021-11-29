package ru.geekbrainsLessonOne.lesson_1.Leson7;

public class Home_work7 {
    public static void main(String[] args) {

        Plate plate = new Plate(100);
        Cats cats[] = {
                new Cats("Мурзик1", 20),
                new Cats("Мурзик2", 25),
                new Cats("Мурзик3", 30),
                new Cats("Мурзик4", 50)
        };


//        Dogs dog1 = new Dogs("Барсик1", 100, 20);
//        cats[0].run(50);
//        cats[1].swim(20);
//        dog1.run(520);
//        dog1.swim(5);
//
//        dog1.run(200);
//        dog1.swim(15);
//
//        System.out.println();
//        System.out.println("Было создано " + Cats.counter + " котов");
//        System.out.println("Было создано " + Dogs.counter + " собак");
//        System.out.println("Было создано " + Animals.counter + " животных");

        for (Cats c : cats) {
            c.eat(plate);
        }
        plate.info();
        for (Cats c : cats) {
            System.out.println(c.name + " сытость - " + c.isSatiety());
        }


    }
}

class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void info() {
        System.out.println("\nЕды в тарелке: " + food + " грамм");
    }

    public boolean decreaseFood(int n) {
        if (food > n) {
            food -= n;
            return true;
        } else return false;
    }

    public void addFood(int f) {
        if (f > 0) food += f;
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
    private int appetite;
    private boolean satiety;

    public boolean isSatiety() {
        return satiety;
    }

    Cats(String name, int appetite) {
        super(name, 200, 0);
        this.appetite = appetite;
        satiety = false;
        counter++;
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать!");
    }

    public void eat(Plate p) {
        if (p.decreaseFood(appetite)) {
            satiety = true;
            System.out.println(name + " покушал)");
        } else System.out.println(name + " не покушал, потому что не хватило еды(");
    }

}