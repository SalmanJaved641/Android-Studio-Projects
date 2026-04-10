package com.example.recyclerview;

public class ContectModel {

    int img;
    String name , number;
    int lastPosition;

    public ContectModel(int img,String name,String number){
        this.img = img;
        this.name = name;
        this.number = number;
    }
    public ContectModel(int img,String name,int lastPosition){
        this.img = img;
        this.name = name;
        this.lastPosition = lastPosition;
    }
}
