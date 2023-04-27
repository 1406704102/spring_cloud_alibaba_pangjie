package feign.userInfo.fallBack;

import com.domain.Product;
import com.domain.User;
import com.result.Result;
import com.result.ResultUtil;
import feign.hystrix.FallbackFactory;
import feign.userInfo.client.UserServiceFeign;
import org.springframework.stereotype.Component;

@Component

public class UserServiceFallBack implements FallbackFactory<UserServiceFeign> {
    @Override
    public UserServiceFeign create(Throwable throwable) {
        return new UserServiceFeign() {
            @Override
            public Result<User> findById(Integer id) {
                return ResultUtil.notFound();
            }
        };
    }
}
