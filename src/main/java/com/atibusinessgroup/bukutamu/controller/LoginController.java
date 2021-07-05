package com.atibusinessgroup.bukutamu.controller;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;
import java.util.*;
import java.util.stream.Collectors;

import com.atibusinessgroup.bukutamu.model.Appointment;
import com.atibusinessgroup.bukutamu.model.Chart;
import com.atibusinessgroup.bukutamu.repo.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.atibusinessgroup.bukutamu.model.BukuTamu;
import com.atibusinessgroup.bukutamu.repo.BukuTamuRepository;

@Controller
public class LoginController {

	@Autowired
	private BukuTamuRepository bukuTamuRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;

    @GetMapping("/")
    public String index(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            List<BukuTamu> getBukuTamu = bukuTamuRepository.findAll();
            List<Appointment> getAppointment = appointmentRepository.findAll();
            model.addAttribute("tamuUmum", getBukuTamu.stream().filter(e -> e.getJenis().contentEquals("Umum")).collect(Collectors.toList()).size());
            model.addAttribute("tamuKhusus", getBukuTamu.stream().filter(e -> e.getJenis().contentEquals("Khusus")).collect(Collectors.toList()).size());
            model.addAttribute("janji", getAppointment.size());
            model.addAttribute("total", getBukuTamu.size()+getAppointment.size());

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMM");
            Date now = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(now);

            String bulan = simpleDateFormat.format(now);
            model.addAttribute("bulan", bulan);

            int month = calendar.get(Calendar.MONTH);

            int janjiSize = getAppointment.stream().filter(e -> {
                Date x = Date.from(e.getCreatedDate());
                Calendar cal = Calendar.getInstance();
                cal.setTime(x);
                int curMonth = cal.get(Calendar.MONTH);
                if(curMonth == month)
                    return true;
                return false;
            }).collect(Collectors.toList()).size();
            int bukuTamuSize = getBukuTamu.stream().filter(e -> {
                Date x = Date.from(e.getCreatedDate());
                Calendar cal = Calendar.getInstance();
                cal.setTime(x);
                int curMonth = cal.get(Calendar.MONTH);
                if(curMonth == month)
                    return true;
                return false;
            }).collect(Collectors.toList()).size();
            model.addAttribute("tamuUmumCurrent", getBukuTamu.stream().filter(e -> {
                Date x = Date.from(e.getCreatedDate());
                Calendar cal = Calendar.getInstance();
                cal.setTime(x);
                int curMonth = cal.get(Calendar.MONTH);
                if(curMonth == month && e.getJenis().contentEquals("Umum"))
                    return true;
                return false;
            }).collect(Collectors.toList()).size());
            model.addAttribute("tamuKhususCurrent", getBukuTamu.stream().filter(e -> {
                Date x = Date.from(e.getCreatedDate());
                Calendar cal = Calendar.getInstance();
                cal.setTime(x);
                int curMonth = cal.get(Calendar.MONTH);
                if(curMonth == month && e.getJenis().contentEquals("Khusus"))
                    return true;
                return false;
            }).collect(Collectors.toList()).size());
            model.addAttribute("janjiCurrent", janjiSize);
            model.addAttribute("totalCurrent", bukuTamuSize+janjiSize);

            Chart grafikTamuTotal = generateGrafikTamuTotal(getBukuTamu, getAppointment);
            Chart grafikTamu = generateGrafikTamu(getBukuTamu, getAppointment);
            Chart grafikStatistikKeperluanTamu = generateStatistikKeperluanTamu(getBukuTamu);
            model.addAttribute("grafikTamuTotal", grafikTamuTotal);
            model.addAttribute("grafikTamu", grafikTamu);
            model.addAttribute("grafikStatistikKeperluanTamu", grafikStatistikKeperluanTamu);
            return "index";
        }
        return "redirect:/guestbook";
    }

    private Chart generateStatistikKeperluanTamu(List<BukuTamu> bukuTamuList){
        Chart chart1 = new Chart();
        chart1.setAnimationEnabled(true);

        Chart.Title title = new Chart.Title();
//        title.setText("Statistik Keperluan Tamu");
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

    private Chart generateGrafikTamu(List<BukuTamu> bukuTamuList, List<Appointment> appointments) {
        Chart chart1 = new Chart();
        chart1.setAnimationEnabled(true);

        Chart.Title title = new Chart.Title();
//        title.setText("Grafik Tamu");
        chart1.setTitle(title);

        Chart.AxisY axisY = new Chart.AxisY();
        axisY.setTitle("Jumlah");
        chart1.setAxisY(axisY);

        Chart.Tooltip toolTip = new Chart.Tooltip();
        toolTip.setShared(true);
        chart1.setToolTip(toolTip);

        List<Chart.Data> chartData = new ArrayList<Chart.Data>();

        String month[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        Chart.Data d = new Chart.Data();
        d.setType("line");
        d.setShowInLegend(true);
        d.setLegendText("Jumlah Tamu Umum");
        d.setName("Jumlah Tamu Umum");

        Chart.Data dKhusus = new Chart.Data();
        dKhusus.setType("line");
        dKhusus.setShowInLegend(true);
        dKhusus.setLegendText("Jumlah Tamu Khusus");
        dKhusus.setName("Jumlah Tamu Khusus");

        Chart.Data dJanji = new Chart.Data();
        dJanji.setType("line");
        dJanji.setShowInLegend(true);
        dJanji.setLegendText("Jumlah Janji");
        dJanji.setName("Jumlah Janji");

        List<Chart.Data.DataPoint> dataPoints = new ArrayList<>();
        List<Chart.Data.DataPoint> dataPointKhusus = new ArrayList<>();
        List<Chart.Data.DataPoint> dataPointJanji = new ArrayList<>();

        Month[] months = {
                Month.JANUARY, Month.FEBRUARY, Month.MARCH, Month.APRIL, Month.MAY, Month.JUNE,
                Month.JULY, Month.AUGUST, Month.SEPTEMBER, Month.OCTOBER, Month.NOVEMBER, Month.DECEMBER
        };
        for(int i=0;i<month.length;i++) {
            int finalI = i;

            // Tamu umum
            Chart.Data.DataPoint dp = new Chart.Data.DataPoint();
            List<BukuTamu> bukuTamus = bukuTamuList.stream().filter(e -> {
                if(LocalDateTime.ofInstant(e.getCreatedDate(), ZoneId.systemDefault()).getMonth() == months[finalI] && e.getJenis().contentEquals("Umum")){
                    return true;
                }
                return false;
            }).collect(Collectors.toList());

            dp.setY(bukuTamus.size());
            dp.setLabel(month[i]);
            dataPoints.add(dp);
            // End Tamu umum

            // Tamu Khusus
            Chart.Data.DataPoint dpKhusus = new Chart.Data.DataPoint();
            List<BukuTamu> bukuTamuKhusus = bukuTamuList.stream().filter(e -> {
                if(LocalDateTime.ofInstant(e.getCreatedDate(), ZoneId.systemDefault()).getMonth() == months[finalI] && e.getJenis().contentEquals("Khusus")){
                    return true;
                }
                return false;
            }).collect(Collectors.toList());

            dpKhusus.setY(bukuTamuKhusus.size());
            dpKhusus.setLabel(month[i]);
            dataPointKhusus.add(dpKhusus);
            // End Tamu Khusus

            // Janji
            Chart.Data.DataPoint dpJanji = new Chart.Data.DataPoint();
            List<Appointment> janji = appointments.stream().filter(e -> {
                if(LocalDateTime.ofInstant(e.getCreatedDate(), ZoneId.systemDefault()).getMonth() == months[finalI]){
                    return true;
                }
                return false;
            }).collect(Collectors.toList());

            dpJanji.setY(janji.size());
            dpJanji.setLabel(month[i]);
            dataPointJanji.add(dpJanji);
            // End Janji
        }

        d.setDataPoints(dataPoints);
        chartData.add(d);

        dKhusus.setDataPoints(dataPointKhusus);
        chartData.add(dKhusus);

        dJanji.setDataPoints(dataPointJanji);
        chartData.add(dJanji);

        chart1.setData(chartData);

        return chart1;
    }

    private Chart generateGrafikTamuTotal(List<BukuTamu> bukuTamuList, List<Appointment> getAppointment) {
        Chart chart1 = new Chart();
        chart1.setAnimationEnabled(true);

        Chart.Title title = new Chart.Title();
//        title.setText("Grafik Tamu Total");
        chart1.setTitle(title);

        Chart.AxisY axisY = new Chart.AxisY();
        axisY.setTitle("Jumlah");
        chart1.setAxisY(axisY);

        Chart.Tooltip toolTip = new Chart.Tooltip();
        toolTip.setShared(true);
        chart1.setToolTip(toolTip);

        List<Chart.Data> chartData = new ArrayList<Chart.Data>();

        String month[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        Chart.Data d = new Chart.Data();
        d.setType("line");
        d.setShowInLegend(true);
        d.setLegendText("Jumlah Tamu");

        List<Chart.Data.DataPoint> dataPoints = new ArrayList<>();

        Month[] months = {
                Month.JANUARY, Month.FEBRUARY, Month.MARCH, Month.APRIL, Month.MAY, Month.JUNE,
                Month.JULY, Month.AUGUST, Month.SEPTEMBER, Month.OCTOBER, Month.NOVEMBER, Month.DECEMBER
        };
        for(int i=0;i<month.length;i++) {
            int finalI = i;

            // Tamu total
            Chart.Data.DataPoint dp = new Chart.Data.DataPoint();
            List<BukuTamu> bukuTamus = bukuTamuList.stream().filter(e -> {
                if(LocalDateTime.ofInstant(e.getCreatedDate(), ZoneId.systemDefault()).getMonth() == months[finalI]){
                    return true;
                }
                return false;
            }).collect(Collectors.toList());
            List<Appointment> appointment = getAppointment.stream().filter(e -> {
                if(LocalDateTime.ofInstant(e.getCreatedDate(), ZoneId.systemDefault()).getMonth() == months[finalI]){
                    return true;
                }
                return false;
            }).collect(Collectors.toList());
            dp.setY(bukuTamus.size()+appointment.size());
            dp.setLabel(month[i]);
            dataPoints.add(dp);
            // End Tamu umum
        }

        d.setDataPoints(dataPoints);
        chartData.add(d);

        chart1.setData(chartData);

        return chart1;
    }

    @GetMapping("/login")
    public String login(Model model) {

        return "login";
    }
}
