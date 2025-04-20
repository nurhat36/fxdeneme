package org.example;
import java.util.*;

class Musteri {
    String ad;
    int oncelik;

    public Musteri(String ad, int oncelik) {
        this.ad = ad;
        this.oncelik = oncelik;
    }

    @Override
    public String toString() {
        return "Müşteri: " + ad + " (Öncelik: " + (oncelik == 1 ? "Öncelikli" : "Normal") + ")";
    }
}

class OncelikliKuyruk {
    private Musteri[] kuyruk;
    private int boyut;

    public OncelikliKuyruk(int kapasite) {
        kuyruk = new Musteri[kapasite];
        boyut = 0;
    }

    public void ekle(Musteri musteri) {
        if (boyut == kuyruk.length) {
            System.out.println("Kuyruk dolu!");
            return;
        }
        kuyruk[boyut++] = musteri;
        sirala();
    }

    private void sirala() {
        for (int i = 0; i < boyut - 1; i++) {
            for (int j = 0; j < boyut - i - 1; j++) {
                if (kuyruk[j].oncelik > kuyruk[j + 1].oncelik) {
                    Musteri temp = kuyruk[j];
                    kuyruk[j] = kuyruk[j + 1];
                    kuyruk[j + 1] = temp;
                }
            }
        }
    }

    public Musteri siradaki() {
        if (boyut == 0) {
            System.out.println("Kuyrukta müşteri yok.");
            return null;
        }
        Musteri siradaki = kuyruk[0];
        for (int i = 0; i < boyut - 1; i++) {
            kuyruk[i] = kuyruk[i + 1];
        }
        boyut--;
        return siradaki;
    }

    public boolean bosMu() {
        return boyut == 0;
    }
}

public class Main {
    public static void main(String[] args) {
        OncelikliKuyruk kuyruk = new OncelikliKuyruk(10);

        // Örnek müşteri eklemeleri
        kuyruk.ekle(new Musteri("Ahmet", 2));
        kuyruk.ekle(new Musteri("Zeynep", 1)); // Öncelikli
        kuyruk.ekle(new Musteri("Mehmet", 2));
        kuyruk.ekle(new Musteri("Ayşe", 1)); // Öncelikli

        kuyruk.ekle(new Musteri("nurhat", 1)); // Öncelikli
        kuyruk.ekle(new Musteri("baydağ", 1)); // Öncelikli

        System.out.println("\nBankadaki Sıra Durumu:");
        while (!kuyruk.bosMu()) {
            System.out.println(kuyruk.siradaki());
        }
    }
}
