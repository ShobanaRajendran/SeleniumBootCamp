package week1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditAccounts {

	public static void main(String[] args) throws InterruptedException {
		// Edit Accounts 
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		//Launch Browser
		driver.get("https://login.salesforce.com/");
		System.out.println("Page Launched");
		driver.manage().window().maximize();
		//Login
		driver.findElementById("username").sendKeys("matschie@testleaf.com");
		driver.findElementById("password").sendKeys("India@123 ");
		driver.findElementById("Login").click();
		//Switching to Sales Classic
//		if(driver.findElementByXPath("//div[contains(text(),'View profile')]").isDisplayed()) {
			System.out.println("Switching to Sales Classic Flow");
			driver.manage().timeouts().implicitlyWait(5000,TimeUnit.SECONDS) ;
			System.out.println("hi");
			try {
			driver.executeScript("arguments[0].click();",driver.findElementByXPath("//span[@data-aura-class='oneUserProfileCardTrigger']//img"));
			driver.findElementByLinkText("Switch to Salesforce Classic").click();
			}
			catch(Exception e)
			{
				driver.executeScript("arguments[0].click();",driver.findElementByXPath("//span[@data-aura-class='oneUserProfileCardTrigger']//img"));
				driver.findElementByLinkText("Switch to Salesforce Classic").click();
				
			}
		//Switching to Account Tab
		driver.findElementByXPath("//li[@id='Account_Tab']").click();
		driver.findElementByXPath("//tr//a[contains(text(),'Boot Camp Puppeteer Shobana1')]").click();
		System.out.println("Editing the Account");
		driver.findElementByXPath("//td[@class='pbButton']//input[@name='edit']").click();
		String newAddress="NAN Street";
		driver.findElementByXPath("//textarea[@id='acc18street']").clear();
		driver.findElementByXPath("//textarea[@id='acc18street']").sendKeys(newAddress);
		driver.findElementByXPath("//td[@class='pbButtonb']//input[@name='save']").click();
		//Getting changed Address
		
		String editedAddr=driver.findElementByXPath("//td[contains(text(),'Shipping Address')]//following-sibling::td//div").getText();
		if(newAddress.contains(editedAddr))
		{
			System.out.println("new Address updated properly"+newAddress+" "+editedAddr);
			}
	driver.close();
	}

}
