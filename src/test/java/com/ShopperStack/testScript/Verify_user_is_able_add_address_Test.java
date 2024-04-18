package com.ShopperStack.testScript;

import java.io.IOException;

import org.testng.annotations.Test;
import com.ShopperStack.Pom.AddressFormPage;
import com.ShopperStack.Pom.HomePage;
import com.ShopperStack.Pom.LoginPage;
import com.ShopperStack.Pom.MyAddressPage;
import com.ShopperStack.Pom.MyProfilePage;
import com.ShopperStack.Pom.WelcomePage;
import com.ShopperStackGUtility.BaseTest;


public class Verify_user_is_able_add_address_Test extends BaseTest
{
	@Test	
	public void addAddress() throws IOException {
	
		WelcomePage wcPage=new WelcomePage(driver);
		wcPage .getLoginButton().click();
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.getEmail().sendKeys(file.readPropertyData("username"));
		loginPage.getPassword().sendKeys(file.readPropertyData("password"));
		loginPage.getLoginBtn().click();
		
		HomePage homePage= new HomePage(driver);
		homePage.getAccountBtn().click();
		homePage.getMyProfileBtn().click();
		
	    MyProfilePage myProfilePage=new MyProfilePage(driver);
		myProfilePage.getMyAddressBtn().click();
		
		MyAddressPage myaddressPage=new MyAddressPage(driver);
		myaddressPage.getAddAddressBtn().click();
		
		AddressFormPage addressFormPage=new AddressFormPage(driver);
		addressFormPage.getNameTf().sendKeys(file.readExcelData("Sheet2",1,0));
		addressFormPage.getHouseTf().sendKeys(file.readExcelData("Sheet2",1,1));
		addressFormPage.getStreetTf().sendKeys(file.readExcelData("Sheet2",1,2));
		addressFormPage.getLandmarkTf().sendKeys(file.readExcelData("Sheet2",1,3));
		
		webdiverutil.selectByValue(addressFormPage.getCountryDD(),file.readPropertyData("country"));
		webdiverutil.selectByValue(addressFormPage.getStateDD(),file.readPropertyData("state"));
		webdiverutil.selectByValue(addressFormPage.getCityDD(),file.readPropertyData("city"));
		
		
		addressFormPage.getPincodeTf().sendKeys(file.readExcelData("Sheet2",1,4));
		addressFormPage.getPhoneNumberTf().sendKeys(file.readExcelData("Sheet2",1,5));
		addressFormPage.getAddAddressBtn().click();
		
		homePage.getAccountBtn().click();
		homePage.getLogoutBtn().click();
	
	
	

	}
}
