package commonFunction;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Reporter;

import config.AppUtil;

public class FunctionLibrary extends AppUtil {
public static boolean verify_login(String user,String pass)
{
	driver.get(conpro.getProperty("Url"));
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath(conpro.getProperty("objuser"))).sendKeys(user);
	driver.findElement(By.xpath(conpro.getProperty("objpass"))).sendKeys(pass);
	driver.findElement(By.xpath(conpro.getProperty("objlogin"))).click();
	String expected="dashboard";
	String actual=driver.getCurrentUrl();
	if(actual.contains(expected))
	{
		Reporter.log("Login success::"+"  "+expected+"      "+actual);
		return true;
	}
	else
	{
		String Error_msg=driver.findElement(By.xpath(conpro.getProperty("objerror"))).getText();
		Reporter.log(Error_msg+"    "+expected+"    "+actual);
		return false;
	}
	
	
}

}
