package com.tempus.gss.product.ins.api.entity.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tempus.gss.order.entity.BuyOrder;
import com.tempus.gss.order.entity.SaleOrder;
import com.tempus.gss.product.ins.api.entity.Insurance;
import com.tempus.gss.product.ins.api.entity.SaleOrderDetail;
import com.tempus.gss.serializer.LongSerializer;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@JsonInclude(Include.NON_NULL)
public class InsApiProduct implements Serializable {
	/**
	 * 产品编号
	 */
	@JsonSerialize(using = LongSerializer.class)
	private Long insuranceNo;

	/**
	 * 编号
	 */
	private Long id;

	/**
	 * 数据归属单位
	 */
	private Integer owner;

	/**
	 * 产品code
	 */
	private String productKey;

	/**
	 * 保险产品名称
	 */
	private String name;

	/**
	 * 保险编码
	 */
	private String code;

	/**
	 * 结算方式
	 */
	private Integer payModel;

	/**
	 * 保险类型 1:航意险 2:航延险 3:航意/航延险
	 */
	private String insureType;

	/**
	 * 保险公司名称
	 */
	private String companyName;

	/**
	 * 是否限制人数
	 */
	private Integer isCheckNum;

	/**
	 * 是否限制年龄
	 */
	private Integer isCheckAge;

	/**
	 * 是否限制份数
	 */
	private Integer isCheckCount;

	/**
	 * 上限人数
	 */
	private Long topNum;

	/**
	 * 下限人数
	 */
	private Long bottomNum;

	/**
	 * 上限份数
	 */
	private Long topCount;

	/**
	 * 下限份数
	 */
	private Long bottomCount;

	/**
	 * 上限年龄
	 */
	private Integer topAge;

	/**
	 * 下限年龄
	 */
	private Integer bottomAge;

	/**
	 * 开始天数
	 */
	private Integer beginDays;

	/**
	 * 结束天数
	 */
	private Integer endDays;

	/**
	 * 采购价
	 */
	private BigDecimal buyPrice;

	/**
	 * 简介
	 */
	private String brief;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 修改时间
	 */
	private Date modifyTime;

	/**
	 * 创建者
	 */
	private String creator;

	/**
	 * 操作人 默认为：sys
	 */
	private String modifier;

	/**
	 * 删除标志 0 无效 已删除 1 有效
	 */
	private Boolean valid;
	/**
	 * 购买方式:1=线上  2=线下
	 */
	private Integer buyWay;

	
	/**
	 * 是否默认.0 否 1 是
	 */
	private Boolean isDefault;

	/**
	 * 供应商编号
	 */
	private Long supplierNo;
	
	/**
	 * 保险类别 1为国内 2为国际  3为国内国际
	 */
    private int internatOrcivil;
    /**
     * 面价
     * @return
     */
    private BigDecimal facePrice;
    
	public BigDecimal getFacePrice() {
		return facePrice;
	}

	public void setFacePrice(BigDecimal facePrice) {
		this.facePrice = facePrice;
	}

	public int getInternatOrcivil() {
		return internatOrcivil;
	}

	public void setInternatOrcivil(int internatOrcivil) {
		this.internatOrcivil = internatOrcivil;
	}


	public Long getInsuranceNo() {
		return insuranceNo;
	}

	public void setInsuranceNo(Long insuranceNo) {
		this.insuranceNo = insuranceNo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getOwner() {
		return owner;
	}

	public void setOwner(Integer owner) {
		this.owner = owner;
	}

	public String getProductKey() {
		return productKey;
	}

	public void setProductKey(String productKey) {
		this.productKey = productKey;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getPayModel() {
		return payModel;
	}

	public void setPayModel(Integer payModel) {
		this.payModel = payModel;
	}

	public String getInsureType() {
		return insureType;
	}

	public void setInsureType(String insureType) {
		this.insureType = insureType;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Integer getIsCheckNum() {
		return isCheckNum;
	}

	public void setIsCheckNum(Integer isCheckNum) {
		this.isCheckNum = isCheckNum;
	}

	public Integer getIsCheckAge() {
		return isCheckAge;
	}

	public void setIsCheckAge(Integer isCheckAge) {
		this.isCheckAge = isCheckAge;
	}

	public Integer getIsCheckCount() {
		return isCheckCount;
	}

	public void setIsCheckCount(Integer isCheckCount) {
		this.isCheckCount = isCheckCount;
	}

	public Long getTopNum() {
		return topNum;
	}

	public void setTopNum(Long topNum) {
		this.topNum = topNum;
	}

	public Long getBottomNum() {
		return bottomNum;
	}

	public void setBottomNum(Long bottomNum) {
		this.bottomNum = bottomNum;
	}

	public Long getTopCount() {
		return topCount;
	}

	public void setTopCount(Long topCount) {
		this.topCount = topCount;
	}

	public Long getBottomCount() {
		return bottomCount;
	}

	public void setBottomCount(Long bottomCount) {
		this.bottomCount = bottomCount;
	}

	public Integer getTopAge() {
		return topAge;
	}

	public void setTopAge(Integer topAge) {
		this.topAge = topAge;
	}

	public Integer getBottomAge() {
		return bottomAge;
	}

	public void setBottomAge(Integer bottomAge) {
		this.bottomAge = bottomAge;
	}

	public Integer getBeginDays() {
		return beginDays;
	}

	public void setBeginDays(Integer beginDays) {
		this.beginDays = beginDays;
	}

	public Integer getEndDays() {
		return endDays;
	}

	public void setEndDays(Integer endDays) {
		this.endDays = endDays;
	}

	public BigDecimal getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(BigDecimal buyPrice) {
		this.buyPrice = buyPrice;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public Boolean getValid() {
		return valid;
	}

	public void setValid(Boolean valid) {
		this.valid = valid;
	}

	public Integer getBuyWay() {
		return buyWay;
	}

	public void setBuyWay(Integer buyWay) {
		this.buyWay = buyWay;
	}

	public Boolean getIsDefault() {

		return isDefault;
	}

	public void setIsDefault(Boolean isDefault) {

		this.isDefault = isDefault;
	}

	public Long getSupplierNo() {
		return supplierNo;
	}

	public void setSupplierNo(Long supplierNo) {
		this.supplierNo = supplierNo;
	}
}