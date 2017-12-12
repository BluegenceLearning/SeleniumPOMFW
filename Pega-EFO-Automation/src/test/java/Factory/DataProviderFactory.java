package Factory;

import dataProvider.ConfigDataProvider;
import dataProvider.ExcelDataProvider;

public class DataProviderFactory {
	
	
public static ConfigDataProvider getConfigDataProvider(){
	
ConfigDataProvider config = new ConfigDataProvider(); 	

return config;
	
}

public static ExcelDataProvider getExcelDataProvider(){
	
ExcelDataProvider excel = new ExcelDataProvider(); 	

return excel;
	
}

}
