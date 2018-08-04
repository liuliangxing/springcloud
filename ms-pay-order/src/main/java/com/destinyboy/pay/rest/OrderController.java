package com.destinyboy.pay.rest;


import com.destinyboy.api.order.dto.OrderDto;
import com.destinyboy.api.order.vo.OrderVo;
import com.destinyboy.pay.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 保存订单
     * @param dto
     * @return
     * @throws Exception
     */
    @PostMapping("/save")
    public OrderVo saveOrder(@RequestBody OrderDto dto) throws Exception{
        return orderService.saveOrder(dto);
    }


    /**
     * 支付订单
     * @param dto
     * @return
     * @throws Exception
     */
    @PostMapping("/pay")
    public OrderVo pay(@RequestBody OrderDto dto) throws Exception{
        return orderService.pay(dto);
    }

}
