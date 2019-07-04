package com.addressbook.GWT.client.cellTable;

import com.google.gwt.user.cellview.client.CellTable;

public interface CellTableResources extends CellTable.Resources {
	
	/**
     * The styles applied to the table.
     */
  interface TableStyle extends CellTable.Style {
  }

  @Override
  @Source({ CellTable.Style.DEFAULT_CSS, "gwtCellTable.css" }) 
  TableStyle cellTableStyle();
	 
}