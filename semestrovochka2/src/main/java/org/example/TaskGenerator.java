package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.Random;

public class TaskGenerator {
    static String[] dictionary = {
            "home", "about", "home", "contact", "home", "about",
            "products", "home", "blog", "contact", "faq", "about",
            "home", "blog", "products", "faq", "home", "about",
            "blog", "home", "services", "home", "contact", "faq",
            "about", "products", "home", "services", "blog", "faq",
            "about", "home", "contact", "blog", "home", "about"
    };

    public static void main(String[] args) throws IOException {
        generateAverageCases(100, 100);
    }

    public static void generateAverageCases(int count, int step) throws IOException {
        Files.createDirectories(Paths.get("task_case"));

        for (int i = 1; i <= count; i++) {
            int size = i * step;

            String[] average = generateRandomArray(size);

            writeArrayToFile(average, "task_case/test_" + size + ".txt");
        }

        System.out.println("Генерация завершена: " + count * 3 + " файлов.");
    }

    private static String[] generateRandomArray(int size) {
        Random rand = new Random();
        String[] array = new String[size];
        for (int i = 0; i < size; i++) {
            array[i] = dictionary[rand.nextInt(dictionary.length)];
        }
        return array;
    }

    private static void writeArrayToFile(String[] array, String filename) throws IOException {
        try (FileWriter writer = new FileWriter(filename)) {
            for (int i = 0; i < array.length; i++) {
                writer.write(array[i] + (i < array.length - 1 ? " " : ""));
            }
        }
    }
}
