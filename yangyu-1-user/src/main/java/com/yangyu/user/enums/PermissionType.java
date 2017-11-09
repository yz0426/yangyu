package com.yangyu.user.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by youz on 2017/11/8.
 */
public enum PermissionType {

    /** 目录 */
    DIRECTORY(0,"目录"),

    /** 菜单 */
    MENU(1,"菜单"),

    /** 按钮 */
    BUTTON(2,"按钮");

    private Integer code;

    private String value;

    PermissionType(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    @JsonValue
    public Integer getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
