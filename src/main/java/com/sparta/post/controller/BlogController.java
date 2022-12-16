package com.sparta.post.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/api")
public class BlogController {

    @GetMapping("/api/posts")
    public ModelAndView blog() {
        return new ModelAndView("index");
    }
}

