package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	
Properties pro;	
	
public ConfigDataProvider(){
	
File src = new File ("./Configuration/Config.properties");

try {
	FileInputStream fis = new FileInputStream(src);
	
	pro = new Properties();
	pro.load(fis);
	
} catch (Exception e) {
	
	System.out.println("Exception is " + e.getMessage());
} 	
	
}

public String getApplicationURL(){
	
String url = pro.getProperty("url");
return url;
	
}

public String getIEPath(){
	
String path = pro.getProperty("IEDriverPath");
return path;
	
}
public String getChromePath(){
	
String path = pro.getProperty("chromeDriverPath");
return path;
	
}
public String getFirefoxPath(){
	
String path = pro.getProperty("firefoxDriverPath");
return path;
	
}
}
