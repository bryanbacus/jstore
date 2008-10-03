package com.shenming.sms.struts.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.shenming.sms.dc.manager.OrderManager;
import com.shenming.sms.dc.manager.ProductManager;
import com.shenming.sms.manager.AccountManager;
import com.shenming.sms.module.hibernateOrm.SmTbProduct;
import com.shenming.sms.module.hibernateOrm.SmTbSaleItem;
import com.shenming.sms.struts.form.OrderForm;
import com.shenming.sms.util.Tool;

public class ManageOrderAction extends Action {

	/* forward name="success" path="/sale/showOrder.jsp" */
	private final static String SUCCESS = "success";
	private final static String QUERY = "query";
	private final static String QUERY_DETAIL = "queryDetail";
	private final static String MESSAGE = "message";
	OrderForm orderForm;
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		orderForm = (OrderForm)form;
		System.out.println("Scope Dump: "+ request.getParameter("type"));
		if(OrderForm.DELETE_SESSION.equalsIgnoreCase(request.getParameter("type"))){
			return doDeleteSession(mapping, form, request, response);
		} else if(OrderForm.CREATE.equalsIgnoreCase(request.getParameter("type"))){
			return doCreate(mapping, form, request, response);
		} else if(OrderForm.UPDATE_STATUS.equalsIgnoreCase(request.getParameter("type"))){
			return doUpdateStatus(mapping, form, request, response);
		} 
		
		if(OrderForm.QUERY.equalsIgnoreCase(orderForm.getFormType())){
			return doQuery(mapping, form, request, response);
		} else if(OrderForm.CREATE.equalsIgnoreCase(orderForm.getFormType())){
			return doCreate(mapping, form, request, response);
		} else if(OrderForm.KEEP_SESSION.equalsIgnoreCase(orderForm.getFormType())){
			return doKeepSession(mapping, form, request, response);
		} else if(OrderForm.UPDATE.equalsIgnoreCase(orderForm.getFormType())){
			return doUpdate(mapping, form, request, response);
		} else if(OrderForm.DELETE_SESSION_ALL.equalsIgnoreCase(orderForm.getFormType())){
			return doDeleteSessionAll(mapping, form, request, response);
		} else if(OrderForm.DELETE.equalsIgnoreCase(orderForm.getFormType())){
			return doDelete(mapping, form, request, response);
		}
		
