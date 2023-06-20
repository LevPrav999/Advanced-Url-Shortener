package ru.levprav.services.authservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import ru.levprav.services.authservice.vo.User;

@FeignClient("users")
public interface UsersClient {
    @PostMapping("user/create")
    User create(@RequestBody User user);

    @GetMapping("user/id/{id}")
    User findById(@PathVariable Long id);

    @GetMapping("user/login/{login}")
    User findByLogin(@PathVariable String login);
}
