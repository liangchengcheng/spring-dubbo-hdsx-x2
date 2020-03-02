package com.hdsx.dubbo.common.framework.vo;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
@SuppressWarnings("unchecked")
public class ResultUtil {
    public static Result success(ResultCode resultCode, Map<String, Object> map) {
        Result result = new Result();
        result.setCode(resultCode.getCode());
        result.setMessage(resultCode.getMessage());
        result.setData(map);

        return result;
    }

    public static Result success(ResultCode resultCode, Object object) {
        Result result = new Result();
        result.setCode(resultCode.getCode());
        result.setMessage(resultCode.getMessage());
        result.setData(object);

        return result;
    }

    public static Result error(ResultCode resultCode, Map<String, Object> map) {
        Result result = new Result();
        result.setCode(resultCode.getCode());
        result.setMessage(resultCode.getMessage());
        result.setData(map);

        return result;
    }

    public static Result success(ResultCode resultEnum) {
        Result result = new Result();
        result.setCode(resultEnum.getCode());
        result.setMessage(resultEnum.getMessage());
        return result;
    }

    public static Result error(ResultCode resultEnum) {
        Result result = new Result();
        result.setCode(resultEnum.getCode());
        result.setMessage(resultEnum.getMessage());

        return result;
    }
    public static Map errorMap(ResultCode resultEnum) {
        Map map = new HashMap();
        map.put("code",resultEnum.getCode());
        map.put("Message",resultEnum.getMessage());
        return map;
    }
}
