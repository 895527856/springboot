package com.example.usercontroller.controller.htmlcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserHtmlController {

    @RequestMapping("index")
    public String index(){
        return "index";
    }
}
