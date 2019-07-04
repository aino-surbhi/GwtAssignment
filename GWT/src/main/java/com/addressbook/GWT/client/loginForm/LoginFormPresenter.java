package com.addressbook.GWT.client.loginForm;


import java.io.Console;

import com.addressbook.GWT.client.GwtEventBus;
import com.addressbook.GWT.client.cellTable.CellTableView;
import com.addressbook.GWT.client.fetchData.fetchCellTableView;
import com.addressbook.GWT.client.loginDetails.LoginDisplayView;
import com.addressbook.GWT.client.newUser.NewUserView;
import com.addressbook.GWT.server.Login;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

@Presenter(view=LoginFormView.class)
public class LoginFormPresenter extends BasePresenter<LoginFormView, GwtEventBus> {

     public void onGetAddressView(){
			view.createUi();			
		}
 
     public void onAddCellTable(CellTableView view) {
    	 this.view.getMainVPanel().clear();
    	 this.view.getMainVPanel().add(view);
    	 
     }
	
  @Override
        public void bind() {
        super.bind();	
		view.initialize();
		view.setStyle();
		
		view.getLoginBtn().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				
				
				if(view.getNameTbx().getText().isEmpty()){
					System.out.println("Name Should not be empty");
					view.getLabelValid().setText("Name should not be empty");	
					view.getLoginBtn().setEnabled(false);
				}
				else if(view.getPasswordTbx().getText().isEmpty()){
					view.getPasswordValid().setText("Password should not be empty");
					view.getLoginBtn().setEnabled(false);
				}
				else {
					
					LoginFormModel model=new LoginFormModel();
					LoginSlim loginSlim=new LoginSlim();
					loginSlim.setUserName(view.getNameTbx().getText());
					loginSlim.setPassword(view.getPasswordTbx().getText());
					
			        model.saveName(loginSlim);
					eventBus.getCellTable();
				}
			}
		});
		
		view.getNameTbx().addBlurHandler(new BlurHandler() {
			
			@Override
			public void onBlur(BlurEvent event) {
				// TODO Auto-generated method stub
				if(view.getNameTbx().getText().isEmpty()){
					System.out.println("Name Should not be empty");
					view.getLabelValid().setText("Name should not be empty");	
					view.getLoginBtn().setEnabled(false);
				}
				else {
					view.getLabelValid().setText("");
					view.getLoginBtn().setEnabled(true);
				}
			}
			
		});
		view.getPasswordTbx().addBlurHandler(new BlurHandler() {
			
			@Override
			public void onBlur(BlurEvent event) {
				// TODO Auto-generated method stub
				if(view.getPasswordTbx().getText().isEmpty()){
					view.getPasswordValid().setText("Password should not be empty");
					view.getLoginBtn().setEnabled(false);
				}
				else {
					view.getPasswordValid().setText("");
					view.getLoginBtn().setEnabled(true);
					
				}
			}
		});
  }
     
}
