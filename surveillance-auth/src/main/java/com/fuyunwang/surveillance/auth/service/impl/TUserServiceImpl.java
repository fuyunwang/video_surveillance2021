package com.fuyunwang.surveillance.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fuyunwang.surveillance.auth.entity.TMenu;
import com.fuyunwang.surveillance.auth.entity.TUser;
import com.fuyunwang.surveillance.auth.mapper.TMenuMapper;
import com.fuyunwang.surveillance.auth.mapper.TUserMapper;
import com.fuyunwang.surveillance.auth.service.ITUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author FuyunWang
 * @since 2020-10-04
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService {
    @Autowired
    private TUserMapper userMapper;
    @Autowired
    private TMenuMapper menuMapper;

    @Override
    public TUser findByName(String username) {
        return userMapper.findByName(username);
    }

    @Override
    public String findUserPermissions(String username) {
        List<TMenu> userPermissions = menuMapper.findUserPermissions(username);

        List<String> perms = new ArrayList<>();
        for (TMenu m: userPermissions){
            perms.add(m.getPerms());
        }
        return StringUtils.join(perms, ",");
    }
}
