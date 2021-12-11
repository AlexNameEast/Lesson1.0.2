package ru.geekbrainsLessonOne.lesson_1.Home12;

public class Sample01 {
    public static void main(String[] args) {
        task01();
        try{
            task02();
        }
        catch (InterruptedException ex){
            System.out.println("");
        }

    }

    public static void task01() {
        final int SIZE = 10000000;
        final int HALF = SIZE / 2;
        float[] arr = new float[SIZE];
        for (float array : arr)
            array = 1;
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++)
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        long b = System.currentTimeMillis();
        System.out.println("Время выполнения в одном потоке - " + (b - a) + " миллисекунд");

    }

    synchronized public static void task02()  throws InterruptedException{
        final int SIZE = 10000000;
        final int HALF = SIZE / 2;
        float[] arr = new float[SIZE];

        for (int i = 0; i < arr.length; i++)
            arr[i] = 1;

        float[] a1 = new float[HALF];
        float[] a2 = new float[HALF];

        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, HALF);
        System.arraycopy(arr, HALF, a2, 0, HALF);

        MyThread myThread01 = new MyThread("thread01", a1);
        MyThread myThread02 = new MyThread("thread02", a2);
        myThread01.start();
        myThread02.start();

        myThread01.join();
        myThread02.join();

        System.arraycopy(myThread01.getArray(), 0, arr, 0, HALF);
        System.arraycopy(myThread02.getArray(), 0, arr, HALF, HALF);
        long b = System.currentTimeMillis();
        System.out.printf("На выполнение вычислений в двух потоках понадобилось - %d миллисекунд\n", b - a);




    }


    public static class MyThread extends Thread {

        private float[] array;

        public float[] getArray() {
            return array;
        }

        public MyThread(String name, float[] array) {
            super(name);
            this.array = array;
        }

        @Override
        public void run() {

            for (int i = 0; i < array.length; i++) {
                array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        }
    }
}
