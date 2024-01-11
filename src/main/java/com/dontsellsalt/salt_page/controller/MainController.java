package com.dontsellsalt.salt_page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String 랜딩페이지(Model model) {
        model.addAttribute("currentPage", "intro");
        return "intro";
    }

    @GetMapping("/main")
    public String 메인페이지(Model model) {
        model.addAttribute("currentPage", "main");
        return "main";
    }

    @GetMapping("/album")
    public String 앨범페이지(Model model) {
        model.addAttribute("currentPage", "album_list");
        return "about/album_list";
    }

    @GetMapping("/lyric")
    public String 가사페이지(Model model) {
        model.addAttribute("currentPage", "lyric");
        return "about/lyric";
    }

    @GetMapping("/news")
    public String 소식페이지(Model model) {
        model.addAttribute("currentPage", "news");
        return "about/news";
    }

    @GetMapping("/notice")
    public String 공지페이지(Model model) {
        model.addAttribute("currentPage", "notice");
        return "about/notice";
    }
}
