package feign.productInfo.fallBack;

import com.domain.Product;
import com.result.Result;
import com.result.ResultUtil;
import feign.hystrix.FallbackFactory;
import feign.productInfo.client.ProductServiceFeign;

import org.springframework.stereotype.Component;

@Component
public class ProductServiceFallback implements FallbackFactory<ProductServiceFeign> {
    @Override
    public ProductServiceFeign create(Throwable throwable) {
        return new ProductServiceFeign() {
            @Override
            public Result<Product> findById(Integer id) {
                return ResultUtil.notFound();
            }

            @Override
            public Result<Product> findByName(String name) {
                return ResultUtil.notFound();
            }

        };
    }
}
