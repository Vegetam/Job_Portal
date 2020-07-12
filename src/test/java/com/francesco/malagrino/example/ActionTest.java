package com.francesco.malagrino.example;

import org.apache.struts2.StrutsTestCase;

import com.francesco.malagrino.actions.LinkAction;
import com.francesco.malagrino.actions.LoginAction;
import com.francesco.malagrino.actions.RegisterAction;
import com.francesco.malagrino.actions.SearchAction;
import com.opensymphony.xwork2.ActionProxy;

public class ActionTest extends StrutsTestCase{
	
	public void testRegisterActionDuplicateEmail() throws Exception
	{
		// parameters are fname, lname, email, password, cpassword
		request.setParameter("fname", "Francesco");
		request.setParameter("lname", "Malagrino");
		request.setParameter("email", "francesco.malagrino@gmail.com");
		request.setParameter("password", "");
		request.setParameter("cpassword", "");
		
		ActionProxy proxy = getActionProxy("/register");
		
		RegisterAction registerAction = (RegisterAction) proxy.getAction();
		
		String result = proxy.execute();
		
		assertTrue("There should not be any problem.", registerAction.getFieldErrors().size() == 0 );
		assertEquals("Result returned from executing the action was not success but it should have been.","error",result);
	}
	
	public void testLinkAction() throws Exception
	{
		
		ActionProxy proxy = getActionProxy("/loginLink");
		
		LinkAction linkAction = (LinkAction) proxy.getAction();
		
		String result = proxy.execute();
		
		assertEquals("Result returned from executing the action was not login but it should have been.","login",result);
	}
	
	public void testSearchAction() throws Exception {
		request.setParameter("query", "mail");
		
		ActionProxy proxy = getActionProxy("/search");
		
		SearchAction searchAction = (SearchAction) proxy.getAction();
		
		String result = proxy.execute();
		
		assertEquals("Result returned from executing the action was not success but it should have been.","success",result);
		
	}


}
