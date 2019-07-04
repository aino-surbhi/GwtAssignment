package com.addressbook.GWT.client.fetchData;
import java.util.List;
import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.addressbook.GWT.client.loginForm.LoginService;
import com.addressbook.GWT.client.loginForm.LoginServiceAsync;
import com.addressbook.GWT.client.newUser.NewUserSlim;


public class fetchCellTableDataModel {
	
	fetchCellTableDataPresenter fetchPresenter;
	LoginServiceAsync loginAsync = GWT.create(LoginService.class);
	
	public void fetchUserData() {
	

		loginAsync.getAllList(new AsyncCallback<ArrayList<NewUserSlim>>() {
		@Override
		public void onSuccess(ArrayList<NewUserSlim> result) {
			// TODO Auto-generated method stub

			Window.alert("fetch data successful");
		}
		
		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
		Window.alert("not fetch");
		}
		
       });	
    }
	
	 public void setPresenter(fetchCellTableDataPresenter fetchPresenter) {
	        this.fetchPresenter=fetchPresenter;

	    }
    }


			
