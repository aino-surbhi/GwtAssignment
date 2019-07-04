package com.addressbook.GWT.client.loginForm;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.addressbook.GWT.client.cellTable.Employee;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
public class LoginFormView extends Composite {

	private VerticalPanel mainVPanel;
	private HorizontalPanel hPanel,passwordHpanel,hPanelBtn;
	private FlowPanel flowPanel1,flowPanel2;
	private Label nameLbl,passwordLbl,labelValid,passwordValid;
	private TextBox nameTbx;
	private PasswordTextBox passwordTbx;
	private Button loginBtn;
	
	public void initialize() {
		mainVPanel =new VerticalPanel();
		hPanel=new HorizontalPanel();
		hPanelBtn=new HorizontalPanel();
		flowPanel1=new FlowPanel();
		flowPanel2=new FlowPanel();
		nameLbl=new Label("UserName:");
		passwordLbl=new Label("PassWord:");
		nameTbx=new TextBox();
		passwordTbx=new PasswordTextBox();
		loginBtn=new Button("Login");
		
		passwordHpanel=new HorizontalPanel();
		labelValid=new Label();
		passwordValid=new Label();
		initWidget(mainVPanel);
	 }
	
	
	public void setStyle() {
	mainVPanel.setStyleName("mainpanel");
	flowPanel1.setStylePrimaryName("flowpanel");
	flowPanel2.setStylePrimaryName("flowpanel");
	hPanel.setStylePrimaryName("hPanel");
	hPanelBtn.setStylePrimaryName("btn");
	
    }
	
	public void createUi() {
		hPanel.add(nameLbl);
		hPanel.add(nameTbx);
		hPanel.add(labelValid);
		passwordHpanel.add(passwordLbl);
		passwordHpanel.add(passwordTbx);
		passwordHpanel.add(passwordValid);
		
		hPanelBtn.add(loginBtn);
	
		flowPanel1.add(hPanel);
		flowPanel2.add(passwordHpanel);
		mainVPanel.add(flowPanel1);
		mainVPanel.add(flowPanel2);
		mainVPanel.add(hPanelBtn);
		
	}

	public Label getLabelValid() {
		return labelValid;
	}

	public void setLabelValid(Label labelValid) {
		this.labelValid = labelValid;
	}

	public Label getPasswordValid() {
		return passwordValid;
	}

	public void setPasswordValid(Label passwordValid) {
		this.passwordValid = passwordValid;
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

	public Label getNameLbl() {
		return nameLbl;
	}

	public void setNameLbl(Label nameLbl) {
		this.nameLbl = nameLbl;
	}

	public Label getPasswordLbl() {
		return passwordLbl;
	}

	public void setPasswordLbl(Label passwordLbl) {
		this.passwordLbl = passwordLbl;
	}

	public TextBox getNameTbx() {
		return nameTbx;
	}

	public void setNameTbx(TextBox nameTbx) {
		this.nameTbx = nameTbx;
	}

	public PasswordTextBox getPasswordTbx() {
		return passwordTbx;
	}

	public void setPasswordTbx(PasswordTextBox passwordTbx) {
		this.passwordTbx = passwordTbx;
	}

	public Button getLoginBtn() {
		return loginBtn;
	}

	public void setLoginBtn(Button loginBtn) {
		this.loginBtn = loginBtn;
	}
}
