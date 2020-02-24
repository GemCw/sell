package com.gem.sell.repository;

import com.gem.sell.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author Gem
 * @Date 2020/2/23 15:37
 */
public interface OrderDetailRepository  extends JpaRepository<OrderDetail,String> {

    List<OrderDetail> findByOrderId(String orderId);
}
