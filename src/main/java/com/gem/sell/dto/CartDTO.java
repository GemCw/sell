package com.gem.sell.dto;

import lombok.Getter;

/**
 * @Author Gem
 * @Date 2020/2/23 18:15
 */
@Getter
public class CartDTO {

    /**商品ID*/
    private String productId;

    /**数量*/
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }

}
