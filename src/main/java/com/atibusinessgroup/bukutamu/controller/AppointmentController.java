package com.atibusinessgroup.bukutamu.controller;

import com.atibusinessgroup.bukutamu.model.Appointment;
import com.atibusinessgroup.bukutamu.model.BukuTamu;
import com.atibusinessgroup.bukutamu.repo.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Controller
public class AppointmentController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @GetMapping("/appointment")
    public String index(Model model) {
        List<Appointment> appointment = appointmentRepository.findAll();
        model.addAttribute("appointment", appointment);

        return "appointment";
    }

    @PostMapping("/appointment")
    public String createAppointment(@ModelAttribute Appointment appointment, RedirectAttributes redirectAttributes) {
        com.atibusinessgroup.bukutamu.model.Appointment bt = new com.atibusinessgroup.bukutamu.model.Appointment();
        if (appointment.getId() != null) {
            bt = appointmentRepository.getOne(appointment.getId());
        }
        bt.setId(UUID.randomUUID().toString());
        bt.setNama(appointment.getNama());
        bt.setAlamat(appointment.getAlamat());
        bt.setJenis(appointment.getJenis());
        bt.setJenisKelamin(appointment.getJenisKelamin());
        bt.setKeperluan(appointment.getKeperluan());
        bt.setNomorIdentitas(appointment.getNomorIdentitas());
        bt.setTipeIdentitas(appointment.getTipeIdentitas());
        bt.setPihakYgDitemui(appointment.getPihakYgDitemui());
        bt.setJanjiTemuDate(appointment.getJanjiTemuDate());
        bt.setCreatedDate(Instant.now());
        appointmentRepository.save(bt);

        redirectAttributes.addFlashAttribute("success", true);
        return "redirect:/appointment";
    }

    @PostMapping("/appointment/approve")
    public String approveAppointment(@ModelAttribute Appointment appointment) {
        Appointment appointment1 = appointmentRepository.getOne(appointment.getId());
        appointment1.setApproved(true);
        appointmentRepository.save(appointment1);
        System.out.println("Approve appointment");
        return "redirect:/appointment";
    }

    @PostMapping("/appointment/reject")
    public String rejectAppointment(@ModelAttribute Appointment appointment) {
        Appointment appointment1 = appointmentRepository.getOne(appointment.getId());
        appointment1.setApproved(false);
        appointmentRepository.save(appointment1);
        System.out.println("Reject appointment");
        return "redirect:/appointment";
    }
}
