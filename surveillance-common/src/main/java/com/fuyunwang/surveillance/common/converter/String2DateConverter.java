package com.fuyunwang.surveillance.common.converter;


import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @Description:
 * @Author: FuyunWang
 * @Date: 2021/1/3 17:16
 */
public class String2DateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        if (StringUtils.hasText(source)) {
            LocalDate localDate = LocalDate.parse(source, DateTimeFormatter.ofPattern("yyyy年MM月DD日"));
            ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.systemDefault());
            return Date.from(zonedDateTime.toInstant());
        }
        return null;
    }
}
