package com.addressbook.GWT.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MyDialog extends DialogBox{
	 public MyDialog() {
      
         setText("Saved Succesfully");
         setAnimationEnabled(true);
         setGlassEnabled(true);
         Button btn = new Button("OK");
         btn.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
               MyDialog.this.hide();
            }
         });

         Label label = new Label("User Details Added Succesfully");

         VerticalPanel panel = new VerticalPanel();
         panel.setHeight("500");
         panel.setWidth("500");
         panel.setSpacing(10);
         panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
         panel.add(label);
         panel.add(btn);
         setWidget(panel);
      }
}
