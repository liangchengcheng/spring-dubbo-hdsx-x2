package com.hdsx.dubbo.common.framework.util;

/**
 * 校验工具类
 */
public class ValidationUtil {

    public static boolean isMobile(String mobile) {
        if (mobile == null || mobile.length() != 11) {
            return false;
        }
        // TODO 后面完善手机校验
        return true;
    }

}