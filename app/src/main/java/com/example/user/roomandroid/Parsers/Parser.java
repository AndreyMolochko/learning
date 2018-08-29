package com.example.user.roomandroid.Parsers;

/**
 * Created by User on 29.08.2018.
 */

public class Parser {
    public Parser(){

    }

    public static String getStringUrlPhoto(String idPhoto){
        if(idPhoto!="")return "https://vk.com/andr_1999?z="+idPhoto;
        else return "";
    }
}
