package com.wmeimob.fastboot.wm.model.wstore.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author LYQ
 * @Classname MemberDetailReq
 * @Description 用户详情接口响应数据
 * @Date 2020-09-25 11:09
 * @Version V1.0
 */
@Data
public class MemberDetailRep {

    /**
     * 手机号
     */
    private String phone;


    /**
     * 会员卡号
     */
    private String code;

    /**
     * 微盟用户wid，客户唯一标识（code，phone，wid不可同时不填）
     */
    private String wid;


    /**
     * "成为客户时间（毫秒级时间戳）"
     */
    @JsonFormat(locale="zh",timezone = "GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date gmtCreate;


    /**
     * 领卡时间（毫秒级时间戳）
     */
    private Date cardPublishTime;


    /**
     * 姓名（非微信昵称）
     */
    private String name;


    /**
     * 生日
     */
    private String birthday;

    /**
     * 身份证号
     */
    private String idCard;


    /**
     * 地址
     */
    private String address;


    /**
     * 邮箱
     */
    private String mail;


    /**
     * 性别（1：男； 2：女； 0：未知）
     */
    private String sex;


    /**
     * 教育背景
     */
    private String education;


    /**
     * 爱好
     */
    private String hobby;


    /**
     * 收入
     */
    private String income;


    /**
     * 行业
     */
    private String industry;


    /**
     * 会员头像地址
     */
    private String logo;


    /**
     * 微信会员卡状态
     */
    private Integer wechatStatus;
    /**
     * 微信会员卡code
     */
    private String wechatCode;


    /**
     * 累计积分
     */
    private Long totalPoint;


    /**
     * 当前积分（扣掉锁定中）
     */
    private Long currentPoint;


    /**
     * 当前余额（扣掉锁定中）（单位：分）
     */
    private Long currentAmount;


    /**
     * 当前成长值
     */
    private Long currentGrowth;


    /**
     * 累积交易金额（单位：元）
     */
    private BigDecimal orderConsumeAmount;

    /**
     * 交易次数
     */
    private Integer orderConsumeCount;

    /**
     * 客单价
     */
    private BigDecimal avgOrderConsumeAmount;
    /**
     * 上次交易时间（毫秒级时间戳）
     */
    private Date lastTradeTime;

    private  String rankName;
    /**
     * 会员等级Id
     */
    private  String rankId;

    /**
     * 会员等级Id
     */
    private  String status;
    /**
     *
     */
    private  String tagList;
    /**
     *
     */
    private  String extInfoList;


    /**
     * 领卡门店id
     */
    private  Long storeId;

    /**
     * 归属门店id
     */
    private  Long  homeStoreId;

    /**
     *  可用实充余额=C端充值+后台充值+接口充值（不包括下单未支付被冻结的部分）
     */
    private Long availableDepositAmount;

    /**
     * 可用赠送余额=接口增加的+营销活动赠送（不包括下单未支付被冻结的部分）
     */
    private  Long availableGiveAmount;


}
