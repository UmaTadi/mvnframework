package pomTests;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Pompages.BrowserFactory;
import Pompages.ClasEbay;


public class pomEbayProdCatSearch 
{
  @Test
  public void CatSearch()
  {

	  WebDriver driver = BrowserFactory.startBrowser("Chrome", "http://ebay.com");
	  
	  ClasEbay obj = new ClasEbay(driver);
	  obj.fnCatSearch("Cameras & Photo" , "Sony");
	  
	  Reporter.log("Ebay cat search is successfull" , true);
  }
}
