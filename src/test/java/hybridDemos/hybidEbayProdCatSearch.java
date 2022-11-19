package hybridDemos;

import org.testng.annotations.Test;

import Pompages.BrowserFactory;
import Pompages.ClasEbay;
import Pompages.ClsExcelData;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

public class hybidEbayProdCatSearch 
{
  @Test(dataProvider = "dp")
  public void CatSearch(String ddValue, String txtValue)
  {
	  WebDriver driver= BrowserFactory.startBrowser("Chrome" , "http://ebay.com");
	
	  ClasEbay obj = new ClasEbay(driver);
	  obj.fnCatSearch(ddValue, txtValue);
  }
  
  @DataProvider
  public Object[][] dp() throws Exception
  {
    Object[][] mydata=ClsExcelData.getExcelData(".\\src\\test\\resources\\SearchData.xlsx");
    return mydata;
  }
}  
	
	  
			  
			  
	