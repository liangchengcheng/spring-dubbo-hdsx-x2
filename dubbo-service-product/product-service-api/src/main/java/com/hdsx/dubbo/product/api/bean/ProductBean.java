package com.hdsx.dubbo.product.api.bean;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 梁铖城 - 移动开发部
 * 2020年02月11日20:00:51
 * 商品基础类
 */
public class ProductBean implements Serializable {

    @ApiModelProperty("32位唯一编码")
    private String id;

    @ApiModelProperty("商品名称")
    private String title;

    @ApiModelProperty("商品价格")
    private double price;

    @ApiModelProperty("商品库存")
    private int num;

    @ApiModelProperty("商品状态，1-正常，2-下架，3-删除")
    private int status;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
