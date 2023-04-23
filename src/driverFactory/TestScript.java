package driverFactory;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import commonFunction.AddEmpPage;
import config.AppUtilPom;

public class TestScript extends AppUtilPom {

	@Test
	public void StartTest()
	{
		AddEmpPage emp=PageFactory.initElements(driver, AddEmpPage.class);
		boolean result = emp.Verify_addemp("Jagruti", "Vivek", "Vaghela");
		Reporter.log("Result is::"+result);
	}

}
