package com.wmeimob.fastboot.wm.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LYQ
 * @Classname Cache
 * @Description  存放token
 * @Date 2020-11-19 11:07
 * @Version V1.0
 */
public class Cache {
    private static Map<String,Object> cache;
    private Cache(){}
    public static   Map<String,Object>  getCahce(){
        if (cache == null) {
            cache =  new HashMap<>();
        }
        return cache;
    }
    public static void setCahce(String token){
        if (cache == null) {
            cache =  new HashMap<>();
        }
        cache.put("token", token);
    }


}
