package config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import commonFunction.LoginPage;
import commonFunction.LogoutPage;

public class AppUtilPom {
	public static WebDriver driver;
@BeforeTest
public void setup()
{
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://orangehrm.qedgetech.com/");
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	LoginPage login=PageFactory.initElements(driver, LoginPage.class);
	login.Verify_login("Admin", "Qedge123!@#");
	
}
@AfterTest
public void teardown()
{
	LogoutPage logout=PageFactory.initElements(driver, LogoutPage.class);
	logout.verify_logout();
	driver.quit();
}
}
