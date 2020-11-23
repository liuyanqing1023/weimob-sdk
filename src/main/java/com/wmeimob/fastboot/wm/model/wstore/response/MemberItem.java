package com.wmeimob.fastboot.wm.model.wstore.response;

import lombok.Data;

import java.util.Date;

/**
 * @author LYQ
 * @Classname MemberDetailReq
 * @Description 用户详情接口响应数据
 * @Date 2020-09-25 11:09
 * @Version V1.0
 */
@Data
public class MemberItem {

    /**
     * 建议外部不要再使用该id，需要唯一标识一个客户，请使用微盟用户wid
     */
    private Long mid;

    /**
     * 微盟用户wid，客户唯一标识
     */
    private Long wid;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 会员卡号
     */
    private String code;

    /**
     * 成为客户时间（毫秒级时间戳）
     */
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
    private Date birthday;

    /**
     * 身份证
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
    private Integer sex;

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
     * 会员等级名称
     */
    private String rankName;

    /**
     * 会员等级Id
     */
    private Long rankId;

    /**
     * 当前积分
     */
    private Integer currentPoint;

    /**
     * 当前余额（单位：分）
     */
    private Long currentAmount;

    /**
     * 当前成长值
     */
    private Long currentGrowth;

    /**
     * 可用实充余额=C端充值+后台充值+接口充值（不包括下单未支付被冻结的部分）（单位：分）
     */
    private Long availableDepositAmount;

    /**
     * 可用赠送余额=接口增加的+营销活动赠送（不包括下单未支付被冻结的部分）（单位：分）
     */
    private Long availableGiveAmount;

    /**
     * 归属门店id
     */
    private Long homeStoreId;

    /**
     * 会员状态：1-正常；2-冻结；3-未领取；5-过期
     */
    private Integer status;

}
