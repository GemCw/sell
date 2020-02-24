package com.gem.sell.converter;

import com.gem.sell.dataobject.OrderMaster;
import com.gem.sell.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author Gem
 * @Date 2020/2/23 21:45
 */
public class OrderMaster2OrderDTOConverter {

        public static OrderDTO convert(OrderMaster orderMaster){
            OrderDTO orderDTO = new OrderDTO();
            BeanUtils.copyProperties(orderMaster,orderDTO);
            return orderDTO;
        }

        public static List<OrderDTO> convert(List<OrderMaster> orderMasterList){
//            List<OrderDto> orderDtoList = new ArrayList<>();
//            for(OrderMaster orderMaster : orderMasterList) {
//                orderDtoList.add(convert(orderMaster));
//            }
//            return orderDtoList;
            /**.stream()就是把orderMasterList转换成stream才能操作，
             * .map()就是把orderMasterList中每个对象e都执行convert(e)，
             * .collect(Collectors.toList())就是把执行convert(e)的全部结果转换成一个List。
             * 总的来说就是把orderMasterList中每个对象都执行convert然后把每个结果都装进List中，**/
            return orderMasterList.stream().map(e -> convert(e)).collect(Collectors.toList());
        }
}
