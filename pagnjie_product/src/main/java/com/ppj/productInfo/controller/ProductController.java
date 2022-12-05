package com.ppj.productInfo.controller;

import com.domain.Product;
import com.ppj.productInfo.service.ProductService;
import com.result.Result;
import com.result.ResultUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("product")
public class ProductController {
    @Autowired
    private final ProductService productService;

    @RequestMapping("/{id}")
    public Result<Product> product(@PathVariable("id") Integer id){
        log.info("查询{}号商品", id);
        Product product =productService.findById(id);
        log.info("查询成功{}", product);
        return ResultUtil.success(product);
    }
}
