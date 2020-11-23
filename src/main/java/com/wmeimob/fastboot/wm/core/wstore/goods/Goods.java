package com.wmeimob.fastboot.wm.core.wstore.goods;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wmeimob.fastboot.wm.core.Component;
import com.wmeimob.fastboot.wm.model.wstore.response.OrderDetailRep;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LYQ
 * @Classname Goods
 * @Description 商品
 * @Date 2020-11-23 13:47
 * @Version V1.0
 */
public final class Goods  extends Component {
    public static  final  String URL = "https://dopen.weimob.com/api/1_0/ec/goods/";

    public Goods(StringRedisTemplate template){
        super(template);
    }

    /**
     * 获取商品详情 	https://dopen.weimob.com/api/1_0/ec/goods/queryGoodsDetail?accesstoken=ACCESS_TOKEN
     * @param goodsId
     * @return
     */
    public JSONObject queryOrderDetail(String  goodsId){
        String url = URL+"queryGoodsDetail?accesstoken="+accessToken();
        Map<String, Object> map = new HashMap<>(1);
        map.put("goodsId",goodsId);
        String restString = doPostReturnString(url, JSON.toJSONString(map));
        JSONObject jsonObject = JSONObject.parseObject(restString);
        return jsonObject;
    }

}
