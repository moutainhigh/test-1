package com.tempus.gss.product.hol.api.entity.response.tc;

import java.io.Serializable;
import java.util.List;


public class ImgInfoSum implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	
	/**
	 * 酒店 Id
	 */
	private Long id;
	
	private List<ImgInfo> imgInfoList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ImgInfo> getImgInfoList() {
		return imgInfoList;
	}

	public void setImgInfoList(List<ImgInfo> imgInfoList) {
		this.imgInfoList = imgInfoList;
	}
	
	
	
	

}
