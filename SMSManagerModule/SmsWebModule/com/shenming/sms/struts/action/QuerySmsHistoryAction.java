package com.shenming.sms.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.shenming.sms.dc.manager.SenderManager;
import com.shenming.sms.struts.form.QuerySmsHistoryForm;
import com.shenming.sms.util.DateUtil;
import com.shenming.sms.util.Tool;

public class QuerySmsHistoryAction extends Action {

	/* forward name="querySmsHistory" path="/sms/querySmsHistory.jsp" */
	private final static String QUERYSMSHISTORY = "querySmsHistory";
	QuerySmsHistoryForm queryForm ;
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		queryForm = (QuerySmsHistoryForm)form;
		int vipId = queryForm.getVipId();
		String mobileNbr = queryForm.getMobileNbr();
		String msgTitle = queryForm.getMsgTitle();
		String status = queryForm.getStatus();
		String createDateStart = queryForm.getCreateTimeStart();
		String createDateEnd = queryForm.getCreateTimeEnd();
		String sendDateStart = queryForm.getSentDateStart();
		String sendDateEnd = queryForm.getSentDateEnd();
		
//		SenderManager.querySmsHistory(vipId, mobileNbr, msgTitle, status,
//				createDateStart, createDateEnd,
//				sendDateStart, sendDateEnd);
		List resultList = SenderManager.retrieveMessageQueue(0, vipId, status, 
				Tool.isNotEmpty(createDateStart)?DateUtil.getSqlTimestampFromString(createDateStart,DateUtil.DATE_FORMAT_DAY_MONTH_YEAR_TIME_DASH):null, 
				Tool.isNotEmpty(createDateEnd)?DateUtil.getSqlTimestampFromString(createDateEnd, DateUtil.DATE_FORMAT_DAY_MONTH_YEAR_TIME_DASH):null, 
				Tool.isNotEmpty(sendDateStart)?DateUtil.getSqlTimestampFromString(sendDateStart, DateUtil.DATE_FORMAT_DAY_MONTH_YEAR_TIME_DASH):null, 
				Tool.isNotEmpty(sendDateEnd)?DateUtil.getSqlTimestampFromString(sendDateEnd, DateUtil.DATE_FORMAT_DAY_MONTH_YEAR_TIME_DASH):null);
		queryForm.setSmTbMessageQueues(resultList);
//		System.out.println(resultList);
		request.setAttribute("querySmsHistoryForm", queryForm);
		
		return mapping.findForward(QUERYSMSHISTORY);
	}

}
