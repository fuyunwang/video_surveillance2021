package com.fuyunwang.surveillance.auth.controller;


import com.fuyunwang.surveillance.auth.service.ITUserService;
import com.fuyunwang.surveillance.auth.vo.UserInfoVo;
import com.fuyunwang.surveillance.common.base.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author FuyunWang
 * @since 2020-12-30
 */
@RestController
@RequestMapping("/t-user")
public class TUserController {

    @Autowired
    private ITUserService itUserService;

    @PostMapping("/info")
    public ResponseResult<UserInfoVo> getUserInfo(@RequestParam("username") String username){
        UserInfoVo userInfo = itUserService.getUserInfo(username);
        return ResponseResult.createBySuccess(userInfo);
    }
}
