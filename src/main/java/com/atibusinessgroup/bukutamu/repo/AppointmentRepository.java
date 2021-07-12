package com.atibusinessgroup.bukutamu.repo;

import com.atibusinessgroup.bukutamu.model.Appointment;
import com.atibusinessgroup.bukutamu.model.BukuTamu;
import com.atibusinessgroup.bukutamu.model.dto.AppointmentDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long>, PagingAndSortingRepository<Appointment, Long> {

    @Query(value = "SELECT b.id, b.jenis, b.nama, b.jenis_kelamin as jenisKelamin, " +
            "b.tipe_identitas as tipeIdentitas, b.nomor_identitas as nomorIdentitas, " +
            "b.alamat, b.keperluan, b.pihak_yg_ditemui as pihakYgDitemui, p.nama as pihakYgDitemuiNama, b.created_date as createdDate, " +
            "b.keterangan, b.no_hp as noHp, b.no_telepon as noTelepon, b.approved, b.janji_temu_date as janjiTemuDate from appointment as b " +
            "left join pegawai p on p.id = cast(b.pihak_yg_ditemui as int) "+
            "where (?1 IS NULL OR ?1='' OR b.jenis  = ?1) AND " +
            "(?2 IS NULL OR ?2='' OR b.nama LIKE CONCAT('%', ?2, '%')) AND "+
            "(?3 IS NULL OR ?3='' OR b.keperluan LIKE CONCAT('%', ?3, '%')) AND "+
            "(?4 IS NULL OR ?4='' OR b.no_hp LIKE CONCAT('%', ?4, '%')) AND " +
            "(?5 IS NULL OR ?5='' OR b.nomor_identitas LIKE CONCAT('%', ?5, '%')) AND "+
            "(CASE WHEN ?6='null' THEN TRUE ELSE b.janji_temu_date >= cast(?6 as date) end) AND "+
            "(CASE WHEN ?7='null' THEN TRUE ELSE b.janji_temu_date <= cast(?7 as date) end) "+
            "order by b.created_date desc"
            ,
            countQuery = "SELECT count(*) from buku_tamu as b " +
                    "left join pegawai p on p.id = cast(b.pihak_yg_ditemui as int) "+
                    "where (?1 IS NULL OR ?1='' OR b.jenis  = ?1) AND " +
                    "(?2 IS NULL OR ?2='' OR b.nama LIKE CONCAT('%', ?2, '%')) AND " +
                    "(?3 IS NULL OR ?3='' OR b.keperluan LIKE CONCAT('%', ?3, '%')) AND "+
                    "(?4 IS NULL OR ?4='' OR b.no_hp LIKE CONCAT('%', ?4, '%')) AND " +
                    "(?5 IS NULL OR ?5='' OR b.nomor_identitas LIKE CONCAT('%', ?5, '%')) AND "+
                    "(CASE WHEN ?6='null' THEN TRUE ELSE b.janji_temu_date >= cast(?6 as date) end) AND "+
                    "(CASE WHEN ?7='null' THEN TRUE ELSE b.janji_temu_date <= cast(?7 as date) end) "
            , nativeQuery = true)
    Page<AppointmentDTO> findAll(String jenis, String nama, String keperluan, String noHp, String nomorIdentitas, String startDate, String endDate, Pageable page);
}
