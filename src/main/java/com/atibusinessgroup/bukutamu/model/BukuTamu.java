package com.atibusinessgroup.bukutamu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "buku_tamu")
public class BukuTamu {

    @Id
    private String id;

    @Column(name = "jenis")
    private String jenis;
    @Column(name = "nama")
    private String nama;
    @Column(name = "jenis_kelamin")
    private String jenisKelamin;
    @Column(name = "tipe_identitas")
    private String tipeIdentitas;
    @Column(name = "nomor_identitas")
    private String nomorIdentitas;
    @Column(name = "alamat")
    private String alamat;
    @Column(name = "keperluan")
    private String keperluan;
    @Column(name = "pihak_yg_ditemui")
    private String pihakYgDitemui;
    @Column(name = "created_date")
    private Instant createdDate;
    @Column(name = "keterangan")
    private String keterangan;
    @Column(name = "no_hp")
    private String noHp;
    @Column(name = "no_telepon")
    private String noTelepon;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getTipeIdentitas() {
        return tipeIdentitas;
    }

    public void setTipeIdentitas(String tipeIdentitas) {
        this.tipeIdentitas = tipeIdentitas;
    }

    public String getNomorIdentitas() {
        return nomorIdentitas;
    }

    public void setNomorIdentitas(String nomorIdentitas) {
        this.nomorIdentitas = nomorIdentitas;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKeperluan() {
        return keperluan;
    }

    public void setKeperluan(String keperluan) {
        this.keperluan = keperluan;
    }

    public String getPihakYgDitemui() {
        return pihakYgDitemui;
    }

    public void setPihakYgDitemui(String pihakYgDitemui) {
        this.pihakYgDitemui = pihakYgDitemui;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }
}
