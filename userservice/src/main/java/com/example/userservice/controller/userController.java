package com.example.userservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.userservice.service.impl.UserServiceImpl;
import com.sun.javafx.collections.MappingChange;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
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

    @RequestMapping(value = "/setContact")
    public JSONObject setContect(HttpServletResponse response, @RequestBody Map map2){
        //System.out.println(name);
        return userService.setContact(map2);
    }

    @RequestMapping(value = "/getArticale")
    public List<Map<String,String>> getArticale(HttpServletResponse response, @RequestBody Map map2){
        //System.out.println(name);
        List<Map<String,String>> list = userService.getArticale(map2);
        for (Map map:list) {
            map.put("id",map.get("id").toString());
        }
        return list;
    }
    @RequestMapping(value = "/getArtpl")
    public List<Map<String,String>> getArtpl(HttpServletResponse response, @RequestBody Map map2){
        //System.out.println(name);
        List<Map<String,String>> list = userService.getArtpl(map2);
        for (Map map:list) {
            map.put("id",map.get("id").toString());
            map.put("artId",map.get("artId").toString());
        }
        return list;
    }
    @RequestMapping(value = "/setArtpl")
    public JSONObject setArtpl(HttpServletResponse response, @RequestBody Map map2){
        //System.out.println(name);
        JSONObject json =userService.setArtpl(map2);
        return json;
    }
}
