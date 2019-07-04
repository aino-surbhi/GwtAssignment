package com.addressbook.GWT.client.EditView;

import com.addressbook.GWT.client.GwtEventBus;
import com.addressbook.GWT.client.MyDialog;
import com.addressbook.GWT.client.cellTable.Employee;
import com.addressbook.GWT.client.loginDetails.LoginDisplayView;
import com.addressbook.GWT.client.newUser.NewUserSlim;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

@Presenter(view=EditView.class)
public class EditPresenter extends BasePresenter<EditView,GwtEventBus> {

	
	
	public void onGetEditTable(Employee selected) {
		view.createUI(selected);
		eventBus.addEditTable(view);
	}
	
	public void onGetEditTable1(NewUserSlim selected) {
		view.createUI1(selected);
		eventBus.addEditTable(view);
	}
	
	public void bind() {
		
		view.initialize();
		view.setStyle();
		view.getCancelBtn().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				view.getMainVPanel().clear();
				eventBus.getCellTableAgain();
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
       
       view.getUpdateBtn().addClickHandler(new ClickHandler() {
		
		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			Window.alert("hey in update");
		}
	});
      
	}
}
