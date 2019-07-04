package com.addressbook.GWT.client.loginForm;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface LoginServiceAsync
{

    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.addressbook.GWT.client.loginForm.LoginService
     */
    void greetServer( java.lang.String name, AsyncCallback<java.lang.String> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.addressbook.GWT.client.loginForm.LoginService
     */
    void loginPage( com.addressbook.GWT.client.loginForm.LoginSlim login, AsyncCallback<java.lang.Integer> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.addressbook.GWT.client.loginForm.LoginService
     */
    void saveUserDetails( com.addressbook.GWT.client.newUser.NewUserSlim newSlim, AsyncCallback<java.lang.Integer> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.addressbook.GWT.client.loginForm.LoginService
     */
    void getAllList( AsyncCallback<java.util.ArrayList<com.addressbook.GWT.client.newUser.NewUserSlim>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see com.addressbook.GWT.client.loginForm.LoginService
     */
    void authenticateUser( java.lang.String name, java.lang.String password, AsyncCallback<com.addressbook.GWT.client.loginForm.LoginSlim> callback );


    /**
     * Utility class to get the RPC Async interface from client-side code
     */
    public static final class Util 
    { 
        private static LoginServiceAsync instance;

        public static final LoginServiceAsync getInstance()
        {
            if ( instance == null )
            {
                instance = (LoginServiceAsync) GWT.create( LoginService.class );
            }
            return instance;
        }

        private Util()
        {
            // Utility class should not be instantiated
        }
    }
}
