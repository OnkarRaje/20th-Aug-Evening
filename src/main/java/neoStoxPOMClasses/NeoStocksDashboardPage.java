package neoStoxPOMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;



public class NeoStocksDashboardPage 
{	//1
	@FindBy(xpath = "(//a[text()='OK'])[2]") private WebElement popUpOkButton;
	
	//@FindBy(xpath ="(//a[text()='Close'])[5]") private WebElement popUpCloseButton;
	
	@FindBy(id = "lbl_username") private WebElement userName;
	
	@FindBy(id = "lnk_logout") private WebElement logOutButton;
	
	@FindBy(id = "lbl_curbalancetop") private WebElement acBalance;
	//2
	
	public NeoStocksDashboardPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//3
	public void handlePopUp(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(5000);
		if(popUpOkButton.isDisplayed())
		{
			Thread.sleep(3000);
			//Utility.scrollIntoView(driver, popUpOkButton);
			popUpOkButton.click();
			Reporter.log("clicking on PopUp OK button", true);
			Thread.sleep(1000);
			//popUpCloseButton.click();
		}
		else {
			Reporter.log("There is no popup", true);
		}
	}
//	public void validateUserName(String expectedUserName)
//	{
//		
//		String actualUserName = userName.getText();
//		
//		if(expectedUserName.equals(actualUserName))
//		{
//			System.out.println("TC is Passed, actual and expected user names are matching ");
//		}
//		else
//		{
//			System.out.println("TC is Failed, actual and expected user names are not matching ");
//		}
//	}
	
	public String getActualUsername()
	{
		String actualUserName = userName.getText();
		Reporter.log("getting actual user Name", true);
		Reporter.log("Actual user name is --> "+actualUserName, true);
		return actualUserName;
	}
	public String getAcBalance() 
	{
		String balance = acBalance.getText();
		Reporter.log("getting AC Balance", true);
		Reporter.log("AC Balance is"+balance+"", true);
		return balance;
	}
	public void logOutFromNeoStocks() throws InterruptedException
	{
		userName.click();
		Thread.sleep(2000);
		logOutButton.click();
		Thread.sleep(1000);
		Reporter.log("Logging Out From Neostox", true);
	}
}

