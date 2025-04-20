package org.example;

public class Main {
    public static void main(String[] args) {

        int[] dizi = new int[10];
        int[] veriler = {15, 25, 35, 20, 30, 40, 10, 5};

        for (int i = 0; i < veriler.length; i++) {
            int index = veriler[i] % 10;
            int hash2 = 7 - (veriler[i] % 7);
            int j = 0;

            while (dizi[index] != 0) {
                index = (index + j * hash2) % 10;
                j++;
                if (j > 10) {
                    break;
                }
            }
            dizi[index] = veriler[i];
        }

        for (int i = 0; i < dizi.length; i++) {
            System.out.println(i + ": " + (dizi[i] != 0 ? dizi[i] : "null"));
        }
    }
}
