package com.atibusinessgroup.bukutamu.model.dto;

import java.io.Serializable;

public class SearchPegawaiListNonOptionalDTO implements Serializable {

    private Integer page = 0;
    private Integer size = 10;

    private String nama = "";
    private String jabatan = "";

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }
}
