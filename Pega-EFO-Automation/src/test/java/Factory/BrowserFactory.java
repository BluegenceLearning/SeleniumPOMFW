package Factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public class BrowserFactory {
	
public static WebDriver driver;

public static WebDriver getBrowser(String browserName){

	if(browserName.equalsIgnoreCase("Firefox")){
		  
		  DesiredCapabilities dc = DesiredCapabilities.firefox();
		  dc.setCapability("marionette", true);
		  System.setProperty("webdriver.gecko.driver",DataProviderFactory.getConfigDataProvider().getFirefoxPath());
		  System.out.println("Starting Firefox browser");
		  driver = new FirefoxDriver(dc);  
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  //driver.manage().window().maximize();
		  	  
	   }else if(browserName.equalsIgnoreCase("IE")){
		  
		  System.setProperty("webdriver.ie.driver",DataProviderFactory.getConfigDataProvider().getIEPath());
		  DesiredCapabilities capabilitiesIE = DesiredCapabilities.internetExplorer();
		  capabilitiesIE.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		  System.out.println("Starting IE browser");
		  driver = new InternetExplorerDriver(capabilitiesIE);
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  
	   }else if(browserName.equalsIgnoreCase("Chrome")){
			  
		  ChromeOptions opt = new ChromeOptions();
		  opt.addArguments("disable-extensions");
		  opt.addArguments("--start-maximized");
		  opt.setExperimentalOption("useAutomationExtension", false);
		  System.setProperty("webdriver.chrome.driver",DataProviderFactory.getConfigDataProvider().getChromePath());
		  System.out.println("Starting Chrome browser");
		  driver = new ChromeDriver(opt);
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	   }	
	
return driver;

}

public static void closeBrowser(WebDriver ldriver){
	
ldriver.quit();	
	
}

}
