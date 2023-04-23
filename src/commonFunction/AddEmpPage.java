package commonFunction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AddEmpPage {
	WebDriver driver;
	public AddEmpPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(xpath = "//b[normalize-space()='PIM']")
	WebElement clickpim;
	@FindBy(xpath = "//input[@id='btnAdd']")
	WebElement clickAddbtn;
	@FindBy(name = "firstName")
	WebElement Enterfname;
	@FindBy(name = "middleName")
	WebElement Entermname;
	@FindBy(name = "lastName")
	WebElement Enterlname;
	@FindBy(xpath = "//input[@id='employeeId']")
	WebElement BeforeEid;
	@FindBy(xpath = "//input[@id='btnSave']")
	WebElement clicksavebtn;
	
	@FindBy(xpath = "//input[@id='personal_txtEmployeeId']")
	WebElement AfterEid;
	public boolean Verify_addemp(String fname,String Mname,String Lname)
	{
		Actions ac=new Actions(driver);
		ac.moveToElement(this.clickpim).click().perform();
		ac.moveToElement(this.clickAddbtn).click().perform();
		this.Enterfname.sendKeys(fname);
		this.Entermname.sendKeys(Mname);
		this.Enterlname.sendKeys(Lname);
		String ExpectedEid=BeforeEid.getAttribute("value");
		ac.moveToElement(this.clicksavebtn).click().perform();
		String ActualEid=AfterEid.getAttribute("value");
		if(ExpectedEid.equals(ActualEid))
		{
			Reporter.log("Add Employee Successfully::"+"    "+ExpectedEid+"     "+ActualEid);
			return true;
		}
		else
		{
			Reporter.log("Add Employee Failed::"+"    "+ExpectedEid+"     "+ActualEid);
			return false;
		}
		
	}
	
	

}
