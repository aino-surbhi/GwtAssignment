package com.addressbook.GWT.client.cellTable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.addressbook.GWT.client.GwtEventBus;
import com.addressbook.GWT.client.fetchData.fetchCellTableView;
import com.addressbook.GWT.client.loginDetails.LoginDisplayView;
import com.addressbook.GWT.client.newUser.NewUserSlim;
import com.addressbook.GWT.client.newUser.NewUserView;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.AsyncDataProvider;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.HasRows;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.Range;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

@Presenter(view=CellTableView.class)
public class CellTablePresenter extends BasePresenter<CellTableView,GwtEventBus> {
	 Employee selected;
	 ListDataProvider<Employee> dataProvider = new ListDataProvider<Employee>();
	 List<Employee> list;
		public void onGetCellTable() {
			view.createUi();
			eventBus.addCellTable(view);
		}
		
		public void onAddUserDetailsView(LoginDisplayView view) {
	    	this.view.getvPanel().clear();
	    	this.view.getvPanel().add(view);
	    	 
	     }
		public void onAddNewUser(NewUserView view) {
			this.view.getvPanel().clear();
	    	this.view.getvPanel().add(view);
		}
		
		public void onGetCellTableAgain() {
			
	       view.getvPanel().add(view.createUi());
		}
		
