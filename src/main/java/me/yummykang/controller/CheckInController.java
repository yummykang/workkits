package me.yummykang.controller;

import me.yummykang.service.CheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * write something to describe this file.
 *
 * @author demon
 * @since 2017-11-08 18:06.
 */
@RestController
@RequestMapping("/checkIn")
public class CheckInController {
    @Autowired
    private CheckInService checkInService;

    @GetMapping
    public Object getCheckIns() {
        return checkInService.getCheckIns();
    }
}
