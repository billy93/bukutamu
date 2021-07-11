package com.atibusinessgroup.bukutamu.repo;

import com.atibusinessgroup.bukutamu.model.Appointment;
import com.atibusinessgroup.bukutamu.model.Pegawai;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PegawaiRepository extends JpaRepository<Pegawai, Long>, PagingAndSortingRepository<Pegawai, Long> {

    @Query(value = "SELECT b.id, b.nama, b.jabatan "+
            "from pegawai as b " +
            "where " +
            "(?1 IS NULL OR ?1='' OR b.nama LIKE CONCAT('%', ?1, '%')) AND "+
            "(?2 IS NULL OR ?2='' OR b.jabatan LIKE CONCAT('%', ?2, '%'))"
            ,
            countQuery = "SELECT count(*) from pegawai b " +
                    "where " +
                    "(?1 IS NULL OR ?1='' OR b.nama LIKE CONCAT('%', ?1, '%')) AND "+
                    "(?2 IS NULL OR ?2='' OR b.jabatan LIKE CONCAT('%', ?2, '%'))"
            , nativeQuery = true)
    Page<Pegawai> findAll(String nama, String jabatan, Pageable page);
}
