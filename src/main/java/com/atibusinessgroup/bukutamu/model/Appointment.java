package com.atibusinessgroup.bukutamu.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;
import java.util.Date;

@Entity
@Table(name = "appointment")
public class Appointment {

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
    @Column(name = "janji_temu_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date janjiTemuDate;
    @Column(name = "created_date")
    private Instant createdDate;
    @Column(name = "approved")
    private boolean approved;

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

    public Date getJanjiTemuDate() {
        return janjiTemuDate;
    }

    public void setJanjiTemuDate(Date janjiTemuDate) {
        this.janjiTemuDate = janjiTemuDate;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
}
