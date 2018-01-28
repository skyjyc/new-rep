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
	private static final String USERNAME = ActiveMQConnectionFactory.DEFAULT_USER;// 默认的连接的用户名  
    private static final String PASSWORD = ActiveMQConnectionFactory.DEFAULT_PASSWORD;// 默认的连接密码  
    private static final String BROKEURL = ActiveMQConnectionFactory.DEFAULT_BROKER_URL;// 默认的连接地址  
    //private static final int SENDNUM = 10;// 发送消息的数量  
	 ConnectionFactory connectionFactory;// 连接工厂  
     Connection connection = null;// 连接  
     Session session;// 会话 发送或者接受消息的线程  
     Destination destination;// 消息的目的地  
     MessageProducer messageProducer;// 消息生产者
     TextMessage message;
    public void producer() throws JMSException{
  
         // 实例化连接工厂  
         connectionFactory = new ActiveMQConnectionFactory(JMSProducer.USERNAME, JMSProducer.PASSWORD,  
                 JMSProducer.BROKEURL);  
   
         try {  
             // 通过连接工厂获取连接  
             connection = connectionFactory.createConnection();  
             // 启动连接  
             connection.start();  
             session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);  
             destination = session.createTopic("AFTN");// 创建消息队列  
             messageProducer = session.createProducer(destination);// 创建消息生产者   
   
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
   
     // 发送消息  
    // public static void sendMessage(Session session, MessageProducer messageProducer) throws SOAPException {  
    	 public  void sendMessage() throws JMSException {
     
             try { 
             messageProducer.send(message);  
             // 由于设置添加事务，这里需要使用提交才能将数据发送出去  
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

