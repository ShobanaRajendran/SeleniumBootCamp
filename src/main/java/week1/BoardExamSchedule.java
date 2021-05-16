package week1;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BoardExamSchedule {
	public static void waitForLoader(ChromeDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(50000, TimeUnit.SECONDS );
	}

	public static void main(String[] args) {
		// Board Exam Schedule
		
		//Driver SEtup 
		System.out.println("Launch Salesforce application https://login.salesforce.com/");
		WebDriverManager.chromedriver().setup();
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com/");
		System.out.println("Login with Provided Credentials");
		driver.manage().window().maximize();
		//Login
		driver.findElementById("username").sendKeys("matschie@testleaf.com");
		driver.findElementById("password").sendKeys("India@123 ");
		driver.findElementById("Login").click();
		waitForLoader(driver);
		System.out.println(" Click on Learn More link in Mobile Publisher");
		waitForLoader(driver);
		driver.findElementByXPath("//span[contains(text(),'Learn More')]").click();
		String home=driver.getWindowHandle(),currentWindow="";
		for (String window : driver.getWindowHandles()) {
			if(!window.contains(home))
			{	currentWindow=window;
			driver.switchTo().window(currentWindow);}
			}
		
		//On clicking mobile publishers 
		waitForLoader(driver);
		waitForLoader(driver);
		System.out.println("Actions");
		//driver.findElementByXPath().click();
		//navigating to new window
		/*Actions builder = new Actions(driver); 
		builder.clickAndHold(*/
		driver.findElementByXPath("//li[@id='solutions_menu_item']//span[contains(text(),'Resources')]").click();
		//builder.doubleClick(
		driver.executeScript("arguments[0].click();", driver.findElementByXPath("//span[contains(text(),'Salesforce Certification')]"));
		//builder.perform();
		 
		 
		
		for (String window : driver.getWindowHandles()) {
			if(!window.contains(home)&&!window.contains(currentWindow))
			{	driver.switchTo().window(currentWindow);
			driver.close();
			currentWindow=window;
			driver.switchTo().window(window);}			
		}
		//Select sales force architect type
		driver.executeScript("arguments[0].click();", driver.findElementByXPath("//a//div[contains(text(),'Salesforce Architect')]"));
		//Selcting Technical Architecht Certifications
		System.out.println("Technical Architect");
		driver.executeScript("arguments[0].click();",driver.findElementByLinkText("Technical Architect"));
		driver.executeScript("arguments[0].click();", driver.findElementByLinkText("See details"));
		//Navigate to Architect Review Boards
		driver.close();
		driver.switchTo().window(home);
		for (String window : driver.getWindowHandles()) {
			if(!window.contains(home))
			{	currentWindow=window;
			driver.switchTo().window(currentWindow);}
			}
		//  //div[contains(@class,'table__line')]
		//Getting the Planned Session Details
		System.out.println("Planned Session Details ");
		HashMap<String,String > examSchedule = new HashMap();
		List<WebElement> plannedElements= driver.findElementsByXPath("//div[contains(@class,'table__line')]");
		for (WebElement planned : plannedElements) {
			if(planned.getText().contains("Planning"))
			{
				//int i=0;
				System.out.print(planned.getText());
				String data=planned.getText();
				String loc,dates;
				String[] split= data.split("\n");
				loc=split[0];
				dates=split[1];
				examSchedule.put(dates, loc);
				System.out.println(examSchedule.get(dates));
				//i++;
				
			}
		}
		if(driver.getTitle().contains("Architect Review Boards"))
		{
			System.out.println("We have Landed Architect Review Boards Page correctly");
		}
		System.out.println(examSchedule);	

	}

}
