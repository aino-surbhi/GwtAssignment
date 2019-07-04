package com.addressbook.GWT.client.newUser;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class NewUserSlim_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.String getCity(com.addressbook.GWT.client.newUser.NewUserSlim instance) /*-{
    return instance.@com.addressbook.GWT.client.newUser.NewUserSlim::city;
  }-*/;
  
  private static native void setCity(com.addressbook.GWT.client.newUser.NewUserSlim instance, java.lang.String value) 
  /*-{
    instance.@com.addressbook.GWT.client.newUser.NewUserSlim::city = value;
  }-*/;
  
  private static native java.lang.String getCountry(com.addressbook.GWT.client.newUser.NewUserSlim instance) /*-{
    return instance.@com.addressbook.GWT.client.newUser.NewUserSlim::country;
  }-*/;
  
  private static native void setCountry(com.addressbook.GWT.client.newUser.NewUserSlim instance, java.lang.String value) 
  /*-{
    instance.@com.addressbook.GWT.client.newUser.NewUserSlim::country = value;
  }-*/;
  
  private static native int getId(com.addressbook.GWT.client.newUser.NewUserSlim instance) /*-{
    return instance.@com.addressbook.GWT.client.newUser.NewUserSlim::id;
  }-*/;
  
  private static native void setId(com.addressbook.GWT.client.newUser.NewUserSlim instance, int value) 
  /*-{
    instance.@com.addressbook.GWT.client.newUser.NewUserSlim::id = value;
  }-*/;
  
  private static native java.lang.String getName(com.addressbook.GWT.client.newUser.NewUserSlim instance) /*-{
    return instance.@com.addressbook.GWT.client.newUser.NewUserSlim::name;
  }-*/;
  
  private static native void setName(com.addressbook.GWT.client.newUser.NewUserSlim instance, java.lang.String value) 
  /*-{
    instance.@com.addressbook.GWT.client.newUser.NewUserSlim::name = value;
  }-*/;
  
  private static native java.lang.String getSurName(com.addressbook.GWT.client.newUser.NewUserSlim instance) /*-{
    return instance.@com.addressbook.GWT.client.newUser.NewUserSlim::surName;
  }-*/;
  
  private static native void setSurName(com.addressbook.GWT.client.newUser.NewUserSlim instance, java.lang.String value) 
  /*-{
    instance.@com.addressbook.GWT.client.newUser.NewUserSlim::surName = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.addressbook.GWT.client.newUser.NewUserSlim instance) throws SerializationException {
    setCity(instance, streamReader.readString());
    setCountry(instance, streamReader.readString());
    setId(instance, streamReader.readInt());
    setName(instance, streamReader.readString());
    setSurName(instance, streamReader.readString());
    
  }
  
  public static com.addressbook.GWT.client.newUser.NewUserSlim instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.addressbook.GWT.client.newUser.NewUserSlim();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.addressbook.GWT.client.newUser.NewUserSlim instance) throws SerializationException {
    streamWriter.writeString(getCity(instance));
    streamWriter.writeString(getCountry(instance));
    streamWriter.writeInt(getId(instance));
    streamWriter.writeString(getName(instance));
    streamWriter.writeString(getSurName(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.addressbook.GWT.client.newUser.NewUserSlim_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.addressbook.GWT.client.newUser.NewUserSlim_FieldSerializer.deserialize(reader, (com.addressbook.GWT.client.newUser.NewUserSlim)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.addressbook.GWT.client.newUser.NewUserSlim_FieldSerializer.serialize(writer, (com.addressbook.GWT.client.newUser.NewUserSlim)object);
  }
  
}
