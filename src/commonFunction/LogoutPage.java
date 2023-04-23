package commonFunction;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage {
	@FindBy(xpath = "//a[@id='welcome']")
	WebElement clickwelcome;
	@FindBy(xpath = "//a[normalize-space()='Logout']")
	WebElement clickLogoutbtn;
	public void verify_logout() {
		clickwelcome.click();
		clickLogoutbtn.click();
	}
	

}
