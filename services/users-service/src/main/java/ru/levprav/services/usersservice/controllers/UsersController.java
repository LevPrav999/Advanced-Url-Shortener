package ru.levprav.services.usersservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.levprav.services.usersservice.models.User;
import ru.levprav.services.usersservice.services.UsersService;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UsersController {
    private final UsersService usersService;

    @PostMapping("create")
    public User create(@RequestBody User user) {
        return usersService.create(user);
    }

    @GetMapping("id/{id}")
    public User findById(@PathVariable Long id) {
        return usersService.findById(id);
    }

    @GetMapping("login/{login}")
    public User findByLogin(@PathVariable String login) {
        return usersService.findByLogin(login);
    }
}