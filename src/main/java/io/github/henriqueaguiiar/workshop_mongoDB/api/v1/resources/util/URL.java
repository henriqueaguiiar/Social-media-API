package io.github.henriqueaguiiar.workshop_mongoDB.api.v1.resources.util;

import lombok.experimental.UtilityClass;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@UtilityClass
public class URL {
    public static String decodeParam(String text){
        try{
            return URLDecoder.decode(text,"UTF-8");
        }catch(UnsupportedEncodingException e){
            return "";
        }
    }
}
