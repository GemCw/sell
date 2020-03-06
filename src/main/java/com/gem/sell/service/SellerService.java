package com.gem.sell.service;

import com.gem.sell.dataobject.SellerInfo;

/**
 * @Author Gem
 * @Date 2020/3/1 21:08
 */
public interface SellerService {

    SellerInfo findSellerInfoByOpenid(String openid);
}
