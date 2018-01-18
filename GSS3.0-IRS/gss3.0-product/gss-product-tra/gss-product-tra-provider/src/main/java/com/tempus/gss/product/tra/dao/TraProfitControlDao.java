package com.tempus.gss.product.tra.dao;

import com.baomidou.mybatisplus.plugins.Page;
import com.tempus.gss.product.tra.api.entity.TraProfitControl;
import com.tempus.gss.product.tra.api.entity.TraProfitControlExample;
import com.tempus.gss.product.tra.api.entity.vo.TraProfitControlVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TraProfitControlDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRA_PROFIT_CONTROL
     *
     * @mbggenerated Fri Feb 24 15:34:26 CST 2017
     */
    int countByExample(TraProfitControlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRA_PROFIT_CONTROL
     *
     * @mbggenerated Fri Feb 24 15:34:26 CST 2017
     */
    int deleteByExample(TraProfitControlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRA_PROFIT_CONTROL
     *
     * @mbggenerated Fri Feb 24 15:34:26 CST 2017
     */
    int deleteByPrimaryKey(Long profitControlNo);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRA_PROFIT_CONTROL
     *
     * @mbggenerated Fri Feb 24 15:34:26 CST 2017
     */
    int insert(TraProfitControl record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRA_PROFIT_CONTROL
     *
     * @mbggenerated Fri Feb 24 15:34:26 CST 2017
     */
    int insertSelective(TraProfitControl record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRA_PROFIT_CONTROL
     *
     * @mbggenerated Fri Feb 24 15:34:26 CST 2017
     */
    List<TraProfitControl> selectByExample(TraProfitControlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRA_PROFIT_CONTROL
     *
     * @mbggenerated Fri Feb 24 15:34:26 CST 2017
     */
    TraProfitControl selectByPrimaryKey(Long profitControlNo);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRA_PROFIT_CONTROL
     *
     * @mbggenerated Fri Feb 24 15:34:26 CST 2017
     */
    int updateByExampleSelective(@Param("record") TraProfitControl record, @Param("example") TraProfitControlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRA_PROFIT_CONTROL
     *
     * @mbggenerated Fri Feb 24 15:34:26 CST 2017
     */
    int updateByExample(@Param("record") TraProfitControl record, @Param("example") TraProfitControlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRA_PROFIT_CONTROL
     *
     * @mbggenerated Fri Feb 24 15:34:26 CST 2017
     */
    int updateByPrimaryKeySelective(TraProfitControl record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRA_PROFIT_CONTROL
     *
     * @mbggenerated Fri Feb 24 15:34:26 CST 2017
     */
    int updateByPrimaryKey(TraProfitControl record);


    List<TraProfitControl>  selectByTrainName(String name);

	List<TraProfitControl> queryPageProfitControl(Page<TraProfitControl> page, TraProfitControlVo entity);
	
	List<TraProfitControl> queryProfitControlList();
}