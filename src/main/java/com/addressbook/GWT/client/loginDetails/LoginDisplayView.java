package com.addressbook.GWT.client.loginDetails;

import com.addressbook.GWT.client.cellTable.Employee;
import com.addressbook.GWT.client.newUser.NewUserSlim;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
public class LoginDisplayView extends Composite {
	
	
	private VerticalPanel mainVpanel;
	private HorizontalPanel hPanel;
	private Button saveBtn,educationBtn,editBtn,fetchdata;
	
	public void initialize() {
		
		mainVpanel=new VerticalPanel();
		hPanel=new HorizontalPanel();
		saveBtn=new Button("Save");
		editBtn=new Button("Edit");
		fetchdata=new Button("Fetch");
				
		educationBtn=new Button("Education");
		initWidget(mainVpanel);
	}
	
	public void setStyle() {
		mainVpanel.setStyleName("mainpanel");
		
		saveBtn.setStyleName("EducationDetails-btn");
		educationBtn.setStyleName("EducationDetails-btn");
		editBtn.setStyleName("EducationDetails-btn");
		
	}

	public void createUI(Employee selected) {
		mainVpanel.add(createField("Name :", selected.getEname()));
		mainVpanel.add(createField("Surname:", selected.geteSurName()));
		mainVpanel.add(createField("City :", selected.getEcity()));
		mainVpanel.add(createField("Country :", selected.getEcountry()));
		hPanel.add(saveBtn);
		hPanel.add(educationBtn);
		hPanel.add(editBtn);
		mainVpanel.add(hPanel);
	
	}

	public void createUI1(NewUserSlim selected) {
		mainVpanel.add(createField("Name :", selected.getName()));
		mainVpanel.add(createField("Surname:", selected.getSurName()));
		mainVpanel.add(createField("City :", selected.getCity()));
		mainVpanel.add(createField("Country :", selected.getCountry()));
		hPanel.add(saveBtn);
		hPanel.add(educationBtn);
		hPanel.add(fetchdata);
		mainVpanel.add(hPanel);
	
	}

	public FlowPanel createField(String fieldname,String fieldValue) {
		FlowPanel flowPanel=new FlowPanel();
		flowPanel.setStylePrimaryName("flowpanel");
		Label field=new Label(fieldname);
		field.setStylePrimaryName("field");
		Label value=new Label(fieldValue);
		value.setStylePrimaryName("value");
		flowPanel.add(field);
		flowPanel.add(value);
		return flowPanel;
	}

	public VerticalPanel getMainVpanel() {
		return mainVpanel;
	}

	public void setMainVpanel(VerticalPanel mainVpanel) {
		this.mainVpanel = mainVpanel;
	}

	public HorizontalPanel gethPanel() {
		return hPanel;
	}

	public void sethPanel(HorizontalPanel hPanel) {
		this.hPanel = hPanel;
	}

	public Button getEditBtn() {
		return editBtn;
	}

	public void setEditBtn(Button editBtn) {
		this.editBtn = editBtn;
	}

	public Button getSaveBtn() {
		return saveBtn;
	}

	public void setSaveBtn(Button saveBtn) {
		this.saveBtn = saveBtn;
	}

	public Button getEducationBtn() {
		return educationBtn;
	}

	public void setEducationBtn(Button educationBtn) {
		this.educationBtn = educationBtn;
	}
	public Button getFetchdata() {
		return fetchdata;
	}

	public void setFetchdata(Button fetchdata) {
		this.fetchdata = fetchdata;
	}

}
