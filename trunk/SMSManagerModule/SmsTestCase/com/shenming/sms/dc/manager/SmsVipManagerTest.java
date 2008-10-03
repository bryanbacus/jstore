package com.shenming.sms.dc.manager;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.shenming.sms.module.hibernateOrm.SmTbVipAccount;
import com.shenming.sms.struts.form.QueryVipForm;
import com.shenming.sms.util.PrintUtil;

import junit.framework.TestCase;

public class SmsVipManagerTest extends TestCase {

	public SmsVipManagerTest() {
		super();
		SmsVipManager.initialize();
	}
	
	private void log(Object obj){
		System.out.println(obj);
	}

	public void testCreateVipUser() {
//		fail("Not yet implemented");
		HashMap hm = new HashMap();
		hm.put("1", null);
		hm.put("1", "123");
//		hm.put("1", null);
		log(hm.toString());
		assertEquals(true, true);
	}
	
	public void testRetrieveUserById(){
		SmTbVipAccount vo = SmsVipManager.retrieveUserById(0);
		log("Get the username: "+ vo.getUsername());
		assertEquals("testRetrieveUserById: ", "admin",vo.getUsername());
	}
	
	public void testRetrieveUserByExample(){
//		List<SmTbVipAccount>
		SmTbVipAccount example = new SmTbVipAccount();
		example.setUsername("admin");
		List<SmTbVipAccount> result = SmsVipManager.retrieveUserByExample(example);
//		System.out.println(result);
		for(SmTbVipAccount vo : result){
			seperate();
			PrintUtil.printObject (vo);
		}
		assertEquals(result.size(), 1);
	}
	
	public void testIsDateInMonth(){
		assertEquals(true, SmsVipManager.isDateInMonth(new Date(), 1));
	}
	
	public void testRetrieveUserByQueryForm(){
		QueryVipForm form = new QueryVipForm();
		form.setSid("S123130132");
		List<SmTbVipAccount> list = SmsVipManager.retrieveUserByQueryForm(form);
		log(list);
		assertEquals(list.size(), 1);
	}

	private void seperate() {
		log("---------------------------------------------------");
	}
}
