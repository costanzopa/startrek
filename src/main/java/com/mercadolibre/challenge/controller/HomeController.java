package com.mercadolibre.challenge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Pablo Costanzo on 21/9/2018.
 * Landing Page for Weather API.
 */
@Controller
public class HomeController {
    @RequestMapping("/swagger")
    public String home() {
        return "redirect:/swagger-ui.html";
    }
}
