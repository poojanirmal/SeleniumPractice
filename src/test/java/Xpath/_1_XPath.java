package Xpath;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class _1_XPath {
	
	WebDriver driver;
	WebDriverWait wait;
	
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
		wait = new WebDriverWait(driver,15);
		driver.get("https://www.myntra.com/");
	}
	
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test
	public void XpathPractice() throws InterruptedException
	{
		WebElement searchBoxEle = driver.findElement(By.xpath("//input[@class='desktop-searchBar']"));
		searchBoxEle.sendKeys("Mobile" + Keys.ENTER);
		
		
		String expectedTitle = "Mobile - Buy Mobile online in India";
		
		Assert.assertEquals(expectedTitle, driver.getTitle());
		
		WebElement sizeBtnEle = driver.findElement(By.xpath("(//span[@class='atsa-downArrow sprites-arrowDownBold myntraweb-sprite'])[3]"));
		sizeBtnEle.click();
		
		WebElement smallBtnEle = driver.findElement(By.xpath("(//div[@class='common-checkboxIndicator'])[1]"));
		smallBtnEle.click();
		
		Thread.sleep(3000);

		   
	}

}
