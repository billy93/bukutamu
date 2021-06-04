package com.atibusinessgroup.bukutamu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.atibusinessgroup.bukutamu.model.BukuTamu;

@Repository
public interface BukuTamuRepository extends JpaRepository<BukuTamu, String>, PagingAndSortingRepository<BukuTamu, String> {

}
