package com.hdsx.dubbo.order.api.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.io.Serializable;

@ApiModel
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class OrderQueryBean implements Serializable {

    @ApiModelProperty("订单状态")
    private int orderstate;

    @ApiModelProperty("购买者ID")
    private String userid;

    @ApiModelProperty("分页条数")
    private Integer limit;

    @ApiModelProperty("当前页")
    private Integer current;

}
