package com.addressbook.GWT.client.loginForm;

import com.addressbook.GWT.server.Login;
import com.addressbook.GWT.server.LoginServiceImpl;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class LoginFormModel {
	
       public void saveName(LoginSlim loginSlim) {
		
	      LoginServiceAsync loginAsync = GWT.create(LoginService.class);
	      loginAsync.loginPage(loginSlim,new AsyncCallback<Integer>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("Details");
			}

			@Override
			public void onSuccess(Integer result) {
				// TODO Auto-generated method stub
				Window.alert("Details added succesfully");
			}		
			
	     });
       }
}
