package com.tempus.gss.product.hol.api.entity.vo.bqy;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

public class HotelEntity extends BaseHoelInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String BulitTime; //建造时间
	
	private double CtripUserRate;	//用户评分等级
	
	private List<CityImportantMessage> cityImportantMessage; //城市重要信息
	
	private List<Policy> policy;	//酒店政策
	
	private List<HotelStar> hotelStar; //酒店星级
	
	private List<RoomType> roomType;	//酒店房型
	
	private String HotelCityName;		//城市名称

	public String getBulitTime() {
		return BulitTime;
	}

	public void setBulitTime(String bulitTime) {
		BulitTime = bulitTime;
	}

	public double getCtripUserRate() {
		return CtripUserRate;
	}

	public void setCtripUserRate(double ctripUserRate) {
		CtripUserRate = ctripUserRate;
	}

	public List<CityImportantMessage> getCityImportantMessage() {
		return cityImportantMessage;
	}

	public void setCityImportantMessage(List<CityImportantMessage> cityImportantMessage) {
		this.cityImportantMessage = cityImportantMessage;
	}

	public List<Policy> getPolicy() {
		return policy;
	}

	public void setPolicy(List<Policy> policy) {
		this.policy = policy;
	}

	public List<HotelStar> getHotelStar() {
		return hotelStar;
	}

	public void setHotelStar(List<HotelStar> hotelStar) {
		this.hotelStar = hotelStar;
	}

	public List<RoomType> getRoomType() {
		return roomType;
	}

	public void setRoomType(List<RoomType> roomType) {
		this.roomType = roomType;
	}

	public String getHotelCityName() {
		return HotelCityName;
	}

	public void setHotelCityName(String hotelCityName) {
		HotelCityName = hotelCityName;
	}
	
	

}