package com.wmeimob.fastboot.wm.service;

import com.wmeimob.fastboot.wm.model.base.MessageCallback;

/**
 * @author LYQ
 * @Classname WmeimobService
 * @Description 微盟消息订阅回调接口
 * @Date 2020-09-22 9:27
 * @Version V1.0
 */
public interface MessageCallbackService {
    /**
     * 消息回调
     * @param param
     * @return
     */
    boolean callback(MessageCallback param);
}
