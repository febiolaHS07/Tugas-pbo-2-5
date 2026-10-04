/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemabsensimurid;

/**
 *
 * @author HYPE AMD
 */
// File: SistemAbsensi.java
import java.util.Scanner;

// File: SistemAbsensi.java
import java.util.Scanner;

public class SistemAbsensi {

    public static void cariSiswa(String nama, Siswa[] daftar, int total) {
        System.out.println("\n--- Hasil Pencarian Nama: '" + nama + "' ---");
        boolean ditemukan = false;
        for (int i = 0; i < total; i++) {
            if (daftar[i].getNama().equalsIgnoreCase(nama)) {
                daftar[i].tampilkanInfo();
                daftar[i].statusAbsensi();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Data siswa dengan nama '" + nama + "' tidak ditemukan.");
        }
    }

   
    public static void cariSiswa(int nisn, Siswa[] daftar, int total) {
        System.out.println("\n--- Hasil Pencarian NISN: " + nisn + " ---");
        boolean ditemukan = false;
        for (int i = 0; i < total; i++) {
            if (daftar[i].getNisn() == nisn) {
                daftar[i].tampilkanInfo();
                daftar[i].statusAbsensi();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Data siswa dengan NISN " + nisn + " tidak ditemukan.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Siswa[] daftarSiswa = new Siswa[20]; 
        int jumlahSiswa = 0;
        boolean isRunning = true;
        
        System.out.println("==========================================================================");
        System.out.println("                  SISTEM MANAJEMEN ABSENSI MAHASISWA                      ");
        System.out.println("==========================================================================");

     
        while (isRunning) {
            System.out.println("\n=========================== MENU UTAMA ===========================");
            System.out.println("1. Tambah Data Siswa Baru");
            System.out.println("2. Tampilkan Seluruh Data Presensi (Method Overriding)");
            System.out.println("3. Cari Data Siswa (Method Overloading)");
            System.out.println("4. Keluar Sistem");
            System.out.print("Pilih Menu (1-4): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Input harus berupa angka!");
                scanner.next();
                continue;
            }

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1 -> {
                    if (jumlahSiswa < daftarSiswa.length) {
                        System.out.println("\n--- Tambah Data Siswa Baru ---");
                        System.out.println("Pilih Tipe Siswa:");
                        System.out.println("1. Siswa Reguler");
                        System.out.println("2. Siswa Beasiswa");
                        System.out.print("Pilihan (1/2): ");
                        
                        int tipe = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Masukkan Nama Siswa  : ");
                        String nama = scanner.nextLine();
                        System.out.print("Masukkan NISN        : ");
                        int nisn = scanner.nextInt();
                        
                
                        int hadir;
                        do {
                            System.out.print("Masukkan Jml Hadir (0-16) : ");
                            while (!scanner.hasNextInt()) {
                                System.out.println("LOG VALIDASI: Input harus berupa angka!");
                                scanner.next();
                            }
                            hadir = scanner.nextInt();
                            
                            if (hadir < 0 || hadir > Siswa.TOTAL_PERTEMUAN) {
                                System.out.println("LOG VALIDASI: Kehadiran tidak boleh < 0 atau > " + Siswa.TOTAL_PERTEMUAN + "! Coba lagi.");
                            }
                        } while (hadir < 0 || hadir > Siswa.TOTAL_PERTEMUAN);

                        scanner.nextLine(); // Clear buffer
                        System.out.print("Masukkan Mata Kuliah : ");
                        String mataKuliah = scanner.nextLine();

                        if (tipe == 1) {
                            daftarSiswa[jumlahSiswa++] = new SiswaReguler(nama, nisn, hadir, mataKuliah);
                        } else if (tipe == 2) {
                            daftarSiswa[jumlahSiswa++] = new SiswaBeasiswa(nama, nisn, hadir, mataKuliah);
                        } else {
                            System.out.println("Tipe tidak valid! Pendaftaran dibatalkan.");
                            break;
                        }
                        System.out.println("-> SUKSES: Data siswa berhasil disimpan.");
                    } else {
                        System.out.println("Kapasitas penyimpanan array sudah penuh!");
                    }
                }

                case 2 -> {
                    System.out.println("\n===============================================================================================");
                    System.out.println("                                  DAFTAR PRESENSI SISWA                                        ");
                    System.out.println("===============================================================================================");
                    System.out.printf("Total Objek Terbuat (Static Counter): %d%n", Siswa.totalSiswaBerhasilDibuat);
                    System.out.println("-----------------------------------------------------------------------------------------------");

                    if (jumlahSiswa == 0) {
                        System.out.println("Belum ada data siswa yang tersimpan.");
                    } else {
                        for (int i = 0; i < jumlahSiswa; i++) {
                            System.out.printf("%d. ", (i + 1));
                            daftarSiswa[i].tampilkanInfo(); 
                            daftarSiswa[i].statusAbsensi();  
                            System.out.println("-----------------------------------------------------------------------------------------------");
                        }
                    }
                }

                case 3 -> {
                    System.out.println("\n--- Fitur Pencarian Data (Overloading) ---");
                    System.out.println("1. Cari Berdasarkan Nama (Teks)");
                    System.out.println("2. Cari Berdasarkan NISN (Angka)");
                    System.out.print("Pilih Opsi (1/2): ");
                    int opsiCari = scanner.nextInt();
                    scanner.nextLine();

                    if (opsiCari == 1) {
                        System.out.print("Masukkan Nama: ");
                        String namaCari = scanner.nextLine();
                        cariSiswa(namaCari, daftarSiswa, jumlahSiswa);
                    } else if (opsiCari == 2) {
                        System.out.print("Masukkan NISN: ");
                        int nisnCari = scanner.nextInt();
                        scanner.nextLine();
                        cariSiswa(nisnCari, daftarSiswa, jumlahSiswa);
                    } else {
                        System.out.println("Opsi pencarian tidak valid.");
                    }
                }

                case 4 -> {
                    System.out.println("\nTerima kasih! Program selesai dijalankan.");
                    isRunning = false;
                }

                default -> System.out.println("Pilihan tidak valid. Silakan pilih 1-4.");
            }
        }
        scanner.close();
    }
}