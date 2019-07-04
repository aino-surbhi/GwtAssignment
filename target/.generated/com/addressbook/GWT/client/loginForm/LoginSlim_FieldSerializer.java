package com.addressbook.GWT.client.loginForm;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class LoginSlim_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native int getId(com.addressbook.GWT.client.loginForm.LoginSlim instance) /*-{
    return instance.@com.addressbook.GWT.client.loginForm.LoginSlim::id;
  }-*/;
  
  private static native void setId(com.addressbook.GWT.client.loginForm.LoginSlim instance, int value) 
  /*-{
    instance.@com.addressbook.GWT.client.loginForm.LoginSlim::id = value;
  }-*/;
  
  private static native java.lang.String getPassword(com.addressbook.GWT.client.loginForm.LoginSlim instance) /*-{
    return instance.@com.addressbook.GWT.client.loginForm.LoginSlim::password;
  }-*/;
  
  private static native void setPassword(com.addressbook.GWT.client.loginForm.LoginSlim instance, java.lang.String value) 
  /*-{
    instance.@com.addressbook.GWT.client.loginForm.LoginSlim::password = value;
  }-*/;
  
  private static native java.lang.String getUserName(com.addressbook.GWT.client.loginForm.LoginSlim instance) /*-{
    return instance.@com.addressbook.GWT.client.loginForm.LoginSlim::userName;
  }-*/;
  
  private static native void setUserName(com.addressbook.GWT.client.loginForm.LoginSlim instance, java.lang.String value) 
  /*-{
    instance.@com.addressbook.GWT.client.loginForm.LoginSlim::userName = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.addressbook.GWT.client.loginForm.LoginSlim instance) throws SerializationException {
    setId(instance, streamReader.readInt());
    setPassword(instance, streamReader.readString());
    setUserName(instance, streamReader.readString());
    
  }
  
  public static com.addressbook.GWT.client.loginForm.LoginSlim instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.addressbook.GWT.client.loginForm.LoginSlim();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.addressbook.GWT.client.loginForm.LoginSlim instance) throws SerializationException {
    streamWriter.writeInt(getId(instance));
    streamWriter.writeString(getPassword(instance));
    streamWriter.writeString(getUserName(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.addressbook.GWT.client.loginForm.LoginSlim_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.addressbook.GWT.client.loginForm.LoginSlim_FieldSerializer.deserialize(reader, (com.addressbook.GWT.client.loginForm.LoginSlim)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.addressbook.GWT.client.loginForm.LoginSlim_FieldSerializer.serialize(writer, (com.addressbook.GWT.client.loginForm.LoginSlim)object);
  }
  
}
