package week1;

import java.awt.Desktop.Action;
import java.awt.RenderingHints.Key;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteOpportunity {

	public static void main(String[] args) throws InterruptedException {
		// code for Delete Opportunity in SalesForce Application
		
		//Driver Initialisation
		//Launch Chrome and URL
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com/");
		System.out.println("Page Launched");
		driver.manage().window().maximize();
		//Login
		driver.findElementById("username").sendKeys("matschie@testleaf.com");
		driver.findElementById("password").sendKeys("India@123 ");
		driver.findElementById("Login").click();
		//Moving to opprotunity tab
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.SECONDS) ;
		driver.findElementByXPath("//div[@class='slds-icon-waffle']").click();
		driver.findElementByXPath("//button[text()='View All']").click();
		
		driver.findElementByXPath("//p[text()='Sales']").click();
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.SECONDS);
//		driver.executeScript("args[0].click();", driver.findElementByXPath("//a[@title='Opportunities']"));
		 
		driver.executeScript("arguments[0].click();", driver.findElementByXPath("//a[@title='Opportunities']"));
		
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.SECONDS);
		driver.executeScript("arguments[0].click();", driver.findElementByXPath("//input[@name='Opportunity-search-input']"));
		
		 driver.findElementByXPath("//input[@name='Opportunity-search-input']").sendKeys("Ref1Del");
		 driver.findElementByXPath("//input[@name='Opportunity-search-input']").sendKeys(Keys.ENTER);
		 driver.switchTo().defaultContent();
		 driver.findElementByXPath("//td//a[contains(@class,'rowActionsPlaceHolder')]").click();
		 driver.findElementByXPath("//li//a[@title='Delete']").click();
		 System.out.println("Delete");
		driver.findElementByXPath("//button[@title='Delete']//span").click();
		Thread.sleep(1000);
		System.out.println("hii");
		driver.findElementByXPath("//input[@name='Opportunity-search-input']").sendKeys(Keys.ENTER);
		 driver.switchTo().defaultContent();
		 if(driver.findElementByXPath("//div[contains(@class,'emptyContentInner')]").isDisplayed())
		 {
			 System.out.println("Element Deleted successfully");
		 }
		
	}

}
