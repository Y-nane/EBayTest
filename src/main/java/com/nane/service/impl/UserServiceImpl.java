package com.nane.service.impl;

import com.alibaba.fastjson.JSON;
import com.nane.pojo.User;
import com.nane.request.AdminAddResource;
import com.nane.service.UserService;
import com.nane.utils.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    /**
     * 新增资源
     *
     * @param adminAddResource 管理员为成员新增资源权限
     * @return
     */
    @Override
    public boolean addResource(AdminAddResource adminAddResource) {
        // 将数据存储进文件代替存储进数据库中
        List<String> resourceList = adminAddResource.getEndpoint();
        Long userId = adminAddResource.getUserId();
        String filePath = System.getProperty("user.dir") + File.separator
                + "userResource" + File.separator
                + userId + ".json";
        try {
            handleRepetitiousResource(filePath, resourceList);
            FileUtil.writeFile(filePath, JSON.toJSONString(resourceList));
        } catch (IOException e) {
            log.error("add resource error", e);
            return false;
        }
        return true;
    }

    /**
     * 处理重复的资源数据
     *
     * @param filePath
     * @param resourceList
     */
    private void handleRepetitiousResource(String filePath, List<String> resourceList) throws IOException {
        String content = FileUtil.readFile(filePath);
        if (StringUtils.isEmpty(content)) {
            return;
        }
        List<String> oldResourceList = JSON.parseArray(content, String.class);
        for (String resource : oldResourceList) {
            if (!resourceList.contains(resource)) {
                resourceList.add(resource);
            }
        }
    }

    /**
     * 查询用户是否有该资源的权限
     *
     * @param user     用户信息
     * @param resource 资源
     * @return
     */
    @Override
    public boolean findResource(User user, String resource) {
        String filePath = System.getProperty("user.dir") + File.separator
                + "userResource" + File.separator
                + user.getId() + ".json";
        String content = null;
        try {
            content = FileUtil.readFile(filePath);
        } catch (IOException e) {
            log.error("read file error", e);
        }
        if (StringUtils.isEmpty(content)) {
            return false;
        }
        List<String> resourceList = JSON.parseArray(content, String.class);
        return resourceList.contains(resource);
    }
}
