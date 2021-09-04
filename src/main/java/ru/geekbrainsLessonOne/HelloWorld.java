package ru.geekbrainsLessonOne;

public class HelloWorld {
    public static void main(String[] args) {
//        hello();
//        variables();
        int a = 100500;
        int b = 24;
        int sum = a - b;
    }

    private static void variables() {
        //        byte byteVariable;
//        byteVariable = 10;
        byte byteVariable = 10; // 8 bit -128 ...127
        short shortVar = 500; //16 bit -32768..32767
        int intVar = 2_147_000_000; // 32 bit -2.1 bil ..2.1 bil
        long longVar = 2_256_147_000_000L; // 64 bit

        boolean booleanVar = true; // true/false

        char charVar = 16; //16 bit 0..65535
        char charVar1 = 'Q';
        char charVar2 = '\u3245';

        double doubleVar = 23.456; // 64 bit
        float floatVar = 23.456f; // 32 bit

        String stringVar = "Hello world";
    }

    private static void hello() {
        System.out.println("Hello World!!!");
    }
}
