package com.atibusinessgroup.bukutamu.model.dto;

import javax.persistence.*;
import java.time.Instant;

public interface BukuTamuDTO {

    public String getId();

    public String getJenis();

    public String getNama();

    public String getJenisKelamin();

    public String getTipeIdentitas();

    public String getNomorIdentitas();

    public String getAlamat();

    public String getKeperluan();

    public String getPihakYgDitemui();

    public String getPihakYgDitemuiNama();

    public Instant getCreatedDate();

    public String getKeterangan();

    public String getNoHp();

    public String getNoTelepon();
}
