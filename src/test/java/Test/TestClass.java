package Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClasses.UtilityClass;
import BaseClasses.ZerodhaBase;
import POMClass.ZerodhaLogin1POM;

public class TestClass {
	ZerodhaBase base;
	WebDriver driver;
	ZerodhaLogin1POM login;
	String tcID;
	
	@BeforeClass
	public void OpenBrowser() {
		Reporter.log("---Open Browser---", true);
		base = new ZerodhaBase();
		driver = base.LaunchBrowser();
		login = new ZerodhaLogin1POM(driver);
	}
	
	@BeforeMethod
	public void refreshMethod() {
		driver.navigate().refresh();
	}
	
	@Test
	public void LoginScenario1() {
    tcID = "tc002";
    Reporter.log("----TC Name: Login Negative Test- Balnk Password----", true);
    
	// Enter User ID
	login.enterKiteID("KTS907");
	
	// Click on Login Button
	login.clickKiteLogin();
	
	
	//Get Password Error Msg from app 
	String  actErrMsg = login.getpwdErrMsg();
	
	String expErrMsg = "Password should be minimum 6 characters.";
	
	// Verification
   Assert.assertEquals(actErrMsg, expErrMsg);
	}
	
	@Test
	public void LoginScenario2() {
		
	tcID = "tc002";
	Reporter.log("---- Login Negative Test- Balnk user id----", true);
	
	// Enter Password
	login.enterKitePwd("Sadahar047");
	
	// Click on Login Button
	login.clickKiteLogin();
	
	// Get User ID Error Msg from app
	String actErrMsg1 = login.getUidErrMsg();
	
	String expErrMsg1 = "User ID should be minimum 6 characters";
	
	// Verification
	Assert.assertEquals(actErrMsg1, expErrMsg1);
	
		}
	
	@Test
	public void LoginScenario3 () {
	
		tcID ="tc001";
		Reporter.log("----Login Negative Test- Blank credentials----", true);
		
		// Click on Login Button
		login.clickKiteLogin();
		
		// Get Error Msg for password from app
		String  actErrMsg = login.getpwdErrMsg();
		String expErrMsg = "Password should be minimum 6 characters.";
		
		//Verification Error Msg for Password
		Assert.assertEquals(actErrMsg, expErrMsg);
		
		//Get Error Msg for User ID from app
		String actErrMsg1 = login.getUidErrMsg();
		String expErrMsg1 = "User ID should be minimum 6 characters.";
		
		// Verification Error Msg for User ID
		Assert.assertEquals(actErrMsg1, expErrMsg1);
	}
	
	@AfterMethod
	public void Screenshot(ITestResult result) throws IOException {
		if(ITestResult.FAILURE==result.getStatus()) {
			UtilityClass.takeScreenshot(driver,tcID);
		}
	}
	
	@AfterClass
	public void closeBrowser() {
	Reporter.log("----close browser----", true);
	driver.close();	
	}
	
}
