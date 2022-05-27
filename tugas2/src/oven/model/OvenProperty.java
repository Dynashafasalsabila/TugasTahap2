/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oven.model;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *

 */
public class OvenProperty {
    private StringProperty id;
    private StringProperty nama;
    private StringProperty tanggalBeli;
    private StringProperty MerkOven;
    private StringProperty pembayaran;

    public OvenProperty(String id, String nama, String tanggalBeli, String MerkOven, String pembayaran) {
        this.id = new SimpleStringProperty(id);
        this.nama = new SimpleStringProperty(nama);
        this.tanggalBeli = new SimpleStringProperty(tanggalBeli);
        this.MerkOven = new SimpleStringProperty(MerkOven);
        this.pembayaran = new SimpleStringProperty(pembayaran);
    }
    public OvenProperty(Oven ovn){
        this.id = new SimpleStringProperty(ovn.getId());
        this.nama = new SimpleStringProperty(ovn.getNama());
        this.tanggalBeli = new SimpleStringProperty(ovn.getTanggalBeli());
        this.MerkOven = new SimpleStringProperty(ovn.getMerkOven());
        this.pembayaran = new SimpleStringProperty(ovn.getPembayaran());
    }
    public StringProperty getProdiProperty() {
        return pembayaran;
    }

    public void setPembayaran(String pembayaran) {
        this.pembayaran = new SimpleStringProperty(pembayaran);
    }

    public StringProperty getIdProperty() {
        return id;
    }

    public void setId(String id) {
        this.id = new SimpleStringProperty(id);
    }

    public StringProperty getNamaProperty() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = new SimpleStringProperty(nama);
    }

    public StringProperty getTanggalBeliProperty() {
        return tanggalBeli;
    }

    public void setTanggalBeli(String tanggalBeli) {
        this.tanggalBeli = new SimpleStringProperty(tanggalBeli);
    }

    public StringProperty getMerkOvenProperty() {
        return MerkOven;
    }

    public void setMerkOven(String MerkOven) {
        this.MerkOven = new SimpleStringProperty(MerkOven);
    }

    public String getId() {
        return id.get();
    }

    public String getNama() {
        return nama.get();
    }

    public String getTanggalBeli() {
        return tanggalBeli.get();
    }

    public String getMerkOven() {
        return MerkOven.get();
    }

    public String getPembayaran() {
        return pembayaran.get();
    }
    
}
