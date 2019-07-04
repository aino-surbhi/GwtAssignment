package com.addressbook.GWT.client.newUser;

import com.addressbook.GWT.client.GwtEventBus;
import com.addressbook.GWT.client.loginForm.LoginFormModel;
import com.addressbook.GWT.client.loginForm.LoginFormView;
import com.addressbook.GWT.client.loginForm.LoginSlim;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

@Presenter(view=NewUserView.class)
public class NewUserPresenter extends BasePresenter<NewUserView, GwtEventBus> {

	
	
	public void onGetNewUser() {
	    view.createUi();
		eventBus.addNewUser(view);
	}
	
	public void bind() {
		view.initialize();
		view.setStyle();
		view.createUi();
		
		view.getSaveBtn().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				NewUserModel model=new NewUserModel();
				NewUserSlim newSlim=new NewUserSlim();
				newSlim.setName(view.getNameTbx().getText());
				newSlim.setSurName(view.getSurNameTbx().getText());
				newSlim.setCity(view.getCityTbx().getText());
				newSlim.setCountry(view.getCountryTbx().getText());
				
		        model.saveDetails(newSlim);
			}
		});
		view.getCancelBtn().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				view.getMainVPanel().clear();
				eventBus.getCellTable();
			}
		});
	}
}
