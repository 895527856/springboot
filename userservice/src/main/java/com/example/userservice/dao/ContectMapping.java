package com.example.userservice.dao;

import java.util.List;
import java.util.Map;

public interface ContectMapping {

    int setContact(Map<String, String> map);

    //获取文章
    List<Map<String,String>> getArticale(Map<String, String> map);

    List<Map<String,String>> getArtpl(Map<String,String> map);

    int setArtpl(Map<String,String> map);
}
