package com.aftnlistner.test;

import javax.jms.Connection;  
import javax.jms.ConnectionFactory;  
import javax.jms.Destination;  
import javax.jms.JMSException;

import javax.jms.MessageConsumer;

import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;  
import org.apache.activemq.ActiveMQConnectionFactory;


public class JMSReceiver {
	private static final String USERNAME1 = ActiveMQConnection.DEFAULT_USER;// Ĭ�ϵ����ӵ��û���  
    private static final String PASSWORD1 = ActiveMQConnection.DEFAULT_PASSWORD;// Ĭ�ϵ���������  
    private static final String BROKEURL1 = ActiveMQConnection.DEFAULT_BROKER_URL;// Ĭ�ϵ����ӵ�ַ
   
    public static void main(String[] args){  
		// TODO Auto-generated method stub
        ConnectionFactory connectionFactory; // ���ӹ���  
        Connection connection = null; // ����  
        Session session; // �Ự ���ܻ��߷�����Ϣ���߳�  
        Destination destination; // ��Ϣ��Ŀ�ĵ�  
        MessageConsumer messageConsumer; // ��Ϣ��������
        connectionFactory = new ActiveMQConnectionFactory(JMSReceiver.USERNAME1, JMSReceiver.PASSWORD1, JMSReceiver.BROKEURL1);   // ͨ�����ӹ�����ȡ����  
            try {
				connection=connectionFactory.createConnection();
	            connection.start(); // ��������  
	            session=connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE); // ����Session  
	            destination=session.createTopic("AFTN");   
	            messageConsumer=session.createConsumer(destination); // ������Ϣ������  
	            messageConsumer.setMessageListener(new Listener_AFTN()); // ע����Ϣ����  
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  // ͨ�����ӹ�����ȡ���� 
           }
}