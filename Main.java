import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final int SIZE = 8;

    public static void main(String[] args) {
        Random random = new Random();
        int[][] colors = new int[SIZE][SIZE];
        int[][] rotatedColors = new int[SIZE][SIZE];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                colors[i][j] = random.nextInt(256);
            }
        }
        System.out.println("Исходная матрица:");
        outputMatrix(colors);
        while (true) {
            System.out.println("Введите угол поворота: 90, 180 или 270");
            int angle = scanner.nextInt();
            if (angle != 90 && angle != 180 && angle != 270) {
                System.out.println("Некорректный угол поворота!");
            } else {
                System.out.println("После поворота на " + angle + " градусов:");
                outputMatrix(rotateMatrix(colors, rotatedColors, angle));
                break;
            }

        }
    }

    public static void outputMatrix(int[][] matrix) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.format("%4d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] rotateMatrix(int[][] colors, int[][] rotatedColors, int angle) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                switch (angle) {
                    case 90:
                        rotatedColors[i][j] = colors[SIZE - 1 - j][i];// 90 градусов
                        break;
                    case 180:
                        rotatedColors[i][j] = colors[SIZE - 1 - i][SIZE - 1 - j]; // 180 градусов
                        break;
                    case 270:
                        rotatedColors[i][j] = colors[j][SIZE - 1 - i]; // 270 градусов
                        break;
                }
            }
        }
        return rotatedColors;
    }
}
