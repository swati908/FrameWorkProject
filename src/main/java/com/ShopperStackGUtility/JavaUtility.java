package com.ShopperStackGUtility;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

public class JavaUtility 
{
	
	public int randomNumber() 
{
		Random r=new Random();
		int num= r.nextInt(1000);
		return num;
	}
	
	public void Localdate() 
	{
		LocalDate.now().toString().replace("-","");
		
	}
	public String localDateTime() {
		String datetime=LocalDateTime.now().toString().replace("-","").replace(":","").replace(".","");
		return datetime;
		
	}

}
