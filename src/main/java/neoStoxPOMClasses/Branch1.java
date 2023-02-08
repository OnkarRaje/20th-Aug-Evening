package neoStoxPOMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Branch1 
{
	public class NeoStocksDashboardPage 
	{	//1
		@FindBy(xpath = "(//a[text()='OK'])[2]") private WebElement popUpOkButton;
		
		//@FindBy(xpath ="(//a[text()='Close'])[5]") private WebElement popUpCloseButton;
		
		@FindBy(id = "lbl_username") private WebElement userName;
		
		@FindBy(id = "lnk_logout") private WebElement logOutButton;
		
		@FindBy(id = "lbl_curbalancetop") private WebElement acBalance;
		//2
	}	
		public Branch1(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		public void Branch1update(int a, int b)
		{
			a=10;
			b=20;
			int c=a+b;
			System.out.println(c);
		}
}
