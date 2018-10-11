package com.yqjr.fin.risk.stat.utils;

import java.util.regex.Pattern;

public class TimeSetting {

	public static String translation(String str) {
		String[] cronArray=str.split(" ");
		String[] timeArray= {"秒","分","点","日","月","周","年"};
		String returnString="";
		
		
		for (int i = 0; i < cronArray.length; i++) {
			if (cronArray[i].equals("*")) {
				returnString="每"+timeArray[i].replaceAll("点", "个小时")+returnString;
			}else if(cronArray[i].equals("?")) {
			}else if(Pattern.matches("\\d{1,4}", cronArray[i])) {
				//纯数字
	            returnString="第"+cronArray[i]+timeArray[i]+returnString;
			}else if(Pattern.matches("\\d{1,4}-\\d{1,4}", cronArray[i])) {
				String digitalString="";
				String[] multipleString=cronArray[i].split("-");
				for (int j =  Integer.parseInt(multipleString[0]); j <= Integer.parseInt(multipleString[1]) ; j++) {
					digitalString=digitalString+j+",";
				}
				digitalString=digitalString.substring(0, digitalString.length()-1);
				returnString=digitalString+timeArray[i]+returnString;
			}else if(Pattern.matches("\\d{1,4}/\\d{1,4}", cronArray[i])) {
				//  /每
				String[] multipleString=cronArray[i].split("/");
				returnString="第"+multipleString[0]+timeArray[i]+"开始每隔"+multipleString[1]+timeArray[i]+returnString;
			}	
		}
		returnString=returnString.replace("每年每月", "每月").replace("每月每日", "每日").replace("每日每个小时", "每个小时").replace("每个小时每分", "每分钟");
		return returnString;
	}
	

}
