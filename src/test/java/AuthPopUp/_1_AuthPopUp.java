package AuthPopUp;

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

public class _1_AuthPopUp {
	
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
		
	}

	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test
	public void authenticationPopUp()
	{
		
		String userName = "admin";
		String password = "admin";
		String url = "https://"+userName+":"+password+"@"+"the-internet.herokuapp.com/basic_auth";
        
		driver.get(url);
		
		WebElement afterSignInTextEle = driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]"));
	     System.out.println(afterSignInTextEle.getText());
	     
	     Assert.assertEquals("After sign in the text is not matched", "Congratulations! You must have the proper credentials.", afterSignInTextEle.getText());
	     
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
