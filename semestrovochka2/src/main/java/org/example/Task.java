package org.example;

/*
Задача:
Есть список посещения страниц на сайте. Найти как часто посещают ту или иную страницу на сайте.
**/

import java.io.*;

public class Task {
    public static void main(String[] args) {
        long[] timesAdding = new long[100];
        long[] timesGetting = new long[100];
        long[] timesDeleting = new long[100];
        int index = 0;
        for (int i = 100; i < 10001; i += 100) {
            long addTime = 0;
            long getTime = 0;
            long removeTime;

            File file = new File("C:\\java\\Semestr2\\task_case\\test_"+i+".txt");
            String[] words = readFile(file);
            String lastWord = words[i - 1];

            BasicHashTable<String, Integer> table = new BasicHashTable<>();

            for (String word : words) {
                long st1 = System.nanoTime();
                Integer count = table.get(word);
                long end1 = System.nanoTime() - st1;
                getTime = Math.max(getTime, end1);
                if (count == null) {
                    long st = System.nanoTime();
                    table.put(word, 1);
                    long end = System.nanoTime() - st;
                    addTime = Math.max(addTime, end);
                } else {
                    long st = System.nanoTime();
                    table.put(word, count + 1);
                    long end = System.nanoTime() - st;
                    addTime = Math.max(addTime, end);
                }
            }
            long st = System.nanoTime();
            table.remove(lastWord);
            removeTime = System.nanoTime() - st;

            timesAdding[index] = addTime;
            timesGetting[index] = getTime;
            timesDeleting[index] = removeTime;
            index++;
        }


        try (FileWriter writer = new FileWriter("results.txt")) {
            for (int i = 0; i < 100; i++) {
                writer.write(((i + 1) * 100) + ";" + timesAdding[i] + ";" +
                        + timesGetting[i] + ";" + timesDeleting[i] + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String[] readFile(File file) {
        try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
            StringBuffer sb = new StringBuffer();

            String line;
            while ((line = bf.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString().split("[^a-zA-Zа-яА-Я]+");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
