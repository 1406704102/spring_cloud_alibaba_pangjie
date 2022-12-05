package feign.productInfo.client;

import com.domain.Product;
import com.result.Result;
import com.result.ResultUtil;
import feign.hystrix.FallbackFactory;
import feign.productInfo.client.ProductServiceFeign;

import org.springframework.stereotype.Component;

@Component
public class ProductServiceFallback implements FallbackFactory<ProductServiceFeign> {
    @Override
    public ProductServiceFeign create(Throwable cause) {
        return new ProductServiceFeign() {
            @Override
            public Result<Product> findById(Integer id) {
                Product product = new Product();
                product.setId(-1);
                return ResultUtil.notFound();
            }
        };
    }
}
