package com.atibusinessgroup.bukutamu.model.dto;

import java.io.Serializable;
import java.util.Optional;

public class SearchPegawaiListDTO implements Serializable {

    private Optional<Integer> page = Optional.ofNullable(0);
    private Optional<Integer> size = Optional.ofNullable(10);
    private Optional<String> nama =  Optional.of("");
    private Optional<String> jabatan =  Optional.of("");

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

    public Optional<String> getNama() {
        return nama;
    }

    public void setNama(Optional<String> nama) {
        this.nama = nama;
    }

    public Optional<String> getJabatan() {
        return jabatan;
    }

    public void setJabatan(Optional<String> jabatan) {
        this.jabatan = jabatan;
    }
}
