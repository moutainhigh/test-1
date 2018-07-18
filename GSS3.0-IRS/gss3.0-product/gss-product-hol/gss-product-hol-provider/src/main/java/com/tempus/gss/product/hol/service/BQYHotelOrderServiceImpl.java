package com.tempus.gss.product.hol.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.toolkit.IdWorker;
import com.tempus.gss.bbp.util.DateUtil;
import com.tempus.gss.bbp.util.StringUtil;
import com.tempus.gss.cps.entity.Supplier;
import com.tempus.gss.cps.service.ISupplierService;
import com.tempus.gss.dps.order.service.SaleService;
import com.tempus.gss.exception.GSSException;
import com.tempus.gss.log.entity.LogRecord;
import com.tempus.gss.log.service.ILogService;
import com.tempus.gss.order.entity.ActualInfoSearchVO;
import com.tempus.gss.order.entity.BusinessOrderInfo;
import com.tempus.gss.order.entity.BuyOrder;
import com.tempus.gss.order.entity.CertificateCreateVO;
import com.tempus.gss.order.entity.CreatePlanAmountVO;
import com.tempus.gss.order.entity.GoodsBigType;
import com.tempus.gss.order.entity.SaleOrder;
import com.tempus.gss.order.entity.TransationOrder;
import com.tempus.gss.order.service.IActualAmountRecorService;
import com.tempus.gss.order.service.IBuyOrderService;
import com.tempus.gss.order.service.ICertificateService;
import com.tempus.gss.order.service.IPlanAmountRecordService;
import com.tempus.gss.order.service.ISaleOrderService;
import com.tempus.gss.order.service.ITransationOrderService;
import com.tempus.gss.product.hol.api.entity.request.tc.CancelOrderBeforePayReq;
import com.tempus.gss.product.hol.api.entity.request.tc.OrderCreateReq;
import com.tempus.gss.product.hol.api.entity.request.tc.OrderDetailInfoReq;
import com.tempus.gss.product.hol.api.entity.response.HolErrorOrder;
import com.tempus.gss.product.hol.api.entity.response.HotelOrder;
import com.tempus.gss.product.hol.api.entity.response.tc.CancelOrderRes;
import com.tempus.gss.product.hol.api.entity.response.tc.OwnerOrderStatus;
import com.tempus.gss.product.hol.api.entity.response.tc.TcOrderStatus;
import com.tempus.gss.product.hol.api.entity.vo.bqy.request.BQYPushOrderInfo;
import com.tempus.gss.product.hol.api.entity.vo.bqy.request.BookOrderParam;
import com.tempus.gss.product.hol.api.entity.vo.bqy.request.CreateOrderReq;
import com.tempus.gss.product.hol.api.entity.vo.bqy.request.OrderCancelParam;
import com.tempus.gss.product.hol.api.entity.vo.bqy.request.QueryHotelParam;
import com.tempus.gss.product.hol.api.entity.vo.bqy.response.BookOrderResponse;
import com.tempus.gss.product.hol.api.entity.vo.bqy.response.CreateOrderRespone;
import com.tempus.gss.product.hol.api.entity.vo.bqy.response.OrderCancelResult;
import com.tempus.gss.product.hol.api.entity.vo.bqy.room.BaseRoomInfo;
import com.tempus.gss.product.hol.api.entity.vo.bqy.room.RoomBedTypeInfo;
import com.tempus.gss.product.hol.api.entity.vo.bqy.room.RoomInfoItem;
import com.tempus.gss.product.hol.api.entity.vo.bqy.room.RoomPriceDetail;
import com.tempus.gss.product.hol.api.entity.vo.bqy.room.RoomPriceInfo;
import com.tempus.gss.product.hol.api.entity.vo.bqy.room.RoomPriceItem;
import com.tempus.gss.product.hol.api.service.IBQYHotelInterService;
import com.tempus.gss.product.hol.api.service.IBQYHotelOrderService;
import com.tempus.gss.product.hol.api.syn.ITCHotelOrderService;
import com.tempus.gss.product.hol.api.util.OrderStatusUtils;
import com.tempus.gss.product.hol.dao.HotelOrderMapper;
import com.tempus.gss.security.AgentUtil;
import com.tempus.gss.system.entity.SmsTemplateDetail;
import com.tempus.gss.system.service.IMaxNoService;
import com.tempus.gss.system.service.ISmsTemplateDetailService;
import com.tempus.gss.util.JsonUtil;
import com.tempus.gss.vo.Agent;

