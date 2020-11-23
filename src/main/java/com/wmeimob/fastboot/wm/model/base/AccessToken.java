package com.wmeimob.fastboot.wm.model.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author LYQ
 * @Classname AccessToken
 * @Description token对象
 * @Date 2020-09-24 16:36
 * @Version V1.0
 */
@Data
public class AccessToken {
    /**
     * Access_token
     */
    @JSONField(name = "access_token")
    private String accessToken;

    /**
     * Access_token的类型目前只支持bearer
     */
    @JSONField(name = "token_type")
    private String tokenType;

    /**
     * Access_token过期时间
     */
    @JSONField(name = "expires_in")
    private String expiresIn;

    /**
     * Refresh_token，可用来刷新access_token
     */
    @JSONField(name = "refresh_token")
    private String refreshToken;

    /**
     * Refresh_token有效期
     */
    @JSONField(name = "refresh_token_expires_in")
    private String refreshTokenExpiresIn;

    /**
     * 授权范围
     */
    private String scope;

    /**
     * 微盟商户id
     */
    @JSONField(name = "business_id")
    private String businessId;

    /**
     * 微盟商户店铺id（新云）/商户公众号id（老云）
     */
    @JSONField(name = "public_account_id")
    private String publicAccountId;


}
