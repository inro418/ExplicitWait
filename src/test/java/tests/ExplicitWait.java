package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ExplicitWait {

	WebDriver driver;
	
	@Test
	public void TestWait() {  

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//ImplicitWait - The implicit wait will tell to the web driver to wait for certain amount of time before it throws an exception
		//ExplicitWait - The explicit wait is used to tell the Web Driver to wait for certain conditions (Expected Conditions)
		//Fluent Wait  -  The fluent wait is used to tell the web driver to wait for a condition, as well as the frequency.
		//Thread.Sleep - Thread.sleep() method can be used to pause the execution of current thread for specified time in milliseconds.
		 
        //Implicit Wait             
		//1. Implicit Wait time is applied to all the elements in the script
		//2. In Implicit Wait, we need not specify "ExpectedConditions" on the element to be located
		//3. It is recommended to use when the elements are located with the time frame specified in implicit wait

		
		//ExplicitWait
		//1. Explicit Wait time is applied only to those elements which are intended by us
		//2. In Explicit Wait, we need to specify "ExpectedConditions" on the element to be located
		//3. It is recommended to use when the elements are taking long time to load and also for verifying the property of the element like(visibilityOfElementLocated, elementToBeClickable,elementToBeSelected)
                                  
		
		driver.get("http://www.itgeared.com/demo/1506-ajax-loading.html"); 
		
		driver.findElement(By.xpath("//*[@id='content']/a[2]")).click();  
		
		WebDriverWait w = new WebDriverWait(driver, 20);
		
		w.until(ExpectedConditions.elementToBeClickable(By.id("results")));
		
		System.out.println(driver.findElement(By.id("results")).getText());   
		
		driver.quit();
    }
	
} 