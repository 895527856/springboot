package com.example.usercontroller.other;

import java.util.List;

public class Component {
    private List <Component> children;
    private  int weight;
    private int getWeight(){
        int result = weight;
        if(children != null){
            for (Component child : children){
                if(child != null){

                    result += child.weight;
                }
            }
        }
        return result;
    }
}
