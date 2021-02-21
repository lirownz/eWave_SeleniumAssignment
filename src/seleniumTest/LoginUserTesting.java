package seleniumTest;

import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginUserTesting {

	//defualt driver
	WebDriver driver;
	//getting the time staring test
	String timeStamp = new SimpleDateFormat("HH.mm.ss--dd.MM.yyyy").format(new java.util.Date());

	@BeforeMethod
	public void setUpTest() {
		//setting Chrome driver  
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\liron.agam\\Desktop\\Automation-Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://www.saucedemo.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void lockedOutUserLoginTest() throws InterruptedException {
		System.out.println("test started at: "+ timeStamp);

		//entering username and pass
		driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		Thread.sleep(1000);

		//pressing Login CTA
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(1000);

		//checking displayed error message 
		boolean errMessage = driver.findElement(By.cssSelector("#login_button_container > div > form > h3")).isDisplayed();
		String errMessageText = driver.findElement(By.cssSelector("#login_button_container > div > form > h3")).getText();
		if(errMessage) {
			System.out.println("PASS -- error Message displyed to user \n message is: "+ errMessageText);
		}
		else {
			System.out.println("No Error  Message found!");
		}
		Thread.sleep(1000);
		
		System.out.println("Locked Out User has NOT been logged in!");
	}

	@Test
	public void performanceGlitchUserLoginTest() throws InterruptedException {
		System.out.println("test started at: "+ timeStamp);

		//entering username and pass
		driver.findElement(By.id("user-name")).sendKeys("performance_glitch_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		Thread.sleep(1000);

		//pressing Login CTA
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(1000);
		
		System.out.println("Performance Glitch User has been logged in!");
	}

	@Test
	public void standardUserLoginTest() throws InterruptedException {
		System.out.println("test started at: "+ timeStamp);

		//entering username and pass
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		Thread.sleep(1000);

		//pressing Login CTA
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(1000);
		
		System.out.println("Standard  User has been logged in!");
	}


	@AfterMethod
	public void finishTest() {
		driver.close();
		driver.quit();
		System.out.println("Test Completed");
	}
}
