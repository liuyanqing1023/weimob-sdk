package com.wmeimob.fastboot.wm.model.wstore.response;

import lombok.Builder;
import lombok.Data;

/**
 * @author LYQ
 * @Classname OrderItem
 * @Description 订单项
 * @Date 2020-11-04 15:21
 * @Version V1.0
 */
@Data
@Builder
public class OrderItem {
    /**
     * 维权状态名称
     */
    private String rightsStatusName;

    /**
     * 维权状态 (1-维权中,2-已退款)
     */
    private String rightsStatus;

    /**
     * 维权单id
     */
    private String rightsOrderId;

    /**
     * 评论状态
     */
    private String commentStatus;

    /**
     * 订单项应付金额
     */
    private String shouldPaymentAmount;

    /**
     * 订单项id
     */
    private String id;

    /**
     * sku金额（skuAmount=price*skuNum）
     */
    private String skuAmount;

    /**
     * sku总金额（totalAmount=skuAmount+其他费用）
     */
    private String totalAmount;

    /**
     * 实付金额
     */
    private String paymentAmount;

    /**
     * 商品id
     */
    private String goodsId;

    /**
     * 规格id
     */
    private String skuId;

    /**
     * 规格图片
     */
    private String imageUrl;

    /**
     * 规格名称
     */
    private String skuName;

    /**
     * 购买数量
     */
    private String skuNum;

    /**
     * 商品售价
     */
    private String price;

    /**
     * 商品编码
     */
    private String goodsCode;

    /**
     * 规格编码
     */
    private String skuCode;

    /**
     * 已经发货的数量
     */
    private String hadDeliveryItemNum;

    /**
     * 原始价
     */
    private String originalPrice;

    /**
     * 商品总积分（point*skuNum)积分订单用）
     */
    private String totalPoint;

    /**
     * 商品积分（积分订单用）
     */
    private String point;

    /**
     * 标签列表
     */
    private String tagInfo;

    /**
     * 商品类型(0-普通商品,1-海淘商品)
     */
    private Integer goodsType;

}
