package com.gem.sell.service.impl;/**
 * @Author Gem
 * @Date 2020/3/1 21:09
 */

import com.gem.sell.dataobject.SellerInfo;
import com.gem.sell.repository.SellerInfoRepository;
import com.gem.sell.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：Gem
 * @description：TODO
 * @date ：2020/3/1 21:09
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoRepository repository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return repository.findByOpenid(openid);
    }
}
