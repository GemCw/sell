package com.gem.sell.service.impl;

import com.gem.sell.dto.OrderDTO;
import com.gem.sell.service.OrderService;
import com.gem.sell.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author Gem
 * @Date 2020/2/26 12:47
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PayServiceImplTest {

    @Autowired
    private PayService payService;

    @Autowired
    private OrderService orderService;

    @Test
    public void create() {
        OrderDTO orderDTO = orderService.findOne("1582534644154540122");
        payService.create(orderDTO);
    }

    @Test
    public void refund(){

    }
}