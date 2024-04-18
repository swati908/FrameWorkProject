package com.ShopperStack.testScript;



import org.testng.annotations.Test;
import com.ShopperStack.Pom.MyAddressPage;
import com.ShopperStack.Pom.MyProfilePage;
import com.ShopperStackGUtility.BaseTest;

public class Verify_user_is_able_delete_address_Test extends BaseTest{
	@Test
	public void deleteAddress() throws InterruptedException
	{
		
		MyProfilePage profilePage=new MyProfilePage(driver);
		profilePage.getMyAddressBtn().click();
		
		MyAddressPage addressPage=new MyAddressPage(driver);
		addressPage.getAddAddressBtn().click();
		
		Thread.sleep(3000);
		addressPage.getDeleteAdress().click();
		Thread.sleep(3000);
		addressPage.getYesBtn().click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
	
	}

}
