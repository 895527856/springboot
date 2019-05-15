package com.example.usercontroller.service;

import com.alibaba.fastjson.JSONObject;
import entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Component
@Service
@FeignClient(value = "userservice") //这里的name对应调用服务的spring.applicatoin.name
@RequestMapping(value = "/user")
public interface UserFeign {

        @RequestMapping(value = "/hi")
        String hi(@RequestParam("id") String id);

    @RequestMapping(value = "/getUserById")
    public User getUserById(int userId) ;

    @RequestMapping(value = "/deleteUserById")
    public Map<String,String> deleteUserById(int userId) ;

    @RequestMapping(value = "/addUser")
    public Map<String,String> addUser(User user);

    @RequestMapping(value = "/updateUser")
    public Map<String,String> updateUser(User user);

    @RequestMapping(value = "/getUserList")
    public JSONObject getUserList(Map<String, String> map);

    @RequestMapping(value = "/setContact")
    public JSONObject setContact(Map<String, String> map);

    @RequestMapping(value = "/getArticale")
    public List<Map> getArticale(Map<String, String> map);

    @RequestMapping(value = "/getArtpl")
    public List<Map<String,String>> getArtpl(Map<String, String> map);

    @RequestMapping(value = "/setArtpl")
    public JSONObject setArtpl(Map map);
}
