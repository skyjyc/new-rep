package com.aftnlistner.test;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class Listener_AFTN  implements MessageListener {
	public void onMessage(Message message)  {
		// TODO Auto-generated method stub
	            try {
					System.out.println("��Ϣ������һ�յ�����Ϣ��"+((TextMessage)message).getText());
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
	        
	} 
}
