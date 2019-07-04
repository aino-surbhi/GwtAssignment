package com.addressbook.GWT.server;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.mapping.List;
import org.hibernate.query.Query;
public class LoginDao {

	
	public Session getSession() {
		return HibernateUtil.getSessionFactory().openSession();

	}

	public int savePage(Login login) {
		// TODO Auto-generated method stub
		Session session=getSession();
		Transaction transaction=session.beginTransaction();
	    Integer id=null;
		try {
			
			id=(Integer) session.save(login);
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

	public Login userAuthentication(String name,String password) {
		// TODO Auto-generated method stub
		Session session=getSession();
		Transaction transaction=null;
		Login login=null;
		try {
			transaction=session.beginTransaction();
			Query query=session.createQuery("from Login where name= :name");
			query.setParameter("name",name);
			Object object= ((org.hibernate.query.Query) query).uniqueResult();
			login=(Login) object;
			
			transaction.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return login;
		
		
		
		
	}

	
}


