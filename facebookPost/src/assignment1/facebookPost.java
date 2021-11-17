package assignment1;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class facebookPost {

	
	@Test
	public void loginandPost() throws InterruptedException
	{
		String username = "wallethubtest@yahoo.com";
		String Password = "Automationtest@12";
		
		EnterPost(username,Password);
		
	}
	
	
	public void EnterPost(String username, String Password) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D://TSG//Jars//chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		WebDriver driver = new ChromeDriver(options);	
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
		//Logging in with username and Password
		
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(Password);
		driver.findElement(By.name("login")).click();	
		
		//Adding a Hello World Post
		
		driver.findElement(By.xpath("//a[@aria-label='Home']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'your mind, Wallet?')]")).click();
		driver.findElement(By.xpath("//div[contains(@aria-label,'on your mind')]")).sendKeys("Hello World");
		driver.findElement(By.xpath("//span[text()='Post']")).click();
		
	
		Thread.sleep(10000);
		
		//Deleting added Post
		
		driver.findElement(By.xpath("//div[text()='Hello World']/preceding::div[@aria-label='Actions for this post']")).click();
		driver.findElement(By.xpath("//span[text()='Move to Recycle bin']")).click();
		driver.findElement(By.xpath("//span[text()='Move']")).click();		
		driver.quit();

	}

}
