package com.fuyunwang.surveillance.apis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * @Description:
 * @Author: FuyunWang
 * @Date: 2021/1/29 21:18
 */
@Data
public class Cat {

    private LocalDateTime dateTime;
}
