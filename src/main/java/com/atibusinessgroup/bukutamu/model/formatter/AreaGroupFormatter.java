/*
 * Copyright (c) 2021. Created by Andreas Billy Sutandi
 */

package com.atibusinessgroup.bukutamu.model.formatter;

import org.springframework.format.Formatter;

import com.atibusinessgroup.bukutamu.model.dto.AreaGroupDTO;

import java.text.ParseException;
import java.util.Locale;

public class AreaGroupFormatter implements Formatter<AreaGroupDTO> {
    @Override
    public String print(AreaGroupDTO areaGroup, Locale locale) {
        return areaGroup.getId()+"";
    }

    @Override
    public AreaGroupDTO parse(String id, Locale locale) throws ParseException {
        AreaGroupDTO areaGroup = new AreaGroupDTO();
        areaGroup.setId(Long.parseLong(id));
        return areaGroup;
    }
}
