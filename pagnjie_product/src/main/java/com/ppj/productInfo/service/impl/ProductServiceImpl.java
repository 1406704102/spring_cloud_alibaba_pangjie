package com.ppj.productInfo.service.impl;

import com.domain.Product;
import com.ppj.productInfo.repo.ProductRepo;
import com.ppj.productInfo.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    @Override
    public Product findById(Integer id) {
        Optional<Product> byId = productRepo.findById(id);
        boolean present = byId.isPresent();
        return present ? byId.get() : null;
    }
}
