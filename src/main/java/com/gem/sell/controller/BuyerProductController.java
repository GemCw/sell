package com.gem.sell.controller;

import com.gem.sell.VO.ProductInfoVO;
import com.gem.sell.VO.ProductVO;
import com.gem.sell.VO.ResultVO;
import com.gem.sell.dataobject.ProductCategory;
import com.gem.sell.dataobject.ProductInfo;
import com.gem.sell.service.CategoryService;
import com.gem.sell.service.ProductService;
import com.gem.sell.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 买家商品
 * @author 39726
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list(){
        //1.查询所有的上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();
        //2.查询所有上架商品的类目(一次性查询)
//            //传统做法
//        List<Integer> categoryTypeList = new ArrayList<>();
//            for(ProductInfo productInfo : productInfoList){
//                categoryTypeList.add(productInfo.getCategoryType());
//            }
        //精简方法(java8,lambda)
        List<Integer> categoryTypeList = productInfoList
                                        .stream()
                                        .map(e -> e.getCategoryType())
                                        .collect(Collectors.toList());
        List<ProductCategory> productcategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //3.数据拼装,最后将productVOList封装到ResultVO统一接口
        List<ProductVO> productVOList = new ArrayList<>();
        for(ProductCategory productCategory:productcategoryList){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for(ProductInfo productInfo : productInfoList){
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    //赋值工具类
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);
    }
}
