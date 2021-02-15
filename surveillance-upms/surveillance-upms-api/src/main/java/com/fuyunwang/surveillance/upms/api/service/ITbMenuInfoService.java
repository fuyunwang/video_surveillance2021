package com.fuyunwang.surveillance.upms.api.service;

import com.fuyunwang.surveillance.upms.api.entity.TbMenuInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author FuyunWang
 * @since 2021-02-15
 */
public interface ITbMenuInfoService extends IService<TbMenuInfo> {
    List<TbMenuInfo> menuInfoList(UserDetails userDetails);
}
