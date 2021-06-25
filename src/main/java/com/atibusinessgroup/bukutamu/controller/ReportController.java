package com.atibusinessgroup.bukutamu.controller;

import com.atibusinessgroup.bukutamu.model.Appointment;
import com.atibusinessgroup.bukutamu.model.BukuTamu;
import com.atibusinessgroup.bukutamu.repo.AppointmentRepository;
import com.atibusinessgroup.bukutamu.repo.BukuTamuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ReportController {

    @Autowired
    private BukuTamuRepository bukuTamuRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;

    @GetMapping("/report")
    public String index(Model model) {
        List<BukuTamu> getBukuTamu = bukuTamuRepository.findAll();
        List<Appointment> getAppointment = appointmentRepository.findAll();
        model.addAttribute("tamuUmum", getBukuTamu.stream().filter(e -> e.getJenis().contentEquals("Umum")).collect(Collectors.toList()).size());
        model.addAttribute("tamuKhusus", getBukuTamu.stream().filter(e -> e.getJenis().contentEquals("Khusus")).collect(Collectors.toList()).size());
        model.addAttribute("janji", getAppointment.size());
        model.addAttribute("total", getBukuTamu.size()+getAppointment.size());

        return "report";
    }
}
