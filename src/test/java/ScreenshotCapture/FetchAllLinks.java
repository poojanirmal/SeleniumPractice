package ScreenshotCapture;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FetchAllLinks {
WebDriver driver;
	
	@Before
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\msnir\\eclipse-workspace\\SeleniumPractice\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.setBinary("C:\\Users\\msnir\\eclipse-workspace\\chrome-win64\\chrome-win64\\chrome.exe");
		driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.google.co.in/");
		
	}

	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test
	public void fetchAllLink()
	{
		List<WebElement> linksEle =  driver.findElements(By.xpath("//a"));//By.Xpath("//a")or xpath("//a[@href]")
		for(int i=0;i<linksEle.size();i++)
		{
			System.out.println(linksEle.get(i).getText());
		}
	}
	
	

}
