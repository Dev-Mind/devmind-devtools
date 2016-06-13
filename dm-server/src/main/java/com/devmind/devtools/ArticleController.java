package com.devmind.devtools;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @RequestMapping("/{id}")
    public String get(){
        return "HEllo";
    }
}
