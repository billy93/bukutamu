package com.atibusinessgroup.bukutamu.model.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.Optional;

public class SearchAppointmentListDTO implements Serializable {

    private Optional<Integer> page = Optional.ofNullable(0);
    private Optional<Integer> size = Optional.ofNullable(10);
    private Optional<String> jenis =  Optional.of("");
    private Optional<String> nama =  Optional.of("");
    private Optional<String> nomorIdentitas =  Optional.of("");
    private Optional<String> keperluan =  Optional.of("");
    private Optional<String> noHp =  Optional.of("");

    public Optional<Integer> getPage() {
        return page;
    }

    public void setPage(Optional<Integer> page) {
        this.page = page;
    }

    public Optional<Integer> getSize() {
        return size;
    }

    public void setSize(Optional<Integer> size) {
        this.size = size;
    }

    public Optional<String> getJenis() {
        return jenis;
    }

    public void setJenis(Optional<String> jenis) {
        this.jenis = jenis;
    }

    public Optional<String> getNama() {
        return nama;
    }

    public void setNama(Optional<String> nama) {
        this.nama = nama;
    }

    public Optional<String> getNomorIdentitas() {
        return nomorIdentitas;
    }

    public void setNomorIdentitas(Optional<String> nomorIdentitas) {
        this.nomorIdentitas = nomorIdentitas;
    }

    public Optional<String> getKeperluan() {
        return keperluan;
    }

    public void setKeperluan(Optional<String> keperluan) {
        this.keperluan = keperluan;
    }

    public Optional<String> getNoHp() {
        return noHp;
    }

    public void setNoHp(Optional<String> noHp) {
        this.noHp = noHp;
    }
}
