package com.addressbook.GWT.client.fetchData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.addressbook.GWT.client.cellTable.CellTableResources;
import com.addressbook.GWT.client.cellTable.Employee;
import com.addressbook.GWT.client.newUser.NewUserSlim;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ImageBundle.Resource;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class fetchCellTableView extends Composite {
	
	private String searchItem;
	private TextBox textBox;
	private Button searchBtn,cancelBtn,tableBtn;
	private CellTable<NewUserSlim> table;
    private List<NewUserSlim> sub;
	private HorizontalPanel hPanel;
    ListDataProvider<NewUserSlim> dataProvider = new ListDataProvider<NewUserSlim>();
    private VerticalPanel vPanel;
	private List<NewUserSlim> list = new ArrayList<NewUserSlim>(Arrays.asList(new NewUserSlim()));
	
	
	 public void initialize() {
		
		textBox=new TextBox();
		searchBtn=new Button("Search");		
		cancelBtn=new Button("Cancel");	
		tableBtn=new Button("Fetch Table");
	    table = new CellTable<NewUserSlim>(10, (CellTable.Resources)GWT.create(CellTableResources.class));
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
		  hPanel.add(cancelBtn);
		  hPanel.add(tableBtn);
		  vPanel.add(hPanel);
          vPanel.add(table);
          getTable().addColumn(nameColumn, "Name");
      
  	      getTable().addColumn(surNameColumn, "SurName");
  	      getTable().addColumn(cityColumn, "City");
  	      getTable().addColumn(countryColumn, "Country");
         
          return vPanel;
	   }
	   

	     TextColumn<NewUserSlim> nameColumn = new TextColumn<NewUserSlim>() {
	      @Override
	      public String getValue(NewUserSlim employee) {
	        return employee.getName();
	      }
	    };

	    // Make the name column sortable.
	    
	    // Create Surname column.
	    TextColumn<NewUserSlim> surNameColumn = new TextColumn<NewUserSlim>() {
	      @Override
	      public String getValue(NewUserSlim employee) {
	        return employee.getSurName();
	      }
	    };
	    
       // Create Cityname column.
	    TextColumn<NewUserSlim> cityColumn = new TextColumn<NewUserSlim>() {
	      @Override
	      public String getValue(NewUserSlim employee) {
	        return employee.getCity();
	      }
	    };
	    
	    
	    // Create Countryname column.
	    TextColumn<NewUserSlim> countryColumn = new TextColumn<NewUserSlim>() {
	      @Override
	      public String getValue(NewUserSlim employee) {
	        return employee.getCountry();
	      }
	    };
	    
	    // Make the Countryname column sortable.
	    
	public TextColumn<NewUserSlim> getNameColumn() {
		return nameColumn;
	}

	public void setNameColumn(TextColumn<NewUserSlim> nameColumn) {
		this.nameColumn = nameColumn;
	}

	public TextColumn<NewUserSlim> getSurNameColumn() {
		return surNameColumn;
	}

	public void setSurNameColumn(TextColumn<NewUserSlim> surNameColumn) {
		this.surNameColumn = surNameColumn;
	}

	public TextColumn<NewUserSlim> getCityColumn() {
		return cityColumn;
	}

	public void setCityColumn(TextColumn<NewUserSlim> cityColumn) {
		this.cityColumn = cityColumn;
	}

	public TextColumn<NewUserSlim> getCountryColumn() {
		return countryColumn;
	}

	public void setCountryColumn(TextColumn<NewUserSlim> countryColumn) {
		this.countryColumn = countryColumn;
	}

	public TextBox getTextBox() {
			return textBox;
		}

		public void setTextBox(TextBox textBox) {
			this.textBox = textBox;
		}

		public Button getTableBtn() {
			return tableBtn;
		}

		public void setTableBtn(Button tableBtn) {
			this.tableBtn = tableBtn;
		}

		public Button getSearchBtn() {
			return searchBtn;
		}

		public void setSearchBtn(Button searchBtn) {
			this.searchBtn = searchBtn;
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

		
		public String getSearchItem() {
			return searchItem;
		}

		public void setSearchItem(String searchItem) {
			this.searchItem = searchItem;
		}
		public Button getCancelBtn() {
			return cancelBtn;
		}

		public void setCancelBtn(Button cancelBtn) {
			this.cancelBtn = cancelBtn;
		}

	    
	    public CellTable<NewUserSlim> getTable() {
			return table;
		}

		public ListDataProvider<NewUserSlim> getDataProvider() {
			return dataProvider;
		}

		public void setDataProvider(ListDataProvider<NewUserSlim> dataProvider) {
			this.dataProvider = dataProvider;
		}

		public void setTable(CellTable<NewUserSlim> table) {
			this.table = table;
		}

		public List<NewUserSlim> getSub() {
			return sub;
		}

		public void setSub(List<NewUserSlim> sub) {
			this.sub = sub;
		}
		public List<NewUserSlim> getList() {
			return list;
		  }
	 
		  public void setList(List<NewUserSlim> list) {
			this.list = list;
		  }

}
