package com.example.usercontroller.controller.htmlcontroller;

import com.example.usercontroller.service.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserHtmlController  {
    @Autowired
    UserFeign userFeign;
    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @RequestMapping("love")
    public String love(){
        return "love/love";
    }

    @RequestMapping("resume")
    public String resume(){
        return "resume/resume";
    }

    @RequestMapping("photo")
    public String photo(){
        return "photo/index";
    }

    @RequestMapping("toArticale")
    public String articale(Model model){

        return "articale/index";
    }

    @RequestMapping("toArtDei")
    public String toArtDei(Model model, HttpServletRequest request){
        String id = request.getParameter("id");
        request.setAttribute("id",id);
        return "articale/single";
    }


}