		public void onAddfetchdata(fetchCellTableView view) {
	    	 this.view.getvPanel().clear();
	    	 this.view.getvPanel().add(view);
	     }
		@Override
		public void bind() {
			
			super.bind();
			view.initialize();
			view.setStyle();
			
			
			view.getFetchData().addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					// TODO Auto-generated method stub
					eventBus.getfetchdata();
				}
			});
			
			view.getAddBtn().addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					// TODO Auto-generated method stub
					eventBus.getNewUser();
				}
			});
		
			 // Create name column.
		    TextColumn<Employee> nameColumn = new TextColumn<Employee>() {
		      @Override
		      public String getValue(Employee employee) {
		        return employee.getEname();
		      }
		    };

		    // Make the name column sortable.
		    nameColumn.setSortable(true);

		    // Create Surname column.
		    TextColumn<Employee> surNameColumn = new TextColumn<Employee>() {
		      @Override
		      public String getValue(Employee employee) {
		        return employee.geteSurName();
		      }
		    };
		    
		    // Make the Surname column sortable.
	        surNameColumn.setSortable(true);
	        
	        
	        
	        // Create Cityname column.
		    TextColumn<Employee> cityColumn = new TextColumn<Employee>() {
		      @Override
		      public String getValue(Employee employee) {
		        return employee.getEcity();
		      }
		    };
		    
		    // Make the Cityname column sortable.
		    cityColumn.setSortable(true);
	        
	        
		    
		    // Create Countryname column.
		    TextColumn<Employee> countryColumn = new TextColumn<Employee>() {
		      @Override
		      public String getValue(Employee employee) {
		        return employee.getEcountry();
		      }
		    };
		    
		    // Make the Countryname column sortable.
		    countryColumn.setSortable(true);
	        
		    
		    
		    // Add the columns.
		    view.getTable().addColumn(nameColumn, "Name");
		    view.getTable().addColumn(surNameColumn, "SurName");
		    view.getTable().addColumn(cityColumn, "City");
		    view.getTable().addColumn(countryColumn, "Country");


		    // Create a data provider.vPanel.add(hPanel);
	      
		   
		    // Connect the table to the data provider.
		    dataProvider.addDataDisplay(view.getTable());

		    // Add the data to the data provider, which automatically pushes it to the
		    // widget.
		    list = dataProvider.getList();
		    for (Employee employee : view.getEmp()){
		      list.add(employee);
		    }

		    // Add a ColumnSortEvent.ListHandler to connect sorting to the
		    // java.util.List.
		    ListHandler<Employee> columnSortHandler = new ListHandler<Employee>(
		        list);
		    columnSortHandler.setComparator(nameColumn,
		        new Comparator<Employee>() {
		          public int compare(Employee o1, Employee o2) {
		            if (o1 == o2) {
		              return 0;
		            }

		            // Compare the name columns.
		            if (o1 != null) {
		              return (o2 != null) ? o1.getEname().compareTo(o2.getEname()) : 1;
		            }
		            return -1;
		          }
		        });
		    view.getTable().addColumnSortHandler(columnSortHandler);

		    // We know that the data is sorted alphabetically by default.
		    view.getTable().getColumnSortList().push(nameColumn);
		    
		    
		    
		    
		    columnSortHandler.setComparator(surNameColumn,
			        new Comparator<Employee>() {
			          public int compare(Employee o1, Employee o2) {
			            if (o1 == o2) {
			              return 0;
			            }
			            
			            // Compare the name columns.
			            if (o1 != null) {
			              return (o2 != null) ? o1.geteSurName().compareTo(o2.geteSurName()) : 1;
			            }
			            return -1;
			          }
			        });
		    view.getTable().addColumnSortHandler(columnSortHandler);

			    // We know that the data is sorted alphabetically by default.
		    view.getTable().getColumnSortList().push(surNameColumn);
		    
			    columnSortHandler.setComparator(cityColumn,
				        new Comparator<Employee>() {
				          public int compare(Employee o1, Employee o2) {
				            if (o1 == o2) {
				              return 0;
				            }

				            // Compare the name columns.
				            if (o1 != null) {
				              return (o2 != null) ? o1.getEcity().compareTo(o2.getEcity()) : 1;
				            }
				            return -1;
				          }
				        });
			    view.getTable().addColumnSortHandler(columnSortHandler);

				    // We know that the data is sorted alphabetically by default.
			    view.getTable().getColumnSortList().push(cityColumn);
			    
		    
				    
				    columnSortHandler.setComparator(countryColumn,
					        new Comparator<Employee>() {
					          public int compare(Employee o1, Employee o2) {
					            if (o1 == o2) {
					              return 0;
					            }

					            // Compare the name columns.
					            if (o1 != null) {
					              return (o2 != null) ? o1.getEcountry().compareTo(o2.getEcountry()) : 1;
					            }
					            return -1;
					          }
					        });
				    view.getTable().addColumnSortHandler(columnSortHandler);

					    // We know that the data is sorted alphabetically by default.
				    view.getTable().getColumnSortList().push(countryColumn);
				    			     
		                
		                SingleSelectionModel<Employee> selectionModel = new SingleSelectionModel<Employee>();
		                   view.getTable().setSelectionModel(selectionModel);
		                   
		                    selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
		                      public void onSelectionChange(SelectionChangeEvent event) {
		                    	  selected = selectionModel.getSelectedObject();
		                    	  Window.alert(selected.getEname());
		                    	
		                    	  eventBus.userDetailView(selected);
	                          
	            
		                      }
		                    });
		                    
		                    
		                    view.getResetBtn().addClickHandler(new ClickHandler() {
								
								@Override
								public void onClick(ClickEvent event) {
									// TODO Auto-generated method stub
									list = dataProvider.getList();
								
								    for (Employee employee : view.getEmp()){
								      list.add(employee);
								    }
									 dataProvider.getList().clear();
				  		             dataProvider.setList(view.getEmp());
								}
							});
		                
		                    view.getSearchBtn().addClickHandler(new ClickHandler() {
								
								@Override
								public void onClick(ClickEvent event) {
									// TODO Auto-generated method stub
									search();
								}
							});
			                     
		      }
		
	       public Employee getSelected() {
			return selected;
		}

		public void setSelected(Employee selected) {
			this.selected = selected;
		}

		public void search() {
			
			String searchItem = view.getTextBox().getText();
			setData(searchItem);
			
		}
	       
	       public void setData(String searchItem) {
	    	  
	  		 if (view.getEmp() != null && view.getEmp().size() > 0) {
	  		
	  		        AsyncDataProvider<Employee> provider = new AsyncDataProvider<Employee>() {
	  		            @Override
	  		            protected void onRangeChanged(HasData<Employee> display) {
	  		                int start = display.getVisibleRange().getStart();
	  		                int end = start + display.getVisibleRange().getLength();
	  		                //new function if searchString is specified take into account
	  		              List<Employee> sub = getSubList(start,end, searchItem);
	  		                 end = end >= sub.size() ? sub.size() : end;
	  		                dataProvider.getList().clear();
	  		                dataProvider.setList(sub);
	  		              updateRowData(start, sub);
	  		              view.getTable().setRowData(0, sub);
	  		            }
	  		        };  		        
	  		        provider.addDataDisplay(view.getTable());
	  		   
	  		        provider.updateRowCount(view.getEmp().size(), true);
	  		    }
	  	}
	       
	       protected List<Employee> getSubList(int start, int end,String searchItem) {
	   		// TODO Auto-generated method stub
	   		
	   		List<Employee> filtered_list = null;
	   	    if (searchItem != null) {
	   	        filtered_list= new ArrayList<Employee>();
	   	        for (Employee employee : view.getEmp()) {
	   	            if (employee.getEname().equals(searchItem) || employee.geteSurName().equals(searchItem)|| employee.getEcountry().equals(searchItem) || employee.getEcity().equals(searchItem))
	   	                filtered_list.add(employee);                
	   	        }
	   	    }
	   	   return filtered_list;
	   	}
}
