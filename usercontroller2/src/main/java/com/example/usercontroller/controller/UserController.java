package com.example.usercontroller.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.usercontroller.service.UserFeign;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@EnableAutoConfiguration
@RequestMapping("/testboot")
public class UserController {

    @Autowired
    UserFeign userFeign;

    @RequestMapping("/getUserById")
    @ResponseBody
    public User selectByPrimaryKey (Integer id){
        User user = new User();
          user = userFeign.getUserById(id);
        return user;
    }

    @RequestMapping("/deleteByPrimaryKey")
    @ResponseBody
    public Map<String,String> deleteByPrimaryKey (Integer id){
        Map<String,String> map = new HashMap<String,String>();
        map = userFeign.deleteUserById(id);
        return map;
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public Map<String,String> addUser (User user){
        Map<String,String> map = new HashMap<String,String>();
        User u = new User();
        u.setAge(12);
        u.setName("王二");
        u.setSex("男");
        map = userFeign.addUser(u);
        return map;
    }

    @RequestMapping("/updateUser")
    @ResponseBody
    public Map<String,String> updateUser (User user){
        Map<String,String> map = new HashMap<String,String>();
        User u = new User();
        u.setId(6);
        u.setAge(23);
        map = userFeign.updateUser(u);
        return map;
    }

    @RequestMapping("/getUserList")
    @ResponseBody
    public JSONObject grtUserList (HttpServletResponse response){System.out.println("sdfsadf");
        JSONObject json = new JSONObject();
        Map<String,String> pmap = new HashMap<String,String>();
        //pmap.put("name","liu");
        json = userFeign.getUserList(pmap);
     /*   Map a = new HashMap();
        a.put("a","s");
        redisService.hmset("map",a);
        redisService.set("data","d");
        Map b = redisService.hmget("map");System.out.println(b);
        Object c = redisService.get("data");System.out.println(c);*/

        //导出的表名
        String title = "测试导出记录";
        //表中第一行表头字段
        String[] headers = {"主键id", "用户名", "年龄", "性别", "密码"};
        //实际数据结果集

        //具体需要写入excel需要哪些字段，这些字段取自UserReward类，也就是上面的实际数据结果集的泛型
        List<String> listColumn = Arrays.asList("id", "name", "age", "sex", "password");
        try {
            List list = (List)json.get("data");
          //  FilePortUtil.exportExcel(response, title, headers, list , listColumn);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return json;
    }

    @RequestMapping("/setSession")
    @ResponseBody
    public String setSession (HttpServletRequest request){
        request.getSession().setAttribute("id","liuzhiping");
        System.out.println(request.getSession().getAttribute("id"));
        return request.getSession().getAttribute("id").toString();
    }

    @RequestMapping("/getSession")
    @ResponseBody
    public String getSession (HttpServletRequest request){

        System.out.println(request.getSession().getAttribute("id"));
        return request.getSession().getAttribute("id").toString();
    }

    @RequestMapping("/cleanSession")
    @ResponseBody
    public String cleanSession (HttpServletRequest request){

        request.getSession().removeAttribute("id");
        return "d";
    }

}
