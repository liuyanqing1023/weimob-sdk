package com.wmeimob.api.core;

import com.alibaba.fastjson.JSON;
import com.wmeimob.api.common.Config;
import com.wmeimob.api.model.base.AccessToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;


/**
 * 基础组件
 * 微盟认证授权分三步:
 *  <p>
 * STEP1:登录微盟后台页面授权
 * <p>
 * STEP2:拿授权后的code获取token {@link Bases#accessToken(java.lang.String)}
 * <p>
 * STEP3:拿refreshRoken实现token续期 {@link Bases#refreshToken()}
 */
@Slf4j
public final class Bases extends Component {

    /**
     * 获取token  获取token 和刷新token都是该URL
     */
    private static final String TOKEN_URL = "https://dopen.weimob.com/fuwu/b/oauth2/token?";
    private Config config;
    private StringRedisTemplate template;

    /**
     * （刷新token时config可传null）
     * @param template
     * @param config
     */
    public Bases(StringRedisTemplate template, Config config){
        super(template);
        this.config = config;
        this.template = template;
    }



    /**
     * 构建授权跳转URL
     * https://dopen.weimob.com/fuwu/b/oauth2/token?code={code}&grant_type=authorization_code&client_id={client_id}&client_secret={client_secret}&redirect_uri={redirect_uri}
     * @return 微盟授权跳转URL
     */
    public String accessTokenUrl(String code) {
        return TOKEN_URL+
                "code=" + code +
                "&grant_type=authorization_code"+
                "&client_id=" + config.getClientId() +
                "&client_secret=" + config.getClientSecret() +
                "&redirect_uri=" + config.getRedirectUri();

    }
    /**
     * 构建延期URL
     * https://dopen.weimob.com/fuwu/b/oauth2/token?grant_type=refresh_token&client_id={client_id}&client_secret={client_secret}&refresh_token={refresh_token}
     * @return 微盟token延期URL
     */
    public String refreshRokenUrl(String refreshToken) {
        return TOKEN_URL+
                "&grant_type=refresh_token" +
                "&client_id=" + config.getClientId() +
                "&client_secret=" + config.getClientSecret() +
                "&refresh_token=" + refreshToken;

    }

    /**
     * 获取accessToken(应该尽量临时保存一个地方，每隔一段时间来获取)
     * <p>1.授权后的第一次获取token</p>
     * @return accessToken，或抛WmeimobException
     */
    public AccessToken accessToken(String code){
        String string = doPost4author(this.accessTokenUrl(code));
        //转换成对象
        AccessToken accessToken = JSON.parseObject(string, AccessToken.class);
        log.debug("获取token,code={},AccessToken={}",code,accessToken.toString());
        saveToken(accessToken);
        return accessToken;
    }


    /**
     * 刷新token(只更新accessToken不更新refreshToken)
     * <p>可以用定时任务轮训调用该方法</p>
     */
    public AccessToken refreshToken(){
        String refreshToken = template.opsForValue().get(REFRESH_TOKEN_KEY);
        return refreshToken(refreshToken);
    }
    /**
     * 刷新token(只更新accessToken不更新refreshToken)
     *
     */
    public AccessToken refreshToken(String refreshToken){
        String string = doPost4author(this.refreshRokenUrl(refreshToken));
        //转换成对象
        AccessToken accessToken = JSON.parseObject(string, AccessToken.class);
        saveToken(accessToken.getAccessToken());
        return accessToken;
    }


    /**
     * 保存token
     * @param accessToken
     */
    public void saveToken(AccessToken accessToken){
        ValueOperations<String, String> opsForValue = template.opsForValue();
        opsForValue.set(ACCESS_TOKEN_KEY,accessToken.getAccessToken(),ACCESS_TOKEN_TIME, TimeUnit.SECONDS);
        opsForValue.set(REFRESH_TOKEN_KEY,accessToken.getRefreshToken());
    }

    /**
     * 保存token
     * @param accessToken
     */
    public void saveToken(String accessToken){
        log.debug("saveToken={}",accessToken);
        ValueOperations<String, String> opsForValue = template.opsForValue();
        opsForValue.set(ACCESS_TOKEN_KEY,accessToken,ACCESS_TOKEN_TIME, TimeUnit.SECONDS);
    }

}
