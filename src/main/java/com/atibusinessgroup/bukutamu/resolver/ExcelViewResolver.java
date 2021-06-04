/*
 * Copyright (c) 2020. Created by Andreas Billy Sutandi
 */

package com.atibusinessgroup.bukutamu.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

@Component
public class ExcelViewResolver implements ViewResolver {

    @Autowired
    private TravellerDataExcelView travellerDataExcelView;

    @Override
    public View resolveViewName(String viewName, Locale locale) throws Exception {
        if(viewName.contentEquals("travellerDataTemplate")) {
            return travellerDataExcelView;
        }
        return null;
    }
}
