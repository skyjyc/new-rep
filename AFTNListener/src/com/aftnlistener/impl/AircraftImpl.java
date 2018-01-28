package com.aftnlistener.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.event.SaveOrUpdateEvent;


import com.aftnlistener.bean.Aircraft;

public class AircraftImpl {
	Configuration cfg = new Configuration().configure();  
	SessionFactory sessionfactory=cfg.buildSessionFactory();
	Session session=sessionfactory.openSession();
	Transaction transaction=session.beginTransaction();
	public SaveOrUpdateEvent Aircraftimplevent;
	public void addinfo(Aircraft aircraft){
		try{
		session.save(aircraft);
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
