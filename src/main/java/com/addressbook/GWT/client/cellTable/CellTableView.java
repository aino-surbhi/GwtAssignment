package com.addressbook.GWT.client.cellTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.addressbook.GWT.client.newUser.NewUserSlim;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ImageBundle.Resource;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class CellTableView extends Composite {
	
	private String searchItem;
	private TextBox textBox;
	private Button searchBtn,addBtn,fetchData,resetBtn;
    private CellTable<Employee> table;
    private List<Employee> sub;
    private VerticalPanel vPanel;
    private HorizontalPanel hPanel;
    CellTablePresenter cp=new CellTablePresenter();
    private List<Employee> emp=Arrays.asList(
			new Employee("Surbhi","upadhyay","pune","india"),
			new Employee("Shree","Upadhyay","Mumbai","india"),
			new Employee("Nandita","Shakya","pune","india"),
			new Employee("Nandu","Sanap","Nasik","uk"),
			new Employee("Vinay","Revar","pune","india"),
			new Employee("Surbhi","upadhyay","pune","india"));
	
	public void initialize() {
		
		textBox=new TextBox();
		searchBtn=new Button("Search");		
		addBtn=new Button("Add user");		
		fetchData=new Button("Fetch Data");
		resetBtn=new Button("Reset Data");
	    table = new CellTable<Employee>(10, (CellTable.Resources)GWT.create(CellTableResources.class));
		vPanel=new VerticalPanel();
	    hPanel=new HorizontalPanel();
	    initWidget(vPanel);
	  }
	
	  public void setStyle() {
			hPanel.setSpacing(30);
		}
	   public Widget createUi() {
		  hPanel.add(textBox);
		  hPanel.add(searchBtn);
		  hPanel.add(addBtn);
		  hPanel.add(fetchData);
		  hPanel.add(resetBtn);
		  vPanel.add(hPanel);
          vPanel.add(table);
          return vPanel;
	   }
	   
	   
	   
	   
	public Button getResetBtn() {
		return resetBtn;
	}

	public void setResetBtn(Button resetBtn) {
		this.resetBtn = resetBtn;
	}

	public Button getFetchData() {
		return fetchData;
	}

	public void setFetchData(Button fetchData) {
		this.fetchData = fetchData;
	}

	public Button getAddBtn() {
		return addBtn;
	}

	public void setAddBtn(Button addBtn) {
		this.addBtn = addBtn;
	}

	public TextBox getTextBox() {
			return textBox;
		}

		public void setTextBox(TextBox textBox) {
			this.textBox = textBox;
		}

		public Button getSearchBtn() {
			return searchBtn;
		}

		public void setSearchBtn(Button searchBtn) {
			this.searchBtn = searchBtn;
		}

		public CellTable<Employee> getTable() {
			return table;
		}

		public void setTable(CellTable<Employee> table) {
			this.table = table;
		}

		public VerticalPanel getvPanel() {
			return vPanel;
			
		}

		public void setvPanel(VerticalPanel vPanel) {
			this.vPanel = vPanel;
		}

		public HorizontalPanel gethPanel() {
			return hPanel;
		}

		public void sethPanel(HorizontalPanel hPanel) {
			this.hPanel = hPanel;
		}

		public List<Employee> getEmp() {
			return emp;
		}

		public void setEmp(List<Employee> emp) {
			this.emp = emp;
		}
		public String getSearchItem() {
			return searchItem;
		}

		public void setSearchItem(String searchItem) {
			this.searchItem = searchItem;
		}

		public List<Employee> getSub() {
			return sub;
		}

		public void setSub(List<Employee> sub) {
			this.sub = sub;
		}
}
