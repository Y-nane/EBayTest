package com.nane.controller;

import com.nane.enumeration.RoleEnum;
import com.nane.pojo.User;
import com.nane.request.AdminAddResource;
import com.nane.response.ErrorCode;
import com.nane.response.Result;
import com.nane.service.UserService;
import com.nane.utils.UserServerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@RestController()
public class AdminController {
    private static final String USER_MSG = "X-user";

    @Autowired
    UserService userService;

    @PostMapping("/admin/addUser")
    public Result addUser(@RequestBody AdminAddResource adminAddResource, HttpServletRequest request) {
        User user = UserServerUtil.decodeUserMsg(request.getHeader(USER_MSG));
        RoleEnum role = RoleEnum.getByDesc(user.getRole());
        if (!Objects.equals(role, RoleEnum.ROLE_ADMIN)) {
            return Result.fail(ErrorCode.NO_PERMISSION);
        }
        boolean res = userService.addResource(adminAddResource);
        return new Result().success(res);
    }
}
