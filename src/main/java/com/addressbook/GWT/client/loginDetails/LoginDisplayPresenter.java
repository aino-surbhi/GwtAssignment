package com.addressbook.GWT.client.loginDetails;

import com.addressbook.GWT.client.GwtEventBus;
import com.addressbook.GWT.client.MyDialog;
import com.addressbook.GWT.client.EditView.EditView;
import com.addressbook.GWT.client.cellTable.Employee;
import com.addressbook.GWT.client.educationDetails.EducationDetailsView;
import com.addressbook.GWT.client.newUser.NewUserSlim;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;


@Presenter(view=LoginDisplayView.class)
public class LoginDisplayPresenter extends BasePresenter<LoginDisplayView,GwtEventBus>  {
	NewUserSlim select1;
   Employee select;
	public void onUserDetailView(Employee selected) {
		select=selected;
		view.createUI(selected);
		eventBus.addUserDetailsView(view);
         
	}
	public void onUserDetailFetch(NewUserSlim selected) {
		select1=selected;
		view.createUI1(selected);
		eventBus.addUserDetailsView(view);
         
	}
	
	public void onAddEducationDetails(EducationDetailsView view) {
		this.view.getMainVpanel().clear();
		this.view.getMainVpanel().add(view);
		
	}
	
	public void onAddEditTable(EditView view) {
		this.view.getMainVpanel().clear();
		this.view.getMainVpanel().add(view);
	}
	
	@Override
	public void bind() {
		// TODO Auto-generated method stub
		super.bind();
		view.initialize();

		view.getEducationBtn().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				eventBus.getEducationDetails();
			}
		});
        view.getEditBtn().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				eventBus.getEditTable(select);
			}
		});
        
        view.getFetchdata().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				eventBus.getEditTable1(select1);
			}
		});
        view.getSaveBtn().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				MyDialog myDialog = new MyDialog();

	            int left = Window.getClientWidth()/ 2;
	            int top = Window.getClientHeight()/ 2;
	            myDialog.setPopupPosition(left, top);
	            myDialog.show();		
			
			}
		});
	}
}
