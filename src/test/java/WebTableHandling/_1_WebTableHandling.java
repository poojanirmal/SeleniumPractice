package WebTableHandling;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class _1_WebTableHandling {
	
WebDriver driver;
String firstName = "Cierra";//Alden,Kierra
	
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
		driver.get("https://demoqa.com/webtables");
		
	}

	@After
	public void tearDown()
	{
		driver.quit();
	}
	

	@Test
	public void webTable_1_()
	{
		
		WebElement firstEle = driver.findElement(By.xpath("//div[text()='"+firstName+"']//following-sibling::div[@class='rt-td']/div/span[@title='Edit']"));
		firstEle.click();
		
		WebElement submitBtnEle = driver.findElement(By.xpath("//button[@id='submit']"));
		submitBtnEle.click();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
