/*
 * Copyright (c) 2020. Created by Andreas Billy Sutandi
 */

package com.atibusinessgroup.bukutamu.resolver;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.document.AbstractXlsView;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Map;

@Component
public class TravellerDataExcelView extends AbstractXlsxView {

    @Override
    protected void buildExcelDocument(Map<String, Object> map, org.apache.poi.ss.usermodel.Workbook workbook, HttpServletRequest httpServletRequest, HttpServletResponse response) throws Exception {
        response.setHeader("Content-Disposition", "attachment; filename=\"TravellerDataTemplate.xlsx\"");

        // create excel xls sheet
        Sheet sheet = workbook.createSheet("Traveller Template");
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
        header.createCell(0).setCellValue("Traveller Type");
        header.getCell(0).setCellStyle(style);
        header.createCell(1).setCellValue("Title");
        header.getCell(1).setCellStyle(style);
        header.createCell(2).setCellValue("First Name");
        header.getCell(2).setCellStyle(style);
        header.createCell(3).setCellValue("Last Name");
        header.getCell(3).setCellStyle(style);
        header.createCell(4).setCellValue("Date of Birth");
        header.getCell(4).setCellStyle(style);
        header.createCell(5).setCellValue("Place of Birth");
        header.getCell(5).setCellStyle(style);
        header.createCell(6).setCellValue("Address");
        header.getCell(6).setCellStyle(style);
        header.createCell(7).setCellValue("Email Address");
        header.getCell(7).setCellStyle(style);
        header.createCell(8).setCellValue("Phone Number");
        header.getCell(8).setCellStyle(style);
        header.createCell(9).setCellValue("Passport Number");
        header.getCell(9).setCellStyle(style);
    }
}