		return mapping.findForward(SUCCESS);
	}

	private ActionForward doUpdateStatus(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		String status = request.getParameter("status");
		String updtype = request.getParameter("updtype");
		String seq = request.getParameter("seq");
		int seqValue = 0;
		if (seq == null || "".equalsIgnoreCase(seq)){
			request.setAttribute("message", "無法更新該資料，請重新確認!");
			return mapping.findForward(MESSAGE);
		} else {
			seqValue = new Integer(seq).intValue();
		}
		
		if("saleItem".equalsIgnoreCase(updtype)){
			OrderManager.updateSaleItemStatusByItemSeq(seqValue, status);
			request.setAttribute("message", "更新項目： "+seqValue+" 成功!");
		}else if ("saleRecord".equalsIgnoreCase(updtype)){
			OrderManager.updateSaleItemStatusBySaleSeq(seqValue, status);
			request.setAttribute("message", "批次更新訂購單項目： "+seqValue+" 成功!");
		}
		
		return mapping.findForward(MESSAGE);
	}

	private ActionForward doDeleteSessionAll(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		request.getSession().removeValue("items");
		return mapping.findForward(QUERY);
	}

	private ActionForward doDeleteSession(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		ArrayList tmp = (ArrayList)request.getSession().getAttribute("items");
		String itemSeq = request.getParameter("idx")!=null?(String)request.getParameter("idx"):"0";
		Iterator iter = tmp.iterator();
		SmTbSaleItem removed =null;
		inner:while(iter.hasNext()){
			removed = (SmTbSaleItem)iter.next();
			if(itemSeq.equalsIgnoreCase(removed.getItemSeq().toString())){
				break inner;
			}
		}
		tmp.remove(removed);
		request.getSession().setAttribute("items", tmp);
		return mapping.findForward(QUERY);
	}

	private ActionForward doKeepSession(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		//Collect the request scope items of sale
		ArrayList tmp = (ArrayList)request.getSession().getAttribute("items");
		Tool.logDebug("original: "+tmp, 3);
		SmTbProduct product = ProductManager.retrieveProductById(orderForm.getPrdId());
		SmTbSaleItem saleItem = new SmTbSaleItem();
		java.util.Date dt = new java.util.Date();
		
		saleItem.setItemSeq(new Integer(dt.getMonth()+""+dt.getDate()+""+ dt.getHours()+""+dt.getMinutes() +""+ dt.getSeconds()));
		saleItem.setPrdUnitPrice(orderForm.getUnitPrice());
		saleItem.setPrdDiscountPrice(orderForm.getDiscountPrice());
		saleItem.setSmTbProduct(product);
		saleItem.setCount(orderForm.getCount());
		saleItem.setLog(orderForm.getLogString());
		saleItem.setIsClose(orderForm.getIsClosed());
		
		if( tmp != null && tmp.size() >= 0){
			tmp.add(saleItem);
		} else {
			tmp = new ArrayList<SmTbSaleItem>();
			tmp.add(saleItem);
		}
		
		request.getSession().setAttribute("items", tmp);
		
		return mapping.findForward(QUERY);
	}

	private ActionForward doDelete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	private ActionForward doUpdate(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	private ActionForward doCreate(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
//		Collect the request scope items of sale
		ArrayList tmp = (ArrayList)request.getSession().getAttribute("items");
		if(tmp == null){
			request.setAttribute("message", "您的購物車是空的，請重新選擇您需要訂購的產品，謝謝!");
			return mapping.findForward(QUERY);
		}
			
		Set set = new HashSet();
		set.addAll(tmp);
		
		//Calculate sale total
		Iterator iter = tmp.iterator();
		long sum = 0;
		while(iter.hasNext()){
			SmTbSaleItem item = (SmTbSaleItem)iter.next();
			sum = sum + item.getPrdDiscountPrice().longValue()*item.getCount();
		}
		
		int saleId = AccountManager.getMyVipId(request);
		int vipId = new Integer(request.getParameter("vipId")!=null?(String)request.getParameter("vipId"):"0");//orderForm.getVipId();
		Tool.logDebug("saleId: "+saleId+"; vipId: "+vipId);
		boolean isSuccess = false;
		if( tmp != null && tmp.size() >= 0){
			isSuccess = OrderManager.createSaleRecord(
					new Long(sum), new java.sql.Timestamp(new java.util.Date().getTime()), 
					set, saleId, vipId);
		}
		
		if(!isSuccess){
			request.setAttribute("message", "無法建立訂購單，請確認客戶代號等資料是否正確!");
		}
		
		request.getSession().removeValue("items");
		
		return mapping.findForward(QUERY);
	}

	private ActionForward doQuery(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		//Collect the request scope items of sale
		
		if(orderForm.getPrdId() > 0){
			SmTbProduct product = ProductManager.retrieveProductById(orderForm.getPrdId());
			SmTbSaleItem saleItem = new SmTbSaleItem();
			saleItem.setPrdDiscountPrice(orderForm.getDiscountPrice());
			saleItem.setSmTbProduct(product);
			saleItem.setCount(orderForm.getCount());
			saleItem.setLog(orderForm.getLogString());
			saleItem.setIsClose(orderForm.getIsClosed());
			orderForm.setUnitPrice(product.getPrice());
			orderForm.setDiscountPrice(product.getPrice());
			orderForm.setPrdGrpId(product.getSmTbProductGroup().getPrdGroupId());
		}
		
		orderForm.setPrdMap(ProductManager.retrieveAvaliableProductsMapByGrpId(orderForm.getPrdGrpId()));
		
		return mapping.findForward(QUERY);
	}

}
