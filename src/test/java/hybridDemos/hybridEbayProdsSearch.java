package hybridDemos;

import org.testng.annotations.Test;

import Pompages.BrowserFactory;
import Pompages.ClasEbay;
import Pompages.ClsExcelData;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

public class hybridEbayProdsSearch 
{
  @Test(dataProvider = "dp")
  public void productSearch(String ddValue, String txtValue)
  {
	WebDriver driver= BrowserFactory.startBrowser("Chrome", "http://ebay.com");
	
	ClasEbay obj = new ClasEbay(driver);
	obj.fnSearch(txtValue);
	
	Reporter.log("Ebay product search is successfull...", true);
  }

  @DataProvider
  public Object[][] dp() throws Exception
  {
    Object[][] mydata=ClsExcelData.getExcelData("C:\\Users\\UMA\\eclipse-workspace\\mvnDemo2\\src\\test\\resources\\SearchData.xlsx");
    return mydata;
  }
}
