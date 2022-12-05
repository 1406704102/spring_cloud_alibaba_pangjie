package com.ppj.orderInfo.controller;

import com.domain.Order;
import com.domain.Product;
import com.ppj.orderInfo.service.OrderService;
import com.result.Result;
import com.result.ResultUtil;
import feign.productInfo.client.ProductServiceFeign;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.time.Instant;

@Slf4j
@RestController
@RequestMapping("order")
@AllArgsConstructor
public class OrderController {

    private final RestTemplate restTemplate;
    private final OrderService orderService;
    private final ProductServiceFeign productServiceFeign;

    @RequestMapping("/prod/{id}")
    public Result<Order> order(@PathVariable("id") Integer id){
        log.info("接收{}号商品下单", id);
//        Product product = restTemplate.getForObject("http://service-product/product/" + id, Product.class);
        Product product = productServiceFeign.findById(id).getData();
        if (product != null) {

            log.info("查询到{}商品的信息是{}", id, product);
            //创建订单
            Order order = new Order();
            order.setCreateTime(Timestamp.from(Instant.now()));
            order.setProductId(product.getId());
            order.setProductName(product.getProductName());
            order.setProductPrice(product.getProductPrice());
            order.setProductNumber(1);
            order.setUserId(1);
            order = orderService.create(order);
            log.info("下单{}号成功,订单信息{}", id, order);
            return ResultUtil.success(order);
        } else {
            return ResultUtil.fail("下单失败");
        }
    }
}
