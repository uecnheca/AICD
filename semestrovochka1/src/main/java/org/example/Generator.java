package org.example;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

public class Generator {
    public static void main(String[] args) {
        final int minSize = 100;
        final int maxSize = 10000;
        final int sets = 100;
        final String fileName = "set_";

        Random random = new Random();

        for (int i = 1; i <= sets; i++) {
            // Генерируем случайный размер от MIN_SIZE до MAX_SIZE
            int size = minSize + random.nextInt(maxSize - minSize + 1);

            // Создаем массив
            int[] dataset = new int[size];

            // Заполняем случайными числами
            for (int j = 0; j < size; j++) {
                dataset[j] = random.nextInt(100000); // Числа от 0 до 99999
            }

            // Сохраняем в файл
            saveToFile(fileName + i + ".txt", dataset);
        }

        System.out.println("Сгенерировано " + sets + " наборов данных.");
    }

    private static void saveToFile(String filename, int[] data) {
        try (FileWriter writer = new FileWriter(filename)) {
            // Записываем размер набора
            writer.write(data.length + "\n");

            // Записываем элементы
            for (int num : data) {
                writer.write(num + " ");
            }
        } catch (IOException e) {
            System.err.println("Ошибка при записи файла " + filename);
            e.printStackTrace();
        }
    }
}