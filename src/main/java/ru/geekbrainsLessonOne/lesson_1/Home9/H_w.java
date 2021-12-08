package ru.geekbrainsLessonOne.lesson_1.Home9;

public class H_w {
    public static void main(String[] args) {
        String[][] myArray = new String[4][4];
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray.length; j++) {
                myArray[i][j] = "2";
            }
        }

        //myArray[2][2] = "f";

        try{
            System.out.println("Сумма элементов массива = " + m(myArray));
        }
        catch (MyArrayDataException e){
            System.out.println("Неправильное значение массива!");
            System.out.println("Ошибка в ячейке: " + e.getI() + "x" + e.getJ());
        }
        catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int m(String[][] arr) throws MyArrayDataException, MyArraySizeException {

            if (arr[0].length !=4 || arr.length != 4) throw new MyArraySizeException("Неверный размер");

            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    try {
                        sum = sum + Integer.parseInt(arr[i][j]);
                    }
                    catch (NumberFormatException e){
                        throw new MyArrayDataException(i,j);
                    }
                }
            }
            return sum;
    }
}


