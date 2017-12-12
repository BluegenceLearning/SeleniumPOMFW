package testScripts;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import Factory.*;
import Pages.LoginPage;

public class VerifyLoginPage extends BaseClass {
	
	
	@Test
	public static void PegaEFOLogin() {
			  
    test = extent.createTest("Login Page", "This test case will verify Passed Login Page");
    test.log(Status.INFO, "Start of the Login test case");
		  
	LoginPage login = PageFactory.initElements(driver, LoginPage.class);

	login.clickOnLogin(DataProviderFactory.getExcelDataProvider().getData(0,1,0), DataProviderFactory.getExcelDataProvider().getData(0,1,1));

	test.log(Status.PASS, "Test Case is passed");
	test.log(Status.INFO, "End of the Test Case");	
		
			}
	

}
