package org.example;
import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        // Папка с тестовыми файлами
        File folder = new File("DataSets");
        File[] files = folder.listFiles();

        // Проверяем каждый файл
        for (File file : files) {
            if (file.isFile()) {
                testSorting(file);
            }
        }
    }

    public static void testSorting(File testFile) {
        try {
            // Читаем числа из файла
            int[] numbers = readNumbersFromFile(testFile);

            // Замеряем время
            long start = System.nanoTime();
            HeapSort.sort(numbers);
            long end = System.nanoTime();

            // Проверяем результат
            boolean isCorrect = checkSorted(numbers);

            // Выводим отчет
            System.out.println("Файл: " + testFile.getName());
            System.out.println("Элементов: " + numbers.length);
            System.out.println("Правильно отсортирован: " + isCorrect);
            System.out.println();

        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + testFile.getName());
        }
    }

    // Чтение чисел из файла
    private static int[] readNumbersFromFile(File file) throws IOException {
        Scanner scanner = new Scanner(file);
        List<Integer> numbers = new ArrayList<>();

        while (scanner.hasNextInt()) {
            numbers.add(scanner.nextInt());
        }

        scanner.close();

        // Конвертируем в массив
        int[] result = new int[numbers.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = numbers.get(i);
        }

        return result;
    }

    // Проверка отсортированности
    private static boolean checkSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i+1]) {
                return false;
            }
        }
        return true;
    }
}