package com.addressbook.GWT.client.educationDetails;

import com.addressbook.GWT.client.GwtEventBus;
import com.addressbook.GWT.client.MyDialog;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

@Presenter(view=EducationDetailsView.class)
public class EducationDetailsPresenter extends BasePresenter<EducationDetailsView, GwtEventBus> {

	public void onGetEducationDetails() {
		view.createUI();
		eventBus.addEducationDetails(view);
	}
	
	public void bind() {
		 super.bind();	
			view.initialize();
			view.setStyle();
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
			view.getCancelBtn().addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					// TODO Auto-generated method stub
					view.getMainVPanel().clear();
					eventBus.getCellTableAgain();
				}
			});
	}
}
