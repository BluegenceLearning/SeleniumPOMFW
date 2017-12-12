package Utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class utilityMethods {
	
/* 
 * This method will click on selected element	
 */
public static void ClickElement(WebElement element){
	
element.click();	
	
} 

/* 
 * This method will click on Submit button	
 */
public static void SubmitElement(WebElement element){
	
element.submit();	
	
} 

/* 
 * This method will enter text in selected element	
 */
public static void setElementText(WebElement element, String text){
	
element.clear();
element.sendKeys(text);
Assert.assertEquals(element.getAttribute("value"),text);
	
}

/* 
 * This method will enter text in selected element	
 */
public static void selectValueInDropdown(WebElement element, String value){

Select select = new Select(element);
select.selectByValue(value);
	
}


}
