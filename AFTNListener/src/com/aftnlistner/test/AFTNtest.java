package com.aftnlistner.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.jms.JMSException;
//import javax.xml.soap.SOAPException;

import com.aftnlistener.bean.Aftn;
import com.aftnlistener.bean.Aircraft;

import com.aftnlistener.impl.AircraftImpl;
import com.aftnlistner.Listner.MySaveListner;
import com.jms.producer.*;

public class AFTNtest {

	public static void main(String[] args) throws IOException,  JMSException {
		// TODO Auto-generated method stub
		String filePath = "E:\\JYC\\JYC的资料\\SWIM\\swim基础工作（研二下）\\20170417\\测试AFTN解析模块用的报文例子\\aftn-fpl（2）.txt";
		String s=null;
		s=readTxtFile(filePath);
		//AFTNimpl aftnimpl=new AFTNimpl();
		 AircraftImpl aircraftImpl=new AircraftImpl();
		//创建Aftn对象和Aircraft对象
		Aftn aftn=new Aftn();
		Aircraft aircraft=new Aircraft();
		//编组解析
		GroupAnalysis groupAnalysis=new GroupAnalysis(); 
		String group3=groupAnalysis.Group3(s);
		String group5=groupAnalysis.Group5(s);
		String group7=groupAnalysis.Group7(s);
		String group8=groupAnalysis.Group8(s);
		String group9=groupAnalysis.Group9(s);
		String group10=groupAnalysis.Group10(s);
		String group13=groupAnalysis.Group13(s);
		String group14=groupAnalysis.Group14(s);
		String group15=groupAnalysis.Group15(s);
		String group16=groupAnalysis.Group16(s);
		String group17=groupAnalysis.Group17(s);
		String group18=groupAnalysis.Group18(s);
		String group19=groupAnalysis.Group19(s);
		String group20=groupAnalysis.Group20(s);
		String group21=groupAnalysis.Group21(s);
		String group22=groupAnalysis.Group22(s);
		aftn.set编组3(group3);
		aftn.set编组5(group5);
		aftn.set编组7(group7);
		aftn.set编组8(group8);
		aftn.set编组9(group9);
		aftn.set编组10(group10);
		aftn.set编组13(group13);
		aftn.set编组14(group14);
		aftn.set编组15(group15);
		aftn.set编组16(group16);
		aftn.set编组17(group17);
		aftn.set编组18(group18);
		aftn.set编组19(group19);
		aftn.set编组20(group20);
		aftn.set编组21(group21);
		aftn.set编组22(group22);
		//使用置值方法将aftn的字段置值到aircraft对象中
		SetMethodCollection setMethodCollection=new SetMethodCollection();
		setMethodCollection.AircraftSetMethod(aircraft, aftn);
//		AircraftDAO aircraftdao=new AircraftDAO();
//		aircraftdao.save(aircraft);
		//使用实施类进行aircraft对象添加到数据库的事务
		aircraftImpl.addinfo(aircraft);
		aircraftImpl.Aircraftimplevent=MySaveListner.event;
		System.out.println(aircraftImpl.Aircraftimplevent.getObject());
	
		if(!aircraftImpl.Aircraftimplevent.getObject().equals(null)){
			JMSProducer jmsProducer=new JMSProducer();
			jmsProducer.producer();
			jmsProducer.textMessageGenerate("xml_file");
			jmsProducer.sendMessage();
			jmsProducer.close();
		}
		
		
	}
	public static String readTxtFile(String filePath) throws IOException{
		 try{
	           File file=new File(filePath);
	           FileInputStream inStream=new FileInputStream(file);
	           ByteArrayOutputStream bos = new ByteArrayOutputStream();

	          byte[] buffer=new byte[1024];

	           int length=-1;

	           while( (length = inStream.read(buffer)) != -1)
	            {

	                bos.write(buffer,0,length);

	                // .write方法 SDK 的解释是 Writes count bytes from the byte array buffer starting at offset index to this stream.

	                //  当流关闭以后内容依然存在

	            }

	            bos.close();

	            inStream.close();

	           return bos.toString();         

	        }catch(Exception e){
	        	System.out.println("读取文件内容出错");
	            e.printStackTrace();
	        return "error";
	        }

	    }


}
