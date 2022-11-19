package pomTests;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Pompages.BrowserFactory;
import Pompages.ClasEbay;


public class pomEbayProdSearch 
{
  @Test
  public void productSearch()
  {
	  WebDriver driver =BrowserFactory.startBrowser("Chrome", "http://ebay.com");
	 ClasEbay obj = new ClasEbay(driver);
	  obj.fnSearch("sony");
	  
	  Reporter.log("Ebay product search is successful...");
  }
}
