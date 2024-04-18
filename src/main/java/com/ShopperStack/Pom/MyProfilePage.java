package com.ShopperStack.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class MyProfilePage {
	
	public MyProfilePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		
	}
	@FindBy(xpath = "//div[text()='My Address']")
	private WebElement myAddressBtn;
	
	public WebElement getMyAddressBtn() {
		return myAddressBtn;
	}
	
	

}
