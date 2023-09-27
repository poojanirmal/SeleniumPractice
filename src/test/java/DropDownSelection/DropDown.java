package DropDownSelection;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropDown {
	
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
		driver.get("https://www.globalsqa.com/");
	}

	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	@Ignore
	@Test
	public void dropDownPractice_1()
	{
		
		WebElement testersHub = driver.findElement(By.xpath("(//a[text()='Tester’s Hub'])[1]"));
		
		Actions act = new Actions(driver);
		act.moveToElement(testersHub).build().perform();
		
		WebElement demoTestingsiteEle = driver.findElement(By.xpath("//span[text()='Demo Testing Site']"));
		act.moveToElement(demoTestingsiteEle).build().perform();
         
		
     	WebElement dropDownBtnEle = driver.findElement(By.xpath("//span[text()='DropDown Menu']"));
		act.doubleClick(dropDownBtnEle).build().perform();
		
		
		
		WebElement countrySelectEle = driver.findElement(By.xpath("//select"));
		 Select sl = new Select(countrySelectEle);
		 sl.selectByValue("AFG");
	}
	
	
	
}
