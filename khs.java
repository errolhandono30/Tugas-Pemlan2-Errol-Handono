package tugas3;

import java.util.ArrayList;
import java.util.Scanner;

public class khs {
    public static void main(String[] args) {

        Scanner sysin = new Scanner(System.in);
        ArrayList<MataKuliah> matkuls = new ArrayList<>();

        matkuls.add(new MataKuliah("Pemrograman Lanjut", "PL"));
        matkuls.add(new MataKuliah("Statistika", "ST"));
        matkuls.add(new MataKuliah("Pemrograman Dasar", "PD"));
        matkuls.add(new MataKuliah("Dasar Basis Data", "BD"));

        ArrayList<Mahasiswa> mhs = new ArrayList<>();

        String check = "y";

        while(check.equals("y")){
            sysin.nextLine();
            Mahasiswa mahasiswa = new Mahasiswa();
            System.out.print("Nama: ");
            String nama = sysin.nextLine();
            mahasiswa.setNama(nama);
            System.out.print("NIM: ");
            String nim = sysin.nextLine();
            mahasiswa.setNim(nim);
        
            for (MataKuliah matkul : matkuls) {
                System.out.print("Masukkan nilai untuk mata kuliah " + matkul.getNamaMk() + ": ");
                double nilai = sysin.nextDouble();
                sysin.nextLine(); // Consume newline
                mahasiswa.addNilai(matkul, nilai);
            }

            mhs.add(mahasiswa);

            System.out.print("Mau Menambah? (y/n)");
            String checking = sysin.next();
            check = checking;
        }

        // Print KHS
        for (Mahasiswa mahasiswa : mhs) {
            System.out.println("Mahasiswa: " + mahasiswa.getNim() + " - " + mahasiswa.getNama());
            System.out.println("Kartu Hasil Studi:");
            for (MataKuliah matkul : matkuls) {
                double nilai = mahasiswa.getNilai(matkul);
                String nilaiHuruf = konversiNilaiHuruf(nilai);
                System.out.println(matkul.getKodeMk() + " - " + matkul.getNamaMk() + ": " + nilaiHuruf);
            }
            System.out.println();
        }

        sysin.close();
    }

    // Method to convert nilai angka to nilai huruf
    public static String konversiNilaiHuruf(double nilai) {
        if (nilai >= 80) {
            return "A";
        } else if (nilai >= 70) {
            return "B";
        } else if (nilai >= 60) {
            return "C";
        } else if (nilai >= 50) {
            return "D";
        } else {
            return "E";
        }
    }
}


//class Matkul
class MataKuliah {
    private String kodeMk;
    private String namaMk;

    public MataKuliah(String namaMk, String kodeMk) {
        this.kodeMk = kodeMk;
        this.namaMk = namaMk;
    }

    public String getKodeMk() {
        return kodeMk;
    }

    public String getNamaMk() {
        return namaMk;
    }
}

//class Mahasiswa
class Mahasiswa {
    private String nama;
    private String nim;
    private ArrayList<Double> nilaiMatkuls;

    public Mahasiswa() {
        nilaiMatkuls = new ArrayList<>();
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public void addNilai(MataKuliah matkul, double nilai) {
        nilaiMatkuls.add(nilai);
    }

    public double getNilai(MataKuliah matkul) {
        int index = matkul.getKodeMk().charAt(0) - 'A'; // Assuming only capital letters for simplicity
        if (index >= 0 && index < nilaiMatkuls.size()) {
            return nilaiMatkuls.get(index);
        }
        return -1; 
    }
    
}


