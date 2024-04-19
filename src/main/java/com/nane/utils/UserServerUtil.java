package com.nane.utils;

import com.alibaba.fastjson.JSON;
import com.nane.pojo.User;
import org.springframework.util.Base64Utils;

import java.nio.charset.StandardCharsets;

public class UserServerUtil {
    /**
     * 解密用户信息
     *
     * @param userMsgEncode
     * @return
     */
    public static User decodeUserMsg(String userMsgEncode) {
        String userMsgDecode = new String(Base64Utils.decode(userMsgEncode.getBytes(StandardCharsets.UTF_8)));
        User user = JSON.parseObject(userMsgDecode, User.class);
        return user;
    }

    /**
     * 加密用户信息
     *
     * @param user
     * @return
     */
    public static String encodeUserMsg(User user) {
        byte[] encode = Base64Utils.encode(JSON.toJSONString(user).getBytes(StandardCharsets.UTF_8));
        return new String(encode);
    }

    public static void main(String[] args) {
//        User user = User.builder().id(123456L).accountName("nane").role("admin").build();
        User user = User.builder().id(123456L).accountName("nane").role("user").build();
        String encodeStr = encodeUserMsg(user);
        System.out.println("加密后字符串为：" + encodeStr);

        User decodeUser = decodeUserMsg(encodeStr);
        System.out.println("解密后的字符串为：" + user);
    }
}
