package com.shenming.sms.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.shenming.sms.dc.manager.OrderManager;
import com.shenming.sms.module.hibernateOrm.SmTbSaleRecord;
import com.shenming.sms.struts.form.QueryOrderForm;
import com.shenming.sms.util.DateUtil;
import com.shenming.sms.util.Tool;

public class QueryOrderAction extends Action {

	/* forward name="success" path="/sale/showOrder.jsp" */
	private final static String SUCCESS = "success";
	private final static String QUERY_DETAIL = "queryDetail";
	QueryOrderForm queryOrderForm;
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		queryOrderForm = (QueryOrderForm)form;
		
		if(QueryOrderForm.QUERY_DETAIL.equalsIgnoreCase(request.getParameter("formType"))){
			return doQueryDetail(mapping, form, request, response);
		}
		
		if(QueryOrderForm.QUERY_ALL.equalsIgnoreCase(queryOrderForm.getFormType())){
			return doQueryAll(mapping, form, request, response);
		} else if(QueryOrderForm.QUERY.equalsIgnoreCase(queryOrderForm.getFormType())){
			return doQuery(mapping, form, request, response);
		}
		
		return mapping.findForward(SUCCESS);
	}
	private ActionForward doQueryDetail(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		String orderSeqStr = (String)request.getParameter("saleSeq");
		int orderSeq = new Integer(orderSeqStr!=null?orderSeqStr:"0").intValue();
		SmTbSaleRecord saleRecord = OrderManager.retrieveSaleRecordById(orderSeq);
		queryOrderForm.setSaleRecord(saleRecord);
		request.setAttribute("queryOrderForm", queryOrderForm);
		return mapping.findForward(QUERY_DETAIL);
	}
	private ActionForward doQuery(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		java.sql.Date dtStart = null;
		java.sql.Date dtEnd = null;
		System.out.println("dtStart: "+ queryOrderForm.getSaleDateStart()+ "; dtEnd: "+ queryOrderForm.getSaleDateEnd());
		if(queryOrderForm.getSaleDateStart() != null && !"".equalsIgnoreCase(queryOrderForm.getSaleDateStart())){
			dtStart = DateUtil.getSqlDateFromString(queryOrderForm.getSaleDateStart(), DateUtil.DATE_FORMAT_DAY_MONTH_YEAR_TIME_DASH);
			Tool.logDebug("dtStart: "+ dtStart.getYear()+"/"+dtStart.getMonth()+ "/" +dtStart.getDate(),3);
		} else if(queryOrderForm.getSaleDateEnd() != null && !"".equalsIgnoreCase(queryOrderForm.getSaleDateEnd())){
			dtEnd = DateUtil.getSqlDateFromString(queryOrderForm.getSaleDateEnd(), DateUtil.DATE_FORMAT_DAY_MONTH_YEAR_TIME_DASH);
			Tool.logDebug("dtEnd: "+ dtEnd.getYear()+"/"+ dtEnd.getMonth()+"/"+ dtEnd.getDate());
		}
		
		queryOrderForm.setSaleRecords(OrderManager.retrieveSaleRecord(queryOrderForm.getVipId(), queryOrderForm.getSaleId(), 
				queryOrderForm.getSaleTotalMin(), queryOrderForm.getSaleTotalMax(),
				dtStart, dtEnd));
		request.setAttribute("queryOrderForm", queryOrderForm);
		return mapping.findForward(SUCCESS);
	}
	private ActionForward doQueryAll(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		queryOrderForm.setSaleRecords(OrderManager.retrieveSaleRecordAll());
		request.setAttribute("queryOrderForm", queryOrderForm);
		return mapping.findForward(SUCCESS);
	}

}
