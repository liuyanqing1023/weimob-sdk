package com.wmeimob.api.model.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author LYQ
 * @Classname WmMessageRequest
 * @Description 微盟订阅消息接口
 * @Date 2020-09-22 14:31
 * @Version V1.0
 */
@Data
public class MessageRequest {
    @JSONField(name = "business_id")
    @JsonProperty("business_id")
    private String businessId;
    private String event;
    private String id;
    private String model;
    @JSONField(name = "msg_body")
    @JsonProperty("msg_body")
    private String msgBody;
    @JSONField(name = "public_account_id")
    @JsonProperty("public_account_id")
    private String publicAccountId;
    private String sign;
    private String msgSignature;
    private String topic;
    private String version;
  //  private String serviceMapKey;
    public String getServiceMapKey() {
        return topic+":"+event;
    }
}
