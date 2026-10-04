/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemabsensimurid;

/**
 *
 * @author HYPE AMD
 */
public class SiswaBeasiswa extends Siswa {
    private String mataKuliah;

    public SiswaBeasiswa(String nama, int nisn, int jumlahHadir, String mataKuliah) {
        super(nama, nisn, jumlahHadir);
        this.mataKuliah = mataKuliah;
    }

    public String getMataKuliah() {
        return this.mataKuliah;
    }

    public void setMataKuliah(String mataKuliah) {
        this.mataKuliah = mataKuliah;
    }

    @Override
    public void tampilkanInfo() {
        System.out.print("[Beasiswa] ");
        super.tampilkanInfo();
        System.out.printf(" | Mata Kuliah: %-15s%n", this.mataKuliah);
    }

    @Override
    public void statusAbsensi() {
        int minimalHadir = TOTAL_PERTEMUAN;
        boolean memenuhi = getJumlahHadir() >= minimalHadir;

        System.out.printf("-> Syarat Beasiswa: Wajib %d/%d pertemuan (100%%) | Status: %s%n",
                minimalHadir, TOTAL_PERTEMUAN, (memenuhi ? "MEMENUHI SYARAT (Beasiswa Aman)" : "TIDAK MEMENUHI (Terancam Dicabut)"));
    }
}