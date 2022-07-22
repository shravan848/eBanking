package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import utilities.ReadConfig;

public class googleLogin extends BaseClass{

	@Test
	public void loginGoogle() throws InterruptedException
	{	setup("");
	   	driver.get("https://www.google.com/");
    	logger.info("google page is opened");  	   	
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	driver.findElement(By.linkText("Sign in")).click();
    	logger.info("Sign in clicked");    	
    	driver.findElement(By.xpath("//input[@type='email']")).sendKeys("shravan.1814@gmail.com"+Keys.ENTER);
    	logger.info("email id is entered");
    	//WebDriverWait wait=new WebDriverWait(driver,10);
    	//Thread.sleep(4);
    	//driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456"+Keys.ENTER);
    	//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='password']"))).sendKeys("shravan.1814@gmail.com"+Keys.ENTER);
    	logger.info("Password is entered");
    	//driver.findElement(By.xpath("(//div[@class='VfPpkd-RLmnJb'])[2]")).click();
    	
    	
        
    }
}
