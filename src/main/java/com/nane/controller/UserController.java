package com.nane.controller;

import com.nane.pojo.User;
import com.nane.response.ErrorCode;
import com.nane.response.Result;
import com.nane.service.UserService;
import com.nane.utils.UserServerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {
    private static final String USER_MSG = "X-user";
    @Autowired
    UserService userService;

    @PostMapping("/user/{resource}")
    public Result addUser(@PathVariable("resource") String resource, HttpServletRequest request) {
        User user = UserServerUtil.decodeUserMsg(request.getHeader(USER_MSG));
        boolean res = userService.findResource(user, resource);
        if (res) {
            return Result.success();
        }
        return Result.fail(ErrorCode.NO_PERMISSION);
    }
}
