package com.fuyunwang.surveillance.auth.security.service;

import com.fuyunwang.surveillance.auth.entity.TUser;
import com.fuyunwang.surveillance.auth.security.entity.SurveillanceAuthUser;
import com.fuyunwang.surveillance.auth.service.ITUserService;
import com.fuyunwang.surveillance.common.pojo.ChuoyueUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @Date: 2020/10/3 20:08
 * @Author: FuyunWang
 * @Description:
 */
@Service
public class SurveillanceUserDetailService implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ITUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        TUser user = userService.findByName(username);
        if (user != null) {
            String permissions = userService.findUserPermissions(user.getUsername());
            /*boolean notLocked = false;
            if (StringUtils.equals(SystemUser.STATUS_VALID, user.getStatus()))
                notLocked = true;*/
            ChuoyueUser authUser = new ChuoyueUser(user.getUsername(), user.getPassword(),
                    true, true, true, true,
                    AuthorityUtils.commaSeparatedStringToAuthorityList(permissions));

            return transTUserToAuthUser(authUser,user);
        } else {
            throw new UsernameNotFoundException("");
        }
    }
    private ChuoyueUser transTUserToAuthUser(ChuoyueUser authUser, TUser tuser) {
        authUser.setAvatar(tuser.getAvatar());
        authUser.setDeptId(tuser.getDeptId());
        authUser.setDeptName(tuser.getDeptName());
        authUser.setEmail(tuser.getEmail());
        authUser.setMobile(tuser.getMobile());
        authUser.setRoleId(tuser.getRoleId());
        authUser.setRoleName(tuser.getRoleName());
        authUser.setSex(tuser.getSsex());
        authUser.setUserId(tuser.getUserId());
        authUser.setLastLoginTime(tuser.getLastLoginTime());
        authUser.setDescription(tuser.getDescription());
        authUser.setStatus(tuser.getStatus());
        return authUser;
    }

}
