package com.gem.sell.service;

import com.gem.sell.dto.OrderDTO;

/**
 * @Author Gem
 * @Date 2020/2/24 18:44
 */
public interface BuyerService {

    /**查询一个订单*/
    OrderDTO findOrderOne(String openid, String orderId);

    /**取消订单*/
    OrderDTO cancelOrder(String openid, String orderId);

}
