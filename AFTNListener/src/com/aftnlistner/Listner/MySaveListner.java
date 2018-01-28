package com.aftnlistner.Listner;

import java.io.Serializable;

import org.hibernate.event.SaveOrUpdateEvent;
import org.hibernate.event.def.DefaultSaveOrUpdateEventListener;

public class MySaveListner extends DefaultSaveOrUpdateEventListener {
	public MySaveListnerFlag  mySaveListnerFlag;
	public static SaveOrUpdateEvent event;
	private static final long serialVersionUID = 7496518453770213930L;  
	protected Serializable performSaveOrUpdate(SaveOrUpdateEvent event){  
        System.out.println("自定义的save事件");  
        System.out.println(event.getObject());
        //由于无法new一个MySaveListener类（这个类在xml中配置的，而且使用configuration类无法使用setListener方法）
        //所以使用static 但是有警告
        this.event=event;
        MySaveListnerFlag  mySaveListnerFlag =new  MySaveListnerFlag();
        mySaveListnerFlag.setFlag(1);
        
        return super.performSaveOrUpdate(event);  
    }  
	public MySaveListnerFlag RetrunMyflag(){
		return mySaveListnerFlag;
	}
}
