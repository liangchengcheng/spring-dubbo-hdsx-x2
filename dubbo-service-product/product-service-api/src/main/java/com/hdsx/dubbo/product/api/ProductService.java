package com.hdsx.dubbo.product.api;

import com.hdsx.dubbo.common.framework.vo.Result;
import com.hdsx.dubbo.product.api.bean.ProductBean;
import com.hdsx.dubbo.product.api.bean.ProductNumBean;
import java.util.Collection;
import java.util.List;

public interface ProductService {

    Result InsertOrUpdateProduct(ProductBean productBean);

    Result UpdateProductNumBean(ProductNumBean productNumBean);

    Result getProductById(String id);
}
