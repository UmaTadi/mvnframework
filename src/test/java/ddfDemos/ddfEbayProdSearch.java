package ddfDemos;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

public class ddfEbayProdSearch 
{
  @Test(dataProvider = "dp")
  public void prodSearch(String ddValue, String txtValue)
  {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver= new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("http://ebay.com");
	  
	  driver.findElement(By.id("gh-ac")).sendKeys(txtValue);
	  driver.findElement(By.id("gh-btn")).click();
	  
	  Reporter.log("ebay product search is successfull...");
  }
  

  @DataProvider
  public Object[][] dp() throws Exception
  {
    Object [][] mydata= null;
    XSSFWorkbook wb= new XSSFWorkbook("C:\\Users\\UMA\\eclipse-workspace\\mvnDemo2\\src\\test\\resources\\SearchData.xlsx");
    XSSFSheet ws = wb.getSheet("Sheet1");
    int rows= ws.getPhysicalNumberOfRows();
    
    mydata = new Object[rows][2];
    for(int i=0; i<rows; i++)
    {
    	mydata[i][0]= ws.getRow(i).getCell(0).getStringCellValue();
    	mydata[i][1]= ws.getRow(i).getCell(1).getStringCellValue();
    }
    return mydata;
  }
}
