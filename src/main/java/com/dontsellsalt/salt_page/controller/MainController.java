package com.dontsellsalt.salt_page.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class MainController {

    @GetMapping("/")
    public String 랜딩페이지(Model model) {
        model.addAttribute("currentPage", "intro");
        return "intro";
    }

    @GetMapping("/salt_home")
    public String 메인페이지() {
        return "main";
    }

    @GetMapping("/lyric")
    public String 가사페이지(Model model) {
        model.addAttribute("currentPage", "lyric");
        return "album/lyric";
    }
}
