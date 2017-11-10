package me.yummykang.controller;

import me.yummykang.entity.tables.pojos.Users;
import me.yummykang.entity.tables.records.UsersRecord;
import me.yummykang.exceptions.BusinessErrorException;
import me.yummykang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * write something to describe this file.
 *
 * @author demon
 * @since 2017-11-09 13:53.
 */
@RestController
@RequestMapping("/auth")
public class AuthorizationController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Object login(@RequestBody Users users) throws BusinessErrorException {
        return userService.login(users);
    }
}
