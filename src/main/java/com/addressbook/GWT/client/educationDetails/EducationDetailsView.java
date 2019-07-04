package com.addressbook.GWT.client.educationDetails;

import com.addressbook.GWT.client.cellTable.Employee;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class EducationDetailsView extends Composite{
	
	
	private VerticalPanel mainVPanel;
	private HorizontalPanel hPanel;
	private Button saveBtn,cancelBtn,updateBtn;
	
	public void initialize() {
		
		mainVPanel= new VerticalPanel();
		hPanel=new HorizontalPanel();
		saveBtn=new Button("save");
		cancelBtn=new Button("Cancel");
		updateBtn=new Button("update");
		TextBox value=new TextBox();
		initWidget(mainVPanel);
	}
	
	public void setStyle() {
		saveBtn.setStyleName("EducationDetails-btn");
		updateBtn.setStyleName("EducationDetails-btn");
		cancelBtn.setStyleName("EducationDetails-btn");
	}
	
	public void createUI() {

		mainVPanel.add(createField("English:",""));
		mainVPanel.add(createField("Maths:", ""));
		mainVPanel.add(createField("Science:", ""));
		mainVPanel.add(createField("Percentage :", ""));
		
		hPanel.add(cancelBtn);
		hPanel.add(updateBtn);
		hPanel.add(saveBtn);
		mainVPanel.add(hPanel);
	}
	
	public FlowPanel createField(String fieldName,String fieldValue) {
	
	FlowPanel flowPanel=new FlowPanel();
	flowPanel.setStylePrimaryName("flowpanel");
	Label field=new Label(fieldName);
	field.setStylePrimaryName("field");
	TextBox value=new TextBox();
	value.setText(fieldValue);
	value.setStylePrimaryName("value");
	flowPanel.add(field);
	flowPanel.add(value);
	return flowPanel;
	
   }
	public VerticalPanel getMainVPanel() {
		return mainVPanel;
	}

	public void setMainVPanel(VerticalPanel mainVPanel) {
		this.mainVPanel = mainVPanel;
	}

	public HorizontalPanel gethPanel() {
		return hPanel;
	}

	public void sethPanel(HorizontalPanel hPanel) {
		this.hPanel = hPanel;
	}

	public Button getSaveBtn() {
		return saveBtn;
	}

	public void setSaveBtn(Button saveBtn) {
		this.saveBtn = saveBtn;
	}

	public Button getCancelBtn() {
		return cancelBtn;
	}

	public void setCancelBtn(Button cancelBtn) {
		this.cancelBtn = cancelBtn;
	}

	public Button getUpdateBtn() {
		return updateBtn;
	}

	public void setUpdateBtn(Button updateBtn) {
		this.updateBtn = updateBtn;
	}

}
