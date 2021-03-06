package com.tempus.gss.product.ift.api.entity.search;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * <pre>
 * <b>国际航班查询参数实体类.</b>
 * <b>Description:</b> 
 *    
 * <b>Author:</b> cz
 * <b>Date:</b> 2018年9月3日 上午9:08:03
 * <b>Copyright:</b> Copyright ©2018 tempus.cn. All rights reserved.
 * <b>Changelog:</b>
 *   Ver   Date                    Author                Detail
 *   ----------------------------------------------------------------------
 *   0.1   2018年9月3日 上午9:08:03    cz
 *         new file.
 * </pre>
 */
public class FlightQuery implements Serializable {

	/** SVUID */
	private static final long serialVersionUID = 1L;

	/** 归集单位 */
	private int owner;
	/** 实际出票航空公司 */
	private String airline;
	/** 航程类型, 1:单程(默认); 2:往返; */
	private Integer voyageType;
	/** 去程航班起飞时间 2018-09-03 */
	private Date flyDate;
	/** 回程起飞时间 2018-09-09 */
	private Date rtnFlyDate;
	/** 当前星期几 1，2，3，4，5，6，7 */
	private int saleWeek;
	/** 出发所属洲 */
	private String departContinent;
	/** 出发城市国际I，还是国内D */
	private String departSign;
	/** 出发国家 */
	private String departCountry;
	/** 出发机场，多个以"/"分割 */
	private String departAirport;
	/** 出发舱位 */
	private String[] departCabin;
	/** 中转机场，多个以"/"分割 */
	//private String[] transitAirport;
	/** 中转机场国际I，还是国内D */
	//private String transitSign;
	/** 中转舱位 */
//	private String[] transitCabin;
	/** 到达所属洲 */
	private String arriveContinent;
	/** 到达国家，A00代表全球，CN0代表境内，CN1代表境外，国家多个以"/"分割 */
	private String arriveCountry;
	/** 到达机场，多个以"/"分割 */
	private String arriveAirport;
	/** 到达机场国际I，还是国内D */
	private String arriveSign;
	/** 乘客人数 */
	private int psgerNum;
	/** 乘机双数true;单数false */
	private Boolean psgerEven;
	/** 乘客类型 1：成人；2:儿童;3:婴儿；4：成人+儿童；5成人+婴儿； */
	private int psgerType;
	/** 去程星期 1，2，3，4，5，6，7 */
	private int departWeek;
	/** 回程星期 */
	private int rtnDepartWeek;
	
	/** 新增往返回程所属国家信息 */
	/** 回程所属洲 */
	private String rtnContinent;
	/** 回程国家，A00代表全球，CN0代表境内，CN1代表境外，国家多个以"/"分割 */
	private String rtnCountry;
	/** 回程机场，多个以"/"分割 */
	private String rtnAirport;
	/** 回程机场国际I，还是国内D */
	private String rtnSign;

	/** 成人数量 */
	private int adtNum;
	/** 儿童数量 */
	private int chdNum;
	/** 婴儿数量 */
	private int infNum;
	
	public String getDepartSign() {
		return departSign;
	}

	public void setDepartSign(String departSign) {
		this.departSign = departSign;
	}
	public String getArriveSign() {
		return arriveSign;
	}

	public void setArriveSign(String arriveSign) {
		this.arriveSign = arriveSign;
	}

	public Boolean getPsgerEven() {
		return psgerEven;
	}

	public void setPsgerEven(Boolean psgerEven) {
		this.psgerEven = psgerEven;
	}

	public int getDepartWeek() {
		return departWeek;
	}

	public void setDepartWeek(int departWeek) {
		this.departWeek = departWeek;
	}

	public int getRtnDepartWeek() {
		return rtnDepartWeek;
	}

	public void setRtnDepartWeek(int rtnDepartWeek) {
		this.rtnDepartWeek = rtnDepartWeek;
	}

	public int getOwner() {
		return owner;
	}

	public void setOwner(int owner) {
		this.owner = owner;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public Integer getVoyageType() {
		return voyageType;
	}

	public void setVoyageType(Integer voyageType) {
		this.voyageType = voyageType;
	}

	public Date getFlyDate() {
		return flyDate;
	}

	public void setFlyDate(Date flyDate) {
		this.flyDate = flyDate;
	}

	public Date getRtnFlyDate() {
		return rtnFlyDate;
	}

	public void setRtnFlyDate(Date rtnFlyDate) {
		this.rtnFlyDate = rtnFlyDate;
	}

	public int getSaleWeek() {
		return saleWeek;
	}

	public void setSaleWeek(int saleWeek) {
		this.saleWeek = saleWeek;
	}

	public String getDepartContinent() {
		return departContinent;
	}

	public void setDepartContinent(String departContinent) {
		this.departContinent = departContinent;
	}

	public String getDepartCountry() {
		return departCountry;
	}

	public void setDepartCountry(String departCountry) {
		this.departCountry = departCountry;
	}

	public String getDepartAirport() {
		return departAirport;
	}

	public void setDepartAirport(String departAirport) {
		this.departAirport = departAirport;
	}

	public String[] getDepartCabin() {
		return departCabin;
	}

	public void setDepartCabin(String[] departCabin) {
		this.departCabin = departCabin;
	}

	public String getArriveContinent() {
		return arriveContinent;
	}

	public void setArriveContinent(String arriveContinent) {
		this.arriveContinent = arriveContinent;
	}

	public String getArriveCountry() {
		return arriveCountry;
	}

	public void setArriveCountry(String arriveCountry) {
		this.arriveCountry = arriveCountry;
	}

	public String getArriveAirport() {
		return arriveAirport;
	}

	public void setArriveAirport(String arriveAirport) {
		this.arriveAirport = arriveAirport;
	}

	public int getPsgerNum() {
		return psgerNum;
	}

	public void setPsgerNum(int psgerNum) {
		this.psgerNum = psgerNum;
	}

	public int getPsgerType() {
		return psgerType;
	}

	public void setPsgerType(int psgerType) {
		this.psgerType = psgerType;
	}

	public String getRtnContinent() {
		return rtnContinent;
	}

	public void setRtnContinent(String rtnContinent) {
		this.rtnContinent = rtnContinent;
	}

	public String getRtnCountry() {
		return rtnCountry;
	}

	public void setRtnCountry(String rtnCountry) {
		this.rtnCountry = rtnCountry;
	}

	public String getRtnAirport() {
		return rtnAirport;
	}

	public void setRtnAirport(String rtnAirport) {
		this.rtnAirport = rtnAirport;
	}

	public String getRtnSign() {
		return rtnSign;
	}

	public void setRtnSign(String rtnSign) {
		this.rtnSign = rtnSign;
	}

	public int getAdtNum() {
		return adtNum;
	}

	public void setAdtNum(int adtNum) {
		this.adtNum = adtNum;
	}

	public int getChdNum() {
		return chdNum;
	}

	public void setChdNum(int chdNum) {
		this.chdNum = chdNum;
	}

	public int getInfNum() {
		return infNum;
	}

	public void setInfNum(int infNum) {
		this.infNum = infNum;
	}
	
}
