package com.capgemini.airport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/airplane")
public class AirplaneController {
    @GetMapping("/")
    public String index(Map<String, Object> model) {
        model.put("title", "Airport");
        return "airplane/index";
    }
}
