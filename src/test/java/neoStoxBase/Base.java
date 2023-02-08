package neoStoxBase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import neoStoxPOMClasses.Utility;



public class Base 
{
	protected static WebDriver driver;
	public void launchBrowser() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\20 August Selenium\\chromedriver.exe");
		//Created object of chrome driver
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Launch URL
		//driver.get("https://neostox.com/");
		
		driver.get(Utility.readDataFromPropertyFile("urlQA"));
		Utility.implicitWait(1000, driver);
		Reporter.log("launching browser", true);
		//comment1
		//comment2
		//comment3
	}
}
