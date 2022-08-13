package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POMClass {
@FindBy(xpath="//input[@id='userid']")private WebElement userID;
	
	@FindBy(xpath="//button[@type='submit']")private WebElement loginBtn;
	
	@FindBy(xpath="//span[contains(text(),'Password')]")private WebElement pwdErrMsg;
	
	@FindBy(xpath="//input[@type='password']")private WebElement password;
	
	@FindBy(xpath="//span[contains(text(),'User ID')]")private WebElement userIdErrMsg;
	 
	public ZerodhaLogin1POM(WebDriver driver){  // Parameterized constructor
		PageFactory.initElements(driver,this); // class.method name
	}
	
	public void enterKiteID(String Uid) {
		userID.sendKeys(Uid);
	}
	
	public void clickKiteLogin() {
		loginBtn.click();
	}
	
	public String getpwdErrMsg() {  // return type
		String msg = pwdErrMsg.getText(); 
		
		return msg;
	}
	
	public void enterKitePwd(String Pwd) {
		password.sendKeys(Pwd);
	}
	
	public String getUidErrMsg() {
		String msg1 = userIdErrMsg.getText();
		
		return msg1;
	}
}
