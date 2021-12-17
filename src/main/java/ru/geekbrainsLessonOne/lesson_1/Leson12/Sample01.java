package ru.geekbrainsLessonOne.lesson_1.Leson12;

import java.util.Random;

public class Sample01 {
    public static Random random = new Random();

    public static void main(String[] args) {
        new Sample01().doWork();

    }

    public void doWork() {

        Plate plate = new Plate();

        Human human = new Human(plate);
        Cat cat01 = new Cat(plate);
        Cat cat02 = new Cat(plate);

        new Thread(human).start();
        new Thread(cat01, "Cat №1").start();
        new Thread(cat02, "Cat №2").start();

    }

    class Plate {
        private int food = 0;

        // взять еду
        public synchronized void get(String name) {
            while (food < 1) {

                try {
                    wait();
                    Thread.sleep(random.nextInt(600));
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
            food--;
            System.out.printf("Кот %s покушал еду из миски", name);
            System.out.println("Еды в миске: " + food);
            notify();
        }

        // положить еду
        public synchronized void put() {
            while (food >= 3){
                try {
                    wait();
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            food++;
            System.out.println("Человек добавил еду в миску");
            System.out.println("Еды в миске: " + food);
            notifyAll();
        }


    }

    class Human implements Runnable {

        Plate plate;

        public Human(Plate plate) {
            this.plate = plate;
        }

        public void run() {
            for (int i = 0; i < 10; i++) {
                plate.put();
            }
            System.out.println("у человека закончилась еда...");
        }
    }

    class Cat implements Runnable {
        Plate plate;

        public Cat(Plate plate) {
            this.plate = plate;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                plate.get(Thread.currentThread().getName());
            }
            System.out.printf("Кот %s наелся...\n", Thread.currentThread().getName());
        }
    }
}


