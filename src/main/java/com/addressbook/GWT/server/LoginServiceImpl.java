package com.addressbook.GWT.server;


import com.addressbook.GWT.client.loginForm.LoginService;
import com.addressbook.GWT.client.loginForm.LoginSlim;
import com.addressbook.GWT.client.newUser.NewUserSlim;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.util.ArrayList;



@SuppressWarnings("serial")
public class LoginServiceImpl extends RemoteServiceServlet implements LoginService{

	@Override
	public String greetServer(String name) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return "Hello";
	}

	
	@Override
	public int loginPage(LoginSlim loginSlim){
		// TODO Auto-generated method stub
		LoginHelper lh=new LoginHelper();
	    lh.savePage(loginSlim);
		return loginSlim.getId();
	}


	@Override
	public int saveUserDetails(NewUserSlim newSlim) {
		// TODO Auto-generated method stub
		
		LoginHelper lh=new LoginHelper();
		lh.saveDetails(newSlim);
		
		return newSlim.getId();
	}


	@Override
	public ArrayList<NewUserSlim> getAllList() {
		
		LoginHelper lh=new LoginHelper();
		ArrayList<NewUserSlim> slimList=lh.listDetails();
		// TODO Auto-generated method stub
		return slimList;
	}


	@Override
	public LoginSlim authenticateUser(String name,String password) {
		// TODO Auto-generated method stub
		LoginHelper lh=new LoginHelper();
	    lh.userAuthenticate(name,password);
		return null;
	}



}
