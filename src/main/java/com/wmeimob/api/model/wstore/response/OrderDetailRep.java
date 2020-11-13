package com.wmeimob.api.model.wstore.response;

import com.alibaba.fastjson.JSONObject;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author LYQ
 * @Classname MemberDetailReq
 * @Description 用户详情接口响应数据
 * @Date 2020-09-25 11:09
 * @Version V1.0
 */
@Data
@Builder
public class OrderDetailRep {

    /**
     * 订单号
     */
    private Long orderNo;

    /**
     * 是否可发货（0-不可发货，1-可发货）*周期购/预售/拼团订单需留意
     */
    private Integer enableDelivery;

    /**
     * 订单状态 (0-待支付,1-待发货,2-已发货,3-已完成,4-已取消，5-已评论)
     */
    private Integer orderStatus;

    /**
     * 订单状态名称【0-等待买家付款, 0-等待买家付定金,0-等待买家付尾款】【1-已付款，待成团(普通团,抽奖团团内抽,抽奖团活动结束抽未成团),1-已成团，待抽奖(抽奖团活动结束抽成团), 1-未付款，待发货(线下支付), 1-已付款，待发货(线上支付)】【2-已发货，待收货, 3-已完成, 4-已取消)】
     */
    private String orderStatusName;

    /**
     * （微商城无需判断）转单类型：0,不允许转单,1,手动转单,2,按库存自动转单,3,按距离自动转单
     */
    private Integer transferType;

    /**
     * （微商城无需判断）转单状态：0,未转单,1,已转单,2,转单失败,3,不允许转单
     */
    private Integer transferStatus;

    /**
     * （微商城无需判断）真实的转单类型：：0,不允许转单,1,手动转单,2,按库存自动转单,3,按距离自动转单
     */
    private Integer transferTypeReality;

    /**
     * 订单创建时间
     */
    private Date createTime;

    /**
     * 用户确认收货时间
     */
    private Date confirmReceivedTime;

    /**
     * 自动取消时间
     */
    private Date autoCancelTime;

    /**
     * 自动确认收货时间
     */
    private Date autoConfirmReceivedTime;

    /**
     * 商品总金额
     */
    private String goodsAmount;

    /**
     * 订单总金额 (商品总金额+运费)
     */
    private String totalAmount;

    /**
     * 运费小计
     */
    private String deliveryAmount;

    /**
     * 运费实付金额
     */
    private String deliveryPaymentAmount;

    /**
     * 运费减免金额
     */
    private String deliveryDiscountAmount;

    /**
     * 订单应付金额
     */
    private String shouldPaymentAmount;

    /**
     * 订单实付金额
     */
    private String paymentAmount;

    /**
     * 订单渠道类型名称
     */
    private String channelTypeName;

    /**
     * 买家备注
     */
    private String buyerRemark;

    /**
     * 买家信息
     */
    private JSONObject buyerInfo;

    /**
     * 发票信息
     */
    private String invoiceInfo;

    /**
     * 发票税费
     */
    private String invoiceTexAmount;

    /**
     * 发票税费实付金额
     */
    private String invoiceTexPaymentAmount;

    /**
     * 发票税费减免金额
     */
    private String invoiceTexDiscountAmount;

    /**
     * 导购信息（微商城无需处理）
     */
    private String guideInfo;

    /**
     * 商家信息
     */
    private String merchantInfo;

    /**
     * 支付信息
     */
    private String paymentInfo;

    /**
     * 商品列表
     */
    private List<OrderItem> itemList;

    /**
     * 折扣信息
     */
    private String discountInfo;

    /**
     * 业务信息
     */
    private String bizInfo;

    /**
     * 配送详情
     */
    private String deliveryDetail;

    /**
     * 标记等级（红色1，黄色2，绿色3，浅蓝4，深蓝5。传空进来会清除原有备注内容）
     */
    private Integer flagRank;

    /**
     * 标记内容
     */
    private String flagContent;

    /**
     * 发货时间
     */
    private Date deliveryTime;

    /**
     * 取消时间
     */
    private Date cancelTime;

    /**
     * 取消类型 (1-买家取消,2-商家取消,3-系统自动取消,4-业务取消,5-维权取消)
     */
    private Integer cancelType;

    /**
     * 自定义字段
     */
    private String customFieldList;

    /**
     * 退款信息
     */
    private String refundInfo;

    /**
     * 会员详细信息
     */
    private String memberDetailInfo;

    /**
     * 返回错误码,0表示success
     */
    private String errcode;

    /**
     * 返回提示信息
     */
    private String errmsg;

    /**
     * 商品营销信息
     */
    private String goodsPromotionInfo;

    /**
     * 商品销售模式：1，普通模式，2，预售模式
     */
    private Integer goodsSellMode;

    /**
     * 最后更新时间
     */
    private Date updateTime;

    /**
     * 订单已完成时间
     */
    private Date finishTime;

    /**
     * 1、普通订单，2、app开单，3、收银台开单
     */
    private Integer bizSourceType;

    /**
     * 海外信息
     */
    private String overseaInfo;

    /**
     * 预售详细信息
     */
    private String preSellDetail;

    /**
     * 渠道类型（ 0-公众号；1-小程序；2-H5；3-QQ；4-微博；5-字节跳动小程序；6-支付宝小程序；7-PC后台；8-安卓app；9-苹果app；10-百度智能小程序；11-PAD；12-自有APP；13-微信小程序webview；14-微信小程序webview-直播；15-大屏扫码；16-企业微信；101-分销供货商订单）
     */
    private Integer channelType;

    /**
     * 可发货时间
     */
    private Date enableDeliveryTime;
    /**
     * 1、普通订单，2、app开单，3、收银台开单
     */
    private Integer bizSouceType;

}
