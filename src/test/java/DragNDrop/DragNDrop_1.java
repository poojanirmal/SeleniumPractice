package DragNDrop;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class DragNDrop_1 {
	
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
	public void _1_DragNDrop() throws InterruptedException
	{
		WebElement testersHubEle = driver.findElement(By.xpath("(//a[text()='Tester’s Hub'])[1]"));
		
		Actions act = new Actions(driver);
		
		act.moveToElement(testersHubEle).build().perform();
		
		WebElement demotestingEle = driver.findElement(By.xpath("//span[text()='Demo Testing Site']"));
		act.moveToElement(demotestingEle).build().perform();
		
		WebElement dragNDropEle = driver.findElement(By.xpath("//span[text()='Drag And Drop']"));
		act.click(dragNDropEle).build().perform();
		
		WebElement iframeEle = driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']"));
		
		driver.switchTo().frame(iframeEle);
		
		WebElement highTarasDragEle = driver.findElement(By.xpath("//img[@alt='The peaks of High Tatras']"));
		WebElement droppedEle = driver.findElement(By.xpath("//div[@id='trash']"));
		WebElement highTaras2DragEle = driver.findElement(By.xpath("//img[@alt='The chalet at the Green mountain lake']"));
		
		act.dragAndDrop(highTarasDragEle, droppedEle).build().perform();
		act.dragAndDrop(highTaras2DragEle, droppedEle).build().perform();
		
		Thread.sleep(3000);		
		
		
	}
	
	@Ignore
	@Test
	public void _2_DragNDrop()
	{
       WebElement testersHubEle = driver.findElement(By.xpath("(//a[text()='Tester’s Hub'])[1]"));
		
		Actions act = new Actions(driver);
		
		act.moveToElement(testersHubEle).build().perform();
		
		WebElement demotestingEle = driver.findElement(By.xpath("//span[text()='Demo Testing Site']"));
		act.moveToElement(demotestingEle).build().perform();
		
		WebElement dragNDropEle = driver.findElement(By.xpath("//span[text()='Drag And Drop']"));
		act.click(dragNDropEle).build().perform();
		
		WebElement acceptEle = driver.findElement(By.id("Accepted Elements"));
		acceptEle.click();
		
        WebElement iframeEle = driver.findElement(By.xpath("(//iframe)[5]"));
		
		driver.switchTo().frame(iframeEle);
		
		//iframe[@class='demo-frame lazyloaded']
		
		WebElement dragEle = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement droppableEle = driver.findElement(By.xpath("//div[@id='droppable']"));
		
		act.dragAndDrop(dragEle, droppableEle).build().perform();
		
		WebElement droppedEle = driver.findElement(By.xpath("//div/p[text()='Dropped!']"));
		String actualText = droppedEle.getText();
		
	    if(actualText.equals("Dropped!"))
	    {
		  Assert.assertTrue("The image is not dropped", true);
		  System.out.println("The test case get passed");
	    }
	    else
	    {
	    	Assert.assertTrue(false);
	    }
	    
	}
	
	@Test
	public void _3_DropDown() throws InterruptedException
	{
		
		
		  WebElement testersHubEle = driver.findElement(By.xpath("(//a[text()='Tester’s Hub'])[1]"));
			
			Actions act = new Actions(driver);
			
			act.moveToElement(testersHubEle).build().perform();
			
			WebElement demotestingEle = driver.findElement(By.xpath("//span[text()='Demo Testing Site']"));
			act.moveToElement(demotestingEle).build().perform();
			
			WebElement dragNDropEle = driver.findElement(By.xpath("//span[text()='Drag And Drop']"));
			act.click(dragNDropEle).build().perform();
			
			
			WebElement propagationEle = driver.findElement(By.xpath("//li[@id='Propagation']"));
			propagationEle.click();
			
			
			
			 WebElement iframeEle = driver.findElement(By.xpath("(//iframe)[5]"));
				
			 driver.switchTo().frame(iframeEle);
			
			 
			 WebElement dragEle = driver.findElement(By.xpath("//div[@id='draggable']"));
			 WebElement outerdroppableEle = driver.findElement(By.xpath("//div[@id='droppable']"));
			 WebElement innerdroppableEle = driver.findElement(By.xpath("//div[@id='droppable-inner']"));
		    
			 act.clickAndHold(dragEle).release(outerdroppableEle).build().perform();
			 
			 WebElement droppedEle = driver.findElement(By.xpath("//div/p[text()='Dropped!']"));
			 String actualText = droppedEle.getText();
			 
			 String expectedText = "Dropped!";
			 
			 Assert.assertEquals(expectedText, actualText);
			 
			 
			 act.dragAndDrop(dragEle, innerdroppableEle).build().perform();
			 
			 Thread.sleep(3000);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	

}
