package com.hdsx.dubbo.order.api.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 订单的对象
 */
@ApiModel
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class OrderBean implements Serializable {
    @ApiModelProperty("ID")
    private String id;

    @ApiModelProperty("商品ID")
    private String productid;

    @ApiModelProperty("订单状态")
    private int orderstate;

    @ApiModelProperty("购买者ID")
    private String userid;

    @ApiModelProperty("购买数量")
    private int ordernum;

    @ApiModelProperty("购买总价格")
    private double orderprice;

    @ApiModelProperty("购买创建时间")
    private String createtime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public int getOrderstate() {
        return orderstate;
    }

    public void setOrderstate(int orderstate) {
        this.orderstate = orderstate;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public int getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(int ordernum) {
        this.ordernum = ordernum;
    }

    public double getOrderprice() {
        return orderprice;
    }

    public void setOrderprice(double orderprice) {
        this.orderprice = orderprice;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }
}
