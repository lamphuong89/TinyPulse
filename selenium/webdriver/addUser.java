package webdriver;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class addUser {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		new Login().login(driver);
	}

	@Test
	public void TC_01_Add_user_with_valid_value() {

		try {
			
			new WebDriverWait(driver, 30).until(ExpectedConditions
					.invisibilityOfElementLocated(By.xpath("//div[@class='Spinner__backdrop___kWhH1']")));
			new WebDriverWait(driver, 20)
					.until(ExpectedConditions.elementToBeClickable(By.xpath(
							"//li[@data-name='settings']//div[@class='site-bar__MenuItems__clickPoint--gmeqo']")))
					.click();

			driver.findElement(By.xpath("//li[@data-name='settings_users_invite']")).click();
			Thread.sleep(2000);

            //add the first user
			driver.manage().window().maximize();
			new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(
					By.xpath("//tbody[@class='lh-copy invitation-table']/tr[1]/td[2]/child::div[1]"))).click();
			Thread.sleep(1000);

			new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//tbody[@class='lh-copy invitation-table']/tr[1]/td[2]/child::div[1]//input[@class='Input__input___1hjYb']")))
					.sendKeys("test10");

			new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//*[@class='lh-copy invitation-table']/tr[1]/td[2]/child::div[2]//input[@field='lastName']")))
					.sendKeys("test10");

			new WebDriverWait(driver, 20)
					.until(ExpectedConditions.elementToBeClickable(
							By.xpath("//*[@class='lh-copy invitation-table']/tr[1]/td[3]//input[@field='email']")))
					.sendKeys("test10@yopmail.com");

			new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//*[@class='lh-copy invitation-table']/tr[1]/td[4]//div[@class='Dropdown__trigger___gDKbL']")))
					.click();
			Thread.sleep(2000);
			new WebDriverWait(driver, 20)
					.until(ExpectedConditions.elementToBeClickable(By.xpath("*//div[@data-value='2022-03-07']")))
					.click();

			new WebDriverWait(driver, 20)
					.until(ExpectedConditions
							.elementToBeClickable(By.xpath("//*[@class='lh-copy invitation-table']/tr[1]/td[5]")))
					.click();
			Thread.sleep(2000);
			new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//div[@class='Dropdown__dropdown___1qf8H']//div[@class='Suggestion__suggestion___21zRt'][1]")))
					.click();
            // add the second user
			new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//tbody[@class='lh-copy invitation-table']/tr[2]/td[2]/child::div[1]//input[@class='Input__input___1hjYb']")))
					.sendKeys("test11");

			new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//*[@class='lh-copy invitation-table']/tr[2]/td[2]/child::div[2]//input[@field='lastName']")))
					.sendKeys("test11");

			new WebDriverWait(driver, 20)
					.until(ExpectedConditions.elementToBeClickable(
							By.xpath("//*[@class='lh-copy invitation-table']/tr[2]/td[3]//input[@field='email']")))
					.sendKeys("test11@yopmail.com");

			new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//*[@class='lh-copy invitation-table']/tr[2]/td[4]//div[@class='Dropdown__trigger___gDKbL']")))
					.click();
			Thread.sleep(2000);
			new WebDriverWait(driver, 20)
					.until(ExpectedConditions.elementToBeClickable(By.xpath("*//div[@data-value='2022-03-08']")))
					.click();

			new WebDriverWait(driver, 20)
					.until(ExpectedConditions
							.elementToBeClickable(By.xpath("//*[@class='lh-copy invitation-table']/tr[2]/td[5]")))
					.click();
			Thread.sleep(2000);
			new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//div[@class='Dropdown__dropdown___1qf8H']//div[@class='Suggestion__suggestion___21zRt'][2]")))
					.click();

			new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//div[@class='Button__button___3FFWB ph4 cucumber-send-invite-button Button__primary___1PWXO']")))
					.click();

         
			WebElement elementTitle_success = driver.findElement(By.xpath("//div[@id='page-wrapper']/div/div/div/div[2]"));
		
			String actual_result=elementTitle_success.getText();
			String expected_result="check_circle"+"\n"+"Congratulations";			
			Assert.assertEquals(expected_result,actual_result);
			
		} catch (InterruptedException e) {

			System.out.print(e.getMessage());
		}
		System.out.println("Check case add new user that has existed yet in the system: passed\n");
		
	}
	

	
	@Test
	public void TC_01_Add_user_existed_in_the_system() {

		try {
			Thread.sleep(3000);
			new WebDriverWait(driver, 30).until(ExpectedConditions
					.invisibilityOfElementLocated(By.xpath("//div[@class='Spinner__backdrop___kWhH1']")));
			new WebDriverWait(driver, 20)
					.until(ExpectedConditions.elementToBeClickable(By.xpath(
							"//li[@data-name='settings']//div[@class='site-bar__MenuItems__clickPoint--gmeqo']")))
					.click();

			driver.findElement(By.xpath("//li[@data-name='settings_users_invite']")).click();
			Thread.sleep(2000);

			driver.manage().window().maximize();
			new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(
					By.xpath("//tbody[@class='lh-copy invitation-table']/tr[1]/td[2]/child::div[1]"))).click();
			Thread.sleep(1000);

	
			new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//tbody[@class='lh-copy invitation-table']/tr[1]/td[2]/child::div[1]//input[@class='Input__input___1hjYb']")))
					.sendKeys("test3");

			new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//*[@class='lh-copy invitation-table']/tr[1]/td[2]/child::div[2]//input[@field='lastName']")))
					.sendKeys("test3");

			new WebDriverWait(driver, 20)
					.until(ExpectedConditions.elementToBeClickable(
							By.xpath("//*[@class='lh-copy invitation-table']/tr[1]/td[3]//input[@field='email']")))
					.sendKeys("test03@yopmail.com");

			new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//*[@class='lh-copy invitation-table']/tr[1]/td[4]//div[@class='Dropdown__trigger___gDKbL']")))
					.click();
			Thread.sleep(2000);
			new WebDriverWait(driver, 20)
					.until(ExpectedConditions.elementToBeClickable(By.xpath("*//div[@data-value='2022-03-10']")))
					.click();

			new WebDriverWait(driver, 20)
					.until(ExpectedConditions
							.elementToBeClickable(By.xpath("//*[@class='lh-copy invitation-table']/tr[1]/td[5]")))
					.click();
			Thread.sleep(2000);
			new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//div[@class='Dropdown__dropdown___1qf8H']//div[@class='Suggestion__suggestion___21zRt'][1]")))
					.click();

			new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//tbody[@class='lh-copy invitation-table']/tr[2]/td[2]/child::div[1]//input[@class='Input__input___1hjYb']")))
					.sendKeys("test4");

			new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//*[@class='lh-copy invitation-table']/tr[2]/td[2]/child::div[2]//input[@field='lastName']")))
					.sendKeys("test3");

			new WebDriverWait(driver, 20)
					.until(ExpectedConditions.elementToBeClickable(
							By.xpath("//*[@class='lh-copy invitation-table']/tr[2]/td[3]//input[@field='email']")))
					.sendKeys("test03@yopmail.com");

			new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//*[@class='lh-copy invitation-table']/tr[2]/td[4]//div[@class='Dropdown__trigger___gDKbL']")))
					.click();
			Thread.sleep(2000);
			new WebDriverWait(driver, 20)
					.until(ExpectedConditions.elementToBeClickable(By.xpath("*//div[@data-value='2022-03-09']")))
					.click();

			new WebDriverWait(driver, 20)
					.until(ExpectedConditions
							.elementToBeClickable(By.xpath("//*[@class='lh-copy invitation-table']/tr[2]/td[5]")))
					.click();
			Thread.sleep(2000);
			new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//div[@class='Dropdown__dropdown___1qf8H']//div[@class='Suggestion__suggestion___21zRt'][2]")))
					.click();

			new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//div[@class='Button__button___3FFWB ph4 cucumber-send-invite-button Button__primary___1PWXO']")))
					.click();

			// verify

			WebElement title_message = driver.findElement(By.xpath("//div[@id='page-wrapper']/div/div/div/div[2]"));
		
			String actual_result_1=title_message.getText();
			String expected_result_1="error"+"\n"+"Uh oh! Unable to add user because email already exists";
	
			
			Assert.assertEquals(expected_result_1,actual_result_1);
			
		} catch (InterruptedException e) {

			System.out.print(e.getMessage());
		}
		System.out.println("Check case added user that existed in the system: passed\n");
	}
		

	@AfterTest
	public void afterClass() {
		driver.quit();
	}

}
