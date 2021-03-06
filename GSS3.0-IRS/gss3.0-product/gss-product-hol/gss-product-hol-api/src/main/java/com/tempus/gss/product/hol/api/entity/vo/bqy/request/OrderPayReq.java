package com.tempus.gss.product.hol.api.entity.vo.bqy.request;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * bqy酒店订单支付
 */
public class OrderPayReq extends BaseQueryParam implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@JSONField(name="OrderNumber")
	private Long orderNumber;		//总订单号
	
	public OrderPayReq (){}
	
	public OrderPayReq(Long orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Long getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Long orderNumber) {
		this.orderNumber = orderNumber;
	}
	
}
