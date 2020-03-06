package com.gem.sell.converter;

import com.gem.sell.VO.OrderVO;
import com.gem.sell.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author Gem
 * @Date 2020/2/27 15:58
 */
public class OrderDTO2OrderVOConverter {

    public static OrderVO convert(OrderDTO orderDTO){
        OrderVO orderVO = new OrderVO();
        BeanUtils.copyProperties(orderDTO,orderVO);
        return orderVO;
    }

    public static List<OrderVO> convert(List<OrderDTO> orderDTOList){
//            List<OrderDto> orderDtoList = new ArrayList<>();
//            for(OrderMaster orderMaster : orderMasterList) {
//                orderDtoList.add(convert(orderMaster));
//            }
//            return orderDtoList;
        /**.stream()就是把orderMasterList转换成stream才能操作，
         * .map()就是把orderMasterList中每个对象e都执行convert(e)，
         * .collect(Collectors.toList())就是把执行convert(e)的全部结果转换成一个List。
         * 总的来说就是把orderMasterList中每个对象都执行convert然后把每个结果都装进List中，**/
        return orderDTOList.stream().map(e -> convert(e)).collect(Collectors.toList());
    }



}
