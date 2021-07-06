package com.atibusinessgroup.bukutamu.service;

import com.atibusinessgroup.bukutamu.model.Appointment;
import com.atibusinessgroup.bukutamu.model.BukuTamu;
import com.atibusinessgroup.bukutamu.model.dto.AppointmentDTO;
import com.atibusinessgroup.bukutamu.model.dto.BukuTamuDTO;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class ExportService {

    public Resource exportBukuTamu(List<BukuTamuDTO> bukuTamuList){
        Workbook workbook = new XSSFWorkbook();

        // create excel xls sheet
        Sheet sheet = workbook.createSheet("Buku Tamu");
        sheet.setDefaultColumnWidth(30);

        // create style for header cells
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("Arial");
        style.setFillForegroundColor(HSSFColor.BLUE.index);
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        font.setBold(true);
        font.setColor(HSSFColor.WHITE.index);
        style.setFont(font);

        // create header row
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Jenis Tamu");
        header.getCell(0).setCellStyle(style);
        header.createCell(1).setCellValue("Nama");
        header.getCell(1).setCellStyle(style);
        header.createCell(2).setCellValue("Jenis Kelamin");
        header.getCell(2).setCellStyle(style);
        header.createCell(3).setCellValue("Alamat");
        header.getCell(3).setCellStyle(style);
        header.createCell(4).setCellValue("Tanda Pengenal");
        header.getCell(4).setCellStyle(style);
        header.createCell(5).setCellValue("No Tanda Pengenal");
        header.getCell(5).setCellStyle(style);
        header.createCell(6).setCellValue("Pihak yang ditemui");
        header.getCell(6).setCellStyle(style);
        header.createCell(7).setCellValue("Keperluan");
        header.getCell(7).setCellStyle(style);
        header.createCell(8).setCellValue("Keterangan");
        header.getCell(8).setCellStyle(style);
        header.createCell(9).setCellValue("No HP");
        header.getCell(9).setCellStyle(style);
        header.createCell(10).setCellValue("No Telepon");
        header.getCell(10).setCellStyle(style);
        header.createCell(11).setCellValue("Tanggal");
        header.getCell(11).setCellStyle(style);

        int rowCount = 1;

        for (BukuTamuDTO bukuTamu : bukuTamuList) {
            Row userRow = sheet.createRow(rowCount++);
            userRow.createCell(0).setCellValue(bukuTamu.getJenis());
            userRow.createCell(1).setCellValue(bukuTamu.getNama());
            userRow.createCell(2).setCellValue(bukuTamu.getJenisKelamin());
            userRow.createCell(3).setCellValue(bukuTamu.getAlamat());
            userRow.createCell(4).setCellValue(bukuTamu.getTipeIdentitas());
            userRow.createCell(5).setCellValue(bukuTamu.getNomorIdentitas());
            userRow.createCell(6).setCellValue(bukuTamu.getPihakYgDitemuiNama());
            userRow.createCell(7).setCellValue(bukuTamu.getKeperluan());
            userRow.createCell(8).setCellValue(bukuTamu.getKeterangan());
            userRow.createCell(9).setCellValue(bukuTamu.getNoHp());
            userRow.createCell(10).setCellValue(bukuTamu.getNoTelepon());
            Date d = bukuTamu.getCreatedDate();
            if(d != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
                userRow.createCell(11).setCellValue(sdf.format(d));
            }
        }

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ByteArrayResource(out.toByteArray());
    }

    public Resource exportAppointment(List<AppointmentDTO> appointmentList){
        Workbook workbook = new XSSFWorkbook();

        // create excel xls sheet
        Sheet sheet = workbook.createSheet("Janji");
        sheet.setDefaultColumnWidth(30);

        // create style for header cells
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("Arial");
        style.setFillForegroundColor(HSSFColor.BLUE.index);
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        font.setBold(true);
        font.setColor(HSSFColor.WHITE.index);
        style.setFont(font);

        // create header row
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Jenis Tamu");
        header.getCell(0).setCellStyle(style);
        header.createCell(1).setCellValue("Nama");
        header.getCell(1).setCellStyle(style);
        header.createCell(2).setCellValue("Jenis Kelamin");
        header.getCell(2).setCellStyle(style);
        header.createCell(3).setCellValue("Alamat");
        header.getCell(3).setCellStyle(style);
        header.createCell(4).setCellValue("Tanda Pengenal");
        header.getCell(4).setCellStyle(style);
        header.createCell(5).setCellValue("No Tanda Pengenal");
        header.getCell(5).setCellStyle(style);
        header.createCell(6).setCellValue("Pihak yang ditemui");
        header.getCell(6).setCellStyle(style);
        header.createCell(7).setCellValue("Keperluan");
        header.getCell(7).setCellStyle(style);
        header.createCell(8).setCellValue("Keterangan");
        header.getCell(8).setCellStyle(style);
        header.createCell(9).setCellValue("No HP");
        header.getCell(9).setCellStyle(style);
        header.createCell(10).setCellValue("No Telepon");
        header.getCell(10).setCellStyle(style);
        header.createCell(11).setCellValue("Tgl & Jam Janji");
        header.getCell(11).setCellStyle(style);

        int rowCount = 1;

        for (AppointmentDTO appointment : appointmentList) {
            Row userRow = sheet.createRow(rowCount++);
            userRow.createCell(0).setCellValue(appointment.getJenis());
            userRow.createCell(1).setCellValue(appointment.getNama());
            userRow.createCell(2).setCellValue(appointment.getJenisKelamin());
            userRow.createCell(3).setCellValue(appointment.getAlamat());
            userRow.createCell(4).setCellValue(appointment.getTipeIdentitas());
            userRow.createCell(5).setCellValue(appointment.getNomorIdentitas());
            userRow.createCell(6).setCellValue(appointment.getPihakYgDitemui());
            userRow.createCell(7).setCellValue(appointment.getKeperluan());
            userRow.createCell(8).setCellValue(appointment.getKeterangan());
            userRow.createCell(9).setCellValue(appointment.getNoHp());
            userRow.createCell(10).setCellValue(appointment.getNoTelepon());

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm");
            if(appointment.getJanjiTemuDate() != null){
                userRow.createCell(11).setCellValue(simpleDateFormat.format(appointment.getJanjiTemuDate()));
            }
        }

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ByteArrayResource(out.toByteArray());
    }
}
