package feign.userInfo.client;

import com.domain.User;
import com.result.Result;
import feign.userInfo.fallBack.UserServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "service-user", fallbackFactory = UserServiceFallBack.class)
public interface UserServiceFeign {

    @RequestMapping("/user/{id}")
    Result<User> findById(@PathVariable Integer id);
    @RequestMapping("/user/findByUsername")
    Result<User> findByUsername(@RequestParam(value = "username") String username);
}
