package com.atibusinessgroup.bukutamu.repo;

import com.atibusinessgroup.bukutamu.model.Appointment;
import com.atibusinessgroup.bukutamu.model.Pegawai;
import com.atibusinessgroup.bukutamu.model.User;
import com.atibusinessgroup.bukutamu.model.dto.AppointmentDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, PagingAndSortingRepository<User, Long> {
    User findByUsername(String username);

    @Query(value = "SELECT  u FROM User u where " +
            "(?1 IS NULL OR ?1='' OR u.username LIKE CONCAT('%', ?1, '%')) AND "+
            "(?2 IS NULL OR ?2='' OR u.firstName LIKE CONCAT('%', ?2, '%')) AND "+
            "(?3 IS NULL OR ?3='' OR u.lastName LIKE CONCAT('%', ?3, '%'))")
    Page<User> findAll(String username, String firstName, String lastName, Pageable page);
}
