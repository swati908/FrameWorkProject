package com.ShopperStackGUtility;

import java.io.File;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersUtility implements ITestListener,ISuiteListener{
  public JavaUtility javautil=new JavaUtility();


	@Override
	public void onTestFailure(ITestResult result) {
		TakesScreenshot ts=(TakesScreenshot) BaseTest.listenersDriver;
		File temp=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(FrameWorkConstants.screenshotPath+javautil.localDateTime()+".png");
		try {
			FileHandler.copy(temp, dest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
