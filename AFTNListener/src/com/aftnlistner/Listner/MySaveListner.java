package com.aftnlistner.Listner;

import java.io.Serializable;

import org.hibernate.event.SaveOrUpdateEvent;
import org.hibernate.event.def.DefaultSaveOrUpdateEventListener;

public class MySaveListner extends DefaultSaveOrUpdateEventListener {
	public MySaveListnerFlag  mySaveListnerFlag;
	public static SaveOrUpdateEvent event;
	private static final long serialVersionUID = 7496518453770213930L;  
	protected Serializable performSaveOrUpdate(SaveOrUpdateEvent event){  
        System.out.println("�Զ����save�¼�");  
        System.out.println(event.getObject());
        //�����޷�newһ��MySaveListener�ࣨ�������xml�����õģ�����ʹ��configuration���޷�ʹ��setListener������
        //����ʹ��static �����о���
        this.event=event;
        MySaveListnerFlag  mySaveListnerFlag =new  MySaveListnerFlag();
        mySaveListnerFlag.setFlag(1);
        
        return super.performSaveOrUpdate(event);  
    }  
	public MySaveListnerFlag RetrunMyflag(){
		return mySaveListnerFlag;
	}
}
