package com.wmeimob.fastboot.wm.service;


import com.wmeimob.fastboot.wm.model.base.MessageRequest;


/**
 * @author LYQ
 * @Classname WmeimobService
 * @Description 微盟消息订阅接口
 * @Date 2020-09-22 9:27
 * @Version V1.0
 */
public interface MessageService {

    String SUCCEED ="{\"code\": {\"errcode\": 0, \"errmsg\": \"success\" }}";


    /**
     * 处理消息(异步)
     * @param param
     * @return
     */
    boolean execute(MessageRequest param);
    /**
     * 处理消息后的回调（实时）
     * @param param
     * @return
     */
    boolean rtExecute(MessageRequest param);
}
