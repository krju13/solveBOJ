package com.boj.week21;

import java.util.Locale;

public class pro신규아이디추천 {
    public String solution(String new_id){
        //1
        new_id=new_id.toLowerCase();
        //2
        new_id=new_id.replaceAll("[^a-z0-9-_.]","");
        //[^a-z]=a~z까지 소문자 제외
        //[^0-9]= 0~9까지 숫자
        //[^a-z0-9-_.] = a-z,0-9,-,_,. 제외
        //3
        while(new_id.contains("..")){
            new_id=new_id.replace("..",".");
        }
        //4
        if(new_id.length()>0&&new_id.charAt(0)=='.'){
            new_id=new_id.substring(1,new_id.length());
        }
        if(new_id.length()>0&&new_id.charAt(new_id.length()-1)=='.'){
            new_id=new_id.substring(0,new_id.length()-1);
        }
        //5
        if(new_id.length()==0){
            new_id="a";
        }
        //6
        if(new_id.length()>15){
            new_id=new_id.substring(0,15);
        }
        if(new_id.charAt(new_id.length()-1)=='.'){
            new_id=new_id.substring(0,new_id.length()-1);
        }
        //7
        while(new_id.length()<3){
            new_id=new_id+new_id.charAt(new_id.length()-1);
        }
        return new_id;
    }
}
