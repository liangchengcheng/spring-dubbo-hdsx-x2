package com.hdsx.dubbo.common.framework.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 梁铖城 - 移动开发部
 * 2020年02月11日10:24:21
 * 设置消息码以及消息文本还有消息数据( 前后台交互信息)
 */
@SuppressWarnings("serial")
@NoArgsConstructor
@Data
@Accessors(chain = true)
@ApiModel
public class Result<T> implements Serializable {

    @ApiModelProperty(value = "返回的信息", hidden = false)
    private String message;

    @ApiModelProperty(value = "信息对应的值", hidden = false)
    private Integer code;

    @ApiModelProperty(value = "返回的数据", hidden = false)
    private T data;
}
