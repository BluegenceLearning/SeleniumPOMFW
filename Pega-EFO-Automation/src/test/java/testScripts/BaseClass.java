package testScripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import Factory.*;
import org.testng.ITestResult;
//import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseClass {
	
public static WebDriver driver;
public static ExtentHtmlReporter htmlReporter;
public static ExtentReports extent;
public static ExtentTest test;


@BeforeSuite
public static void beforeTest() {

htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/MyExtentReport.html");
extent = new ExtentReports();
extent.attachReporter(htmlReporter);
	  
extent.setSystemInfo("OS", "Windows 7");
extent.setSystemInfo("Host Name", "HTG");
extent.setSystemInfo("Environment", "INT");
extent.setSystemInfo("Project", "Pega EFO");
extent.setSystemInfo("User", "Abhishek V");
	  
htmlReporter.config().setDocumentTitle("Selenium Hybrid Framework");
htmlReporter.config().setReportName("Regression Report");
htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
htmlReporter.config().setTheme(Theme.DARK);
htmlReporter.config().setChartVisibilityOnOpen(true);	
	
driver = BrowserFactory.getBrowser("Chrome");
driver.get(DataProviderFactory.getConfigDataProvider().getApplicationURL());
		
}


@AfterMethod
public void getResult(ITestResult result) {
	  
	if(result.getStatus() == ITestResult.FAILURE){
		
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "Test case FAILED due to below issue", ExtentColor.RED));
		test.fail(result.getThrowable());
		
	} 
	else if(result.getStatus() == ITestResult.SUCCESS){
		
		test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "Test case PASSED", ExtentColor.GREEN));
				
	}
	else {
		
		test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + "Test case SKIPPED", ExtentColor.BLUE));
		test.skip(result.getThrowable());
		
	}
}


@AfterSuite
public static void tearDown() {
	
BrowserFactory.closeBrowser(driver);
extent.flush();
	
}

}
