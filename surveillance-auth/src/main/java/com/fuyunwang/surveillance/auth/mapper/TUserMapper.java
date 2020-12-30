package com.fuyunwang.surveillance.auth.mapper;

import com.fuyunwang.surveillance.auth.entity.TUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author FuyunWang
 * @since 2020-12-30
 */
public interface TUserMapper extends BaseMapper<TUser> {
    TUser findByName(String username);
}
