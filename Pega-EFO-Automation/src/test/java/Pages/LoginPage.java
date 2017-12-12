package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import Utility.*;

public class LoginPage {
	
WebDriver driver;
	
public LoginPage(WebDriver ldriver){
	
this.driver = ldriver;	
	
}	

@FindBy(css=".noback[name=user]") WebElement accname;

@FindBy(css=".noback[name=password]") WebElement password;

@FindBy(css="input[name=Login][value=login]") WebElement login;

public void clickOnLogin(String user, String pass){
	
utilityMethods.setElementText(accname, user);
utilityMethods.setElementText(password, pass);
utilityMethods.ClickElement(login);

}

}
