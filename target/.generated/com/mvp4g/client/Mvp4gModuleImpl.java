package com.mvp4g.client;

import com.mvp4g.client.history.PlaceService;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.mvp4g.client.presenter.PresenterInterface;
import com.mvp4g.client.event.EventBus;
import com.mvp4g.client.Mvp4gException;
import com.mvp4g.client.history.HistoryConverter;
import com.mvp4g.client.Mvp4gEventPasser;
import com.mvp4g.client.Mvp4gModule;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.mvp4g.client.event.BaseEventBus;
import com.mvp4g.client.event.EventFilter;
import com.mvp4g.client.event.EventHandlerInterface;
import java.util.List;
import com.mvp4g.client.history.NavigationEventCommand;
import com.mvp4g.client.history.NavigationConfirmationInterface;
import com.google.gwt.core.client.RunAsyncCallback;
import com.mvp4g.client.Mvp4gRunAsync;
import com.google.gwt.user.client.Command;

public class Mvp4gModuleImpl implements Mvp4gModule {
    
    private abstract class AbstractEventBus extends com.mvp4g.client.event.BaseEventBusWithLookUp implements com.addressbook.GWT.client.GwtEventBus{}
    
    @GinModules({com.mvp4g.client.DefaultMvp4gGinModule.class})
    public interface com_mvp4g_client_Mvp4gModuleGinjector extends Ginjector {
      com.addressbook.GWT.client.loginForm.LoginFormPresenter getcom_addressbook_GWT_client_loginForm_LoginFormPresenter();
      com.addressbook.GWT.client.fetchData.fetchCellTableDataPresenter getcom_addressbook_GWT_client_fetchData_fetchCellTableDataPresenter();
      com.addressbook.GWT.client.loginDetails.LoginDisplayPresenter getcom_addressbook_GWT_client_loginDetails_LoginDisplayPresenter();
      com.addressbook.GWT.client.cellTable.CellTablePresenter getcom_addressbook_GWT_client_cellTable_CellTablePresenter();
      com.addressbook.GWT.client.newUser.NewUserPresenter getcom_addressbook_GWT_client_newUser_NewUserPresenter();
      com.addressbook.GWT.client.EditView.EditPresenter getcom_addressbook_GWT_client_EditView_EditPresenter();
      com.addressbook.GWT.client.educationDetails.EducationDetailsPresenter getcom_addressbook_GWT_client_educationDetails_EducationDetailsPresenter();
      com.addressbook.GWT.client.fetchData.fetchCellTableView getcom_addressbook_GWT_client_fetchData_fetchCellTableDataPresenterView();
      com.addressbook.GWT.client.EditView.EditView getcom_addressbook_GWT_client_EditView_EditPresenterView();
      com.addressbook.GWT.client.loginForm.LoginFormView getcom_addressbook_GWT_client_loginForm_LoginFormPresenterView();
      com.addressbook.GWT.client.loginDetails.LoginDisplayView getcom_addressbook_GWT_client_loginDetails_LoginDisplayPresenterView();
      com.addressbook.GWT.client.educationDetails.EducationDetailsView getcom_addressbook_GWT_client_educationDetails_EducationDetailsPresenterView();
      com.addressbook.GWT.client.cellTable.CellTableView getcom_addressbook_GWT_client_cellTable_CellTablePresenterView();
      com.addressbook.GWT.client.newUser.NewUserView getcom_addressbook_GWT_client_newUser_NewUserPresenterView();
      com.mvp4g.client.history.PlaceService getcom_mvp4g_client_history_PlaceService();
    }
    private Object startView = null;
    private PresenterInterface startPresenter = null;
    protected AbstractEventBus eventBus = null;
    protected com_mvp4g_client_Mvp4gModuleGinjector injector = null;
    protected com.mvp4g.client.Mvp4gModule itself = this;
    private PlaceService placeService = null;
    public void setParentModule(com.mvp4g.client.Mvp4gModule module){}
    public void loadChildModule(String childModuleClassName, String eventName, boolean passive, Mvp4gEventPasser passer){
    }
    public void addConverter(String historyName, HistoryConverter<?> hc){
      placeService.addConverter(historyName, hc);
    }
    public void clearHistory(){
      placeService.clearHistory();
    }
    public String place(String token, String form, boolean onlyToken){
      return placeService.place( token, form, onlyToken );
    }
    public void dispatchHistoryEvent(String eventType, final Mvp4gEventPasser passer){
      int index = eventType.indexOf(PlaceService.MODULE_SEPARATOR);
      if(index > -1){
        String moduleHistoryName = eventType.substring(0, index);
        String nextToken = eventType.substring(index + 1);
        Mvp4gEventPasser nextPasser = new Mvp4gEventPasser(nextToken) {
          public void pass(Mvp4gModule module) {
            module.dispatchHistoryEvent((String) eventObjects[0], passer);
          }
        };
        passer.setEventObject(false);
        passer.pass(this);
      }else{
        passer.pass(this);
      }
    }
    public void sendInitEvent(){
    }
    public void sendNotFoundEvent(){
    }
    
