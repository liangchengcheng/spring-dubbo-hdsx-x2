package com.hdsx.dubbo.product.dao;

import com.hdsx.dubbo.product.api.bean.ProductBean;
import com.hdsx.dubbo.product.api.bean.ProductNumBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.Collection;
import java.util.List;

public interface ProductMapper {
    /**
     * 添加商品信息
     */
    int addProduct(ProductBean productBean);

    /**
     * 修改商品信息
     */
    int updateProductNumBean(ProductNumBean productNumBean);

    /**
     * 修改商品信息
     */
    int editProduct(ProductBean productBean);

    /**
     * 通过ID获取商品信息
     */
    ProductBean getProductById(String id);
}
