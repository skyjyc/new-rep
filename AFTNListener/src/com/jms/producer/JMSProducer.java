package com.jms.producer;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;


import com.sun.messaging.xml.MessageTransformer;

import org.apache.activemq.ActiveMQConnectionFactory;


public class JMSProducer {
	private static final String USERNAME = ActiveMQConnectionFactory.DEFAULT_USER;// Ĭ�ϵ����ӵ��û���  
    private static final String PASSWORD = ActiveMQConnectionFactory.DEFAULT_PASSWORD;// Ĭ�ϵ���������  
    private static final String BROKEURL = ActiveMQConnectionFactory.DEFAULT_BROKER_URL;// Ĭ�ϵ����ӵ�ַ  
    //private static final int SENDNUM = 10;// ������Ϣ������  
	 ConnectionFactory connectionFactory;// ���ӹ���  
     Connection connection = null;// ����  
     Session session;// �Ự ���ͻ��߽�����Ϣ���߳�  
     Destination destination;// ��Ϣ��Ŀ�ĵ�  
     MessageProducer messageProducer;// ��Ϣ������
     TextMessage message;
    public void producer() throws JMSException{
  
         // ʵ�������ӹ���  
         connectionFactory = new ActiveMQConnectionFactory(JMSProducer.USERNAME, JMSProducer.PASSWORD,  
                 JMSProducer.BROKEURL);  
   
         try {  
             // ͨ�����ӹ�����ȡ����  
             connection = connectionFactory.createConnection();  
             // ��������  
             connection.start();  
             session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);  
             destination = session.createTopic("AFTN");// ������Ϣ����  
             messageProducer = session.createProducer(destination);// ������Ϣ������   
   
         } catch (JMSException e) {  
             // TODO Auto-generated catch block  
             e.printStackTrace();  
         } 
//         finally {  
//             if (connection != null) {  
//                 try {  
//                     connection.close();  
//                 } catch (JMSException e) {  
//                     // TODO Auto-generated catch block  
//                     e.printStackTrace();  
//                 }  
//             }  
//         }  
     }  
    public void close(){
    	try {  
          connection.close();  
    	} catch (JMSException e) {  
          // TODO Auto-generated catch block  
          e.printStackTrace();  
    	}  
    }
   
     // ������Ϣ  
    // public static void sendMessage(Session session, MessageProducer messageProducer) throws SOAPException {  
    	 public  void sendMessage() throws JMSException {
     
             try { 
             messageProducer.send(message);  
             // ���������������������Ҫʹ���ύ���ܽ����ݷ��ͳ�ȥ  
             session.commit(); 
             } catch (JMSException e) {  
                 // TODO Auto-generated catch block  
                 e.printStackTrace();  
             }  
         }  
    public void textMessageGenerate(String XMLText){
    	try {
			message=session.createTextMessage(XMLText);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
    }
  }