@Service
class BQYHotelOrderServiceImpl implements IBQYHotelOrderService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IBQYHotelInterService bqyHotelInterService;

	@Reference
	private ISupplierService supplierService;

	@Reference
	private IMaxNoService maxNoService;

	@Reference
	private ISaleOrderService saleOrderService;

	@Reference
	private IBuyOrderService buyOrderService;

	@Autowired
	private HotelOrderMapper hotelOrderMapper;
	
	@Reference
	private SaleService saleService;
	
	@Reference
	private ILogService logService;
	
	@Reference
	private ITransationOrderService transationOrderService;
	
	@Reference
	private IPlanAmountRecordService planAmountRecordService;
	
	@Reference
	private ITCHotelOrderService tCHotelOrderService;
	
	@Reference
	private ICertificateService certificateService;
	
	@Reference
	private IActualAmountRecorService actualAmountRecorService;
	
	@Reference
	private ISmsTemplateDetailService smsTemplateDetailService;

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	@Value("${tc.contactNo}")
	private String tempusMobile;

	@Override
	public CancelOrderRes cancelOrder(Agent agent, CancelOrderBeforePayReq orderCancelBeforePayReq) {
		logger.info("取消酒店订单开始,入参:" + JSONObject.toJSONString(orderCancelBeforePayReq) + ";remark=" + orderCancelBeforePayReq.getOtherReason());
		if (StringUtil.isNullOrEmpty(orderCancelBeforePayReq)) {
            logger.error("取消订单入参为空");
            throw new GSSException("取消酒店订单", "0101", "取消订单入参为空");
        }
        if (StringUtil.isNullOrEmpty(agent)) {
            logger.error("agent对象为空");
            throw new GSSException("取消酒店订单", "0102", "agent对象为空");
        }
        CancelOrderRes cancelOrderRes = new CancelOrderRes();
        OrderCancelParam cancelParam = new OrderCancelParam();
        HotelOrder hotelOrder = new HotelOrder();
        hotelOrder.setHotelOrderNo(orderCancelBeforePayReq.getOrderId());
        hotelOrder = hotelOrderMapper.selectOne(hotelOrder);
        if (StringUtil.isNullOrEmpty(hotelOrder)) {
            logger.error("订单信息不存在");
            throw new GSSException("取消酒店订单", "0103", "订单信息不存在");
        } else {
        	LogRecord logRecord=new LogRecord();
        	String des = "";
        	try {
        		String orderStatus = hotelOrder.getTcOrderStatus();
            	if (TcOrderStatus.WAIT_PAY.getKey().equals(orderStatus)) {	//待支付
            		cancelParam.setOrderNumber(Long.valueOf(orderCancelBeforePayReq.getOrderId()));
            		OrderCancelResult orderCancelResult = bqyHotelInterService.cancelOrder(cancelParam);
            		if (orderCancelResult.getResult()) {
            			des = "订单号"+hotelOrder.getHotelOrderNo() +",订单状态由"+ OwnerOrderStatus.keyOf(hotelOrder.getOrderStatus()).getValue()+"变成:"+ OwnerOrderStatus.CANCEL_OK.getValue();
            			//更新销售单和采购单状态
            		    updateSaleAndBuyOrderStatus(agent, hotelOrder.getSaleOrderNo(), hotelOrder.getBuyOrderNo(), OrderStatusUtils.getStatus(OwnerOrderStatus.CANCEL_OK));
            		   //更新酒店订单状态
            		    hotelOrder.setOrderStatus(OwnerOrderStatus.CANCEL_OK.getKey());
            		    hotelOrder.setTcOrderStatus(TcOrderStatus.ALREADY_CANCEL.getKey());
            		    hotelOrder.setCancelTime(new Date());
            		    hotelOrderMapper.updateById(hotelOrder); 
            		    cancelOrderRes.setResult(true);
            		    cancelOrderRes.setMsg(orderCancelResult.getMessage());
            		    cancelOrderRes.setLasestCancelTime(hotelOrder.getLatestArriveTime());
            		}else {
            			cancelOrderRes.setResult(false);
            		    cancelOrderRes.setMsg(orderCancelResult.getMessage());
            		    cancelOrderRes.setLasestCancelTime(hotelOrder.getLatestArriveTime());
            		}
            		
            	}else if (TcOrderStatus.WAIT_TC_CONFIRM.getKey().equals(orderStatus) || TcOrderStatus.ALREADY_TC_CONFIRM.getKey().equals(orderStatus)) {//待BQY确认 || BQY已确认
            		String policyType = hotelOrder.getDbOrderType();	//政策类型 cancelOrderRes
            		if("0".equals(policyType) || "8".equals(policyType)) {
            			cancelOrderRes.setResult(false);
                        cancelOrderRes.setMsg("该订单不可取消!");
                        
            		}else if ("1".equals(policyType)) {	//免费取消, 任意退
            			des = cancelOrder(agent, orderCancelBeforePayReq, cancelOrderRes, cancelParam, hotelOrder, des);
                		
            		}else if ("2".equals(policyType)) {	//限时取消
            			String latestArriveTime = hotelOrder.getLatestArriveTime();
            			String currentTime = sdf.format(new Date());
            			long compareDate = DateUtil.compareDateStr(latestArriveTime, currentTime);
            			if (compareDate > 0) {
            				cancelOrderRes.setResult(false);
                            cancelOrderRes.setMsg("已超过订单取消时间,该订单不可取消!");
                            cancelOrderRes.setLasestCancelTime(hotelOrder.getLatestArriveTime());
            			}else {
            				des = cancelOrder(agent, orderCancelBeforePayReq, cancelOrderRes, cancelParam, hotelOrder, des);
            			}
            			
            		}else if ("4".equals(policyType)) {	//超时担保限时取消
            			//TODO 取消酒店订单,超时担保限时取消
            		}
            		
            	}
			} catch (Exception e) {
				logger.error("取消酒店订单请求出错"+e);
                throw new GSSException("取消酒店订单出错", "0106", "取消酒店订单出错!");
			}
        	logRecord.setBizCode("HOL-Order");
    		logRecord.setTitle("申请取消订单");
    		logRecord.setBizNo(hotelOrder.getHotelOrderNo());
    		logRecord.setCreateTime(new Date());
    		logRecord.setDesc(des);
    		if(StringUtils.isNotEmpty(agent.getAccount())){
    			logRecord.setOptName(agent.getAccount());
    		}
    		logService.insert(logRecord);
        }
        return cancelOrderRes;
	}

	private String cancelOrder(Agent agent, CancelOrderBeforePayReq orderCancelBeforePayReq,
			CancelOrderRes cancelOrderRes, OrderCancelParam cancelParam, HotelOrder hotelOrder, String des) {
		cancelParam.setOrderNumber(Long.valueOf(orderCancelBeforePayReq.getOrderId()));
		OrderCancelResult orderCancelResult = bqyHotelInterService.cancelOrder(cancelParam);
		if (orderCancelResult.getResult()) {
			BigDecimal saleRefundCert = saleRefund(agent, hotelOrder);
			if (null != saleRefundCert && saleRefundCert.compareTo(BigDecimal.ZERO) == 1) {	//退款成功
				des = "订单号"+hotelOrder.getHotelOrderNo() +",订单状态由"+ OwnerOrderStatus.keyOf(hotelOrder.getOrderStatus()).getValue()+"变成:"+ OwnerOrderStatus.CANCEL_OK.getValue();
				//更新销售单和采购单状态
			    updateSaleAndBuyOrderStatus(agent, hotelOrder.getSaleOrderNo(), hotelOrder.getBuyOrderNo(), OrderStatusUtils.getStatus(OwnerOrderStatus.CANCEL_OK));
			   //更新酒店订单状态
			    hotelOrder.setOrderStatus(OwnerOrderStatus.CANCEL_OK.getKey());
			    hotelOrder.setTcOrderStatus(TcOrderStatus.ALREADY_CANCEL.getKey());
			    hotelOrder.setCancelTime(new Date());
			    hotelOrder.setFactTotalPrice(hotelOrder.getFactTotalPrice().subtract(saleRefundCert));
			    hotelOrderMapper.updateById(hotelOrder); 
			    cancelOrderRes.setResult(true);
			    cancelOrderRes.setMsg(orderCancelResult.getMessage());
			    cancelOrderRes.setLasestCancelTime(hotelOrder.getLatestArriveTime());
			}else {
				throw new GSSException("取消酒店订单", "0107", "取消酒店订单,退款失败!");
			}
			
		}else {
			cancelOrderRes.setResult(false);
		    cancelOrderRes.setMsg(orderCancelResult.getMessage());
		    cancelOrderRes.setLasestCancelTime(hotelOrder.getLatestArriveTime());
		}
		return des;
	}

	private BigDecimal saleRefund(Agent agent, HotelOrder hotelOrder) {
		ActualInfoSearchVO actualInfo = actualAmountRecorService.queryActualInfoByBusNo(agent, Long.valueOf(hotelOrder.getRequestCode()), 2);
		CertificateCreateVO certificateCreateVO = new CertificateCreateVO();
		certificateCreateVO.setPayNo(actualInfo.getPayNo());
		certificateCreateVO.setCustomerTypeNo(Long.valueOf(hotelOrder.getRequestText()));
		certificateCreateVO.setCustomerNo(hotelOrder.getCustomerNo());
		certificateCreateVO.setIncomeExpenseType(2);
		certificateCreateVO.setAmount(hotelOrder.getTotalPrice());
		List<BusinessOrderInfo> businessOrderInfoList = new ArrayList<>();
		BusinessOrderInfo businessOrderInfo = new BusinessOrderInfo();
		businessOrderInfo.setRecordNo(Long.valueOf(hotelOrder.getRequestCode()));
		businessOrderInfo.setBusinessType(Long.valueOf(hotelOrder.getRequestText()).intValue());
		businessOrderInfoList.add(businessOrderInfo);
		certificateCreateVO.setOrderInfoList(businessOrderInfoList);
		BigDecimal saleRefundCert = certificateService.saleRefundCert(agent, certificateCreateVO);
		return saleRefundCert;
	}

	
	/**
     * 更新销售单和采购单状态
     *
     * @param saleOrderNo
     * @param buyOrderNo
     */
    private void updateSaleAndBuyOrderStatus(Agent agent, Long saleOrderNo, Long buyOrderNo, Integer status) throws GSSException{
        saleOrderService.updateStatus(agent, saleOrderNo, status);
        buyOrderService.updateStatus(agent, buyOrderNo, status);
    }
    
	@Override
	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT)
	public Boolean bqyPushOrderInfo(Agent agent, BQYPushOrderInfo bqyPushOrderInfo) {
		logger.info("推送更新订单状态:{}",JSON.toJSONString(bqyPushOrderInfo));
		if (StringUtil.isNotNullOrEmpty(bqyPushOrderInfo) && StringUtil.isNotNullOrEmpty(bqyPushOrderInfo.getOrdernumber()) 
				&& StringUtil.isNotNullOrEmpty(bqyPushOrderInfo.getOrderId())) {
			//订单号
			Long orderNumber = bqyPushOrderInfo.getOrdernumber();
			if (null == orderNumber) {
				logger.error("推送酒店订单号为空!");
				throw new GSSException("更新状态信息异常", "0191", "推送酒店订单号为空!");
			}
			//子订单号
			Long orderId = bqyPushOrderInfo.getOrderId();
			HotelOrder hotelOrder = hotelOrderMapper.getOrderByNo(String.valueOf(orderNumber));
			LogRecord LogRecord=new LogRecord();
			LogRecord.setBizCode("HOL-Order");
			LogRecord.setTitle("酒店订单状态");
			LogRecord.setBizNo(hotelOrder.getHotelOrderNo());
			hotelOrder.setModifier("供应商");
			hotelOrder.setModifyTime(new Date());
			String des= "";
			String orderStatus = hotelOrder.getOrderStatus();
			//订单状态
	 		TcOrderStatus pushOrderStatus = bqyPushOrderInfo.getOrderStatus();
			if (pushOrderStatus.getKey().equals(TcOrderStatus.ALREADY_TC_CONFIRM.getKey())) {	//订单确认
				if(!orderStatus.equals(OwnerOrderStatus.ALREADY_CONRIRM.getKey())) {
					if (OwnerOrderStatus.PAY_OK.equals(orderStatus)) {
						des = "订单号"+orderId +",订单状态由"+ OwnerOrderStatus.keyOf(orderStatus).getValue()+"变成:"+ OwnerOrderStatus.ALREADY_CONRIRM.getValue();
						//更新销售单和采购单状态
						updateSaleAndBuyOrderStatus(agent, hotelOrder.getSaleOrderNo(), hotelOrder.getBuyOrderNo(), OrderStatusUtils.getStatus(OwnerOrderStatus.ALREADY_CONRIRM));
						hotelOrder.setOrderStatus(OwnerOrderStatus.ALREADY_CONRIRM.getKey());
						hotelOrder.setTcOrderStatus(TcOrderStatus.ALREADY_TC_CONFIRM.getKey());
						hotelOrderMapper.updateById(hotelOrder);
				    	
						SmsTemplateDetail smsTemplateDetail = new SmsTemplateDetail();
						smsTemplateDetail.setDictCode("HOTEL_GUARANTEE");
				    	List<SmsTemplateDetail> stds = smsTemplateDetailService.query(smsTemplateDetail);
				    	String messageReplace = messageReplace(stds.get(0).getContent(), hotelOrder);
				    	LogRecord logRecord=new LogRecord();
						logRecord.setAppCode("GSS");
						logRecord.setBizCode("HOL-Order");
						logRecord.setBizNo(hotelOrder.getHotelOrderNo());		
						//logRecord.setCreateTime(new java.sql.Date(System.currentTimeMillis()));
						logRecord.setDesc(messageReplace);
						logRecord.setCreateTime(new Date());
						logRecord.setOptName("腾邦国际");
						logService.insert(logRecord); 
						
						//Agent ag = new Agent(8755, 301L, hotelOrder.getCustomerNo());
						//mssReserveService.interHotelStatus(ag, hotelOrder.getSaleOrderNo(), OwnerOrderStatus.ALREADY_CONRIRM.getKey(), "酒店订单"+hotelOrder.getSaleOrderNo()+"下单确认成功");
					}else {
						logger.error("更新订单状态失败,订单状态非已支付!");
						throw new GSSException("更新酒店订单", "0106", "更新订单状态失败,订单状态非已支付!");
					}
					
				}
				
			}else if (pushOrderStatus.getKey().equals(TcOrderStatus.CANCEL_ING.getKey())) {		//退订中
				if (!orderStatus.equals(OwnerOrderStatus.CANCEL_ONGOING.getKey())) {
					if (OwnerOrderStatus.PAY_OK.equals(orderStatus) || OwnerOrderStatus.ALREADY_CONRIRM.equals(orderStatus)) {
						des = "订单号"+orderId +",订单状态由"+ OwnerOrderStatus.keyOf(orderStatus).getValue()+"变成:"+ OwnerOrderStatus.CANCEL_ONGOING.getValue();
						//更新销售单和采购单状态
						updateSaleAndBuyOrderStatus(agent, hotelOrder.getSaleOrderNo(), hotelOrder.getBuyOrderNo(), OrderStatusUtils.getStatus(OwnerOrderStatus.CANCEL_ONGOING));
						hotelOrder.setOrderStatus(OwnerOrderStatus.CANCEL_ONGOING.getKey());
						hotelOrder.setTcOrderStatus(TcOrderStatus.CANCEL_ING.getKey());
						hotelOrderMapper.updateById(hotelOrder);
					}else {
						logger.error("更新订单状态失败,订单状态非已支付或已确认!");
						throw new GSSException("更新酒店订单", "0108", "更新订单状态失败,订单状态非已支付、已确认!");
					}
				}
				
			}else if (pushOrderStatus.getKey().equals(TcOrderStatus.CANCEL_FINISH.getKey())) {	//已退订
				if (!orderStatus.equals(OwnerOrderStatus.CANCEL_OK.getKey())) {
					des = "订单号"+orderId +",订单状态由"+ OwnerOrderStatus.keyOf(orderStatus).getValue()+"变成:"+ OwnerOrderStatus.CANCEL_OK.getValue();
					if (OwnerOrderStatus.PAY_OK.equals(orderStatus) || OwnerOrderStatus.CANCEL_ONGOING.equals(orderStatus) || OwnerOrderStatus.ALREADY_CONRIRM.equals(orderStatus)) {
						try {
							BigDecimal saleRefund = saleRefund(AgentUtil.getAgent(), hotelOrder);
							if (null != saleRefund && saleRefund.compareTo(BigDecimal.ZERO) == 1) {	//退款成功
								des = "订单号"+hotelOrder.getHotelOrderNo() +",订单状态由"+ OwnerOrderStatus.keyOf(hotelOrder.getOrderStatus()).getValue()+"变成:"+ OwnerOrderStatus.CANCEL_OK.getValue();
								//更新销售单和采购单状态
							    updateSaleAndBuyOrderStatus(agent, hotelOrder.getSaleOrderNo(), hotelOrder.getBuyOrderNo(), OrderStatusUtils.getStatus(OwnerOrderStatus.CANCEL_OK));
							   //更新酒店订单状态
							    hotelOrder.setOrderStatus(OwnerOrderStatus.CANCEL_OK.getKey());
							    hotelOrder.setTcOrderStatus(TcOrderStatus.ALREADY_CANCEL.getKey());
							    hotelOrder.setCancelTime(new Date());
							    hotelOrder.setFactTotalPrice(hotelOrder.getFactTotalPrice().subtract(saleRefund));
							    hotelOrderMapper.updateById(hotelOrder);
							}
						} catch (GSSException e) {
							//更新酒店订单状态
						    hotelOrder.setOrderStatus(OwnerOrderStatus.CANCEL_BAD.getKey());
						    hotelOrder.setCancelTime(new Date());
						    hotelOrderMapper.updateById(hotelOrder);
						    return false;
						}
					}else {
						logger.error("更新订单状态失败,订单状态非已支付、已确认、退订中!");
						throw new GSSException("更新酒店订单", "0107", "更新订单状态失败,与本地订单状态不符!");
					}
				}

			}else if (pushOrderStatus.getKey().equals(TcOrderStatus.ALREADY_CANCEL.getKey())) { //已取消
				if (!orderStatus.equals(OwnerOrderStatus.CANCEL_OK.getKey())) {
					des = "订单号"+orderId +",订单状态由"+ OwnerOrderStatus.keyOf(orderStatus).getValue()+"变成:"+ OwnerOrderStatus.CANCEL_OK.getValue();
					//更新销售单和采购单状态
					updateSaleAndBuyOrderStatus(agent, hotelOrder.getSaleOrderNo(), hotelOrder.getBuyOrderNo(), OrderStatusUtils.getStatus(OwnerOrderStatus.CANCEL_OK));
					hotelOrder.setOrderStatus(OwnerOrderStatus.CANCEL_OK.getKey());
					hotelOrder.setTcOrderStatus(TcOrderStatus.ALREADY_CANCEL.getKey());
					hotelOrderMapper.updateById(hotelOrder);
				}
			}
			
		}else {
			logger.error("bqy酒店订单状态更新异常!");
			throw new GSSException("更新状态信息异常", "0111", "bqy酒店订单更新状态异常!");
		}
		return true;
	}
	
	public String messageReplace(String message, HotelOrder hotelOrder){
		SimpleDateFormat simpleorder = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat simple = new SimpleDateFormat("yyyy/MM/dd");
		String replace1 = message.replace("{$OrderNo}", hotelOrder.getSaleOrderNo().toString());
		String replace2 = replace1.replace("{$CreateDate}", simpleorder.format(hotelOrder.getCreateOrderTime()));
		String replace3 = replace2.replace("{$HotelName}", hotelOrder.getHotelName());
		String replace4 = replace3.replace("{$Address}", hotelOrder.getHotelAddress());
		String replace5 = replace4.replace("{$Phone}", hotelOrder.getHotelPhone());
		String replace6 = replace5.replace("{$RoomNum}", hotelOrder.getBookCount().toString());
		String replace7 = replace6.replace("{$RoomNight}", hotelOrder.getNightCount().toString());
		String replace8 = replace7.replace("{$RoomType}", hotelOrder.getProName());
		String replace9 = replace8.replace("{$DayInfo}", simple.format(hotelOrder.getArrivalDate()).substring(5, 10)+"-"+simple.format(hotelOrder.getDepartureDate()).substring(5, 10)+" 总价¥"+hotelOrder.getTotalPrice());
		String replace10 = replace9.replace("{$GuestsName}", hotelOrder.getGuestName());
		String replace = replace10.replace("{$LateTime}", hotelOrder.getArriveHotelTime().substring(0, 13));
		return replace;
	}

	@Override
	public HotelOrder createOrder(Agent agent, CreateOrderReq orderReq, OrderCreateReq orderCreateReq) {
		orderReq.setMobile(tempusMobile);
		if (StringUtil.isNullOrEmpty(orderReq)) {
			logger.error("orderReq查询条件为空");
			throw new GSSException("创建订单信息", "0101", "orderReq查询条件为空");
		}
		if (StringUtil.isNullOrEmpty(agent)) {
			logger.error("agent对象为空");
			throw new GSSException("创建酒店订单", "0102", "agent对象为空");
		}
		if (StringUtil.isNullOrEmpty(orderReq.getHotelId())) {
			logger.error("酒店ID为空！");
			throw new GSSException("创建酒店订单", "0103", "酒店ID为空！");
		}
		if (StringUtil.isNullOrEmpty(orderReq.getHotelRoomId())) {
			logger.error("房型ID为空！");
			throw new GSSException("创建酒店订单", "0104", "房型ID为空！");
		}
		if (StringUtil.isNullOrEmpty(orderReq.getProductId())) {
			logger.error("房间ID为空！");
			throw new GSSException("创建酒店订单", "0109", "房间ID为空！");
		}
		if (StringUtils.isBlank(orderReq.getPassengers())) {
			logger.error("酒店入住人为空!");
			throw new GSSException("创建酒店订单", "0105", "酒店入住人为空!");
		}
		if (StringUtil.isNullOrEmpty(orderReq.getBookNumber())) {
			logger.error("预定房间数为空！");
			throw new GSSException("创建酒店订单", "0106", "预定房间数为空！");
		}
		/*if (StringUtil.isNullOrEmpty(orderReq.getUnitPrice())) {
			logger.error("酒店单价为空！");
			throw new GSSException("创建酒店订单", "0107", "酒店单价为空！");
		}*/
		if (StringUtil.isNullOrEmpty(orderReq.getCheckInTime())) {
			logger.error("入住时间为空！");
			throw new GSSException("创建酒店订单", "0107", "入住时间为空！");
		}
		if (StringUtil.isNullOrEmpty(orderReq.getCheckOutTime())) {
			logger.error("离店时间为空！");
			throw new GSSException("创建酒店订单", "0107", "离店时间为空！");
		}
		if (StringUtil.isNullOrEmpty(orderReq.getLateArrivalTime())) {
			logger.error("最迟到店时间(整点数)为空！");
			throw new GSSException("创建酒店订单", "0113", "最迟到店时间(只能是整点,默认18点)为空！");
		}
		if (StringUtil.isNullOrEmpty(orderReq.getHotelMobile())) {
			logger.error("酒店联系电话为空！");
			throw new GSSException("创建酒店订单", "0109", "酒店联系电话为空！");
		}
		if (StringUtil.isNullOrEmpty(orderReq.getCancelNotice())) {
			logger.error("取消政策为空！");
			throw new GSSException("创建酒店订单", "0110", "取消政策为空！");
		}
		if (StringUtil.isNullOrEmpty(orderReq.getOrderLink())) {
			logger.error("联系人姓名为空！");
			throw new GSSException("创建酒店订单", "0110", "联系人姓名为空！");
		}
		if (StringUtil.isNullOrEmpty(orderReq.getMobile())) {
			logger.error("联系人电话为空！");
			throw new GSSException("创建酒店订单", "0112", "联系人电话为空！");
		}
		/*
		 * if (StringUtil.isNullOrEmpty(orderReq.getPaymentSign())) {
		 * logger.error("支付模式为空！"); throw new GSSException("创建酒店订单", "0114",
		 * "支付模式为空！"); }
		 */
		if (StringUtil.isNullOrEmpty(orderReq.getBreakfast())) {
			logger.error("早餐为空！");
			throw new GSSException("创建酒店订单", "0114", "早餐为空！");
		}

		Date dateStartDate;
		Date departureDate;
		int daysBetween;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			dateStartDate = dateFormat.parse(orderReq.getCheckInTime());
			Date departDate = dateFormat.parse(orderReq.getCheckOutTime());
			Calendar cal = Calendar.getInstance();
			cal.setTime(departDate);
			cal.add(Calendar.DAY_OF_MONTH, 1);
			departureDate = cal.getTime();
			daysBetween = com.tempus.gss.ops.util.DateUtil.daysBetween(orderReq.getCheckInTime(),
					orderReq.getCheckOutTime());
		} catch (ParseException e) {
			logger.error("入住日期/离店日期 格式错误,请重新输入！入住日期/离店日期的正确格式为(yyyy-MM-dd)", e);
			throw new GSSException("创建酒店订单", "0129",
					"入住日期/离店日期 格式错误,请重新输入！入住日期/离店日期的正确格式为(yyyy-MM-dd)" + e.getMessage());
		}

		HotelOrder hotelOrder = new HotelOrder();

		// 查询酒店房间价格
		QueryHotelParam query = new QueryHotelParam();
		query.setCheckInTime(orderReq.getCheckInTime());
		query.setCheckOutTime(orderReq.getCheckOutTime());
		query.setCityCode(String.valueOf(orderReq.getCityId()));
		query.setHotelId(orderReq.getHotelId());
		List<RoomPriceItem> roomPriceList = bqyHotelInterService.queryHotelRoomPrice(query);
		// 房型ID
		String roomTypeId = orderReq.getProductId();
		//房间单价 (房间每天的价格相加)
		BigDecimal unitPrice = null;
		// 每天的价格记录
		String eachNightPrice = null;
		//供应商ID
		String supplierId = null;
		//预定检查类型
		String ratePlanCategory = null;
		//政策类型
		String policyType = "";
		outer:
		for (RoomPriceItem roomPriceItem : roomPriceList) {
			BaseRoomInfo baseRoomInfo = roomPriceItem.getBaseRoomInfo();
			if (roomTypeId.equals(baseRoomInfo.getRoomTypeID())) {// 判断房型是否一致
				List<RoomInfoItem> roomInfoList = roomPriceItem.getRoomInfo();
				for (RoomInfoItem roomInfoItem : roomInfoList) {
					if (orderReq.getHotelRoomId().equals(Long.valueOf(roomInfoItem.getRoomID()))) {// 判断房间ID是否一致
						orderReq.setHotelRoomName(baseRoomInfo.getRoomName());
						orderReq.setProductName(roomInfoItem.getRoomName());
						//政策类型
						policyType = roomInfoItem.getCancelLimitInfo().getPolicyType();
						RoomPriceInfo roomPriceInfo = roomInfoItem.getRoomPriceInfo();
						//预定检查类型
						ratePlanCategory = roomPriceInfo.getRatePlanCategory();
						//供应商ID
						supplierId = roomInfoItem.getSupplierId();
						//平均价格
						Double settleFee = roomPriceInfo.getAveragePrice().getSettleFee();
						unitPrice = new BigDecimal(settleFee);
						/*List<RoomPriceDetail> priceDetailList = roomPriceInfo.getRoomPriceDetail();
						for (RoomPriceDetail roomPriceDetail : priceDetailList) {
							String oneDayPrice = roomPriceDetail.getPrice().getAmount();
							// 计算一间房的价格
							newTotalPrice = newTotalPrice.add(new BigDecimal(oneDayPrice));
							// 记录每天的价格
							if (eachNightPrice == null || "".equals(eachNightPrice)) {
								eachNightPrice = oneDayPrice;
							} else {
								eachNightPrice = eachNightPrice + "," + oneDayPrice;
							}
						}*/
						for (int i = 0; i < daysBetween; i++) {
							if (eachNightPrice == null || "".equals(eachNightPrice)) {
								eachNightPrice = settleFee.toString();
							} else {
								eachNightPrice = eachNightPrice + "," + settleFee.toString();
							}
						}
						// 产品名称
						hotelOrder.setSupPriceName(roomInfoItem.getRoomName());
						hotelOrder.setProName(roomInfoItem.getRoomName());
						// 床型
						RoomBedTypeInfo roomBedTypeInfo = roomInfoItem.getRoomBedTypeInfo();
						if ("T".equals(roomBedTypeInfo.getHasKingBed())) {
							hotelOrder.setBedTypeName("大床");
						} else if ("T".equals(roomBedTypeInfo.getHasTwinBed())) {
							hotelOrder.setBedTypeName("双床");
						} else if ("T".equals(roomBedTypeInfo.getHasSingleBed())) {
							hotelOrder.setBedTypeName("单人床");
						}
						break;
					}
				}
				break outer;
			}
		}
		if (unitPrice == null) {
			logger.error("酒店房间单价为空!");
			throw new GSSException("创建酒店订单", "0107", "酒店单价为空！");
		}
		orderReq.setUnitPrice(unitPrice);
		// 总价格
		BigDecimal newTotalPrice = (unitPrice.multiply(new BigDecimal(daysBetween))).multiply(new BigDecimal(orderReq.getBookNumber()));
		hotelOrder.setEachNightPrice(eachNightPrice);

		Long businessSignNo = IdWorker.getId();
		BuyOrder buyOrder = orderCreateReq.getBuyOrder();
		if (buyOrder == null) {
			buyOrder = new BuyOrder();
		}
		if (StringUtil.isNotNullOrEmpty(orderCreateReq.getSupplierNo())) {
			Long supplierNo = Long.valueOf(orderCreateReq.getSupplierNo());
			hotelOrder.setSupplierNo(supplierNo);
			buyOrder.setSupplierNo(supplierNo);
			// 从客商系统查询供应商信息
			Supplier supplier = supplierService.getSupplierByNo(agent, supplierNo);
			if (StringUtil.isNotNullOrEmpty(supplier)) {
				buyOrder.setSupplierTypeNo(supplier.getCustomerTypeNo());
			} else {
				throw new GSSException("创建酒店订单", "0130", "根据编号查询供应商信息为空！");
			}
		} else {
			logger.error("供应商信息不存在！");
			throw new GSSException("创建酒店订单", "0130", "供应商信息不存在！");
		}

		/* 创建销售订单 */
		Long saleOrderNo = maxNoService.generateBizNo("HOL_SALE_ORDER_NO", 13);
		//获取交易单
		SaleOrder saleOrder = orderCreateReq.getSaleOrder();
		if (null == saleOrder) {
			saleOrder = new SaleOrder();
		}
		saleOrder.setSaleOrderNo(saleOrderNo);
		saleOrder.setOwner(agent.getOwner());
		saleOrder.setSourceChannelNo(agent.getDevice());
		saleOrder.setCustomerTypeNo(agent.getType());
		saleOrder.setCustomerNo(agent.getNum());
		saleOrder.setOrderingLoginName(agent.getAccount());
		saleOrder.setGoodsType(GoodsBigType.GROGSHOP.getKey());//
		saleOrder.setGoodsSubType(GoodsBigType.GROGSHOP.getKey());//
		saleOrder.setOrderingTime(new Date());// 下单时间
		saleOrder.setPayStatus(1);// 待支付
		saleOrder.setValid(1);// 有效
		saleOrder.setBusinessSignNo(businessSignNo);
		saleOrder.setBsignType(1);// 1销采 2换票 3废和退 4改签
		saleOrder.setTransationOrderNo(orderCreateReq.getSaleOrder().getTransationOrderNo());
		saleOrder.setOrderType(1);
		saleOrder.setOrderChildStatus(OrderStatusUtils.getStatus(OwnerOrderStatus.ORDER_ONGOING));
		saleOrder.setGoodsName(orderReq.getHotelName());
		saleOrderService.create(agent, saleOrder);
		
		//创建应收单
		CreatePlanAmountVO amountVO = new CreatePlanAmountVO();
		amountVO.setRecordNo(saleOrderNo);
		amountVO.setBusinessType(2);
		amountVO.setGoodsType(4);
		amountVO.setIncomeExpenseType(1);
		amountVO.setPlanAmount(newTotalPrice);
		amountVO.setRecordMovingType(1);
		planAmountRecordService.create(agent, amountVO);

		/* 创建采购单 */
		Long buyOrderNo = maxNoService.generateBizNo("HOL_BUY_ORDER_NO", 14);
		buyOrder.setOwner(agent.getOwner());
		buyOrder.setBuyOrderNo(buyOrderNo);
		buyOrder.setSaleOrderNo(saleOrderNo);
		buyOrder.setGoodsType(GoodsBigType.GROGSHOP.getKey());
		buyOrder.setGoodsSubType(GoodsBigType.GROGSHOP.getKey());
		buyOrder.setGoodsName(orderReq.getHotelName());
		buyOrder.setBuyChannelNo("HOTEL");
		buyOrder.setBusinessSignNo(businessSignNo);
		buyOrder.setBuyChildStatus(OrderStatusUtils.getStatus(OwnerOrderStatus.ORDER_ONGOING));
		buyOrder.setBsignType(1);// 1销采 2换票 3废和退 4改签
		buyOrderService.create(agent, buyOrder);

		// 入住旅客
		String passengers = orderReq.getPassengers();
		String[] passengerArr = passengers.split(",");

		// 创建酒店订单
		hotelOrder.setOwner(agent.getOwner());
		hotelOrder.setCustomerNo(agent.getNum());
		//hotelOrder.setDbOrderType(orderCreateReq.getDbOrderType());
		hotelOrder.setDbOrderMoney(orderCreateReq.getDbOrderMoney());
		hotelOrder.setDbCancelRule(orderCreateReq.getDbCancelRule());
		hotelOrder.setCancelPenalty(orderCreateReq.getCancelPenalty());
		hotelOrder.setEarlyArriveTime(orderCreateReq.getEarlyArriveTime());
		hotelOrder.setLatestArriveTime(orderCreateReq.getLatestArriveTime());
		hotelOrder.setSaleOrderNo(saleOrderNo);
		hotelOrder.setBuyOrderNo(buyOrderNo);
		hotelOrder.setHotelCode(String.valueOf(orderCreateReq.getResId()));
		hotelOrder.setHotelName(orderReq.getHotelName());
		hotelOrder.setOrderType(2);	//设置为2代表订单属于BQY (1.TC; 2.BQY)
		hotelOrder.setContactName(orderCreateReq.getLinkManName());
		hotelOrder.setContactNumber(orderCreateReq.getLinkManMobile());
		hotelOrder.setArrivalDate(dateStartDate);
		hotelOrder.setDepartureDate(departureDate);
		hotelOrder.setTotalPrice(newTotalPrice);
		hotelOrder.setNightCount(daysBetween);
		hotelOrder.setTransationOrderNo(orderCreateReq.getSaleOrder().getTransationOrderNo());
		hotelOrder.setTotalRefund(orderCreateReq.getTotalRebateRateProfit());
		hotelOrder.setFactTotalRefund(new BigDecimal(0));
		hotelOrder.setGuestName(passengers);
		hotelOrder.setGuestMobile(orderReq.getMobile());
		hotelOrder.setDbOrderType(policyType);
		if (StringUtil.isNotNullOrEmpty(orderCreateReq.getOrderRemark())) {
			hotelOrder.setRemark(orderCreateReq.getOrderRemark());
		}
		//最迟取消时间
		if (StringUtils.isNoneBlank(orderCreateReq.getCancelPenalty())) {
			try {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				hotelOrder.setCancelTime(format.parse(orderCreateReq.getCancelPenalty()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		hotelOrder.setLocker(0L);
		hotelOrder.setOrderStatus(OwnerOrderStatus.ORDER_ONGOING.getKey());
		hotelOrder.setCreator(agent.getAccount());
		hotelOrder.setCreateOrderTime(new Date());
		hotelOrder.setProductUniqueId(orderCreateReq.getProductUniqueId());
		hotelOrder.setBookCount(orderCreateReq.getBookCount());
		hotelOrder.setPaymentSign(orderCreateReq.getPaymentSign());
		hotelOrder.setArriveHotelTime(orderCreateReq.getArriveHotelTime());
		hotelOrder.setHotelAddress(orderReq.getCityName() + "市" + orderReq.getAddress());
		hotelOrder.setHotelPhone(orderCreateReq.getHotelPhone());
		//hotelOrder.setProName(orderCreateReq.getProName());
		hotelOrder.setProId(orderCreateReq.getProId());
		hotelOrder.setBreakfastCount(orderCreateReq.getBreakfastCount());
		hotelOrder.setRequestText(String.valueOf(saleOrder.getCustomerTypeNo()));	//存储CustomerType
		//特殊要求
		if (StringUtils.isNoneBlank(orderCreateReq.getOrderRemark())) {
			hotelOrder.setRequestText(orderCreateReq.getOrderRemark());
			orderReq.setRemark(orderCreateReq.getOrderRemark());
		}
		hotelOrderMapper.insertSelective(hotelOrder);

		//前台传入的价格
		BigDecimal beforeTotalPrice = orderCreateReq.getBeforeTotalPrice();
		
		//验证价格是否一致
		//BigDecimal checkPrice = bookOrderResult.getCheckPrice();
		
		if (beforeTotalPrice.compareTo(newTotalPrice) != 0) {
			logger.error("传入的总价与最新的总价不一致");
			throw new GSSException("创建酒店订单失败", "0132", "价格不一致");
		}
		
		if (StringUtils.isBlank(supplierId)) {
			logger.error("BQY酒店供应商ID为空!");
			throw new GSSException("创建酒店订单失败!", "0132", "酒店供应商ID为空!");
		}
		
		if (StringUtils.isBlank(ratePlanCategory)) {
			logger.error("预定检查类型为空!");
			throw new GSSException("创建酒店订单失败!", "0133", "酒店预定检查类型为空!");
		}
		orderReq.setSupplierId(supplierId);
		orderReq.setRatePlanCategory(ratePlanCategory);
		//可以不传
		orderReq.setChannelType(2);
		logger.info("创建8000YI酒店订单入参"+JsonUtil.toJson(orderReq));
		CreateOrderRespone createOrderRespone = bqyHotelInterService.createOrder(orderReq);
		logger.info("创建8000YI酒店订单返回结果:"+ JsonUtil.toJson(createOrderRespone));
		Long orderNo = createOrderRespone.getOrderNumber();
		// 判断条件返回0订单创建失败
		if (null != createOrderRespone && orderNo > 0) {
			//订单创建成功更新订单表中数据
			hotelOrder.setHotelOrderNo(orderNo.toString());
			//0=>下单失败，1=>下单成功，2=>下单成功，支付失败，3=>下单成功，支付成功
			hotelOrder.setResultCode("1");
			hotelOrder.setTcOrderStatus(TcOrderStatus.WAIT_PAY.getKey());
			hotelOrder.setOrderStatus(OwnerOrderStatus.WAIT_PAY.getKey());
			hotelOrder.setFactTotalPrice(createOrderRespone.getPayPrice());
			hotelOrderMapper.updateById(hotelOrder);
			return hotelOrder;
		}else {
			throw new GSSException("bqy酒店创建失败!", "10001", "bqy酒店创建失败!");
		}
	}
}
