package com.aftnlistner.test;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.aftnlistener.bean.Aftn;
import com.aftnlistener.bean.Aircraft;;
public class SetMethodCollection {
	
public void AircraftSetMethod(Aircraft aircraft,Aftn aftn){
	//声明所有aftn编组以及字段，以及以空格隔开的字符串数组
	String group7a;
	String[] group7;
	String group19;
	String group19g;
	String[] group19gsplit;
	String group9a,group9b,group9c;
	String[] group9;
	String group18=aftn.get编组18();
	String group18AircraftAddress,group18AircraftAppoarchCataloge;
	//将编组7中的字段set进aircraft的aircraftRegistration
	
	group7=aftn.get编组7().split("\\/");
	group7a=group7[0];
	aircraft.setAircraftRegistration(group7a);
	
	//将编组19字段写入aircraft的aircraftColour字段
	//将编组19中A/...的字段提取并按空格分离
	group19=aftn.get编组19();
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
			//将A/..  ..字段中第一个单词赋值给颜色
		    aircraft.setColourCode(group19gsplit[0].substring(2));
		    //将A/.. ..字段中第二个单词赋值给重要标志
		    aircraft.setSignificantMarkings(group19gsplit[1]);
		}else{
			   aircraft.setColourCode(group19gsplit[0].substring(2));
			    //将A/.. ..字段中没有第二个单词，将重要标志置值null
			    aircraft.setSignificantMarkings(null);
		}
	
	}else{
		  aircraft.setColourCode(null);
		  aircraft.setSignificantMarkings(null);
	}

    

	//例如-03ZZZZ/M 03是指三个飞机
	 group9a=aftn.get编组9().substring(1,2);
	 group9=aftn.get编组9().split("\\/");
	if(!group9a.matches("\\d{2}")){
		group9a=null;
		group9b=group9[0];
		group9c=group9[1];
	}else{
		group9b=group9[0].substring(2);
		group9c=group9[1];
	}
	//group9a转成Integer类型，并设置到aircraft中
	if(!(group9a==null)){
		Integer  group9aInt=new Integer(group9a);
		aircraft.setNumberofAircraft(group9aInt);
	}else{
		aircraft.setNumberofAircraft(null);
	}
	
	
	
	//group9b飞机型号设置入aircraftType中参数的设置
	aircraft.setIcaoAircraftTypeReference(group9b);
	
	//group9c设置进入尾流类型
	aircraft.setWakeTurbulenceCategory(group9c);
	
	//AircraftAddress的置值
	Pattern patterngroup18AircraftAddress=Pattern.compile("CODE\\/");
	Matcher matchergroup18AircraftAddress = patterngroup18AircraftAddress.matcher(group18);
	if(matchergroup18AircraftAddress.find()){
		group18AircraftAddress=matchergroup18AircraftAddress.group();
		aircraft.setAircraftAddress(group18AircraftAddress.substring(5));
	}else{
		group18AircraftAddress=null;
		//aircraft.setAircraftAddress(null);
	}
	
	
	//AircraftAppoarchCataloge的置值
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
