package com.aftnlistener.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.event.EventListeners;
import org.hibernate.event.SaveOrUpdateEvent;

import com.aftnlistener.bean.Aftn;

public class AFTNimpl {
	Configuration cfg = new Configuration().configure();  
	SessionFactory sessionfactory=cfg.buildSessionFactory();
	Session session=sessionfactory.openSession();
	//Session session=HibernateSessionFactory.getSession();
	Transaction transaction=session.beginTransaction();
	public SaveOrUpdateEvent AFTNimplevent;
	public void addinfo(Aftn aftn){
		try{
		session.save(aftn);
		transaction.commit();
		
			}
		catch(Exception e){ 
			if(transaction!=null){
			   transaction.rollback();
			} 
			e.printStackTrace();  }
		finally{
			session.close();
			}  
	
	}
}
