package XAndYCo_ordinates;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ClickByUsingXYCoOrdinates {
	
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
	public void getX_YCoordiantes()
	{
		//By using the getLocation we get the x and y coordinates
		//By using the getRect()we get the x,y,height and width of the web element
		WebElement searchBoxEle = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
		System.out.println(searchBoxEle.getLocation());
		
		//getRect() - way to get x,y,height and width
//		Rectangle r =  searchBoxEle.getRect();
//		System.out.println(r.x);
		
		//getLocation() -  to get x and y
//		Point p = searchBoxEle.getLocation();
//		System.out.println(p.x);
		
		//getsize()  - we get only height and width
//		Dimension d = searchBoxEle.getSize();
//		System.out.println(d.getHeight());
//		System.out.println(d.getWidth());
		
		Actions act = new Actions(driver);
		//act.moveToElement(searchBoxEle, searchBoxEle.getLocation().x, searchBoxEle.getLocation().y).click().build().perform();
		//act.moveByOffset(523, 189).click(searchBoxEle).build().perform();
		act.moveToElement(searchBoxEle, 523, 189).click().build().perform();
		
		
	}

}
