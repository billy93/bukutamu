package com.atibusinessgroup.bukutamu.controller;

import com.atibusinessgroup.bukutamu.model.Appointment;
import com.atibusinessgroup.bukutamu.model.BukuTamu;
import com.atibusinessgroup.bukutamu.model.Chart;
import com.atibusinessgroup.bukutamu.model.SearchReportForm;
import com.atibusinessgroup.bukutamu.repo.AppointmentRepository;
import com.atibusinessgroup.bukutamu.repo.BukuTamuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ReportController {

    @Autowired
    private BukuTamuRepository bukuTamuRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;

    @PostMapping("/report")
    public String search(@ModelAttribute SearchReportForm searchReportForm, Model model){
        System.out.println(searchReportForm);
        return index(searchReportForm, model);
    }

    @GetMapping("/report")
    public String index(SearchReportForm searchReportForm, Model model){
        List<BukuTamu> getBukuTamu = bukuTamuRepository.findAll();
        List<Appointment> getAppointment = appointmentRepository.findAll();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        if(searchReportForm.getStartDate() != null){
            try {
                Date searchStartDate = simpleDateFormat.parse(searchReportForm.getStartDate());
                getBukuTamu = getBukuTamu.stream().filter(e -> {
                    Date d = Date.from(e.getCreatedDate());
                    d.setHours(0);
                    d.setMinutes(0);
                    d.setSeconds(0);

                    if(d.after(searchStartDate)){
                        return true;
                    }
                    return false;
                }).collect(Collectors.toList());

                getAppointment = getAppointment.stream().filter(e -> {
                    Date d = Date.from(e.getCreatedDate());
                    d.setHours(0);
                    d.setMinutes(0);
                    d.setSeconds(0);

                    if(d.after(searchStartDate)){
                        return true;
                    }
                    return false;
                }).collect(Collectors.toList());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if(searchReportForm.getEndDate() != null){
            try {
                Date searchEndDate = simpleDateFormat.parse(searchReportForm.getEndDate());
                getBukuTamu = getBukuTamu.stream().filter(e -> {
                    Date d = Date.from(e.getCreatedDate());
                    d.setHours(0);
                    d.setMinutes(0);
                    d.setSeconds(0);

                    if(d.before(searchEndDate)){
                        return true;
                    }
                    return false;
                }).collect(Collectors.toList());

                getAppointment = getAppointment.stream().filter(e -> {
                    Date d = Date.from(e.getCreatedDate());
                    d.setHours(0);
                    d.setMinutes(0);
                    d.setSeconds(0);

                    if(d.before(searchEndDate)){
                        return true;
                    }
                    return false;
                }).collect(Collectors.toList());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        model.addAttribute("searchForm", searchReportForm);
        model.addAttribute("tamuUmum", getBukuTamu.stream().filter(e -> e.getJenis().contentEquals("Umum")).collect(Collectors.toList()).size());
        model.addAttribute("tamuKhusus", getBukuTamu.stream().filter(e -> e.getJenis().contentEquals("Khusus")).collect(Collectors.toList()).size());
        model.addAttribute("janji", getAppointment.size());
        model.addAttribute("total", getBukuTamu.size()+getAppointment.size());

        Chart grafikStatistikKeperluanTamu = generateStatistikKeperluanTamu(getBukuTamu);
        model.addAttribute("grafikStatistikKeperluanTamu", grafikStatistikKeperluanTamu);
        return "report";
    }

    private Chart generateStatistikKeperluanTamu(List<BukuTamu> bukuTamuList){
        Chart chart1 = new Chart();
        chart1.setAnimationEnabled(true);

        Chart.Title title = new Chart.Title();
        title.setText("Statistik Keperluan Tamu");
        chart1.setTitle(title);

        List<Chart.Data> chartData = new ArrayList<Chart.Data>();

        String keperluan[] = {"Dinas", "Pribadi", "Surat Menyurat", "Informasi & Pengaduan", "Lainnya"};

        Chart.Data d = new Chart.Data();
        d.setType("pie");
//        d.setShowInLegend(true);

        List<Chart.Data.DataPoint> dataPoints = new ArrayList<>();
        for(int i=0;i<keperluan.length;i++) {
            Chart.Data.DataPoint dp = new Chart.Data.DataPoint();

            int finalI = i;
            List<BukuTamu> bukuTamus = bukuTamuList.stream().filter(e -> e.getKeperluan().contentEquals(keperluan[finalI])).collect(Collectors.toList());
            dp.setY(bukuTamus.size());
            dp.setLabel(keperluan[i]);
            dataPoints.add(dp);
        }

        d.setDataPoints(dataPoints);
        chartData.add(d);
        chart1.setData(chartData);

        return chart1;
    }
}
