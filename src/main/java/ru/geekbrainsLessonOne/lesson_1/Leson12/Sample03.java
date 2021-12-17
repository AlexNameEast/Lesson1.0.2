package ru.geekbrainsLessonOne.lesson_1.Leson12;

import java.util.concurrent.*;

public class Sample03 {
    public static void main(String[] args) {


        System.out.println("Начало главного");
        ExecutorService service = Executors.newFixedThreadPool(3);


        service.execute(new Runnable() {
            @Override
            public void run() {

                try{
                    Thread.sleep(500);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("Выполнение первого потока..");
            }
        });

        Future future = service.submit(new Runnable() {
            @Override
            public void run() {

                try{
                    Thread.sleep(1500);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("Выполнение второго потока..");
            }
        });

        Future<Integer> future2 = service.submit(new Callable<Integer>() {

            public Integer call() throws Exception{
                System.out.println("");
                Thread.sleep(1500);
                return 123;
            }

        });



        try{
            future.get();
            int res = future2.get();
            System.out.println("Вернули " + res);
        }
//        catch (ExecutionException e){
//            e.printStackTrace();
//        }
//        catch(InterruptedException e){
//            e.printStackTrace();
//        }
        catch(InterruptedException |  ExecutionException e){
            e.printStackTrace();
        }


        System.out.println("Конец главного");
        service.shutdown();
    }
}
