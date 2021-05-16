package week1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewChartCreation {
	public static void waitForLoader(ChromeDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(50000, TimeUnit.SECONDS );
	}

	public static void main(String[] args) {
		// New Chart Creation
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver= new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		System.out.println("Login with Provided Credentials");
		//Login
		driver.findElementById("username").sendKeys("matschie@testleaf.com");
		driver.findElementById("password").sendKeys("India@123 ");
		driver.findElementById("Login").click();
		waitForLoader(driver);
		//Clicking Applauncher View All
		driver.findElementByXPath("//div[@class='slds-icon-waffle']").click();
		driver.findElementByXPath("//button[text()='View All']").click();
		//Clicking Content
		driver.findElementByXPath("//p[text()='Salesforce CRM Content']").click();
		driver.findElementByXPath("//a[@aria-label='View All Tasks']").click();
		
		driver.findElementByXPath("//div[@class='maincontent']//a[@title='Select List View']").click();
		driver.findElementByXPath("//span[@class=' virtualAutocompleteOptionText' and text()='Open Tasks']").click();
		//Changing the view
		waitForLoader(driver);
		waitForLoader(driver);
		waitForLoader(driver);
		driver.findElementByXPath("//div[@class='test-listviewdisplayswitcher forceListViewManagerDisplaySwitcher']").click();
		waitForLoader(driver);
		waitForLoader(driver);
		waitForLoader(driver);
		driver.findElementByXPath("//li[@title='Table']").click();
		driver.findElementByXPath("//button[@title='Show charts']").click();
				
		driver.executeScript("arguments[0].click()", driver.findElementByXPath("//span[text()='Settings']"));
		driver.executeScript("arguments[0].click()",driver.findElementByXPath("//a[@title='New Chart']"));
		
		
		driver.findElementByXPath("//input[@class='chartNameInputBox input']").sendKeys("Opened Tasks");
		driver.switchTo().defaultContent();
		driver.executeScript("arguments[0].click();", driver.findElementByXPath("//span[text()='Chart Type']//parent::span//following-sibling::div//a"));
		driver.findElementByXPath("//div[@class='select-options']//a[text()='Donut Chart']").click();
		driver.switchTo().defaultContent();
		//Click Grouping Label to select status
		driver.executeScript("arguments[0].click();",driver.findElementByXPath("//span[text()='Grouping Field']//parent::span/following-sibling::div//a"));
		driver.executeScript("arguments[0].click();",driver.findElementByXPath("//a[contains(text(),'Status')]"));
		//Saving
		driver.findElementByXPath("//button[@title='Save']").click();
		System.out.println("getting the chart status ");
		Actions builder= new Actions(driver);
		WebElement chart= driver.findElementByXPath("//div[contains(@class,'windowViewMode-normal')]//div[@data-aura-class='reportsEclairChart']");
		
		builder.moveToElement(chart).perform();
		driver.executeScript("arguments[0].scrollIntoView(true);", chart);
		String text=driver.findElementByXPath("//div[@class='ng-charthover reportsEclairChart']").getText();
		System.out.println(text);
		//Selecting the Row and Editing the Row
		driver.findElementByXPath("//tr//div[text()='In Progress']").click();
		driver.executeScript("arguments[0].click();", driver.findElementByXPath("//tr[1]//div[text()='In Progress']/parent::div//following-sibling::span[@class='triggerContainer']"));
		
		//Changeing to completed
		driver.findElementByXPath("//ul[@role='presentation']//a[text()='Completed']").click();
		driver.findElementByXPath("//span[text()='Save']").click();
		//driver.findElementByXPath("//button[@title='Save']").click();
		driver.navigate().refresh();
		driver.findElementByXPath("//button[@title='Show charts']").click();
		//Actions builder= new Actions(driver);
		//chagne move to element 
		//to click chart
		
		builder.moveToElement(chart).perform();
		driver.executeScript("arguments[0].click();",driver.findElementByXPath("eclair-component-chart ng-cursor-default"));
		String text2=driver.findElementByXPath("//div[@class='ng-charthover reportsEclairChart']").getText();
		System.out.println(text2);
			

	}

}
