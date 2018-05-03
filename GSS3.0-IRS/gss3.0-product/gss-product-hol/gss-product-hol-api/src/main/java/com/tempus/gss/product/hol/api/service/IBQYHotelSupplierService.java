package com.tempus.gss.product.hol.api.service;

import com.tempus.gss.product.hol.api.entity.request.HotelListSearchReq;
import com.tempus.gss.product.hol.api.entity.response.TCResponse;
import com.tempus.gss.product.hol.api.entity.vo.bqy.HotelInfo;

/**
 * BQY酒店查询接口
 */
public interface IBQYHotelSupplierService {
	
	/**
	 * 查询酒店列表接口
	 * @param hotelSearchReq
	 * @return
	 */
	TCResponse<HotelInfo> queryHotelListForBack(HotelListSearchReq hotelSearchReq);
}