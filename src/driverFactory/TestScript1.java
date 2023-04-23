package driverFactory;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunction.AddEmpPage;
import config.AppUtilPom;
import utilities.ExcelFileUtil;

public class TestScript1 extends AppUtilPom {
	String inputpath="E:\\SELENIUM_TESTING\\DDT_Framework\\FileInput\\EmployeeData.xlsx";
	String outputpath="E:\\SELENIUM_TESTING\\DDT_Framework\\FileOutput\\EmpResult.xlsx";
	ExtentReports report;
	ExtentTest test;
	@Test
	public void StartTest()throws Throwable
	{
		AddEmpPage emp=PageFactory.initElements(driver,AddEmpPage.class);
		ExcelFileUtil xl=new ExcelFileUtil(inputpath);
		int rc=xl.rowCount("EmpData");
		report=new ExtentReports("E:\\SELENIUM_TESTING\\DDT_Framework\\ExtentReport\\addemp.html");
		for(int i=1;i<=rc;i++)
		{
			test=report.startTest("AddEmployee");
			test.assignAuthor("Jagruti");
			String Firstname=xl.getCellData("EmpData", i, 0);
			String Middlename=xl.getCellData("EmpData", i, 1);
			String Lastname=xl.getCellData("EmpData", i, 2);
			boolean res=emp.Verify_addemp(Firstname, Middlename, Lastname);
			if(res)
			{
				xl.setCelldata("EmpData", i, 3, "Pass", outputpath);
				test.log(LogStatus.PASS, "Add Employee success");
			}
			else
			{
				xl.setCelldata("EmpData", i, 3, "Fail", outputpath);
				test.log(LogStatus.FAIL, "Add Employee Failed");

			}
		}
		
		
	}

}
