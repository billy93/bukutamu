package com.atibusinessgroup.bukutamu.model.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

public interface AppointmentDTO {

    public Long getId();

    public String getJenis();

    public String getNama();

    public String getJenisKelamin();

    public String getTipeIdentitas();

    public String getNomorIdentitas();

    public String getAlamat();

    public String getKeperluan();

    public String getPihakYgDitemui();

    public String getPihakYgDitemuiNama();

    public String getKeterangan();

    public String getNoHp();

    public String getNoTelepon();

    public Date getJanjiTemuDate();

    public Instant getCreatedDate();

    public int getApproved();
}
