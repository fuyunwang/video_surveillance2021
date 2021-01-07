package com.fuyunwang.surveillance.common.converter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.util.Date;

/**
 * @Description:
 * @Author: FuyunWang
 * @Date: 2021/1/7 20:39
 */
public class Long2DateDeSerializer extends JsonDeserializer<Date> {
    @Override
    public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        Long time=p.getLongValue();
        return new Date(time);
    }
}
