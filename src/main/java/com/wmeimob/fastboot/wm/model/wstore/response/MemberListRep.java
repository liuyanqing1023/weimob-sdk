package com.wmeimob.fastboot.wm.model.wstore.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author LYQ
 * @Classname MemberDetailReq
 * @Description 用户详情接口响应数据
 * @Date 2020-09-25 11:09
 * @Version V1.0
 */
@Data
public class MemberListRep {

   private Long cursor;
   private ArrayList<MemberItem>  items;
}
