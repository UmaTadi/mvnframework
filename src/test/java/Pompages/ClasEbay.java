package Pompages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ClasEbay 
{

	public WebDriver wd;
	public ClasEbay(WebDriver d)
	{
		wd=d;
	}
	
	By txtSearch= By.id("gh-ac");
	By btnSearch= By.id("gh-btn");
	By ddValue= By.id("gh-cat");
	
	
	public void fnSearch(String prodName)
	{
		wd.findElement(txtSearch).sendKeys(prodName);
		wd.findElement(btnSearch).click();
	}
	
	public void fnCatSearch(String cat, String prodName)
	{
		WebElement dd= wd.findElement(ddValue);
		Select s= new Select(dd);
		s.selectByVisibleText(cat);
		fnSearch(prodName);
	}
	

}
