package com.gem.sell.service.impl;

import com.gem.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 3972
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void findOne() {
        ProductCategory category = categoryService.findOne(3);
        Assert.assertEquals(new Integer(3), category.getCategoryId());
    }

    @Test
    public void findAll() {
        List<ProductCategory> CategoryList = categoryService.findAll();
        Assert.assertNotEquals(0, CategoryList.size());
    }

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> CategoryList = categoryService.findByCategoryTypeIn(Arrays.asList(1,2,3,4));
        Assert.assertNotEquals(0, CategoryList.size());
    }

    @Test
    public void save() {
        ProductCategory Category = new ProductCategory("男生专享", 10);
        ProductCategory result = categoryService.save(Category);
        Assert.assertNotNull(result);
    }

}