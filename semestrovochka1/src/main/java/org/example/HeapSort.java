package org.example;

public class HeapSort {
    private static long iterationCount = 0;

    public static void sort(int[] arr) {
        iterationCount = 0; // Сбрасываем счетчик итераций
        long startTime = System.nanoTime(); // Начало измерения времени

        // Построение max-heap
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapify(arr, arr.length, i);
            iterationCount++; // Учет итерации внешнего цикла
        }

        // Извлечение элементов из кучи один за другим
        for (int i = arr.length - 1; i > 0; i--) {
            // Перемещаем текущий корень в конец
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            iterationCount++; // Учет итерации основного цикла

            // Вызываем heapify на уменьшенной куче
            heapify(arr, i, 0);
        }

        long endTime = System.nanoTime(); // Конец измерения времени
        long time = endTime - startTime;

        System.out.println("Время выполнения: " + time + " нс (" +
                (time/1_000_000) + " мс)");
        System.out.println("Количество итераций: " + iterationCount);
    }

    // Просеивание вниз (sift-down) для поддерева с корнем в i
    private static void heapify(int[] arr, int n, int i) {
        iterationCount++; // Учет входа в heapify (рекурсивный случай)

        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Сравнение с левым потомком
        iterationCount++;
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // Сравнение с правым потомком
        iterationCount++;
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // Проверка необходимости обмена
        iterationCount++;
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Рекурсивный вызов
            heapify(arr, n, largest);
        }
    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

    }
}