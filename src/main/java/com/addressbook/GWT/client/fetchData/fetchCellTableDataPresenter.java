package com.addressbook.GWT.client.fetchData;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.addressbook.GWT.client.GwtEventBus;
import com.addressbook.GWT.client.cellTable.CellTableView;
import com.addressbook.GWT.client.cellTable.Employee;
import com.addressbook.GWT.client.loginForm.LoginService;

import com.addressbook.GWT.client.newUser.NewUserSlim;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;
import com.addressbook.GWT.client.loginForm.LoginServiceAsync;

@Presenter(view=fetchCellTableView.class)
public class fetchCellTableDataPresenter extends BasePresenter<fetchCellTableView,GwtEventBus>{
  
	
	fetchCellTableDataModel model;
	List<NewUserSlim> list;
	NewUserSlim selected;
	ListDataProvider<NewUserSlim> dataProvider = new ListDataProvider<NewUserSlim>();
	
	public void onGetfetchdata() {
		view.createUi();
		eventBus.addfetchdata(view);
	}
	public void onFetchData(fetchCellTableView view) {
		 this.view.getvPanel().clear();
    	 this.view.getvPanel().add(view);
	}
	
	public void onGetSortTableData(ArrayList<NewUserSlim> result) {
		
		   dataProvider.getList().clear();
           list = dataProvider.getList();
           for (NewUserSlim contact : result) {
             list.add(contact);
           }
            view.getNameColumn().setSortable(true);
		    view.getSurNameColumn().setSortable(true);
		
		    view.getCityColumn().setSortable(true);
		    view.getCountryColumn().setSortable(true);
		 
		 
		 
  	     ListHandler<NewUserSlim> columnSortHandler = new ListHandler<NewUserSlim>(
			        list);
			    columnSortHandler.setComparator(view.getNameColumn(),
			        new Comparator<NewUserSlim>() {
			          public int compare(NewUserSlim o1, NewUserSlim o2) {
			            if (o1 == o2) {
			              return 0;
			            }

			            // Compare the name columns.
			            if (o1 != null) {
			              return (o2 != null) ? o1.getName().compareTo(o2.getName()) : 1;
			            }
			            return -1;
			          }
			        });
			    view.getTable().addColumnSortHandler(columnSortHandler);

			    // We know that the data is sorted alphabetically by default.
			    view.getTable().getColumnSortList().push(view.getNameColumn());

			    
			    
			    
			 columnSortHandler.setComparator(view.getSurNameColumn(),
		        new Comparator<NewUserSlim>() {
		          public int compare(NewUserSlim o1, NewUserSlim o2) {
		            if (o1 == o2) {
		              return 0;
		            }
		            
		            // Compare the name columns.
		            if (o1 != null) {
		              return (o2 != null) ? o1.getSurName().compareTo(o2.getSurName()) : 1;
		            }
		            return -1;
		          }
		        });
	    view.getTable().addColumnSortHandler(columnSortHandler);

		    // We know that the data is sorted alphabetically by default.
	    view.getTable().getColumnSortList().push(view.getSurNameColumn());
	    
		    columnSortHandler.setComparator(view.getCityColumn(),
			        new Comparator<NewUserSlim>() {
			          public int compare(NewUserSlim o1, NewUserSlim o2) {
			            if (o1 == o2) {
			              return 0;
			            }

			            // Compare the name columns.
			            if (o1 != null) {
			              return (o2 != null) ? o1.getCity().compareTo(o2.getCity()) : 1;
			            }
			            return -1;
			          }
			        });
		    view.getTable().addColumnSortHandler(columnSortHandler);

			    // We know that the data is sorted alphabetically by default.
		    view.getTable().getColumnSortList().push(view.getCityColumn());
		    
	    
			    
			    columnSortHandler.setComparator(view.getCountryColumn(),
				        new Comparator<NewUserSlim>() {
				          public int compare(NewUserSlim o1, NewUserSlim o2) {
				            if (o1 == o2) {
				              return 0;
				            }

				            // Compare the name columns.
				            if (o1 != null) {
				              return (o2 != null) ? o1.getCountry().compareTo(o2.getCountry()) : 1;
				            }
				            return -1;
				          }
				        });
			    view.getTable().addColumnSortHandler(columnSortHandler);

				    // We know that the data is sorted alphabetically by default.
			    view.getTable().getColumnSortList().push(view.getCountryColumn());
			    dataProvider.addDataDisplay(view.getTable());
	}
	
	public void bind() {
		view.initialize();
		view.setStyle();
		
		model=new fetchCellTableDataModel();
		model.setPresenter(this);
		    
		
		view.getCancelBtn().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				view.getvPanel().clear();
				eventBus.getCellTableAgain();
			}
		});
			 
		view.getTableBtn().addClickHandler(new ClickHandler() {
			
		
			 @Override
	            public void onClick(ClickEvent event) {

	                
				 LoginServiceAsync loginAsync = GWT.create(LoginService.class);
	                loginAsync.getAllList(new AsyncCallback<ArrayList<NewUserSlim>>() {

	                    @Override
	                    public void onSuccess(ArrayList<NewUserSlim> result) {
	                    	
	                    	eventBus.getSortTableData(result);
	                        Window.alert("Success");

	                    }
	                    @Override
	                    public void onFailure(Throwable caught) {
	                        Window.alert("Try again");

	                    }
	                });
	            }
	        });
		
		 SingleSelectionModel<NewUserSlim> selectionModel = new SingleSelectionModel<NewUserSlim>();
         view.getTable().setSelectionModel(selectionModel);
         
          selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
            public void onSelectionChange(SelectionChangeEvent event) {
          	  selected = selectionModel.getSelectedObject();
          	  eventBus.userDetailFetch(selected);
            }
          });
          
          
	}
}
