package com.addressbook.GWT.client.newUser;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class NewUserView extends Composite{
	
	private VerticalPanel mainVPanel;
	private HorizontalPanel hPanelName,hpanelSName,hPanelCity,hPanelCountry,hPanelBtn;
	private FlowPanel flowPanel1,flowPanel2,flowPanel3,flowPanel4;
	private Label nameLbl,surNameLbl,cityLbl,countryLbl,labelValid1,labelValid2,labelValid3,labelValid4;
	private TextBox nameTbx,surNameTbx,cityTbx,countryTbx;
	
	private Button saveBtn,cancelBtn;
	
	public void initialize() {
		mainVPanel =new VerticalPanel();
		hPanelName=new HorizontalPanel();
		hpanelSName=new HorizontalPanel();
		hPanelCity=new HorizontalPanel();
		hPanelCountry=new HorizontalPanel();
		
		hPanelBtn=new HorizontalPanel();
		flowPanel1=new FlowPanel();
		flowPanel2=new FlowPanel();
		flowPanel3=new FlowPanel();
		flowPanel4=new FlowPanel();
		nameLbl=new Label("Name:");
		surNameLbl=new Label("SurName:");
		cityLbl=new Label("City:");
		countryLbl=new Label("Country:");
		nameTbx=new TextBox();
		surNameTbx=new TextBox();
		cityTbx=new TextBox();
		countryTbx=new TextBox();
		cancelBtn=new Button("cancel");
		saveBtn=new Button("Save");
	
		labelValid1=new Label();
		labelValid2=new Label();
		labelValid3=new Label();
		labelValid4=new Label();
		
		initWidget(mainVPanel);
	 }
	
	
	public Button getSaveBtn() {
		return saveBtn;
	}


	public void setSaveBtn(Button saveBtn) {
		this.saveBtn = saveBtn;
	}


	public void setStyle() {
	//mainVPanel.setStyleName("mainpanel");
	flowPanel1.setStylePrimaryName("flowpanel");
	flowPanel2.setStylePrimaryName("flowpanel");
	flowPanel3.setStylePrimaryName("flowpanel");
	flowPanel4.setStylePrimaryName("flowpanel");
	hPanelName.setStylePrimaryName("hPanel");
	hpanelSName.setStylePrimaryName("hPanel");
	hPanelCity.setStylePrimaryName("hPanel");
	hPanelCountry.setStylePrimaryName("hPanel");
	hPanelBtn.setStylePrimaryName("btn");
	//loginBtn.setStyleName("btn");
    }
	
	public void createUi() {
		hPanelName.add(nameLbl);
		hPanelName.add(nameTbx);
		hPanelName.add(labelValid1);
		hpanelSName.add(surNameLbl);
		hpanelSName.add(surNameTbx);
		hpanelSName.add(labelValid2);
		hPanelCity.add(cityLbl);
		hPanelCity.add(cityTbx);
		hPanelCity.add(labelValid3);
		hPanelCountry.add(countryLbl);
		hPanelCountry.add(countryTbx);
		hPanelCountry.add(labelValid4);
		hPanelBtn.add(saveBtn);
		hPanelBtn.add(cancelBtn);
		flowPanel1.add(hPanelName);
		flowPanel2.add(hpanelSName);
		flowPanel3.add(hPanelCity);
		flowPanel4.add(hPanelCountry);
		mainVPanel.add(flowPanel1);
		mainVPanel.add(flowPanel2);
		mainVPanel.add(flowPanel3);
		mainVPanel.add(flowPanel4);
		mainVPanel.add(hPanelBtn);
		
	}


	public VerticalPanel getMainVPanel() {
		return mainVPanel;
	}


	public void setMainVPanel(VerticalPanel mainVPanel) {
		this.mainVPanel = mainVPanel;
	}


	public HorizontalPanel gethPanelName() {
		return hPanelName;
	}


	public void sethPanelName(HorizontalPanel hPanelName) {
		this.hPanelName = hPanelName;
	}


	public HorizontalPanel getHpanelSName() {
		return hpanelSName;
	}


	public void setHpanelSName(HorizontalPanel hpanelSName) {
		this.hpanelSName = hpanelSName;
	}


	public HorizontalPanel gethPanelCity() {
		return hPanelCity;
	}


	public void sethPanelCity(HorizontalPanel hPanelCity) {
		this.hPanelCity = hPanelCity;
	}


	public HorizontalPanel gethPanelCountry() {
		return hPanelCountry;
	}


	public void sethPanelCountry(HorizontalPanel hPanelCountry) {
		this.hPanelCountry = hPanelCountry;
	}


	public HorizontalPanel gethPanelBtn() {
		return hPanelBtn;
	}


	public void sethPanelBtn(HorizontalPanel hPanelBtn) {
		this.hPanelBtn = hPanelBtn;
	}


	public FlowPanel getFlowPanel1() {
		return flowPanel1;
	}


	public void setFlowPanel1(FlowPanel flowPanel1) {
		this.flowPanel1 = flowPanel1;
	}


	public FlowPanel getFlowPanel2() {
		return flowPanel2;
	}


	public void setFlowPanel2(FlowPanel flowPanel2) {
		this.flowPanel2 = flowPanel2;
	}


	public FlowPanel getFlowPanel3() {
		return flowPanel3;
	}


	public void setFlowPanel3(FlowPanel flowPanel3) {
		this.flowPanel3 = flowPanel3;
	}


	public FlowPanel getFlowPanel4() {
		return flowPanel4;
	}


	public void setFlowPanel4(FlowPanel flowPanel4) {
		this.flowPanel4 = flowPanel4;
	}


	public Label getNameLbl() {
		return nameLbl;
	}


	public void setNameLbl(Label nameLbl) {
		this.nameLbl = nameLbl;
	}


	public Label getSurNameLbl() {
		return surNameLbl;
	}


	public void setSurNameLbl(Label surNameLbl) {
		this.surNameLbl = surNameLbl;
	}


	public Label getCityLbl() {
		return cityLbl;
	}


	public void setCityLbl(Label cityLbl) {
		this.cityLbl = cityLbl;
	}


	public Label getCountryLbl() {
		return countryLbl;
	}


	public void setCountryLbl(Label countryLbl) {
		this.countryLbl = countryLbl;
	}


	public Label getLabelValid1() {
		return labelValid1;
	}


	public void setLabelValid1(Label labelValid1) {
		this.labelValid1 = labelValid1;
	}


	public Label getLabelValid2() {
		return labelValid2;
	}


	public void setLabelValid2(Label labelValid2) {
		this.labelValid2 = labelValid2;
	}


	public Label getLabelValid3() {
		return labelValid3;
	}


	public void setLabelValid3(Label labelValid3) {
		this.labelValid3 = labelValid3;
	}


	public Label getLabelValid4() {
		return labelValid4;
	}


	public void setLabelValid4(Label labelValid4) {
		this.labelValid4 = labelValid4;
	}


	public TextBox getNameTbx() {
		return nameTbx;
	}


	public void setNameTbx(TextBox nameTbx) {
		this.nameTbx = nameTbx;
	}


	public TextBox getSurNameTbx() {
		return surNameTbx;
	}


	public void setSurNameTbx(TextBox surNameTbx) {
		this.surNameTbx = surNameTbx;
	}


	public TextBox getCityTbx() {
		return cityTbx;
	}


	public void setCityTbx(TextBox cityTbx) {
		this.cityTbx = cityTbx;
	}


	public TextBox getCountryTbx() {
		return countryTbx;
	}


	public void setCountryTbx(TextBox countryTbx) {
		this.countryTbx = countryTbx;
	}


	public Button getCancelBtn() {
		return cancelBtn;
	}


	public void setCancelBtn(Button cancelBtn) {
		this.cancelBtn = cancelBtn;
	}

}
