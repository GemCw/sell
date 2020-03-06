package com.gem.sell.service;

import com.gem.sell.dataobject.ProductCategory;

import java.util.List;

/**
 * @author 39726
 */
public interface CategoryService {

    ProductCategory findOne(Integer CategoryId);

    /**查询所有类目*/
    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> CategoryTypeList);

    ProductCategory save(ProductCategory Category);

}
