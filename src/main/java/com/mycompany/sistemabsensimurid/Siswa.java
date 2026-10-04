/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemabsensimurid;

/**
 *
 * @author HYPE AMD
 */
public class Siswa {
    private String nama;
    private int nisn;
    private int jumlahHadir;

    public static final int TOTAL_PERTEMUAN = 16;
    public static int totalSiswaBerhasilDibuat = 0;

    public Siswa(String nama, int nisn, int jumlahHadir) {
        this.nama = nama;
        this.nisn = nisn;
        setJumlahHadir(jumlahHadir); 
        totalSiswaBerhasilDibuat++;
    }

    public double getPersentaseKehadiran() {
        return ((double) this.jumlahHadir / TOTAL_PERTEMUAN) * 100.0;
    }

    public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {
        if (nama != null && !nama.trim().isEmpty()) {
            this.nama = nama;
        } else {
            System.out.println("LOG VALIDASI: Nama tidak boleh kosong!");
        }
    }

    public int getNisn() {
        return this.nisn;
    }

    public void setNisn(int nisn) {
        if (nisn > 0) {
            this.nisn = nisn;
        } else {
            System.out.println("LOG VALIDASI: NISN harus berupa angka positif!");
        }
    }

    public int getJumlahHadir() {
        return this.jumlahHadir;
    }

    public void setJumlahHadir(int jumlahHadir) {
        if (jumlahHadir >= 0 && jumlahHadir <= TOTAL_PERTEMUAN) {
            this.jumlahHadir = jumlahHadir;
        } else if (jumlahHadir > TOTAL_PERTEMUAN) {
            System.out.println("LOG VALIDASI: Kehadiran melebihi " + TOTAL_PERTEMUAN + "! Otomatis diatur ke " + TOTAL_PERTEMUAN);
            this.jumlahHadir = TOTAL_PERTEMUAN;
        } else {
            System.out.println("LOG VALIDASI: Kehadiran tidak boleh negatif! Otomatis diatur ke 0");
            this.jumlahHadir = 0;
        }
    }

    public void tampilkanInfo() {
        System.out.printf("NISN: %-10d | Nama: %-15s | Kehadiran: %2d/%d Pertemuan (%5.1f%%)",
                this.nisn, this.nama, this.jumlahHadir, TOTAL_PERTEMUAN, getPersentaseKehadiran());
    }

    public void statusAbsensi() {
        System.out.println("Status: Mengikuti prosedur absensi akademik standar.");
    }
}