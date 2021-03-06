package com.tempus.gss.product.hol.api.entity.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.tempus.gss.vo.Agent;

/**
 * 城市列表搜索入参
 * Created by luofengjie on 2017/3/24.
 */
public class CityListSearchReq extends BaseRequest {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * 城市编号
     */
    @JSONField(name = "CityCode")
    private String cityCode;

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

}
