package com.example.demo.controller.other;

import java.nio.charset.StandardCharsets;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import com.example.demo.utils.ValidUtil;



public class ParameterValidator {

    public static void validToken(String token, boolean allowNull) {
        ValidUtil.validByRegex("Token", token, allowNull, "^[0-9]{16}$");
    }

    public static void validLoginName(String loginName, boolean allowNull) {
        ValidUtil.validByRegex("登录名", loginName, allowNull, "^[a-zA-Z0-9_]{4,32}$");
    }

    public static void validPassword(String password, boolean allowNull) {
        ValidUtil.validByRegex("登录密码", password, allowNull, "^[\\S]{4,32}$");
    }

    public static void validLoginAgent(String loginAgent, boolean allowNull) {
        if (allowNull && StringUtils.isEmpty(loginAgent)) {
            return;
        }
        Assert.isTrue(allowNull || StringUtils.hasText(loginAgent), "[登录Agent]不能为空");

        Assert.isTrue(loginAgent.length() <= 256, "[登录Agent]不合法");
    }

    public static void validLoginIp(String loginIp, boolean allowNull) {
        ValidUtil.validByRegex("登录IP", loginIp, allowNull, "^[0-9\\.]{8,32}$");
    }

    public static void validLoginMac(String lastLoginMac, boolean allowNull) {
        ValidUtil.validByRegex("登录MAC", lastLoginMac, allowNull, "^[0-9a-zA-Z\\-]{4,64}$");
    }

    public static void validUserName(String userName, boolean allowNull) {
        if (StringUtils.hasText(userName)) {
            Assert.isTrue(userName.getBytes(StandardCharsets.UTF_8).length < 48, "[姓名]不合法");
        } else {
            Assert.isTrue(allowNull, "[姓名]不能为空");
        }
    }

    public static void validUserEmail(String userEmail, boolean allowNull) {
        ValidUtil.validByRegex("邮箱", userEmail, allowNull, "^[\\S]{4,64}$");
    }

    public static void validUserMobile(String userMobile, boolean allowNull) {
        ValidUtil.validByRegex("电话", userMobile, allowNull, "^[0-9]{8,11}$");
    }

    public static void validId(Long userId, boolean allowNull) {
        ValidUtil.validByRegex("ID", String.valueOf(userId), allowNull, "^[0-9]{1,16}$");
    }

    public static void validPage(int pageNum, int pageSize) {
        Assert.isTrue(pageNum > 0 && pageNum < 1000 && pageSize > 0 && pageSize < 1000, "[分页参数]不合法");
    }

    public static void validRemark(String remark, boolean allowNull) {
        if (StringUtils.hasText(remark)) {
            Assert.isTrue(remark.getBytes(StandardCharsets.UTF_8).length < 256, "[备注]不合法");
        } else {
            Assert.isTrue(allowNull, "[备注]不能为空");
        }
    }

//    public static void validAuthType(String authType, boolean allowNull) {
//        if (StringUtils.hasText(authType)) {
//            Assert.isTrue(authType.equals(MMSConstants.AUTH_TYPE_MENU) || authType.equals(MMSConstants.AUTH_TYPE_BUTTON), "[权限类型]不合法");
//        } else {
//            Assert.isTrue(allowNull, "[权限类型]不能为空");
//        }
//    }

    public static void validName(String name, boolean allowNull) {
        if (StringUtils.hasText(name)) {
            Assert.isTrue(name.getBytes(StandardCharsets.UTF_8).length <= 128, "[名称]不合法");
        } else {
            Assert.isTrue(allowNull, "[名称]不能为空");
        }
    }

}
