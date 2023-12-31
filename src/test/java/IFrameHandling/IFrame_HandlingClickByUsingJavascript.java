package IFrameHandling;

import java.io.File;
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
import org.openqa.selenium.interactions.Actions;

public class IFrame_HandlingClickByUsingJavascript {

	WebDriver driver;
	
	@Before
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\msnir\\eclipse-workspace\\SeleniumPractice\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();

		opt.setBinary("C:\\Users\\msnir\\eclipse-workspace\\chrome-win64\\chrome-win64\\chrome.exe");
		//opt.addExtensions(new File("C:\\Users\\LENOVO\\eclipse-workspace\\SeleniumPractices\\extension_5_9_0_0.crx"));
		//opt.addArguments("--incognito");
		
		driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.automationtesting.in/Frames.html");
	}

	@After
	public void tearDown()
	{
			driver.quit();
	}

	@Test
	public void iFrameHandling()
	{
		WebElement enteringBtnEle = driver.findElement(By.xpath("//img[@id='enterimg']"));
		enteringBtnEle.click();
		
		WebElement switchToEle = driver.findElement(By.xpath("//a[text()='SwitchTo']"));
//		Actions act = new Actions(driver);
//		act.moveToElement(switchToEle);
		switchToEle.click();
		
		WebElement framesBtnEle = driver.findElement(By.xpath("//a[text()='Frames']"));
		//framesBtnEle.click();
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();", framesBtnEle);
		
		
		WebElement iframeEle = driver.findElement(By.xpath("//iframe[@id='singleframe']"));
		driver.switchTo().frame(iframeEle);
		
		WebElement textBoxEle = driver.findElement(By.xpath("//input[@type='text']"));
		textBoxEle.sendKeys("Pooja");
	
	}
	
	//button[text()='Skip Sign In']
	//a[text()='SwitchTo']
	//a[text()='Frames']
	//iframe[@id='singleframe']
	//(//input[@type='text'])[1]
	
	
	
	
	
	
	
	
	
	
}
