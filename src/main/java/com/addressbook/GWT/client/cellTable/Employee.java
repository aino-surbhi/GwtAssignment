package com.addressbook.GWT.client.cellTable;

public class Employee {

	private String ename;
	private String eSurName;
    private String ecity;
    private String ecountry;

    public Employee(String ename,String eSurName,String ecity,String ecountry) {
       this.setEname(ename);
       this.seteSurName(eSurName);
       this.setEcity(ecity);
       this.setEcountry(ecountry);
    }

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String geteSurName() {
		return eSurName;
	}

	public void seteSurName(String eSurName) {
		this.eSurName = eSurName;
	}

	public String getEcity() {
		return ecity;
	}

	public void setEcity(String ecity) {
		this.ecity = ecity;
	}

	public String getEcountry() {
		return ecountry;
	}

	public void setEcountry(String ecountry) {
		this.ecountry = ecountry;
	}
	
}
