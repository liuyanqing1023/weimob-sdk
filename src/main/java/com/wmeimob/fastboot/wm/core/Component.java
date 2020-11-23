package com.wmeimob.fastboot.wm.core;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wmeimob.fastboot.wm.common.HttpClient;
import com.wmeimob.fastboot.wm.exception.WmeimobException;
import com.wmeimob.fastboot.wm.model.base.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Map;

/**
 * 微信组件需要继承该类
 * Author: LYQ
 * Email: haolin.h0@gmail.com
 * Date: 18/11/15
 * @since 1.4.0
 */
@Slf4j
public abstract class Component {
   // protected static final JavaType MAP_STRING_OBJ_TYPE = Jsons.DEFAULT.createCollectionType(Map.class, String.class, Object.class);
    protected final String ACCESS_TOKEN_KEY = "WM:ACCESS_TOKEN";
    protected final String REFRESH_TOKEN_KEY = "WM:REFRESH_TOKEN";
    protected final Integer ACCESS_TOKEN_TIME = 4000;

    protected StringRedisTemplate template;
    protected Component(StringRedisTemplate template){
        this.template = template;
    }



    /**
     * POST请求
     * @param url URL
     * @param body 请求body
     * @return Map结果集
     */
    protected String doPostReturnString(String url, String body){
        HttpClient httpClient = new HttpClient(url);
        httpClient.setParameter(body);
        String content = "";
        try {
            httpClient.postForJson();
            content = httpClient.getContent();
        } catch (Exception e){
            throw new WmeimobException(e);
        }
        if (httpClient.getStatusCode() != 200){
            String msg = "调用"+url+"异常,statusCode = httpClient.getStatusCode()";
            throw  new WmeimobException(msg);
        }
        log.debug("url={};body={};content={}",url,body,content);
        return error(content);
    }
    /**
     * POST请求
     * @param url URL
     * @param params 请求body
     * @return Map结果集
     */
    protected String doPostReturnString(String url, Map<String, Object> params){
        log.debug("url={};body={}",url,JSON.toJSONString(params));
        HttpClient httpClient = new HttpClient(url);
        httpClient.setParameter(params);
        String content = "";
        try {
            httpClient.postForJson();
            content = httpClient.getContent();
        } catch (Exception e){
            throw new WmeimobException(e);
        }
        if (httpClient.getStatusCode() != 200){
            String msg = "调用"+url+"异常,statusCode = httpClient.getStatusCode()";
            throw  new WmeimobException(msg);
        }
        log.debug("content={}",content);
        return error(content);
    }
    /**
     * POST请求
     * @param url URL
     * @return Map结果集
     */
    protected String doPostReturnString(String url){
        log.debug("url={};",url);
        HttpClient httpClient = new HttpClient(url);
        String content = "";
        try {
            httpClient.postForJson();
            content = httpClient.getContent();
        } catch (Exception e){
            throw new WmeimobException(e);
        }
        if (httpClient.getStatusCode() != 200){
            String msg = "调用"+url+"异常,statusCode = httpClient.getStatusCode()";
            throw  new WmeimobException(msg);
        }
        log.debug("content={}",content);
        return error(content);
    }

    /**
     * POST请求
     * @param url URL
     * @return Map结果集
     */
    protected String doPost4author(String url){

        HttpClient httpClient = new HttpClient(url);
        String content = "";
        try {
            httpClient.postForJson();
            content = httpClient.getContent();
        } catch (Exception e){
            throw new WmeimobException(e);
        }
        if (httpClient.getStatusCode() != 200){
            String msg = "调用"+url+"异常,statusCode = "+httpClient.getStatusCode()+"content="+content;
            log.error(msg);
            throw  new WmeimobException(msg);
        }
        return content;
    }


    /**
     * get请求
     * @param url URL
     * @param params 请求body
     * @return Map结果集
     */
    protected String doGetReturnString(String url, Map<String, Object> params){
        log.debug("url={};body={}",url,JSON.toJSONString(params));
        HttpClient httpClient = new HttpClient(url);
        httpClient.setParameter(params);
        String content = "";
        try {
            httpClient.get();
            content = httpClient.getContent();
        } catch (Exception e){
            throw new WmeimobException(e);
        }
        if (httpClient.getStatusCode() != 200){
            String msg = "调用"+url+"异常,statusCode = httpClient.getStatusCode()";
            throw  new WmeimobException(msg);
        }
        log.debug("content={}",content);
        return error(content);
    }



    /**
     * GET请求
     * @param url URL
     * @return Map结果集
     */
    protected Map<String, Object> doGet(String url){
        return doGet(url);
    }

    /**
     * 获取accessToken(从缓存中获取token)
     * <p>从Redis中获取token</p>
     * @return accessToken，或抛WmeimobException
     */
    protected String accessToken(){
        return template.opsForValue().get(ACCESS_TOKEN_KEY);
    }

    private String error(String content){
        if (content == null ){
            return "";
        }
       // ApiResult apiResult = JSON.parseObject(content, ApiResult.class);
        JSONObject contentJson = JSON.parseObject(content);

        JSONObject code = contentJson.getJSONObject("code");
        String errcode = code.getString("errcode");
        if (!"0".equals(errcode) ){
            throw  new WmeimobException(code.toJSONString());
        }
        String date = contentJson.getString("data");
        return date;
    }

}
