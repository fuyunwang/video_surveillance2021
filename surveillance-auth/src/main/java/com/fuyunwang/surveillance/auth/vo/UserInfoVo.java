package com.fuyunwang.surveillance.auth.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Description:
 * @Author: FuyunWang
 * @Date: 2021/2/15 11:18
 */
@Data
public class UserInfoVo {

    private Long userId;

    private String username;

    private Long deptId;

    private String email;

    private String mobile;

    private String status;

    private LocalDateTime createTime;

    private LocalDateTime modifyTime;

    private LocalDateTime lastLoginTime;

    private String ssex;

    private String avatar;

    private String description;

    private String roleName;
}
