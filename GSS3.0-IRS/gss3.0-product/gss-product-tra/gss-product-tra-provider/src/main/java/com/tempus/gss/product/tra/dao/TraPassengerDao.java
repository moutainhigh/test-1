package com.tempus.gss.product.tra.dao;

import com.tempus.gss.product.tra.api.entity.TraPassenger;
import com.tempus.gss.product.tra.api.entity.TraPassengerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TraPassengerDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRA_PASSENGER
     *
     * @mbggenerated Fri Feb 24 15:34:26 CST 2017
     */
    int countByExample(TraPassengerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRA_PASSENGER
     *
     * @mbggenerated Fri Feb 24 15:34:26 CST 2017
     */
    int deleteByExample(TraPassengerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRA_PASSENGER
     *
     * @mbggenerated Fri Feb 24 15:34:26 CST 2017
     */
    int deleteByPrimaryKey(Long passengerNo);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRA_PASSENGER
     *
     * @mbggenerated Fri Feb 24 15:34:26 CST 2017
     */
    int insert(TraPassenger record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRA_PASSENGER
     *
     * @mbggenerated Fri Feb 24 15:34:26 CST 2017
     */
    int insertSelective(TraPassenger record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRA_PASSENGER
     *
     * @mbggenerated Fri Feb 24 15:34:26 CST 2017
     */
    List<TraPassenger> selectByExample(TraPassengerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRA_PASSENGER
     *
     * @mbggenerated Fri Feb 24 15:34:26 CST 2017
     */
    TraPassenger selectByPrimaryKey(Long passengerNo);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRA_PASSENGER
     *
     * @mbggenerated Fri Feb 24 15:34:26 CST 2017
     */
    int updateByExampleSelective(@Param("record") TraPassenger record, @Param("example") TraPassengerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRA_PASSENGER
     *
     * @mbggenerated Fri Feb 24 15:34:26 CST 2017
     */
    int updateByExample(@Param("record") TraPassenger record, @Param("example") TraPassengerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRA_PASSENGER
     *
     * @mbggenerated Fri Feb 24 15:34:26 CST 2017
     */
    int updateByPrimaryKeySelective(TraPassenger record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TRA_PASSENGER
     *
     * @mbggenerated Fri Feb 24 15:34:26 CST 2017
     */
    int updateByPrimaryKey(TraPassenger record);
}