package com.wmeimob.api.core.wstore.user;

import com.alibaba.fastjson.JSON;
import com.wmeimob.api.core.Component;
import com.wmeimob.api.model.wstore.request.MemberDetailReq;
import com.wmeimob.api.model.wstore.response.MemberDetailRep;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LYQ
 * @Classname UserInfo
 * @Description 微盟客户信息接口
 * @Date 2020-09-25 10:45
 * @Version V1.0
 */
@Slf4j
public final class UserInfo extends Component {
    public static  final  String URL = "https://dopen.weimob.com/api/1_0/";


    public UserInfo(StringRedisTemplate template){
        super(template);
    }

    /**
     * 获取客户信息
     * https://dopen.weimob.com/api/1_0/mc/member/getMemberDetail?accesstoken=ACCESS_TOKEN
     * @param param
     * @return
     */
    public MemberDetailRep getMemberDetail(MemberDetailReq param){
        String url = URL+"mc/member/getMemberDetail?accesstoken="+accessToken();
        log.debug("url={},param={}",url,param.toString());
        String restString = doPostReturnString(url, JSON.toJSONString(param));

        return JSON.parseObject(restString, MemberDetailRep.class);
    }
    /**
     * 获取用户信息
     * https://dopen.weimob.com/api/1_0/uc/user/getUserInfo?accesstoken=ACCESS_TOKEN
     * @param wid
     *
     * @return
     */
    public MemberDetailRep getUserInfo(String wid){
        String url = URL+"uc/user/getUserInfo?accesstoken="+accessToken();
        log.debug("url={},wid={}",url,wid);
        Map<String, Object> map = new HashMap<>();
        map.put("wid",wid);
        String restString = doPostReturnString(url, JSON.toJSONString(map));
        return JSON.parseObject(restString, MemberDetailRep.class);
    }






}
