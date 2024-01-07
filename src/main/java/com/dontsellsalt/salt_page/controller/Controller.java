package com.dontsellsalt.salt_page.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/")
    public String 랜딩페이지() {
        return "index";
    }

    @GetMapping("/salt_home")
    public String 메인페이지() {
        return "/main/main";
    }
}
