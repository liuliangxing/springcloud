package com.destinyboy.pay.service.impl;

import com.destinyboy.api.order.dto.OrderDto;
import com.destinyboy.api.order.vo.OrderVo;
import com.destinyboy.api.user.dto.UserDto;
import com.destinyboy.api.user.vo.UserVo;
import com.destinyboy.pay.entity.Order;
import com.destinyboy.pay.feign.UserServer;
import com.destinyboy.pay.repository.OrderRepository;
import com.destinyboy.pay.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserServer userServer;

    /**
     * 保存用户订单
     * @param dto
     * @return
     * @throws Exception
     */
    @Override
    public OrderVo saveOrder(OrderDto dto) throws Exception{
        Long userId = dto.getUserId();
        UserVo user = userServer.getUser(userId);

        if (user == null || user.getId() == null) {
            throw  new RuntimeException("用户不存在");
        }

        Order order = new Order();
        order.setOrderName(dto.getOrderName());
        order.setPrice(dto.getPrice());
        order.setUserId(user.getId());
        order.setStatus(0);


        Order orderTemp = this.orderRepository.save(order);
        OrderVo vo = new OrderVo();
        vo.setOrderName(orderTemp.getOrderName());
        vo.setPrice(vo.getPrice());
        return vo;
    }

    /**
     * 支付订单
     * @param dto
     * @return
     * @throws Exception
     */
    @Override
    @Transactional // 本地事务，分布式事务 8月25号
    public OrderVo pay(OrderDto dto) throws Exception{
        Order order = this.orderRepository.findById(dto.getId()).orElseThrow(() -> new RuntimeException("订单不存在"));

        UserDto userDto = new UserDto();
        userDto.setId(dto.getUserId());
        userDto.setBalance(order.getPrice());
        UserVo userVo = userServer.editUserBalance(userDto);// 减去 订单的价格
        // ----- 没有问题的

        order.setStatus(1);

        // 抛异常了

        int i = 0/0;

        Order orderTemp = this.orderRepository.saveAndFlush(order);

        OrderVo vo = new OrderVo();
        BeanUtils.copyProperties(orderTemp, vo);
        return vo;
    }
}
