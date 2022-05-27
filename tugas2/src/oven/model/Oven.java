/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oven.model;

/**
 *
 */
public class Oven {
    private String id;
    private String nama;
    private String tanggalBeli;
    private String MerkOven;
    private String pembayaran;

    public Oven(String id, String nama, String tanggalBeli, String MerkOven, String Pembayaran) {
        this.id = id;
        this.nama = nama;
        this.tanggalBeli = tanggalBeli;
        this.MerkOven = MerkOven;
        this.pembayaran = pembayaran;
    }

    public String getPembayaran() {
        return pembayaran;
    }

    public void setPembayaran(String pembayaran) {
        this.pembayaran = pembayaran;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTanggalBeli() {
        return tanggalBeli;
    }

    public void setTanggalBeli(String tanggalBeli) {
        this.tanggalBeli = tanggalBeli;
    }

    public String getMerkOven() {
        return MerkOven;
    }

    public void setMerkOven(String MerkOven) {
        this.MerkOven = MerkOven;
    }
    
}
