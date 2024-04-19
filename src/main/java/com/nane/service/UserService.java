package com.nane.service;

import com.nane.pojo.User;
import com.nane.request.AdminAddResource;

public interface UserService {
    /**
     * 新增资源
     *
     * @param adminAddResource 管理员为成员新增资源权限
     * @return
     */
    boolean addResource(AdminAddResource adminAddResource);

    /**
     * 查询用户是否有该资源的权限
     *
     * @param user 用户信息
     * @param resource 资源
     * @return
     */
    boolean findResource(User user,String resource);
}
