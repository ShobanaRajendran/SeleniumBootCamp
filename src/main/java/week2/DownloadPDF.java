package week2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadPDF {
	
	public static void waitForLoader(ChromeDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(90000, TimeUnit.SECONDS );
	}
	public static void main(String[] args) {
		//Download PDF
		WebDriverManager.chromedriver().setup();
		ChromeOptions options =new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver= new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		//Login
		driver.findElementById("username").sendKeys("matschie@testleaf.com");
		driver.findElementById("password").sendKeys("India@123 ");
		driver.findElementById("Login").click();
		waitForLoader(driver);
				

	}

}
