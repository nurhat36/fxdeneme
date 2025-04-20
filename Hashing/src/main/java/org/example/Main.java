package org.example;
import java.util.Arrays;
import java.util.Random;

public class Main {
    private static final int TABLE_SIZE = 100;
    private static final int[] hashTableLinear = new int[TABLE_SIZE];
    private static final int[] hashTableQuadratic = new int[TABLE_SIZE];

    static {
        Arrays.fill(hashTableLinear, -1);
        Arrays.fill(hashTableQuadratic, -1);
    }

    // Hash fonksiyonu (Division method)
    private static int hashFunction(int key) {
        return key % TABLE_SIZE;
    }

    // Linear Probing ile yerleştirme
    private static void insertLinear(int key) {
        int index = hashFunction(key);
        while (hashTableLinear[index] != -1) {
            index = (index + 1) % TABLE_SIZE;
        }
        hashTableLinear[index] = key;
    }

    // Quadratic Probing ile yerleştirme
    private static void insertQuadratic(int key) {
        int index = hashFunction(key);
        int i = 1;
        while (hashTableQuadratic[index] != -1) {
            index = (hashFunction(key) + i * i) % TABLE_SIZE;
            if (index < 0) index += TABLE_SIZE; // Negatif indeksleri düzelt
            i++;
        }
        hashTableQuadratic[index] = key;
    }

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int key = random.nextInt(1000) + 1; // 1 ile 1000 arasında rastgele anahtarlar
            insertLinear(key);
            insertQuadratic(key);
        }

        // Hash tablolarını ekrana yazdır
        System.out.println("Linear Probing Hash Table:");
        System.out.println(Arrays.toString(hashTableLinear));

        System.out.println("\nQuadratic Probing Hash Table:");
        System.out.println(Arrays.toString(hashTableQuadratic));
    }
}