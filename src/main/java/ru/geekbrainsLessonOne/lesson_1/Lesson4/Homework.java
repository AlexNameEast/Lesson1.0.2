package ru.geekbrainsLessonOne.lesson_1.Lesson4;

import java.util.Random;
import java.util.Scanner;

public class Homework {

        static final char DOT_HUMAN = 'X'; // Фишка игрока - человек
        static final char DOT_AI = '0'; // Фишка игрока - компьютер
        static final char DOT_EMPTY = '•'; // Признак пустого поля
        static final Scanner scanner = new Scanner(System.in);
        static final Random random = new Random();
        static char[][] field; // Игровое поле
        static int fieldSizeX; // Размерность игрового поля
        static int fieldSizeY; // Размерность игрового поля

        /**
         * Инициализация объектов игры
         */
        static void initialize(){
            // Установим размерность игрового поля
            fieldSizeX = 3;
            fieldSizeY = 3;

            // Инициализация массива, описывающего игровое поле
            field = new char[fieldSizeY][fieldSizeX];
            for(int y = 0; y < fieldSizeY; y++){
                for(int x = 0; x < fieldSizeX; x++){
                    field[y][x] = DOT_EMPTY;
                }
            }
        }

        /**
         * Отрисовка игрового поля
         */
        static void printField(){

            System.out.print("+");

            // Шапка
            for (int i = 0; i < fieldSizeX * 2 + 1; i++){
                if (i % 2 == 0){
                    System.out.print('-');
                }
                else{
                    System.out.print(i / 2 + 1);
                }
            }
            System.out.println();

            // Игровое поле
            for(int i = 0; i < fieldSizeY; i++){
                System.out.print(i + 1 + "|");
                for(int j = 0; j < fieldSizeX; j++){
                    System.out.print(field[i][j] + "|");
                }
                System.out.println();
            }

            System.out.print("+");

            //
            for (int i = 0; i < fieldSizeX * 2 + 1; i++){
                System.out.print("-");
            }

            System.out.println();
        }

        /**
         * Обработка хода игрока (человека)
         */
        static void humanTurn(){
            int x, y;

            do{
                System.out.print("Введите координаты хода X и Y (от 1 до 3) через пробел >>> ");
                x = scanner.nextInt() - 1;
                y = scanner.nextInt() - 1;
            }
            while (!(isCellValid(x, y) && isCellEmpty(x, y)));

            field[y][x] = DOT_HUMAN;
        }

        /**
         * Обработка хода компьютера
         * TODO: Усложнить логику обработки хода компьютера
         */
        static void aiTurn(){
            int x, y;
            do{
                x = random.nextInt(fieldSizeX);
                y = random.nextInt(fieldSizeY);
            }
            while (!isCellEmpty(x, y));

            field[y][x] = DOT_AI;
        }

        /**
         * Проверка корректности ввода (координаты хода не должны превышать размерность массива,
         * описывающего игровое поле)
         * @param x
         * @param y
         * @return
         */
        static boolean isCellValid(int x, int y){
            return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
        }

        /**
         * Проверка, ячейка является пустой (DOT_EMPTY)
         * @param x
         * @param y
         * @return
         */
        static boolean isCellEmpty(int x, int y){
            return field[y][x] == DOT_EMPTY;
        }

        /**
         * Проверка победы
         * @param c Фишка игрока (человек или компьютер)
         * TODO: Переработать механизм проверки победы
         * @return Результат проверки победы
         */
        static boolean checkWin(char c){
            // Проверка по трем горизонталям
            if (field[0][0] == c && field[0][1] == c && field[0][2] == c) return true;
            if (field[1][0] == c && field[1][1] == c && field[1][2] == c) return true;
            if (field[2][0] == c && field[2][1] == c && field[2][2] == c) return true;

//            for(int i = 0; i < fieldSizeX; i++){
//                for(int j = 0; j < fieldSizeY; j++)
//                    if (field[i][j] == c && field[i][j] == c && field[i][j] == c) return true;
//            }

            // Проверка по трем вертикалям
            if (field[0][0] == c && field[1][0] == c && field[2][0] == c) return true;
            if (field[0][1] == c && field[1][1] == c && field[2][1] == c) return true;
            if (field[0][2] == c && field[1][2] == c && field[2][2] == c) return true;

            // Проверка по диагоналям
            if (field[0][0] == c && field[1][1] == c && field[2][2] == c) return true;
            if (field[0][2] == c && field[1][1] == c && field[2][0] == c) return true;

            return false;
        }

        /**
         * Проверка на ничью (все поле заполнено фишками игрока (человека) или компьютера)
         * @return
         */
        static boolean checkDraw(){
            for(int y = 0; y < fieldSizeY; y++){
                for(int x = 0; x < fieldSizeX; x++){
                    if (isCellEmpty(x, y))
                        return false;
                }
            }
            return true;
        }

        /**
         * Метод проверки состояния игры
         * (вызывается каждый раз, после того как игрок или компьютер совершит ход)
         * @param dot
         * @param s
         * @return
         */
        static boolean gameChecks(char dot, String s){
            // Проверка победы игрока (человек или компьютер, в зависимости от типа фишки)
            if (checkWin(dot)){
                System.out.println(s);
                return true;
            }
            // Проверка на ничью
            if (checkDraw()){
                System.out.println("Ничья!");
                return true;
            }
            // Продолжение игры
            return false;
        }

        public static void main(String[] args) {

            while (true) {
                initialize();
                printField();

                boolean f = true;
                while (f) {
                    humanTurn(); // Обработка хода игрока (человека)
                    printField();
                    if (gameChecks(DOT_HUMAN, "Вы победили!"))
                        break;
                    aiTurn(); // Обработка хода игрока (компьютера)
                    printField();
                    if (gameChecks(DOT_AI, "Победил компьютер!"))
                        break;
                }

                System.out.print("Желаете сыграть еще раз? (Y - да): ");
                if (!scanner.next().equalsIgnoreCase("Y"))
                    break;

            }

        }

    }

