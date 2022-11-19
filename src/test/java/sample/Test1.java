package sample;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 {

	public static void main(String[] args) {
		
		WebDriver driver = WebDriverManager.chromedriver().create();
		
        driver.manage().window().maximize();
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.get("https://www.gmail.com");
	}

}
