package com.gem.sell.service.impl;

import com.gem.sell.dataobject.Category;
import com.gem.sell.repository.CategoryRepository;
import com.gem.sell.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 39726
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository repository;

    @Override
    public Category findOne(Integer categoryId) {
        return repository.findOne(categoryId);
    }

    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Category> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return  repository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public Category save(Category Category) {
        return repository.save(Category);
    }
}
