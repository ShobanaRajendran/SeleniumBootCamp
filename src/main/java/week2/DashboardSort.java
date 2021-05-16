package week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DashboardSort {
	
	public static void waitForLoader(ChromeDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(50000, TimeUnit.SECONDS );
	}

	public static void main(String[] args) {
		// Verify Dashboards sort order by Dashboard name
		System.out.println("Verify Dashboards sort order by Dashboard name");
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
		//Clicking Dashboard 
		driver.executeScript("arguments[0].click();", driver.findElementByXPath("//p[text()='Dashboards']"));//.click();
		waitForLoader(driver);
		//th[@aria-label='Dashboard Name']//lightning-primitive-icon[@class='slds-icon_container']
		driver.executeScript("arguments[0].click();", driver.findElementByXPath("//th[@aria-label='Dashboard Name']"));
		////Actions builder= new Actions(driver);
		//builder.moveToElement(driver.findElementByXPath("//span[text()='Dashboard Name']")).perform();
		driver.executeScript("arguments[0].click();", driver.findElementByXPath("//th[@aria-label='Dashboard Name']//lightning-primitive-icon[@class='slds-icon_container']"));
		List<WebElement> list= new ArrayList();
		list=driver.findElementsByXPath("//tr//th[@data-label='Dashboard Name']");
		String[] array=new String[list.size()];
		String []array2= new String[list.size()];//int i=0;
		int k=0;
		for (WebElement we : list) {
			String temp=we.getText();
			array[k]=temp;
			k++;
		}
		
		for (int i=0;i<array.length;i++) {
				array2[i]=array[i];			
		}
		//Arrays.sort(array);
		for(int i=0;i<array.length;i++)
		{	for(int j=i+1;j<array.length;j++)
			{
			if(array[i].charAt(0)>'A'&&array[i].charAt(0)<'Z') {
			if(array[i].charAt(0)>array[j].charAt(0))
			{
				String temp=array[i];
				array[i]=array[j];
				array[j]=temp;
			}}
			else if(array[i].charAt(0)>'a'&&array[i].charAt(0)<'a') {
				if(array[i].charAt(0)>array[j].charAt(0))
				{
					String temp=array[i];
					array[i]=array[j];
					array[j]=temp;
				}}
			}
		}
		    if(Arrays.equals(array, array2))
		    {
		    	System.out.println("True");
		    }
		    else
		    {
		    	System.out.println("False");
		    }
		    for(int i=0;i<array.length;i++)
		    {
		    	System.out.println(" "+array[i]+" "+array2[i]);
		    }
		    


	}

}
