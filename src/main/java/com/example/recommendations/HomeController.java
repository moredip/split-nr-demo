package com.example.recommendations;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/humans.txt")
    public String humans(){
        return "Pete Hodgson";
    }

    @GetMapping("/")
    public String root(){
        return "<html>try something like <a href=\"/recommendations/related-to-product/00000000-0000-0000-0000-111111111111\">/recommendations/related-to-product/00000000-0000-0000-0000-111111111111</a></html>";
    }
}
