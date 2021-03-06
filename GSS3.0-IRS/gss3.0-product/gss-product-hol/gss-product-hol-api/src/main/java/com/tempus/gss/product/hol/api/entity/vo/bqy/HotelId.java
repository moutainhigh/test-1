package com.tempus.gss.product.hol.api.entity.vo.bqy;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 酒店ID
 */
public class HotelId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JSONField(name="HotelId")
	private Long hotelId; 			//酒店Id
	
	@JSONField(name="HotelName")
	private String hotelName; 	//酒店名称

	private String lastUpdateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

	public HotelId(){}
	public HotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(String lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
}
