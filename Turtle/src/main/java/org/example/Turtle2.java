package org.example;

public class Turtle2 {
    public static int minSum(int[][] arr) {
        if (arr == null || arr.length == 0 || arr[0].length == 0) {
            return 0;
        }

        int m = arr.length;
        int n = arr[0].length;

        // Создаем массив для хранения минимальных сумм
        int[][] min = new int[m][n];
        min[0][0] = arr[0][0];

        // Заполняем первую строку (можем идти только вправо)
        for (int j = 1; j < n; j++) {
            min[0][j] = min[0][j - 1] + arr[0][j];
        }

        // Заполняем первый столбец (можем идти только вниз)
        for (int i = 1; i < m; i++) {
            min[i][0] = min[i - 1][0] + arr[i][0];
        }

        // Заполняем остальные ячейки
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                min[i][j] = Math.min(min[i - 1][j], min[i][j - 1]) + arr[i][j];
            }
        }

        return min[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        System.out.println("Минимальная сумма пути: " + minSum(grid));
    }
}