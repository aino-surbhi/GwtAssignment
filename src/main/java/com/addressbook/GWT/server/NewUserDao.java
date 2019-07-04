package com.addressbook.GWT.server;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class NewUserDao {
	
	public Session getSession() {
		return HibernateUtil.getSessionFactory().openSession();

	}

	public int saveUserDetails(NewUserPojo newPojo) {
		// TODO Auto-generated method stub
		Session session=getSession();
		Transaction transaction=session.beginTransaction();
	    Integer id=null;
		try {
			
			id=(Integer) session.save(newPojo);
			transaction.commit(); 
			System.out.println("Details saved!");
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			session.close();
		}
		return id;
	}

	public ArrayList<NewUserPojo> listDetails() {
		// TODO Auto-generated method stub

		   ArrayList<NewUserPojo> al=null;
		   NewUserPojo addUserRecordObject=null;
	        Session session=getSession();
	        Transaction transaction=session.beginTransaction();
	        try {
	            al= (ArrayList<NewUserPojo>) session.createQuery("from NewUserPojo").list();

	        }catch (Exception e) {
	        }
	        
	        return al;
	 	

	}
}
