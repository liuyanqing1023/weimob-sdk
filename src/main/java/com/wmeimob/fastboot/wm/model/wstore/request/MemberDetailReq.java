package com.wmeimob.fastboot.wm.model.wstore.request;

import lombok.Builder;
import lombok.Data;

/**
 * @author LYQ
 * @Classname MemberDetailReq
 * @Description TODO
 * @Date 2020-09-25 11:09
 * @Version V1.0
 */
@Data
@Builder
public class MemberDetailReq {
    /**
     * 会员卡类型，多张会员卡时填入s
     */
    private String type;

    /**
     * 会员卡code
     */
    private String code;

    /**
     * 手机号
     */
    private String phone;

    /**
     * wid（code，phone，wid三选一必填）微盟用户wid，客户唯一标识
     */
    private String wid;


    /**
     * 是否需要查询包括标签信息 默认false
     */
    private String isNeedTagsInfo;

    /**
     * 是否需要查询会员的扩展信息 默认false
     */
    private String isNeedExtInfo;

}
