package com.atibusinessgroup.bukutamu.repo;

import com.atibusinessgroup.bukutamu.model.Appointment;
import com.atibusinessgroup.bukutamu.model.BukuTamu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, String>, PagingAndSortingRepository<Appointment, String> {

}
