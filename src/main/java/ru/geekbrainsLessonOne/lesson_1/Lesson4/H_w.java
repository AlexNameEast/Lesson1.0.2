package ru.geekbrainsLessonOne.lesson_1.Lesson4;

import java.util.Random;
import java.util.Scanner;

public class H_w {

    static final char DOT_HUMAN = 'X';
    static final char DOT_AI = 'O';
    static final char DOT_EMPTY = '•';
    static final Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    static char[][] field;
    static int fieldSizeX;
    static int fieldSizeY;

    static void initialize(int x, int y) {
        field = new char[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                field[i][j] = DOT_EMPTY;
            }
        }
    }

    static boolean dotEmpty(int x, int y) {
        return field[x][y] == DOT_EMPTY;
    }

    static void humanTurn() {
        int x, y;
        do {
            System.out.print("Введите координаты для хода: ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!(isCellValid(y, x) && dotEmpty(y, x)));
        field[y][x] = DOT_HUMAN;

    }

    static void aiTurn() {
        int x, y;
        do {
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);
        } while (!dotEmpty(y, x));
        field[y][x] = DOT_AI;
    }

    static boolean isCellValid(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    public static void drawMap() {
        // top
        System.out.print("-");
        for (int i = 0; i < fieldSizeX * 2 + 1; i++) {
            if (i % 2 == 0) System.out.print(" ");
            else System.out.print(i / 2 + 1);
        }
        System.out.println();


        // field

        for (int i = 0; i < fieldSizeY; i++) {
            System.out.print(i + 1 + "|");
            for (int j = 0; j < fieldSizeX; j++) {
                System.out.print(field[i][j] + "|");
            }
            System.out.println();
        }

    }

    static boolean gameChecks(char dot, String s) {
        // Проверка победы игрока (человек или компьютер, в зависимости от типа фишки)
        if (checkWin2(dot,4)) {
            System.out.println(s);
            return true;
        }
        // Проверка на ничью
        if (checkDraw()) {
            System.out.println("Ничья!");
            return true;
        }
        // Продолжение игры
        return false;
    }
    // проверка с доп параметром
    static boolean checkWin2(char c, int kol) {
        // проверка по горизонтали
        boolean f = true;
        for (int i = 0; i < fieldSizeY; i++) {

            f = true;
            for (int j = 0,k=0; j < kol; j++) {
                if(j==kol-1+k && f==false ) {
                    f=true;
                    j= j-kol+2+k;
                    k++;
                }
                f = f & (field[j][i] == c);
            }
            if (f) return f;
        }
        // проверка по вертикали
        f = true;
        for (int i = 0; i < fieldSizeY; i++) {

            f = true;
            for (int j = 0; j < fieldSizeX; j++) {
                f = f & (field[i][j] == c);
            }
            if (f) return f;
        }
        //диагональ положительная
        f = true;
        for (int i = 0; i < fieldSizeY; i++) {
            f = f & (field[i][i] == c);
        }
        if (f) return f;

        //диагональ отрицательная
        f = true;
        for (int i = 0, j = fieldSizeX - 1; i < fieldSizeY; i++, j--) {
            f = f & (field[i][j] == c);
            if (f) return f;
        }

        return false;
    }

    static boolean checkWin(char c) {
        // проверка по горизонтали
        boolean f = true;
        for (int i = 0; i < fieldSizeY; i++) {

            f = true;
            for (int j = 0; j < fieldSizeX; j++) {
                f = f & (field[j][i] == c);
            }
            if (f) return f;
        }
        // проверка по вертикали
        f = true;
        for (int i = 0; i < fieldSizeY; i++) {

            f = true;
            for (int j = 0; j < fieldSizeX; j++) {
                f = f & (field[i][j] == c);
            }
            if (f) return f;
        }
        //диагональ положительная
        f = true;
        for (int i = 0; i < fieldSizeY; i++) {
            f = f & (field[i][i] == c);
        }
        if (f) return f;

        //диагональ отрицательная
        f = true;
        for (int i = 0, j = fieldSizeX - 1; i < fieldSizeY; i++, j--) {
                f = f & (field[i][j] == c);
            if (f) return f;
        }

        return false;
    }


    static boolean checkDraw() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isCellValid(x, y))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        while (true) {
            System.out.print("Введите размерность поля Х, Y: ");
            fieldSizeX = scanner.nextInt();
            fieldSizeY = scanner.nextInt();
            initialize(fieldSizeX, fieldSizeY);
            drawMap();

            boolean f = true;
            while (f) {
                humanTurn();
                drawMap();
                if (gameChecks(DOT_HUMAN, "Вы победили!"))
                    break;
                aiTurn();
                drawMap();
                if (gameChecks(DOT_AI, "Вы проиграли!"))
                    break;
            }
            System.out.print("Желаете сыграть еще раз? (Y - да): ");
            if (!scanner.next().equalsIgnoreCase("Y"))
                break;
        }

    }
}

