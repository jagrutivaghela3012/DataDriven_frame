package driverFactory;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunction.FunctionLibrary;
import config.AppUtil;
import utilities.ExcelFileUtil;

public class Driverscript extends AppUtil {
	String Fileinputpath="E:\\SELENIUM_TESTING\\DDT_Framework\\FileInput\\LoginData.xlsx";
	String Fileoutputpath="E:\\SELENIUM_TESTING\\DDT_Framework\\FileOutput\\DataDrivernResults.xlsx";
	ExtentReports report;
	ExtentTest test;
	@Test
	public void startTest()throws Throwable
	{
		ExcelFileUtil xl=new ExcelFileUtil(Fileinputpath);
		int rc=xl.rowCount("Login");
		report=new ExtentReports("./ExtentReport/login.html");
		Reporter.log("No of rows are::"+rc);
		for(int i=1;i<=rc;i++)
		{
			test=report.startTest("Validate Login");
			test.assignAuthor("Jagruti");
			String username=xl.getCellData("login", i, 0);
			String password=xl.getCellData("login", i, 1);
			boolean result=FunctionLibrary.verify_login(username, password);
			if(result)
			{
				xl.setCelldata("login", i, 2,"login success",Fileoutputpath);
				xl.setCelldata("login", i, 3, "Pass", Fileoutputpath);
				test.log(LogStatus.PASS, "Login success");
			}
			else
			{
				File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screen, new File("./Screenshort/iteration/"+i+"Loginpage.png"));
				xl.setCelldata("login", i, 2,"login fail",Fileoutputpath);
				xl.setCelldata("login", i, 3, "Fail", Fileoutputpath);
				test.log(LogStatus.FAIL, "Login fail");
			}
			report.endTest(test);
			report.flush();
		}


	}


}
