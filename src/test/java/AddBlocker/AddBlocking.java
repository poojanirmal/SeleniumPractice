package AddBlocker;

import java.io.File;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddBlocking{

WebDriver driver;
WebDriverWait wait;
	
	@Before
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO\\eclipse-workspace\\SeleniumPractices\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		
		
		opt.setBinary("C:\\Users\\LENOVO\\eclipse-workspace\\chrome-win64\\chrome-win64\\chrome.exe");
		opt.addExtensions(new File("C:\\Users\\LENOVO\\eclipse-workspace\\SeleniumPractices\\extension_5_9_0_0.crx"));//add blocker file ,this line need get to be used before chrome driver
		
		driver = new ChromeDriver(opt);

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.globalsqa.com/");
		wait = new WebDriverWait(driver,15);
	}

	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test
	public void _1_Iframe() throws InterruptedException 
	{
       WebElement testersHub = driver.findElement(By.xpath("(//a[text()='Tester’s Hub'])[1]"));
		
		Actions act = new Actions(driver);
		act.moveToElement(testersHub).build().perform();
		
		
		WebElement demoTestingsiteEle = driver.findElement(By.xpath("//span[text()='Demo Testing Site']"));
		act.moveToElement(demoTestingsiteEle).build().perform();
		
		WebElement iFrameEle = driver.findElement(By.xpath("//span[text()='Frames And Windows']"));
		iFrameEle.click();
		
		
		
		WebElement iframeBtnEle = driver.findElement(By.xpath("//ul[@class='resp-tabs-list ']/li[3]"));
		iframeBtnEle.click();
		//wait.until(ExpectedConditions.elementToBeClickable(iframeBtnEle));
		
		WebElement frameEle = driver.findElement(By.xpath("//input[@id='s']"));
		frameEle.sendKeys("pooja");
		
		
		WebElement logoEle = driver.findElement(By.xpath("//img[@alt='GlobalSQA']"));
		logoEle.isDisplayed();	
	
		Thread.sleep(3000);
		

		
		
		
		
		
		
		
	}
	
	
}
