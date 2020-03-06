package com.gem.sell.controller;/**
 * @Author Gem
 * @Date 2020/3/1 16:00
 */

import com.gem.sell.dataobject.ProductCategory;
import com.gem.sell.enums.ResultEnum;
import com.gem.sell.exception.SellException;
import com.gem.sell.form.CategoryForm;
import com.gem.sell.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ：Gem
 * @description：TODO
 * @date ：2020/3/1 16:00
 */
@Controller
@RequestMapping("/seller/category")
public class SellerCategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 类目列表
     * */
    @GetMapping("/list")
    public ModelAndView list(Map<String,Object> map){
       List<ProductCategory>productCategoryList = categoryService.findAll();
        map.put("categoryList",productCategoryList);
        return  new ModelAndView("category/list",map);
    }

     /**
      * 展示
      * */
     @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "categoryId",required = false) Integer categoryId,
                              Map<String,Object> map){
         if(null!=categoryId){
             ProductCategory productCategory = categoryService.findOne(categoryId);
             map.put("category",productCategory);
         }
         return new ModelAndView("category/index",map);
     }

    /**
     * 保存/更新
     */
    @PostMapping("/save")
    public ModelAndView save(@Valid CategoryForm form,
                             BindingResult bindingResult,
                             Map<String, Object> map) {
        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/sell/seller/category/index");
            return new ModelAndView("common/error", map);
        }
        ProductCategory productCategory = new ProductCategory();
        try {
            if (form.getCategoryId() != null) {
                productCategory = categoryService.findOne(form.getCategoryId());
            }
            //   判断类型是否已经存在
            List<Integer> categoryTypeList= new ArrayList<>();
            categoryTypeList.add(form.getCategoryType());
            List<ProductCategory> categoryList= categoryService.findByCategoryTypeIn(categoryTypeList);
            if(categoryList.size()!=0){
                map.put("msg", ResultEnum.PRODUCT_TPYE_EXSIT.getMessage());
                map.put("url", "/sell/seller/category/list");
                return new ModelAndView("common/error", map);
            }

            BeanUtils.copyProperties(form, productCategory);
            categoryService.save(productCategory);
        }catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/category/index");
            return new ModelAndView("common/error", map);
        }

        map.put("url", "/sell/seller/category/list");
        return new ModelAndView("common/success", map);
    }
}
