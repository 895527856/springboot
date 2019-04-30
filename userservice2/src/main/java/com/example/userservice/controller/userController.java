package com.example.userservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.userservice.service.impl.UserServiceImpl;
import com.sun.javafx.collections.MappingChange;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/user")
@RestController
public class userController {
    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = "/getUserList")
    public JSONObject grtUserList(HttpServletResponse response, @RequestBody Map map2){
        //System.out.println(name);
        return userService.getUserList(map2);
    }
}
