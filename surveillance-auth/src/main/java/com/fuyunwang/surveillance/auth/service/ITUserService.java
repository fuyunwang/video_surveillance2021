package com.fuyunwang.surveillance.auth.service;

import com.fuyunwang.surveillance.auth.entity.TUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author FuyunWang
 * @since 2020-12-30
 */
public interface ITUserService extends IService<TUser> {
    TUser findByName(String username);
    String findUserPermissions(String username);
}
