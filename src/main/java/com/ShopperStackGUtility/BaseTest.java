package com.ShopperStackGUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.ShopperStack.Pom.HomePage;
import com.ShopperStack.Pom.LoginPage;
import com.ShopperStack.Pom.WelcomePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class BaseTest {

	public WebDriver driver;
	public static WebDriver listenersDriver;
	public FileUtility file= new FileUtility();
	public WebDriverUtility webdiverutil=new WebDriverUtility();
	public ExtentSparkReporter spark;
	public ExtentReports report;
	public ExtentTest test;
	public JavaUtility java=new JavaUtility();
	public HomePage homePage;

	@BeforeSuite
	public void bs() {
		System.out.println("Before Suit");
		spark=new ExtentSparkReporter("./Reports/"+java.localDateTime()+".html");
	}
	@BeforeTest
	public void bt() {

		System.out.println("Before Test");
		report =new ExtentReports();
		report.attachReporter(spark);
		test=report.createTest("demo");
	}

	@BeforeClass
	public void bc() throws IOException {

		String url = file.readPropertyData("url");
		String browser = file.readPropertyData("browser");

		System.out.println("Before Class");

		if(browser.equals("Chrome")) {
			driver =new ChromeDriver();

		}
		else if (browser.equals("edge")) {
			driver=new EdgeDriver();

		}
		else {
			System.out.println("Enter valid Browser Name");
		}
		listenersDriver=driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(url);
		
		
	}
	@BeforeMethod
	public void bm() throws IOException, InterruptedException 
	{
		
		System.out.println("BeforeMethod");
		test.log(Status.INFO, "Navigated");
		
		WelcomePage welcomepage=new WelcomePage(driver);
		Thread.sleep(3000);
		
		welcomepage.getLoginButton().click();
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.getEmail().sendKeys(file.readPropertyData("username"));
		loginPage.getPassword().sendKeys(file.readPropertyData("password"));
		loginPage.getLoginBtn().click();
		
	}
	

	@AfterMethod
	public void am() {
		System.out.println("After Method");
		homePage.getAccountBtn().click();
		homePage.getLogoutBtn().click();
			
	}
	
	@AfterClass
	public void ac() throws InterruptedException {
	 System.out.println("After Class");
	 Thread.sleep(3000);
	 driver.quit();
 }
	
	
	@AfterTest
	public void at() {
	System.out.println("After Test");
	report.flush();
	
}
	@AfterSuite
	public void as() {
		System.out.println("After Suite");
	}
}
