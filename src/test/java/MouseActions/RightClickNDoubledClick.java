package MouseActions;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;


public class RightClickNDoubledClick {
	
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
		driver.get("https://demoqa.com/buttons");
		
	}

	@After
	public void tearDown()
	{
		driver.quit();
	}

	
	@Test
	public void mouseClick()
	{
		
		WebElement rightClickEle = driver.findElement(By.xpath("//button[text()='Right Click Me']"));
		
		Actions act = new Actions(driver);
		act.contextClick(rightClickEle).build().perform();
		
		WebElement textEle = driver.findElement(By.xpath("//p[text()='You have done a right click']"));
		
		String expected = "You have done a right click";
		String actual = textEle.getText();
		Assert.assertEquals(expected, actual);
		
		
		WebElement doubledCleckEle = driver.findElement(By.xpath("//button[text()='Double Click Me']"));
		act.doubleClick(doubledCleckEle).build().perform();
		
		WebElement clickEle = driver.findElement(By.xpath("//button[text()='Click Me']"));
		act.click(clickEle).build().perform();
		
		
		
		
		
	}

}
