package com.gem.sell.service;

import com.gem.sell.dataobject.Category;

import java.util.List;

/**
 * @author 39726
 */
public interface CategoryService {

    Category findOne(Integer CategoryId);

    List<Category> findAll();

    List<Category> findByCategoryTypeIn(List<Integer> CategoryTypeList);

    Category save(Category Category);

}
