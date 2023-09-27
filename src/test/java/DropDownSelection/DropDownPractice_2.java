package DropDownSelection;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DropDownPractice_2 {
	
WebDriver driver;
	
	@Before
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO\\eclipse-workspace\\SeleniumPractices\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.setBinary("C:\\Users\\LENOVO\\eclipse-workspace\\chrome-win64\\chrome-win64\\chrome.exe");
		driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://formstone.it/");
	}

	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test
	public void dropDownPractice_2() throws InterruptedException
	{
		
		WebElement dropDownEle = driver.findElement(By.xpath("//a[text()='Dropdown']"));
		dropDownEle.click();
		
		
//		WebElement demoEle = driver.findElement(By.xpath("(//a[text()='Demo'])[1]"));
//		Actions act = new Actions(driver);
//		act.moveToElement(demoEle);
		
		WebElement selectStateEle = driver.findElement(By.xpath("//select[@id='demo_label']"));
		Select sl = new Select(selectStateEle);
		sl.selectByVisibleText("Indiana");
		
		Thread.sleep(5000);
		
		
		
		
	}
	
}
