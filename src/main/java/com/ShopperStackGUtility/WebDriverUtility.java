package com.ShopperStackGUtility;

import java.io.File;	
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;


public class WebDriverUtility {
	Select sel;
	File temp;
	File dest;
	
	public void selectByValue(WebElement element,String value) {
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	public void selectByIndex(WebElement element,int index) {
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	public void selectByvisiblity(WebElement element,String value) {
		Select sel=new Select(element);
		sel.selectByVisibleText(value);
	}

	
	public void screenshotWebpage(WebDriver driver) throws IOException{
		TakesScreenshot ts=(TakesScreenshot) driver;
		temp=ts.getScreenshotAs(OutputType.FILE);
		dest=new File("./screenshot");
		FileHandler.copy(temp, dest);	
	}
		
	public void screenshotWebelement(WebElement element) throws IOException {
		temp=element.getScreenshotAs(OutputType.FILE);
		dest=new File("./screenshot");
		FileHandler.copy(temp, dest);
	}
	
}
