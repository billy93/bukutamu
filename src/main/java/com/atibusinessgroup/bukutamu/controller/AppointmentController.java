package com.atibusinessgroup.bukutamu.controller;

import com.atibusinessgroup.bukutamu.model.Appointment;
import com.atibusinessgroup.bukutamu.model.BukuTamu;
import com.atibusinessgroup.bukutamu.model.dto.SearchAppointmentListDTO;
import com.atibusinessgroup.bukutamu.model.dto.SearchAppointmentListNonOptionalDTO;
import com.atibusinessgroup.bukutamu.model.dto.SearchGuestbookListDTO;
import com.atibusinessgroup.bukutamu.model.dto.SearchGuestbookListNonOptionalDTO;
import com.atibusinessgroup.bukutamu.repo.AppointmentRepository;
import com.atibusinessgroup.bukutamu.service.ExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class AppointmentController {

    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private ExportService exportService;

    @GetMapping("/appointment")
    public String index(Model model) {
        return "appointment";
    }

    @PostMapping("/appointment/list")
    public String listSearch(SearchAppointmentListDTO searchAppointmentListDTO, Model model, HttpSession httpSession) {
        return list(searchAppointmentListDTO, model, httpSession);
    }

    @GetMapping("/appointment/list")
    public String list(SearchAppointmentListDTO searchAppointmentListDTO, Model model, HttpSession httpSession){
        Pageable page = PageRequest.of(searchAppointmentListDTO.getPage().get(), searchAppointmentListDTO.getSize().get());
        Page<com.atibusinessgroup.bukutamu.model.Appointment> appointment = appointmentRepository.findAll(
                searchAppointmentListDTO.getJenis().get(),
                searchAppointmentListDTO.getNama().get(),
                searchAppointmentListDTO.getKeperluan().get(),
                searchAppointmentListDTO.getNoHp().get(),
                searchAppointmentListDTO.getNomorIdentitas().get(),
                page);
        model.addAttribute("appointment", appointment.getContent());

        SearchAppointmentListNonOptionalDTO searchAppointmentListNonOptionalDTO = new SearchAppointmentListNonOptionalDTO();
        searchAppointmentListNonOptionalDTO.setPage(searchAppointmentListDTO.getPage().get());
        searchAppointmentListNonOptionalDTO.setJenis(searchAppointmentListDTO.getJenis().get());
        searchAppointmentListNonOptionalDTO.setNama(searchAppointmentListDTO.getNama().get());
        searchAppointmentListNonOptionalDTO.setKeperluan(searchAppointmentListDTO.getKeperluan().get());
        searchAppointmentListNonOptionalDTO.setNoHp(searchAppointmentListDTO.getNoHp().get());
        searchAppointmentListNonOptionalDTO.setNomorIdentitas(searchAppointmentListDTO.getNomorIdentitas().get());
        model.addAttribute("searchParam", searchAppointmentListNonOptionalDTO);

        int totalData = Integer.parseInt((appointment.getTotalElements())+"");

        int currentPage = searchAppointmentListDTO.getPage().get();
        int max = 5;
        double total = totalData;
        double size = searchAppointmentListDTO.getSize().get();
        int totalPages = (int)Math.ceil(total/size);
        if (totalPages > 0) {
            List<Integer> pageNumbers = new ArrayList<Integer>();
            int cPage = currentPage+1;
            if(cPage-2 > 0 && totalPages > max) {
                int startPage = ((cPage+2) > totalPages ? (cPage+1) > totalPages ? (cPage-4) : (cPage-3) : (cPage-2));
                int endPage = ((cPage+2) > totalPages ? totalPages : (cPage+2));
                for(int i=startPage; i<=endPage; i++) {
                    pageNumbers.add(i);
                }
            }
            else {
                pageNumbers.addAll(IntStream.rangeClosed(1, totalPages > max ? max : totalPages).boxed().collect(Collectors.toList()));
            }
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalData", totalData);

        int itemPerPage = 10;
        int to =  ((searchAppointmentListDTO.getPage().get()+1) * itemPerPage) > totalData ? totalData : ((searchAppointmentListDTO.getPage().get()+1) * itemPerPage);
        int from = ((searchAppointmentListDTO.getPage().get()) * itemPerPage + 1);
        String showingData = from + "-" + to;
        model.addAttribute("showingData", showingData);
        return "appointment-list";
    }

    @PostMapping("/appointment/list/export")
    public ResponseEntity<Resource> exportPolicyList(SearchAppointmentListDTO searchAppointmentListDTO) throws IOException {
        Pageable page = PageRequest.of(searchAppointmentListDTO.getPage().get(), searchAppointmentListDTO.getSize().get());

        Page<com.atibusinessgroup.bukutamu.model.Appointment> getAppointment = appointmentRepository.findAll(
                searchAppointmentListDTO.getJenis().get(),
                searchAppointmentListDTO.getNama().get(),
                searchAppointmentListDTO.getKeperluan().get(),
                searchAppointmentListDTO.getNoHp().get(),
                searchAppointmentListDTO.getNomorIdentitas().get(),
                page);
        Resource file = exportService.exportAppointment(getAppointment.getContent());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String filename = "Janji_"+sdf.format(new Date())+".xlsx";
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\""+filename+"\"")
                .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
//                .contentType(MediaType.APPLICATION_PDF)
                .contentLength(file.contentLength())
                .body(file);
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
        bt.setKeterangan(appointment.getKeterangan());
        bt.setNoHp(appointment.getNoHp());
        bt.setNoTelepon(appointment.getNoTelepon());
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
        return "redirect:/appointment/list";
    }

    @PostMapping("/appointment/reject")
    public String rejectAppointment(@ModelAttribute Appointment appointment) {
        Appointment appointment1 = appointmentRepository.getOne(appointment.getId());
        appointment1.setApproved(false);
        appointmentRepository.save(appointment1);
        System.out.println("Reject appointment");
        return "redirect:/appointment/list";
    }
}
