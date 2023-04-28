package feign.productInfo.client;

import com.domain.Product;
import com.result.Result;
import feign.productInfo.fallBack.ProductServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "service-product", fallbackFactory = ProductServiceFallback.class)
public interface ProductServiceFeign {

    @RequestMapping("/product/{id}")
    Result<Product> findById(@PathVariable Integer id);
    @RequestMapping("/product/{name}")
    Result<Product> findByName(@PathVariable String name);
}
