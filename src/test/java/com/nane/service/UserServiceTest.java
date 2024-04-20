package com.nane.service;

import com.nane.pojo.User;
import com.nane.request.AdminAddResource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testResourceOperation() {
        // 新增资源信息
        List<String> resourceList = new ArrayList<>();
        resourceList.add("resourceA");
        resourceList.add("resourceB");
        AdminAddResource adminAddResource = AdminAddResource.builder()
                .userId(123456L)
                .endpoint(resourceList)
                .build();
        boolean res = userService.addResource(adminAddResource);
        assertTrue(res, "新增资源权限失败");

        // 查询资源信息
        User user = User.builder()
                .id(123456L)
                .accountName("nane")
                .role("user")
                .build();
        boolean res1 = userService.findResource(user, "resourceA");
        assertTrue(res1, "查询资源信息失败");
        boolean res2 = userService.findResource(user, "resourceC");
        assertFalse(res2, "查询资源信息失败");
    }
}