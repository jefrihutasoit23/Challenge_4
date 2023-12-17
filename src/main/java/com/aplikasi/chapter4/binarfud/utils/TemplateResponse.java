package com.aplikasi.chapter4.binarfud.utils;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component // IOC - Beans
public class TemplateResponse {

    public static Map templateSukses(Object objek){
        Map map = new HashMap();
        map.put("data", objek);
        map.put("message", "sukses");
        map.put("status", "200");
        return map;
    }

    public static Map templateEror(Object objek){
        Map map = new HashMap();
        map.put("message", objek);
        map.put("status", "404");
        return map;
    }
    public static Map notFound(Object objek){
        Map map = new HashMap();
        map.put("message", objek);
        map.put("status", "404");
        return map;
    }


    public static boolean chekNull(Object obj){
        if(obj == null){
            return true;
        }
        return  false;
    }
}
