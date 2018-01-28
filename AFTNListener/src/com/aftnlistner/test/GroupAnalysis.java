package com.aftnlistner.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroupAnalysis {
	public int AFTNCataloge(String s){
		String substring=s.substring(1,4);
		System.out.println(substring);
		int flag;
		if(substring=="FPL"){
			flag=1;
			return flag;
			
		}else{
			flag=0;
			return flag;
		}
	}
	public  String Group3(String s){
		Pattern pattern = Pattern.compile("(\\((FPL|CHG|CNL|DEP|ARR|DLA|CPL|EST|CDN|ACP|LAM|RQP|RQS|SPL|ALR|RCF)|\\((FPL|CHG|CNL|DEP|ARR|DLA|CPL|EST|CDN|ACP|LAM|RQP|RQS|SPL|ALR|RCF)[A-Z]{1,4}\\/[A-Z]{1,4}\\d{3}[A-Z]{1,4}\\/[A-Z]{1,4}\\d{3})");
		Matcher matcher = pattern.matcher(s);
		if(matcher.find()){
			System.out.println("success3");
			System.out.println(matcher.group());
			return matcher.group();
			}else{
				return "fail3";
			}	
	 }
	public  String Group5(String s){
		Pattern pattern = Pattern.compile("\\-(INCERFA|ALERFA|DETRESFA)\\/([A-Z]{4}[A-Z]{3})([A-Z]{1}|\\bX)\\/.*");
		Matcher matcher = pattern.matcher(s);
		if(matcher.find()){
			System.out.println("success5");
			System.out.println(matcher.group());
			return matcher.group();
			}else{
				return "fail5";
			}	
	 }
	
	public String Group7(String s){
		Pattern pattern = Pattern.compile("\\-([A-Z]{3}\\d{4}|[A-Z]{3}\\d{3}([Q-Z]{1})?)(\\/A\\d{4})?");
		Matcher matcher = pattern.matcher(s);
		if(matcher.find()){
			System.out.println("success7");
			System.out.println(matcher.group());
			return matcher.group();
			}else{
				return "fail7";
			}
		
	}
	public String Group8(String s){
		Pattern pattern = Pattern.compile("\\-(([IVYZ]{1}[GMNSX]{1})|([IVYZ]{1}£ªB))\\b");
		Matcher matcher = pattern.matcher(s);
		if(matcher.find()){
			System.out.println("success8");
			System.out.println(matcher.group());
			return matcher.group();
			}else{
				return "fail8";
			}
		
	}
	public String Group9(String s){
		Pattern pattern = Pattern.compile("\\-\\d{0,2}\\w{2,4}\\/[HML]{1}");
		Matcher matcher = pattern.matcher(s);
		if(matcher.find()){
			System.out.println("success9");
			System.out.println(matcher.group());
			return matcher.group();
			}else{
				return "fail9";
			}
		
	}
	public String Group10(String s){
		Pattern pattern = Pattern.compile("\\-([NS]{1}[A-Z]{1,24}\\/[NACXPISD]{1,2})");
		Matcher matcher = pattern.matcher(s);
		if(matcher.find()){
			System.out.println("success10");
			System.out.println(matcher.group());
			return matcher.group();
			}else{
				return "fail10";
			}
		
	}
	public String Group13(String s){
		//Pattern pattern = Pattern.compile("\\-([A-Z]{4}|AFIL)\\s|\\-([A-Z]{4}|AFIL)\\d{4}(\\s\\-|\\-)||\\-([A-Z]{4}|AFIL)\\d{4}");
		//Pattern pattern = Pattern.compile("\\-([A-Z]{4}|AFIL)\\s|\\-([A-Z]{4}|AFIL)\\d{4}(\\s\\-|\\-)|\\-([A-Z]{4}|AFIL)\\d{4}");
		Pattern pattern = Pattern.compile("\\-([A-Z]{4}|AFIL)\\d{4}");
		Matcher matcher = pattern.matcher(s);
		if(matcher.find()){
			System.out.println("success13");
			System.out.println(matcher.group());
			return matcher.group();
			}else{
				return "fail13";
			}
		
	}
	public String Group14(String s){
		Pattern pattern = Pattern.compile("\\-\\w{2,11}\\/\\d{4}(M\\d{4}?|S\\d{4}?|A\\d{3}?|F\\d{3}?){1,2}([AB]{1})?");
		Matcher matcher = pattern.matcher(s);
		if(matcher.find()){
			System.out.println("success14");
			System.out.println(matcher.group());
			return matcher.group();
			}else{
				return "fail14";
			}
		
	}
	public String Group15(String s){
		Pattern pattern = Pattern.compile("\\-(K\\d{4}?|N\\d{4}?|M\\d{3}?)(M\\d{4}?|S\\d{4}?|A\\d{3}?|F\\d{3}?)\\s(.*[^=.:]\\n)+?");
		Matcher matcher = pattern.matcher(s);
		if(matcher.find()){
			System.out.println("success15");
			System.out.println(matcher.group());
			return matcher.group();
			}else{
				return "fail15";
			}
		
	}
	public String Group16(String s){
		Pattern pattern = Pattern.compile("\\-[A-Z]{4}\\)|\\-[A-Z]{4}(\\d{4})\\s[A-Z]{4}(\\s[A-Z]{4})?");
		Matcher matcher = pattern.matcher(s);
		if(matcher.find()){
			System.out.println("success16");
			System.out.println(matcher.group());
			return matcher.group();
			}else{
				return "fail16";
			}
		
	}
	public String Group17(String s){
		Pattern pattern = Pattern.compile("\\-[A-Z]{4}\\d{4}\\)|\\-[A-Z]{4}\\d{4}\\s[A-Z]{5,}");
		Matcher matcher = pattern.matcher(s);
		if(matcher.find()){
			System.out.println("success17");
			System.out.println(matcher.group());
			return matcher.group();
			}else{
				return "fail17";
			}
	
	}
	public String Group18(String s){
		Pattern pattern = Pattern.compile("\\-0|((\\-)?EET.*(\\n.*)?|(\\-)?RIF.*(\\n.*)?|(\\-)?\\s?REG.*(\\n.*)?|(\\-)?SEL\\s.*(\\n.*)?|(\\-)?OPR.*(\\n.*)?|(\\-)?STS.*(\\n.*)?|(\\-)?TYP.*(\\n.*)?|(\\-)?PER.*(\\n.*)?|(\\-)?COM.*(\\n.*)?|(\\-)?DAT\\s.*(\\n.*)?|(\\-)?NAV.*(\\n.*)?|(\\-)?\\sDEP.*(\\n.*)?|(\\-)?DEST.*(\\n.*)?|(\\-)?ALTN.*(\\n.*)?|(\\-)?RALT.*(\\n.*)?|(\\-)?RMK.*(\\n.*)?)");
		Matcher matcher = pattern.matcher(s);
		if(matcher.find()){
			System.out.println("success18");
			System.out.println(matcher.group());
			return matcher.group();
			}else{
				return "fail18";
			}
	
	}
	public String Group19(String s){
		Pattern pattern = Pattern.compile("(\\-E\\/\\d{4})?(\\sP\\/\\d{1,3})?(\\sR\\/[UVE]{1,3})?(\\sS\\/[PDMJ]{1,4})(\\sJ[\\/LFUV]{1,4})?(\\sD\\/\\d{1}\\s\\d{2}\\sC\\s[A-Z]{3,})?(\\sD\\/[A-Z]{3,10}\\s\\w{1,7})?(\\sA\\/.*)?(\\sN\\/.*)? ");
		Matcher matcher = pattern.matcher(s);
		if(matcher.find()){
			System.out.println("success19");
			System.out.println(matcher.group());
			return matcher.group();
			}else{
				return "fail19";
			}
	
	}
	public String Group20(String s){
		Pattern pattern = Pattern.compile("\\-NIL|\\-NOT\\sKNOWN|(\\-[A-Z]{2}|\\-[A-Z]{3,10})\\s[A-Z]{4}([A-Z]{2}|\\w{2})\\s\\d{4}\\s\\d{2,3}\\.\\d{1,2}.*");
		Matcher matcher = pattern.matcher(s);
		if(matcher.find()){
			System.out.println("success20");
			System.out.println(matcher.group());
			return matcher.group();
			}else{
				return "fail19";
			}
	
	}
	public String Group21(String s){
		Pattern pattern = Pattern.compile("\\-NIL|\\-NOT\\sKNOWN|\\-\\d{4}\\s\\d{2,3}\\.\\d{1,2}\\s\\w{2,11}[^_]\\s\\d{4}\\s[A-Z]{1,}\\s.*");
		Matcher matcher = pattern.matcher(s);
		if(matcher.find()){
			System.out.println("success21");
			System.out.println(matcher.group());
			return matcher.group();
			}else{
				return "fail21";
			}
	
	}
	public String Group22(String s){
		Pattern pattern = Pattern.compile("\\-((3|5|7|8|9|10|13|14|15|16|17|18|19|20|21|22)\\/\\w{2,10})(\\/\\w{1,10})?");
		Matcher matcher = pattern.matcher(s);
		if(matcher.find()){
			System.out.println("success22");
			System.out.println(matcher.group());
			return matcher.group();
			}else{
				return "fail22";
			}
	
	}
}
