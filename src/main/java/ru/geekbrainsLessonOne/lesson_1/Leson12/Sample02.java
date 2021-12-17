package ru.geekbrainsLessonOne.lesson_1.Leson12;

import java.util.concurrent.Semaphore;

public class Sample02 {
    public static void main(String[] args) {

        new Sample02().doWork();
    }

    public void doWork() {

//        Semaphore semaphore = new Semaphore(1);
//        SamoleClass samoleClass = new SamoleClass();
//
//        new Thread(new MyThread(samoleClass, semaphore), "thread01").start();
//        new Thread(new MyThread(samoleClass, semaphore), "thread02").start();
//        new Thread(new MyThread(samoleClass, semaphore), "thread03").start();

        Semaphore semaphore = new Semaphore(2);
        for (int i = 0; i < 5; i++) {
            new Cat(semaphore, i + 1).start();
        }


    }


    public class SamoleClass {
        int a = 0;


    }

    class MyThread implements Runnable {

        SamoleClass samoleClass;
        Semaphore semaphore;

        public MyThread(SamoleClass samoleClass, Semaphore semaphore) {
            this.samoleClass = samoleClass;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {

            try {
                System.out.println(Thread.currentThread().getName() + "ожидает разрешения");
                semaphore.acquire();

                samoleClass.a = 1;
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " : " + samoleClass.a);
                    samoleClass.a++;
                    Thread.sleep(100);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            semaphore.release();
        }
    }

    class Cat extends Thread {

        public static final String RESET = "\u001B[0m";
        public static final String RED = "\033[1;91m";
        public static final String GREEN = "\033[1;92m";

        Semaphore semaphore;
        int num = 0;

        public Cat(Semaphore semaphore, int no) {
            super("Кот №" + no);
            this.semaphore = semaphore;
        }

        public void run() {


            try {
                while (num < 3) {
                    semaphore.acquire();

                    System.out.printf(
                            "%s %sподходит%s к миске кушать ...\n", getName(), GREEN, RESET);
                    Thread.sleep(1500);
                    num++;
                    System.out.printf(
                            "%s %sотходит%s от миске, сытость %d  ...\n", getName(), RED, RESET, num);
                    Thread.sleep(500);
                    semaphore.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
