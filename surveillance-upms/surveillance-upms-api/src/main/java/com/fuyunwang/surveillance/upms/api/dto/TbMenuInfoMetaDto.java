package com.fuyunwang.surveillance.upms.api.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @Description:
 * @Author: FuyunWang
 * @Date: 2021/2/16 18:57
 */
@Data
public class TbMenuInfoMetaDto {

    private Integer id;


    private String title;


    private String icon;


    private Integer menuId;

    private boolean affix;
}
