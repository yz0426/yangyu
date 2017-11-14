package com.yangyu.user.controller;

import com.yangyu.common.json.JsonResult;
import com.yangyu.common.json.JsonUtil;
import com.yangyu.global.model.JwtUser;
import com.yangyu.user.api.UserServer;
import com.yangyu.user.api.vo.UserInfoVo;
import com.yangyu.user.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by youz on 2017/10/27.
 */
@RestController
@Api(value = "UserApi", description = "用户API", tags = {"用户服务"})
public class UserController implements UserServer {

    @Autowired
    UserService userService;


    @Override
    public JsonResult<UserInfoVo> info(Long id) {
        return JsonResult.success("用户详细信息",UserInfoVo.assemblyData(userService.selectById(id)));
    }

    @Override
    public UserInfoVo selectByName(String userName) {
        return JsonUtil.convert(userService.selectByName(userName),UserInfoVo.class);
    }
}