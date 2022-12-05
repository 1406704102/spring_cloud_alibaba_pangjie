package com.ppj.orderInfo.service.impl;

import com.domain.Order;
import com.ppj.orderInfo.repo.OrderRepo;
import com.ppj.orderInfo.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;
    @Override
    public Order create(Order order) {
        return orderRepo.save(order);
    }
}
