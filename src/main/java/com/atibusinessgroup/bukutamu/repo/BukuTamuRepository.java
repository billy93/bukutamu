package com.atibusinessgroup.bukutamu.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.atibusinessgroup.bukutamu.model.BukuTamu;

import javax.persistence.Column;
import javax.persistence.Id;
import java.time.Instant;

@Repository
public interface BukuTamuRepository extends JpaRepository<BukuTamu, String>, PagingAndSortingRepository<BukuTamu, String> {

    @Query(value = "SELECT b.id, b.jenis, b.nama, b.jenis_kelamin as jenisKelamin, " +
            "b.tipe_identitas as tipeIdentitas, b.nomor_identitas as nomorIdentitas, " +
            "b.alamat, b.keperluan, b.pihak_yg_ditemui as pihakYgDitemui, b.created_date as createdDate, " +
            "b.keterangan, b.no_hp as noHp, b.no_telepon as noTelepon from buku_tamu as b " +
            "where (?1 IS NULL OR ?1='' OR b.jenis  = ?1) AND " +
            "(?2 IS NULL OR ?2='' OR b.nama LIKE CONCAT('%', ?2, '%')) AND "+
            "(?3 IS NULL OR ?3='' OR b.keperluan LIKE CONCAT('%', ?3, '%')) AND "+
            "(?4 IS NULL OR ?4='' OR b.no_hp LIKE CONCAT('%', ?4, '%')) AND " +
            "(?5 IS NULL OR ?5='' OR b.nomor_identitas LIKE CONCAT('%', ?5, '%'))"
            ,
            countQuery = "SELECT count(*) from buku_tamu " +
                    "where (?1 IS NULL OR ?1='' OR b.jenis  = ?1) AND " +
                    "(?2 IS NULL OR ?2='' OR b.nama LIKE CONCAT('%', ?2, '%')) AND " +
                    "(?3 IS NULL OR ?3='' OR b.keperluan LIKE CONCAT('%', ?3, '%')) AND "+
                    "(?4 IS NULL OR ?4='' OR b.no_hp LIKE CONCAT('%', ?4, '%')) AND " +
                    "(?5 IS NULL OR ?5='' OR b.nomor_identitas LIKE CONCAT('%', ?5, '%'))"
            , nativeQuery = true)
    Page<BukuTamu> findAll(String jenis, String nama, String keperluan, String noHp, String nomorIdentitas, Pageable page);
}
