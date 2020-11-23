package com.wmeimob.fastboot.wm.core.wstore.user;

import com.alibaba.fastjson.JSON;
import com.wmeimob.fastboot.wm.core.Component;
import com.wmeimob.fastboot.wm.model.wstore.request.MemberDetailReq;
import com.wmeimob.fastboot.wm.model.wstore.request.MemberPointAmountReq;
import com.wmeimob.fastboot.wm.model.wstore.response.MemberDetailRep;
import com.wmeimob.fastboot.wm.model.wstore.response.MemberListRep;
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
    /**
     * 获取用户信息列表
     * https://dopen.weimob.com/api/1_0/mc/member/getMemberList?accesstoken=ACCESS_TOKEN
     * @param cursor 滚动游标
     * @param size 滚动数量，最大100
     *
     * @return
     */
    public MemberListRep getMemberList(Long cursor, Long size){
        String url = URL+"mc/member/getMemberList?accesstoken="+accessToken();
        log.debug("url={},cursor={};size={}",url,cursor,size);
        Map<String, Object> map = new HashMap<>(2);
        map.put("cursor",cursor);
        map.put("size",size);
        String restString = doPostReturnString(url, JSON.toJSONString(map));
        return JSON.parseObject(restString, MemberListRep.class);
    }
    /**
     *  增加积分
     * 	https://dopen.weimob.com/api/1_0/mc/member/addMemberPointAmount?accesstoken=ACCESS_TOKEN
     * @param param
     *
     * @return
     */
    public void addMemberPointAmount(MemberPointAmountReq param){
        String url = URL+"mc/member/addMemberPointAmount?accesstoken="+accessToken();
        String string = JSON.toJSONString(param);
        log.debug("url={},param={}",url, string);
        String restString = doPostReturnString(url,string);
    }
    /**
     *  减少积分
     * 	hhttps://dopen.weimob.com/api/1_0/mc/member/useMemberPointAmountOffLine?accesstoken=ACCESS_TOKEN
     * @param param 滚动游标
     *
     * @return
     */
    public void useMemberPointAmountOffLine(MemberPointAmountReq param){
        String url = URL+"mc/member/useMemberPointAmountOffLine?accesstoken="+accessToken();
        String string = JSON.toJSONString(param);
        log.debug("url={},param={}",url, string);
        String restString = doPostReturnString(url,string);
    }
}
