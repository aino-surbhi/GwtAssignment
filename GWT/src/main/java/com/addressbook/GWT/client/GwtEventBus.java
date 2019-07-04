package com.addressbook.GWT.client;

import java.util.ArrayList;

import com.addressbook.GWT.client.EditView.EditPresenter;
import com.addressbook.GWT.client.EditView.EditView;
import com.addressbook.GWT.client.cellTable.CellTablePresenter;
import com.addressbook.GWT.client.cellTable.CellTableView;
import com.addressbook.GWT.client.cellTable.Employee;
import com.addressbook.GWT.client.educationDetails.EducationDetailsPresenter;
import com.addressbook.GWT.client.educationDetails.EducationDetailsView;
import com.addressbook.GWT.client.fetchData.fetchCellTableDataPresenter;
import com.addressbook.GWT.client.fetchData.fetchCellTableView;
import com.addressbook.GWT.client.loginDetails.LoginDisplayPresenter;
import com.addressbook.GWT.client.loginDetails.LoginDisplayView;
import com.addressbook.GWT.client.loginForm.LoginFormPresenter;
import com.addressbook.GWT.client.newUser.NewUserPresenter;
import com.addressbook.GWT.client.newUser.NewUserSlim;
import com.addressbook.GWT.client.newUser.NewUserView;
import com.google.gwt.user.client.ui.FlexTable;
import com.mvp4g.client.annotation.Event;
import com.mvp4g.client.annotation.Events;
import com.mvp4g.client.annotation.Start;
import com.mvp4g.client.event.EventBusWithLookup;

@Events(startPresenter=LoginFormPresenter.class)
public interface GwtEventBus extends EventBusWithLookup{
	
	@Start
	@Event(handlers=LoginFormPresenter.class)
	public void getAddressView();
    
	@Event(handlers=LoginFormPresenter.class)
	public void addCellTable(CellTableView view);
	
	@Event(handlers=LoginDisplayPresenter.class)
	public void userDetailView(Employee selected);
	
	@Event(handlers=CellTablePresenter.class)
	public void addUserDetailsView(LoginDisplayView view);
    
	@Event(handlers=EducationDetailsPresenter.class)
	public void getEducationDetails();
	
	@Event(handlers=LoginDisplayPresenter.class)
	public void addEducationDetails(EducationDetailsView view);
	
	@Event(handlers=CellTablePresenter.class)
	public void getCellTable();
	
	@Event(handlers=EditPresenter.class)
	public void getEditTable(Employee selected);
	
	@Event(handlers=LoginDisplayPresenter.class)
	public void addEditTable(EditView view);
	
	@Event(handlers=CellTablePresenter.class)
	public void getCellTableAgain();
	
	@Event(handlers=NewUserPresenter.class)
	public void getNewUser();
	
	@Event(handlers=CellTablePresenter.class)
	public void addNewUser(NewUserView view);
	
	@Event(handlers=fetchCellTableDataPresenter.class)
	public void getfetchdata();
	
	@Event(handlers=CellTablePresenter.class)
	public void addfetchdata(fetchCellTableView view);
	
	@Event(handlers=fetchCellTableDataPresenter.class)
	public void fetchData(fetchCellTableView view);
	
	@Event(handlers=LoginDisplayPresenter.class)
	public void userDetailFetch(NewUserSlim selected);
	
	@Event(handlers=EditPresenter.class)
	public void getEditTable1(NewUserSlim selected);
	
	@Event(handlers=fetchCellTableDataPresenter.class)
	public void getSortTableData(ArrayList<NewUserSlim> result);
}
