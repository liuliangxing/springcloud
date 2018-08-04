package com.destinyboy.pay.service;

import com.destinyboy.api.order.dto.OrderDto;
import com.destinyboy.api.order.vo.OrderVo;

public interface OrderService {


    /**
     * 保存订单
     * @param dto
     * @return
     * @throws Exception
     */
    OrderVo saveOrder(OrderDto dto) throws Exception;


    /**
     * 支付订单
     * @param dto
     * @return
     * @throws Exception
     */
    OrderVo pay(OrderDto dto) throws Exception;
}
