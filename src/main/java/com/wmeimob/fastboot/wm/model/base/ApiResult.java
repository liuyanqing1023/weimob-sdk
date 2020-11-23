package com.wmeimob.fastboot.wm.model.base;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @author LYQ
 * @Classname AccessToken
 * @Description token对象 废弃
 * @Date 2020-09-24 16:36
 * @Version V1.0
 */
@Data
public class ApiResult {
    /**
     * 请求状态
     */
     private String  code;
    /**
     * 业务数据
     */
    private  String date;
}
