package commonFunction;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	@FindBy(xpath = "//input[@id='txtUsername']")
	WebElement enteruser;
	@FindBy(xpath = "//input[@id='txtPassword']")
	WebElement enterpass;
	@FindBy(xpath = "//input[@id='btnLogin']")
	WebElement clickbtn;
	public  void Verify_login(String username,String password)
	{
		enteruser.sendKeys(username);
		enterpass.sendKeys(password);
		clickbtn.click();
	}
	

}
