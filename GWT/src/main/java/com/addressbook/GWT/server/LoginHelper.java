package com.addressbook.GWT.server;

import java.util.ArrayList;

import com.addressbook.GWT.client.loginForm.LoginSlim;
import com.addressbook.GWT.client.newUser.NewUserSlim;
import com.google.gwt.user.client.Window;

public class LoginHelper {

	public void savePage(LoginSlim loginSlim) {
		// TODO Auto-generated method stub
		LoginDao ld=new LoginDao();
		LoginHelper lh=new LoginHelper();
		Login login=lh.convertSlimToPojo(loginSlim);
		ld.savePage(login);
	}
	
	public Login convertSlimToPojo(LoginSlim login) {
		Login pojo=new Login();
		pojo.setUserName(login.getUserName());
		pojo.setPassword(login.getPassword());
		return pojo;
	}
	
	public LoginSlim convertPojoToSlim(Login login) {

		LoginSlim slim=new LoginSlim();
		slim.setUserName(login.getUserName());
		slim.setPassword(login.getPassword());
		return slim;
	}
	
	public NewUserPojo convertSlimToPojo1(NewUserSlim newSlim) {
		NewUserPojo  pojo=new NewUserPojo ();
		pojo.setName(newSlim.getName());
		pojo.setSurName(newSlim.getSurName());
		pojo.setCity(newSlim.getCity());
		pojo.setCountry(newSlim.getCountry());
		return pojo;
	}
	
	
	
	public NewUserSlim convertPojoToSlim1(NewUserPojo newPojo) {

		NewUserSlim slim=new NewUserSlim();
		slim.setName(newPojo.getName());
		slim.setSurName(newPojo.getSurName());
		slim.setCity(newPojo.getCity());
		slim.setCountry(newPojo.getCountry());
	
		return slim;
	}
	/*
	 * Convert Address to Address Slim when we retrieve records from database i.e. while reading data from the database.
	 */
	

	public void saveDetails(NewUserSlim newSlim) {
		// TODO Auto-generated method stub
		NewUserDao ld=new NewUserDao();
		LoginHelper lh=new LoginHelper();
		NewUserPojo newPojo=lh.convertSlimToPojo1(newSlim);
		ld.saveUserDetails(newPojo);
	}

	public ArrayList<NewUserSlim> listDetails() {
		// TODO Auto-generated method stub
		NewUserDao newUdao=new NewUserDao();
		LoginHelper lh=new LoginHelper();
		ArrayList<NewUserPojo> newList=newUdao.listDetails();
		ArrayList<NewUserSlim> slimList=new ArrayList<NewUserSlim>();
		for(NewUserPojo pojo:newList) {
			NewUserSlim newSlim=lh.convertPojoToSlim1(pojo);
			slimList.add(newSlim);
		}
		return slimList;
	}

	public void userAuthenticate(String name,String password) {
		// TODO Auto-generated method stub
		LoginDao ld=new LoginDao();
         ld.userAuthentication(name, password);
	}	
}
