package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
  
	public void login(WebDriver driver) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
		driver.get("https://staging.tinyserver.info/auth");
		
		driver.findElement(By.xpath("//div[@class='Input__container___3DFfQ']//input[@class='Input__input___1hjYb' and @type='text']")).sendKeys("testing06@yopmail.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		driver.findElement(By.xpath("//div[@role='button']")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
	    new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='Input__container___3DFfQ']//input[@class='Input__input___1hjYb' and @type='password']"))).sendKeys("Passw0rd@1");
		
	    driver.findElement(By.xpath("//div[@role='button' and @data-cucumber='button-login']")).click();
	    Thread.sleep(3000);
	
	}
}
