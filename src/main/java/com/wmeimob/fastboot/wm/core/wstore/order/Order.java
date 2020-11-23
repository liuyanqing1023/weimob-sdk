package com.wmeimob.fastboot.wm.core.wstore.order;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wmeimob.fastboot.wm.core.Component;
import com.wmeimob.fastboot.wm.model.wstore.response.OrderDetailRep;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author LYQ
 * @Classname UserInfo
 * @Description 微盟客户信息接口
 * @Date 2020-09-25 10:45
 * @Version V1.0
 */
public final class Order extends Component {
    public static  final  String URL = "https://dopen.weimob.com/api/1_0/ec/order/";

    public Order(StringRedisTemplate template){
        super(template);
    }

    /**
     * 查看订单详情 	https://dopen.weimob.com/api/1_0/ec/order/queryOrderDetail?accesstoken=ACCESS_TOKEN
     * @param param
     * @return
     */
    public  OrderDetailRep queryOrderDetail(OrderDetailRep param){
        String url = URL+"queryOrderDetail?accesstoken="+accessToken();
        String restString = doPostReturnString(url, JSON.toJSONString(param));
        return JSON.parseObject(restString, OrderDetailRep.class);
    }
    /**
     * 查看订单详情 	https://dopen.weimob.com/api/1_0/ec/order/queryOrderDetail?accesstoken=ACCESS_TOKEN
     * @param param
     * @return
     */
    public JSONObject queryOrderDetailJSON(OrderDetailRep param){
        String url = URL+"queryOrderDetail?accesstoken="+accessToken();
        String restString = doPostReturnString(url, JSON.toJSONString(param));
        return JSON.parseObject(restString);
    }


}
