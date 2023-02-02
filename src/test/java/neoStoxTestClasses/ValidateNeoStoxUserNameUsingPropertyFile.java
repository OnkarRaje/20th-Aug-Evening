package neoStoxTestClasses;

import org.testng.annotations.Test;
import neoStoxBase.Base;
import neoStoxPOMClasses.NeoStocksDashboardPage;
import neoStoxPOMClasses.NeoStocksHomePage;
import neoStoxPOMClasses.NeoStocksPasswordPage;
import neoStoxPOMClasses.NeoStocksSignInPage;
import neoStoxPOMClasses.Utility;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
@Listeners(neoStoxTestClasses.Listener.class)
public class ValidateNeoStoxUserNameUsingPropertyFile extends Base
{
	NeoStocksHomePage home;
	NeoStocksSignInPage signIn;
	NeoStocksPasswordPage pass;
	NeoStocksDashboardPage dash;
	String s = "TCID-2501";
  @BeforeClass
  public void launchNeoStoxApp() throws IOException 
  {
	  launchBrowser();
	  home = new NeoStocksHomePage(driver);
	  signIn = new NeoStocksSignInPage(driver);
	  pass = new NeoStocksPasswordPage(driver);
	  dash = new NeoStocksDashboardPage(driver);
  }
  
  @BeforeMethod
  public void loginToNeoStox() throws EncryptedDocumentException, IOException, InterruptedException 
  {
	  home.clickOnSignInButton();
	  Utility.implicitWait(1000, driver);
	  signIn.enterMobileNumber(Utility.readDataFromPropertyFile("mobile"));
	  Thread.sleep(1000);
	  
	  signIn.clickOnSignInButton();
	  Utility.implicitWait(1000, driver);
	  pass.enterPassword(Utility.readDataFromPropertyFile("password"));
	  pass.clickOnSubmitButton();
	  Utility.implicitWait(1000, driver);
	  
	  dash.handlePopUp(driver);
  }
  
  @Test
  public void validateUserName() throws EncryptedDocumentException, IOException 
  {
	//Assert.fail();
	Assert.assertEquals(dash.getActualUsername(), Utility.readDataFromPropertyFile("userName"), "Expected & Actual UserNames are not Matching, TC failed");
	Utility.takeScreenShot(driver, Utility.readDataFromPropertyFile("TCID"));
  }
  @Test
  public void validateAcBalance() 
  {
	  Assert.assertNotNull(dash.getAcBalance(), "Ac Balance is Null, TC is Failed");
  }

  @AfterMethod
  public void logOutFromNeoStox() throws InterruptedException 
  {
	  dash.logOutFromNeoStocks();
  }

  @AfterClass
  public void closeNeoStoxApp() throws InterruptedException 
  {
	  driver.close();
	  Reporter.log("Closing application", true);
	  Thread.sleep(1000);
  }

}
