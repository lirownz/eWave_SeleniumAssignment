package TestNG;

import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumAssignment {

	WebDriver driver = null;
	
	@BeforeTest
	public void setUpTest() {
		
		//getting the time staring test
		String timeStamp1 = new SimpleDateFormat("HH.mm.ss--dd.MM.yyyy").format(new java.util.Date());

		//setting Chrome driver  
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\liron.agam\\Desktop\\Automation-Selenium\\chromedriver.exe");
		
		//writing Chrome logs
		System.setProperty("webdriver.chrome.logfile", "C:\\Users\\liron.agam\\Desktop\\PaisLogs\\ChromeLog-"+timeStamp1+".log");
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void errorLogin() {
		//test steps
		driver.navigate().to("https://www.saucedemo.com/");
	}
	
	@AfterTest
	public void finishTest() {
		driver.close();
		driver.quit();
		System.out.println("Test Completed");
	}
}
