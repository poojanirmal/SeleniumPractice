package AlertHandling;

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



public class _1_AlertHandling {
	
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
		driver.get("https://nxtgenaiacademy.com/");
	}

	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	
	@Test
	public void alertPopUp() throws InterruptedException
	{
		WebElement demoSiteEle = driver.findElement(By.xpath("(//a[text()='Demo Sites'])[2]"));
		Actions act = new Actions(driver);
		act.moveToElement(demoSiteEle).build().perform();
		
		WebElement practiceAutomationEle = driver.findElement(By.xpath("(//a[text()='Practice Automation'])[2]"));
		//act.moveToElement(practiceAutomationEle).build().perform();
		practiceAutomationEle.click();
		
		WebElement demoSiteAlertEle = driver.findElement(By.xpath("(//a[text()='Demo Site – Alert and Popup'])[2]"));
		demoSiteAlertEle.click();
		
		WebElement alertBtn = driver.findElement(By.xpath("//button[@name='alertbox']"));
		alertBtn.click();
		
		System.out.println(driver.switchTo().alert().getText());// uesd to get text which is inside the alert pop up
		
		driver.switchTo().alert().accept();
		
		Thread.sleep(4000);
		
		WebElement courseOfferedEle = driver.findElement(By.xpath("(//a[text()='Course Offered'])[2]"));
		act.moveToElement(courseOfferedEle).build().perform();
		
		Thread.sleep(4000);
		
	}
	
	@Ignore
	@Test
	public void alertPopUp_2_()
	{
		WebElement demoSiteEle = driver.findElement(By.xpath("(//a[text()='Demo Sites'])[2]"));
		Actions act = new Actions(driver);
		act.moveToElement(demoSiteEle).build().perform();
		
		WebElement practiceAutomationEle = driver.findElement(By.xpath("(//a[text()='Practice Automation'])[2]"));
		//act.moveToElement(practiceAutomationEle).build().perform();
		practiceAutomationEle.click();
		
		WebElement demoSiteAlertEle = driver.findElement(By.xpath("(//a[text()='Demo Site – Alert and Popup'])[2]"));
		demoSiteAlertEle.click();
		
		WebElement comfirmAlertBtnEle = driver.findElement(By.xpath("//button[@name='confirmalertbox']"));
		comfirmAlertBtnEle.click();
		
		driver.switchTo().alert().accept();//for click on ok used .accept() and for click on cancel used .dismiss()
		
		WebElement confirmationEle = driver.findElement(By.xpath("//p[text()='You clicked on OK!']"));
		
		String expectedText = "You clicked on OK!";
		String actualText = confirmationEle.getText();
		
		Assert.assertEquals(expectedText, actualText);
		
		
		
	}
	
	@Ignore
	@Test
	public void alertPouUp_3_() throws InterruptedException
	{
		
		WebElement demoSiteEle = driver.findElement(By.xpath("(//a[text()='Demo Sites'])[2]"));
		Actions act = new Actions(driver);
		act.moveToElement(demoSiteEle).build().perform();
		
		WebElement practiceAutomationEle = driver.findElement(By.xpath("(//a[text()='Practice Automation'])[2]"));
		//act.moveToElement(practiceAutomationEle).build().perform();
		practiceAutomationEle.click();
		
		WebElement demoSiteAlertEle = driver.findElement(By.xpath("(//a[text()='Demo Site – Alert and Popup'])[2]"));
		demoSiteAlertEle.click();
		
		WebElement promptAlertBtnEle = driver.findElement(By.xpath("//button[@name='promptalertbox1234']"));
		promptAlertBtnEle.click();
		
		driver.switchTo().alert().sendKeys("Yes");
		
		driver.switchTo().alert().accept();
		
		WebElement confirmationTextEle = driver.findElement(By.xpath("//p[text()='Thanks for Liking Automation']"));
		String actualText = confirmationTextEle.getText();
		String expectaedText = "Thanks for Liking Automation";
		
		Assert.assertEquals(expectaedText, actualText);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	

}
