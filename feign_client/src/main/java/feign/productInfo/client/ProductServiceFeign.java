package feign.productInfo.client;

import com.domain.Product;
import com.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "service-product", fallbackFactory = ProductServiceFallback.class)
public interface ProductServiceFeign {

    @RequestMapping("/product/{id}")
    Result<Product> findById(@PathVariable Integer id);
}
