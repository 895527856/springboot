package service;

import com.alibaba.fastjson.JSONObject;
import entity.User;

import java.util.List;
import java.util.Map;


public interface UserService {

    public User getUserById(int userId) ;

    public Map<String,String> deleteUserById(int userId) ;

    public Map<String,String> addUser(User user);

    public Map<String,String> updateUser(User user);

    public JSONObject getUserList(Map<String, String> map);

    public JSONObject setContact(Map<String, String> map);

    public List<Map<String,String>> getArticale(Map<String, String> map);

    public List<Map<String,String>> getArtpl(Map<String, String> map);

    public JSONObject setArtpl(Map<String, String> map);
}
