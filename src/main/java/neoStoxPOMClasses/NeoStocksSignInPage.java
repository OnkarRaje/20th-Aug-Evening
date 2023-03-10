package neoStoxPOMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class NeoStocksSignInPage 
{
	//1
	@FindBy(id = "MainContent_signinsignup_txt_mobilenumber") private WebElement mobileNumField;
	
	@FindBy(id = "lnk_signup1") private WebElement signINButton;
	
	//2
	public NeoStocksSignInPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//3
	 public void enterMobileNumber(String mobileNum)
	 {
		 mobileNumField.sendKeys(mobileNum);
		 Reporter.log("Entering Mobile Number", true);
	 }
	 
	 public void clickOnSignInButton()
	 {
		 signINButton.click();
		 Reporter.log("Clicking on SignIn Button", true);
	 }
	
	
}
