package com.addressbook.GWT.client.loginForm;

import java.util.ArrayList;

import com.addressbook.GWT.client.cellTable.Employee;
import com.addressbook.GWT.client.newUser.NewUserSlim;
import com.addressbook.GWT.server.Login;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("greet")
public interface LoginService extends RemoteService {

	
	 String greetServer(String name) throws IllegalArgumentException;
	 
	 public int loginPage(LoginSlim login);
	 
	 public int saveUserDetails(NewUserSlim newSlim);
	 
	 public ArrayList<NewUserSlim>getAllList();
	 public LoginSlim authenticateUser(String name,String password);  

}
