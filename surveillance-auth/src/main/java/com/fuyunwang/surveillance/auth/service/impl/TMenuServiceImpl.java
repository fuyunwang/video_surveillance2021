package com.fuyunwang.surveillance.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fuyunwang.surveillance.auth.entity.TMenu;
import com.fuyunwang.surveillance.auth.mapper.TMenuMapper;
import com.fuyunwang.surveillance.auth.service.ITMenuService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author FuyunWang
 * @since 2020-10-04
 */
@Service
public class TMenuServiceImpl extends ServiceImpl<TMenuMapper, TMenu> implements ITMenuService {

}
