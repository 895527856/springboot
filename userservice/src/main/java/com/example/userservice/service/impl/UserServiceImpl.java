package com.example.userservice.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.example.userservice.dao.ContectMapping;
import com.example.userservice.dao.UserMapping;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.RedisService;
import service.UserService;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired(required=false)
    private UserMapping userMapping;
    @Autowired
    private RedisService redisService;
    @Autowired(required=false)
    private ContectMapping contectMapping;

    @Override
    public User getUserById(int userId) {
        Integer d = 1;
        return userMapping.selectByPrimaryKey(userId);
    }

    @Override
    public Map<String, String> deleteUserById(int userId) {
        Map<String,String> map = new HashMap<String,String >();
        int num = userMapping.deleteByPrimaryKey(userId);
        if(num>0){
            map.put("code","1");
            map.put("msg","删除成功");
        }else{
            map.put("code","-1");
            map.put("msg","删除失败");
        }
        return map;
    }

    @Override
    public Map<String, String> addUser(User user) {
        Map<String,String> map = new HashMap<String,String >();
        int num = userMapping.insertSelective(user);
        if(num>0){
            map.put("code","1");
            map.put("msg","增加成功");
        }else{
            map.put("code","-1");
            map.put("msg","增加失败");
        }
        return map;
    }

    @Override
    public Map<String, String> updateUser(User user) {
        Map<String,String> map = new HashMap<String,String >();
        int num = userMapping.updateByPrimaryKeySelective(user);
        if(num>0){
            map.put("code","1");
            map.put("msg","修改成功");
        }else{
            map.put("code","-1");
            map.put("msg","修改失败");
        }
        return map;
    }

    @Override
    public JSONObject getUserList(Map<String, String> map) {
        JSONObject json = new JSONObject();
        try{System.out.println("8784");
            List<User> list = userMapping.getUserList(map);
            json.put("data",list);
            json.put("code","1");
            json.put("msg","查询成功");
            //Destination destination = new ActiveMQQueue("mytest.queue");
            //producer.sendMessage(destination,"查询所有用户成功");

        }catch(Exception e){
            json.put("code","-1");
            json.put("msg","查询失败");
        }
        return json;
    }

    @Override
    public JSONObject setContact(Map<String, String> map) {
        JSONObject json = new JSONObject();
        try{
            int num = contectMapping.setContact(map);
            if (num>0){
                json.put("code","1");
                json.put("msg","查询成功");
            }
        }catch(Exception e){
            json.put("code","-1");
            json.put("msg","查询失败");
        }
        return json;
    }

    @Override
    public List<Map<String,String>> getArticale(Map<String, String> map) {
        List<Map<String,String>> list = new ArrayList();
        try{
             list = contectMapping.getArticale(map);

        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Map<String,String>> getArtpl(Map<String, String> map) {
        List<Map<String,String>> list = new ArrayList();
        try{
            list = contectMapping.getArtpl(map);

        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public JSONObject setArtpl(Map<String, String> map) {
        JSONObject json = new JSONObject();
        try{
            int num = contectMapping.setArtpl(map);
            if (num>0){
                json.put("code","1");
                json.put("msg","添加成功");
            }
        }catch(Exception e){
            json.put("code","-1");
            json.put("msg","添加失败");
        }
        return json;
    }
}
