package com.atibusinessgroup.bukutamu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppointmentController {


    @GetMapping("/appointment")
    public String index() {
        return "appointment";
    }
}