    public void onForward(){
    }
    
    public void createAndStartModule(){
      injector = GWT.create( com_mvp4g_client_Mvp4gModuleGinjector.class );
      final com.addressbook.GWT.client.fetchData.fetchCellTableView com_addressbook_GWT_client_fetchData_fetchCellTableDataPresenterView = injector.getcom_addressbook_GWT_client_fetchData_fetchCellTableDataPresenterView();
      final com.addressbook.GWT.client.EditView.EditView com_addressbook_GWT_client_EditView_EditPresenterView = injector.getcom_addressbook_GWT_client_EditView_EditPresenterView();
      final com.addressbook.GWT.client.loginForm.LoginFormView com_addressbook_GWT_client_loginForm_LoginFormPresenterView = injector.getcom_addressbook_GWT_client_loginForm_LoginFormPresenterView();
      final com.addressbook.GWT.client.loginDetails.LoginDisplayView com_addressbook_GWT_client_loginDetails_LoginDisplayPresenterView = injector.getcom_addressbook_GWT_client_loginDetails_LoginDisplayPresenterView();
      final com.addressbook.GWT.client.educationDetails.EducationDetailsView com_addressbook_GWT_client_educationDetails_EducationDetailsPresenterView = injector.getcom_addressbook_GWT_client_educationDetails_EducationDetailsPresenterView();
      final com.addressbook.GWT.client.cellTable.CellTableView com_addressbook_GWT_client_cellTable_CellTablePresenterView = injector.getcom_addressbook_GWT_client_cellTable_CellTablePresenterView();
      final com.addressbook.GWT.client.newUser.NewUserView com_addressbook_GWT_client_newUser_NewUserPresenterView = injector.getcom_addressbook_GWT_client_newUser_NewUserPresenterView();
      
      
      
      placeService = injector.getcom_mvp4g_client_history_PlaceService();
      
      final com.addressbook.GWT.client.loginForm.LoginFormPresenter com_addressbook_GWT_client_loginForm_LoginFormPresenter = injector.getcom_addressbook_GWT_client_loginForm_LoginFormPresenter();
      com_addressbook_GWT_client_loginForm_LoginFormPresenter.setView(com_addressbook_GWT_client_loginForm_LoginFormPresenterView);
      final com.addressbook.GWT.client.fetchData.fetchCellTableDataPresenter com_addressbook_GWT_client_fetchData_fetchCellTableDataPresenter = injector.getcom_addressbook_GWT_client_fetchData_fetchCellTableDataPresenter();
      com_addressbook_GWT_client_fetchData_fetchCellTableDataPresenter.setView(com_addressbook_GWT_client_fetchData_fetchCellTableDataPresenterView);
      final com.addressbook.GWT.client.loginDetails.LoginDisplayPresenter com_addressbook_GWT_client_loginDetails_LoginDisplayPresenter = injector.getcom_addressbook_GWT_client_loginDetails_LoginDisplayPresenter();
      com_addressbook_GWT_client_loginDetails_LoginDisplayPresenter.setView(com_addressbook_GWT_client_loginDetails_LoginDisplayPresenterView);
      final com.addressbook.GWT.client.cellTable.CellTablePresenter com_addressbook_GWT_client_cellTable_CellTablePresenter = injector.getcom_addressbook_GWT_client_cellTable_CellTablePresenter();
      com_addressbook_GWT_client_cellTable_CellTablePresenter.setView(com_addressbook_GWT_client_cellTable_CellTablePresenterView);
      final com.addressbook.GWT.client.newUser.NewUserPresenter com_addressbook_GWT_client_newUser_NewUserPresenter = injector.getcom_addressbook_GWT_client_newUser_NewUserPresenter();
      com_addressbook_GWT_client_newUser_NewUserPresenter.setView(com_addressbook_GWT_client_newUser_NewUserPresenterView);
      final com.addressbook.GWT.client.EditView.EditPresenter com_addressbook_GWT_client_EditView_EditPresenter = injector.getcom_addressbook_GWT_client_EditView_EditPresenter();
      com_addressbook_GWT_client_EditView_EditPresenter.setView(com_addressbook_GWT_client_EditView_EditPresenterView);
      final com.addressbook.GWT.client.educationDetails.EducationDetailsPresenter com_addressbook_GWT_client_educationDetails_EducationDetailsPresenter = injector.getcom_addressbook_GWT_client_educationDetails_EducationDetailsPresenter();
      com_addressbook_GWT_client_educationDetails_EducationDetailsPresenter.setView(com_addressbook_GWT_client_educationDetails_EducationDetailsPresenterView);
      
      
      eventBus = new AbstractEventBus(){
        protected <T extends EventHandlerInterface<?>> T createHandler( Class<T> handlerClass ){
        return null;
        }
        public void getSortTableData(java.util.ArrayList attr0){
          if (com_addressbook_GWT_client_fetchData_fetchCellTableDataPresenter.isActivated(false, "getSortTableData", new Object[]{attr0})){
            com_addressbook_GWT_client_fetchData_fetchCellTableDataPresenter.onGetSortTableData(attr0);
          }
        }
        public void getCellTable(){
          if (com_addressbook_GWT_client_cellTable_CellTablePresenter.isActivated(false, "getCellTable")){
            com_addressbook_GWT_client_cellTable_CellTablePresenter.onGetCellTable();
          }
        }
        public void getEducationDetails(){
          if (com_addressbook_GWT_client_educationDetails_EducationDetailsPresenter.isActivated(false, "getEducationDetails")){
            com_addressbook_GWT_client_educationDetails_EducationDetailsPresenter.onGetEducationDetails();
          }
        }
        public void getEditTable1(com.addressbook.GWT.client.newUser.NewUserSlim attr0){
          if (com_addressbook_GWT_client_EditView_EditPresenter.isActivated(false, "getEditTable1", new Object[]{attr0})){
            com_addressbook_GWT_client_EditView_EditPresenter.onGetEditTable1(attr0);
          }
        }
        public void addCellTable(com.addressbook.GWT.client.cellTable.CellTableView attr0){
          if (com_addressbook_GWT_client_loginForm_LoginFormPresenter.isActivated(false, "addCellTable", new Object[]{attr0})){
            com_addressbook_GWT_client_loginForm_LoginFormPresenter.onAddCellTable(attr0);
          }
        }
        public void addEditTable(com.addressbook.GWT.client.EditView.EditView attr0){
          if (com_addressbook_GWT_client_loginDetails_LoginDisplayPresenter.isActivated(false, "addEditTable", new Object[]{attr0})){
            com_addressbook_GWT_client_loginDetails_LoginDisplayPresenter.onAddEditTable(attr0);
          }
        }
        public void getfetchdata(){
          if (com_addressbook_GWT_client_fetchData_fetchCellTableDataPresenter.isActivated(false, "getfetchdata")){
            com_addressbook_GWT_client_fetchData_fetchCellTableDataPresenter.onGetfetchdata();
          }
        }
        public void addUserDetailsView(com.addressbook.GWT.client.loginDetails.LoginDisplayView attr0){
          if (com_addressbook_GWT_client_cellTable_CellTablePresenter.isActivated(false, "addUserDetailsView", new Object[]{attr0})){
            com_addressbook_GWT_client_cellTable_CellTablePresenter.onAddUserDetailsView(attr0);
          }
        }
        public void addNewUser(com.addressbook.GWT.client.newUser.NewUserView attr0){
          if (com_addressbook_GWT_client_cellTable_CellTablePresenter.isActivated(false, "addNewUser", new Object[]{attr0})){
            com_addressbook_GWT_client_cellTable_CellTablePresenter.onAddNewUser(attr0);
          }
        }
        public void fetchData(com.addressbook.GWT.client.fetchData.fetchCellTableView attr0){
          if (com_addressbook_GWT_client_fetchData_fetchCellTableDataPresenter.isActivated(false, "fetchData", new Object[]{attr0})){
            com_addressbook_GWT_client_fetchData_fetchCellTableDataPresenter.onFetchData(attr0);
          }
        }
        public void userDetailView(com.addressbook.GWT.client.cellTable.Employee attr0){
          if (com_addressbook_GWT_client_loginDetails_LoginDisplayPresenter.isActivated(false, "userDetailView", new Object[]{attr0})){
            com_addressbook_GWT_client_loginDetails_LoginDisplayPresenter.onUserDetailView(attr0);
          }
        }
        public void addfetchdata(com.addressbook.GWT.client.fetchData.fetchCellTableView attr0){
          if (com_addressbook_GWT_client_cellTable_CellTablePresenter.isActivated(false, "addfetchdata", new Object[]{attr0})){
            com_addressbook_GWT_client_cellTable_CellTablePresenter.onAddfetchdata(attr0);
          }
        }
        public void userDetailFetch(com.addressbook.GWT.client.newUser.NewUserSlim attr0){
          if (com_addressbook_GWT_client_loginDetails_LoginDisplayPresenter.isActivated(false, "userDetailFetch", new Object[]{attr0})){
            com_addressbook_GWT_client_loginDetails_LoginDisplayPresenter.onUserDetailFetch(attr0);
          }
        }
        public void getAddressView(){
          if (com_addressbook_GWT_client_loginForm_LoginFormPresenter.isActivated(false, "getAddressView")){
            com_addressbook_GWT_client_loginForm_LoginFormPresenter.onGetAddressView();
          }
        }
        public void getNewUser(){
          if (com_addressbook_GWT_client_newUser_NewUserPresenter.isActivated(false, "getNewUser")){
            com_addressbook_GWT_client_newUser_NewUserPresenter.onGetNewUser();
          }
        }
        public void getCellTableAgain(){
          if (com_addressbook_GWT_client_cellTable_CellTablePresenter.isActivated(false, "getCellTableAgain")){
            com_addressbook_GWT_client_cellTable_CellTablePresenter.onGetCellTableAgain();
          }
        }
        public void getEditTable(com.addressbook.GWT.client.cellTable.Employee attr0){
          if (com_addressbook_GWT_client_EditView_EditPresenter.isActivated(false, "getEditTable", new Object[]{attr0})){
            com_addressbook_GWT_client_EditView_EditPresenter.onGetEditTable(attr0);
          }
        }
        public void addEducationDetails(com.addressbook.GWT.client.educationDetails.EducationDetailsView attr0){
          if (com_addressbook_GWT_client_loginDetails_LoginDisplayPresenter.isActivated(false, "addEducationDetails", new Object[]{attr0})){
            com_addressbook_GWT_client_loginDetails_LoginDisplayPresenter.onAddEducationDetails(attr0);
          }
        }
        public void dispatch( String eventType, Object... data ){
          try{
            if ( "getSortTableData".equals( eventType ) ){
              getSortTableData((java.util.ArrayList) data[0]);
            } else if ( "getCellTable".equals( eventType ) ){
              getCellTable();
            } else if ( "getEducationDetails".equals( eventType ) ){
              getEducationDetails();
            } else if ( "getEditTable1".equals( eventType ) ){
              getEditTable1((com.addressbook.GWT.client.newUser.NewUserSlim) data[0]);
            } else if ( "addCellTable".equals( eventType ) ){
              addCellTable((com.addressbook.GWT.client.cellTable.CellTableView) data[0]);
            } else if ( "addEditTable".equals( eventType ) ){
              addEditTable((com.addressbook.GWT.client.EditView.EditView) data[0]);
            } else if ( "getfetchdata".equals( eventType ) ){
              getfetchdata();
            } else if ( "addUserDetailsView".equals( eventType ) ){
              addUserDetailsView((com.addressbook.GWT.client.loginDetails.LoginDisplayView) data[0]);
            } else if ( "addNewUser".equals( eventType ) ){
              addNewUser((com.addressbook.GWT.client.newUser.NewUserView) data[0]);
            } else if ( "fetchData".equals( eventType ) ){
              fetchData((com.addressbook.GWT.client.fetchData.fetchCellTableView) data[0]);
            } else if ( "userDetailView".equals( eventType ) ){
              userDetailView((com.addressbook.GWT.client.cellTable.Employee) data[0]);
            } else if ( "addfetchdata".equals( eventType ) ){
              addfetchdata((com.addressbook.GWT.client.fetchData.fetchCellTableView) data[0]);
            } else if ( "userDetailFetch".equals( eventType ) ){
              userDetailFetch((com.addressbook.GWT.client.newUser.NewUserSlim) data[0]);
            } else if ( "getAddressView".equals( eventType ) ){
              getAddressView();
            } else if ( "getNewUser".equals( eventType ) ){
              getNewUser();
            } else if ( "getCellTableAgain".equals( eventType ) ){
              getCellTableAgain();
            } else if ( "getEditTable".equals( eventType ) ){
              getEditTable((com.addressbook.GWT.client.cellTable.Employee) data[0]);
            } else if ( "addEducationDetails".equals( eventType ) ){
              addEducationDetails((com.addressbook.GWT.client.educationDetails.EducationDetailsView) data[0]);
            } else {
              throw new Mvp4gException( "Event " + eventType + " doesn't exist. Have you forgotten to add it to your Mvp4g configuration file?" );
            }
          } catch ( ClassCastException e ) {
            handleClassCastException( e, eventType );
          }
        }
      public void setNavigationConfirmation( NavigationConfirmationInterface navigationConfirmation ) {
        placeService.setNavigationConfirmation(navigationConfirmation);
      }
      public void confirmNavigation(NavigationEventCommand event){
        placeService.confirmEvent(event);
      }
      public void setApplicationHistoryStored( boolean historyStored ){
        placeService.setEnabled(historyStored);
      }
      };
      
      com_addressbook_GWT_client_loginForm_LoginFormPresenter.setEventBus(eventBus);
      com_addressbook_GWT_client_fetchData_fetchCellTableDataPresenter.setEventBus(eventBus);
      com_addressbook_GWT_client_loginDetails_LoginDisplayPresenter.setEventBus(eventBus);
      com_addressbook_GWT_client_cellTable_CellTablePresenter.setEventBus(eventBus);
      com_addressbook_GWT_client_newUser_NewUserPresenter.setEventBus(eventBus);
      com_addressbook_GWT_client_EditView_EditPresenter.setEventBus(eventBus);
      com_addressbook_GWT_client_educationDetails_EducationDetailsPresenter.setEventBus(eventBus);
      placeService.setModule(itself);
      
      this.startPresenter = com_addressbook_GWT_client_loginForm_LoginFormPresenter;
      this.startView = startPresenter.getView();
      eventBus.getAddressView();
    }
    public Object getStartView(){
      if (startPresenter != null) {
        startPresenter.setActivated(true);
        startPresenter.isActivated(false, null);
      }return startView;
    }
    
    public EventBus getEventBus(){
      return eventBus;
    }
  }
