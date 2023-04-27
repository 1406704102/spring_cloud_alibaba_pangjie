package feign.userInfo.client;

import com.domain.Product;
import com.domain.User;
import com.result.Result;
import feign.userInfo.fallBack.UserServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "service-user", fallbackFactory = UserServiceFallBack.class)
public interface UserServiceFeign {

    @RequestMapping("/user/{id}")
    Result<User> findById(@PathVariable Integer id);
}
