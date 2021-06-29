package com.atibusinessgroup.bukutamu.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
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
    @Column(name = "keterangan")
    private String keterangan;
    @Column(name = "no_hp")
    private String noHp;
    @Column(name = "no_telepon")
    private String noTelepon;
    @Column(name = "janji_temu_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date janjiTemuDate;
    @Column(name = "created_date")
    private Instant createdDate;
    @Column(name = "approved")
    private boolean approved;
    @Transient
    private String tanggal;
    @Transient
    private String jam;

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

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id='" + id + '\'' +
                ", jenis='" + jenis + '\'' +
                ", nama='" + nama + '\'' +
                ", jenisKelamin='" + jenisKelamin + '\'' +
                ", tipeIdentitas='" + tipeIdentitas + '\'' +
                ", nomorIdentitas='" + nomorIdentitas + '\'' +
                ", alamat='" + alamat + '\'' +
                ", keperluan='" + keperluan + '\'' +
                ", pihakYgDitemui='" + pihakYgDitemui + '\'' +
                ", keterangan='" + keterangan + '\'' +
                ", noHp='" + noHp + '\'' +
                ", noTelepon='" + noTelepon + '\'' +
                ", janjiTemuDate=" + janjiTemuDate +
                ", createdDate=" + createdDate +
                ", approved=" + approved +
                ", tanggal='" + tanggal + '\'' +
                ", jam='" + jam + '\'' +
                '}';
    }
}
