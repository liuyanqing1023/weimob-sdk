package com.wmeimob.fastboot.wm.model.wstore.request;

import lombok.Builder;
import lombok.Data;

/**
 * 增加积分/余额. 减少积分
 * 1.接口适用于各种营销活动赠送积分余额场景 ；2.该接口不可用来充值，充值见充值接口；3、给会员增加积分和余额；4、该接口不可用于扣减；5、智慧旅游业务无余额
 * @author LYQ
 * @Classname MemberDetailReq
 * @Description TODO
 * @Date 2020-09-25 11:09
 * @Version V1.0
 */
@Data
@Builder
public class MemberPointAmountReq {
    /**
     * 建议外部不要再使用该id，需要唯一标识一个客户，请使用微盟用户wid
     */
    private Long mid;

    /**
     * 增加余额（单位：元），积分余额不可同时为空，单位为元
     */
    private String amount;

    /**
     * 增加余额原因，若amount&gt;0,必填
     */
    private String addAmountReason;

    /**
     * 增加积分，积分余额不可同时为空
     */
    private Integer point;

    /**
     * 增加积分原因，若point>0,必填
     */
    private String addPointReason;

    /**
     * 参见字典说明
     */
    private Integer channelType;

    /**
     * 权益获取门店id
     */
    private Long storeId;

    /**
     * 业务附属对象id,比如订单号
     */
    private String attachId;

    /**
     * 作为幂等请求唯一id （每次请求值不能相同，位数上限100）
     */
    private String requestId;

    /**
     * 微盟用户wid，客户唯一标识
     */
    private Long wid;

}
