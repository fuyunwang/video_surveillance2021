package com.fuyunwang.surveillance.auth.mapper;

import com.fuyunwang.surveillance.auth.entity.TMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 菜单表 Mapper 接口
 * </p>
 *
 * @author FuyunWang
 * @since 2020-12-30
 */
public interface TMenuMapper extends BaseMapper<TMenu> {
    List<TMenu> findUserPermissions(String username);
}
