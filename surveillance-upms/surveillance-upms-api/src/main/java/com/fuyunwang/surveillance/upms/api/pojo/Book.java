package com.fuyunwang.surveillance.upms.api.pojo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fuyunwang.surveillance.common.converter.Long2DateDeSerializer;

import java.util.Date;

/**
 * @Description:
 * @Author: FuyunWang
 * @Date: 2021/1/7 20:43
 */
public class Book {
    @JsonDeserialize(using = Long2DateDeSerializer.class)
    private Date publishTime;
}
