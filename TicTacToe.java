/**
 * Java 1. HomeWork 4
 *
 @ autor Shchukina Olga
 @ version 17.11.2021
*/

import java.util.Scanner;
import java.util.Random;

class TicTacToe {

    final char SIGN_X = 'x';
    final char SIGN_O = '0';
    final char SIGN_EMPTY = ' ';
    char[][] map;
    Scanner sc;
    Random random;

    public static void main(String[] args) {
        new TicTacToe().game();
    }

    TicTacToe() {
        map = new char[3][3];
        sc = new Scanner(System.in);
        random = new Random();
    }

    void game() {
        initMap();
        while (true) {
            turnHuman();
            if (checkWin(SIGN_X)) {
                System.out.println("YOU WIN!");
                break;
            }
            if (isMapFull()) {
                System.out.println("DRAW!");
                break;
            }
        turnAI();
        printMap();
            if (checkWin(SIGN_O)) {
                System.out.println("YOU LOSE");
                break;
            }
            if (isMapFull()) {
                System.out.println("DRAW!");
                break;
            }
        }
        System.out.println("GAME OVER!");
        printMap();
    }

    void initMap() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                map[i][j] = SIGN_EMPTY;
            }
        }
    }

    void printMap() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    void turnHuman() {
        int x, y;
        do {
            System.out.print("Enter X and Y (1..3):");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = SIGN_X;
    }

    void turnAI() {
        int x, y;
        do {
            x = random.nextInt(3);
            y = random.nextInt(3);
        } while (!isCellValid(x, y));
        map[y][x] = SIGN_O;
    }

    boolean checkWin(char ch) {
        for (int i = 0; i < 3; i++) {
            if ((map[i][0] == ch && map[i][1] == ch && map[i][2] == ch) ||
                (map[0][i] == ch && map[1][i] == ch && map[2][i] == ch)) {
                return true;
                }
        }
        if ((map[0][0] == ch && map[1][1] == ch && map [2][2] == ch) ||
            (map[2][0] == ch && map[1][1] == ch && map [0][2] == ch)) {
            return true;
        }
        return false;
    }

    boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= 3|| y >= 3)
            return false;
        return map[y][x] == SIGN_EMPTY;
    }

    boolean isMapFull() {
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
                if (map[row][col] == SIGN_EMPTY)
                    return false;
        return true;
    }
}