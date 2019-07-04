package com.addressbook.GWT.client.newUser;

import com.addressbook.GWT.client.loginForm.LoginService;
import com.addressbook.GWT.client.loginForm.LoginServiceAsync;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class NewUserModel {

	public void saveDetails(NewUserSlim newSlim) {
		// TODO Auto-generated method stub
		
		LoginServiceAsync loginAsync = GWT.create(LoginService.class);
	      loginAsync.saveUserDetails(newSlim,new AsyncCallback<Integer>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("user Details Not Saved");
			}

			@Override
			public void onSuccess(Integer result) {
				// TODO Auto-generated method stub
				Window.alert("user Details saved successfully");
			}
	});

  }
}
