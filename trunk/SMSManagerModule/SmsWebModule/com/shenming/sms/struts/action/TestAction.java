package com.shenming.sms.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.shenming.sms.struts.form.TestForm;

public class TestAction extends Action {

	/* forward name="message" path="/message.jsp" */
	private final static String MESSAGE = "message";

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		TestForm tf = (TestForm)form;
		System.out.println(tf.getUsername()+"::"+tf.getPassword());
		// TODO process request and return an ActionForward instance, for example:
		// return mapping.findForward(MESSAGE);
		return null;
	}

}
