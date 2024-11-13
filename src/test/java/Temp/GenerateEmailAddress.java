package Temp;

import java.util.Date;

public class GenerateEmailAddress {
	
	public static void main(String[] args) {
		
		Date date=new Date();
		String dateString=date.toString();
		String noSpaceDate=dateString.replaceAll(" ", "");
		String realDateWithoutSpaces=noSpaceDate.replace(":", "");
		
		String emailWithTimeStamp = realDateWithoutSpaces+"@gmail.com";
		System.out.println(emailWithTimeStamp);
		
	}
	
	public static void GenerateEmail()
	{
		Date date=new Date();
		String dateString=date.toString();
		String noSpaceDate=dateString.replaceAll(" ", "");
		String realDateWithoutSpaces=noSpaceDate.replace(":", "");
		
		String emailWithTimeStamp = realDateWithoutSpaces+"@gmail.com";
		System.out.println(emailWithTimeStamp);
		
	}

}
