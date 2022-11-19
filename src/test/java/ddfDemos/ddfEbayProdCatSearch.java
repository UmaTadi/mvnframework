package ddfDemos;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

public class ddfEbayProdCatSearch
{
  @Test(dataProvider = "dp")
  public void CatSearch(String ddValue, String  txtValue) 
  {
	 // WebDriverManager.chromedriver().setup();
	  WebDriver driver= new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("http://ebay.com");
	  
	  	WebElement dd= driver.findElement(By.id("gh-cat"));
	  	Select s= new Select(dd);
	  	s.selectByVisibleText(ddValue);
	  	
	  	driver.findElement(By.id("gh-ac")).sendKeys(txtValue);
	  	driver.findElement(By.id("gh-btn")).click();
	  
	  	Reporter.log("Ebay product category search is successfull...",true);
  }

  @DataProvider
  public Object[][] dp() throws Exception 
  {
    Object [][] mydata= null;
    XSSFWorkbook wb= new XSSFWorkbook("C:\\Users\\UMA\\eclipse-workspace\\mvnDemo2\\src\\test\\resources\\SearchData.xlsx");
    XSSFSheet ws= wb.getSheet("Sheet1");
    int rows = ws.getPhysicalNumberOfRows();
    mydata = new Object[rows][2];
    
    for(int i=0; i<rows; i++)
    {
    	mydata[i][0]= ws.getRow(i).getCell(0).getStringCellValue();
    	mydata[i][1]= ws.getRow(i).getCell(1).getStringCellValue();
    }
    return mydata;
  }
}
