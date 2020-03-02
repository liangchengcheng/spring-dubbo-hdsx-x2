package com.hdsx.dubbo.product.api.bean;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 梁铖城 - 移动开发部
 * 2020年02月11日20:00:51
 * 商品基础类 - 减少库存的数量
 */
public class ProductNumBean implements Serializable {

    @ApiModelProperty("32位唯一编码")
    private String id;

    @ApiModelProperty("商品较少库存")
    private int num;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
