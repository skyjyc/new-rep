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
	private static final String USERNAME1 = ActiveMQConnection.DEFAULT_USER;// 默认的连接的用户名  
    private static final String PASSWORD1 = ActiveMQConnection.DEFAULT_PASSWORD;// 默认的连接密码  
    private static final String BROKEURL1 = ActiveMQConnection.DEFAULT_BROKER_URL;// 默认的连接地址
   
    public static void main(String[] args){  
		// TODO Auto-generated method stub
        ConnectionFactory connectionFactory; // 连接工厂  
        Connection connection = null; // 连接  
        Session session; // 会话 接受或者发送消息的线程  
        Destination destination; // 消息的目的地  
        MessageConsumer messageConsumer; // 消息的消费者
        connectionFactory = new ActiveMQConnectionFactory(JMSReceiver.USERNAME1, JMSReceiver.PASSWORD1, JMSReceiver.BROKEURL1);   // 通过连接工厂获取连接  
            try {
				connection=connectionFactory.createConnection();
	            connection.start(); // 启动连接  
	            session=connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE); // 创建Session  
	            destination=session.createTopic("AFTN");   
	            messageConsumer=session.createConsumer(destination); // 创建消息消费者  
	            messageConsumer.setMessageListener(new Listener_AFTN()); // 注册消息监听  
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  // 通过连接工厂获取连接 
           }
}