package com.nane.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;


@Getter
@AllArgsConstructor
public enum RoleEnum {
    ROLE_ADMIN(1, "admin"),
    ROLE_USER(2, "user");
    private final Integer code;
    private final String desc;

    public static RoleEnum getByDesc(String desc) {
        if (StringUtils.isEmpty(desc)) {
            return null;
        }
        for (RoleEnum value : RoleEnum.values()) {
            if (StringUtils.equals(value.getDesc(), desc)){
                return value;
            }
        }
        return null;
    }
}
