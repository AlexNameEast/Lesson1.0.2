package Leson2;

import java.util.Arrays;

public class Classwork {
    public static void main(String[] args){
        loopsExample();

        int[] arrr = {1,2,3,4,5};
      //  System.out.println(arrr);
        System.out.println(Arrays.toString(arrr));
    }

    private static void loopsExample() {
        int counter =0;

        while (counter < 100) {
            System.out.println(++counter);
            if (counter == 50) break;
        }

        do {
            System.out.println(++counter);
        } while (counter < 100);

        for (int i = 0; i < 100; i++){
            System.out.println(i);
        }
    }
}
