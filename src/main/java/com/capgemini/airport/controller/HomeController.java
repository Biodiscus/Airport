package com.capgemini.airport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/")
public class HomeController {
    @RequestMapping("/")
    public String index(Map<String, Object> model) {
        model.put("title", "Base");
        return "index";
    }
}
