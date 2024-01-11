package com.dontsellsalt.salt_page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
    @GetMapping("/letter")
    public String 팬레터페이지(Model model) {
        model.addAttribute("currentPage", "letter");
        return "board/letter";
    }

    @GetMapping("/chat")
    public String 심플챗페이지(Model model) {
        model.addAttribute("currentPage", "chat");
        return "board/chat";
    }
}
