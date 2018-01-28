package com.aftnlistner.test;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.aftnlistener.bean.Aftn;
import com.aftnlistener.bean.Aircraft;;
public class SetMethodCollection {
	
public void AircraftSetMethod(Aircraft aircraft,Aftn aftn){
	//��������aftn�����Լ��ֶΣ��Լ��Կո�������ַ�������
	String group7a;
	String[] group7;
	String group19;
	String group19g;
	String[] group19gsplit;
	String group9a,group9b,group9c;
	String[] group9;
	String group18=aftn.get����18();
	String group18AircraftAddress,group18AircraftAppoarchCataloge;
	//������7�е��ֶ�set��aircraft��aircraftRegistration
	
	group7=aftn.get����7().split("\\/");
	group7a=group7[0];
	aircraft.setAircraftRegistration(group7a);
	
	//������19�ֶ�д��aircraft��aircraftColour�ֶ�
	//������19��A/...���ֶ���ȡ�����ո����
	group19=aftn.get����19();
	Pattern patternAircraft = Pattern.compile("A\\/");
	Matcher matcherAircraft = patternAircraft.matcher(group19);
	if(matcherAircraft.find()){
		group19g=matcherAircraft.group();
	}else{
		group19g=null;
	}
	
	if(!(group19g==null)){
		group19gsplit=group19g.split("\\s");
	
		if(group19gsplit.length>1){
			//��A/..  ..�ֶ��е�һ�����ʸ�ֵ����ɫ
		    aircraft.setColourCode(group19gsplit[0].substring(2));
		    //��A/.. ..�ֶ��еڶ������ʸ�ֵ����Ҫ��־
		    aircraft.setSignificantMarkings(group19gsplit[1]);
		}else{
			   aircraft.setColourCode(group19gsplit[0].substring(2));
			    //��A/.. ..�ֶ���û�еڶ������ʣ�����Ҫ��־��ֵnull
			    aircraft.setSignificantMarkings(null);
		}
	
	}else{
		  aircraft.setColourCode(null);
		  aircraft.setSignificantMarkings(null);
	}

    

	//����-03ZZZZ/M 03��ָ�����ɻ�
	 group9a=aftn.get����9().substring(1,2);
	 group9=aftn.get����9().split("\\/");
	if(!group9a.matches("\\d{2}")){
		group9a=null;
		group9b=group9[0];
		group9c=group9[1];
	}else{
		group9b=group9[0].substring(2);
		group9c=group9[1];
	}
	//group9aת��Integer���ͣ������õ�aircraft��
	if(!(group9a==null)){
		Integer  group9aInt=new Integer(group9a);
		aircraft.setNumberofAircraft(group9aInt);
	}else{
		aircraft.setNumberofAircraft(null);
	}
	
	
	
	//group9b�ɻ��ͺ�������aircraftType�в���������
	aircraft.setIcaoAircraftTypeReference(group9b);
	
	//group9c���ý���β������
	aircraft.setWakeTurbulenceCategory(group9c);
	
	//AircraftAddress����ֵ
	Pattern patterngroup18AircraftAddress=Pattern.compile("CODE\\/");
	Matcher matchergroup18AircraftAddress = patterngroup18AircraftAddress.matcher(group18);
	if(matchergroup18AircraftAddress.find()){
		group18AircraftAddress=matchergroup18AircraftAddress.group();
		aircraft.setAircraftAddress(group18AircraftAddress.substring(5));
	}else{
		group18AircraftAddress=null;
		//aircraft.setAircraftAddress(null);
	}
	
	
	//AircraftAppoarchCataloge����ֵ
	Pattern patterngroup18AircraftAppoarchCataloge=Pattern.compile("PER\\/");
	Matcher matchergroup18AircraftAppoarchCataloge = patterngroup18AircraftAppoarchCataloge.matcher(group18);
	if(matchergroup18AircraftAppoarchCataloge.find()){
		group18AircraftAppoarchCataloge=matchergroup18AircraftAppoarchCataloge.group();
		aircraft.setAircraftApproachCategory(group18AircraftAppoarchCataloge.substring(4));
	}else{
		group18AircraftAppoarchCataloge=null;
		//aircraft.setAircraftApproachCategory(null);
	}
	
  }
}
