package saurabhkumbhar.GroceryTrackerAdminPanel;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login {
	private WebDriver driver;
    private String baseUrl = "https://grocery-admin-panel-rose.vercel.app/#/";

	
	@BeforeMethod
	  //TEST CASE NO 1
	  		public void setUp() {
			  System.setProperty("webdriver.chrome.driver", "C:\\Users\\SAURABH\\Downloads\\chromedriver-win64 (3)\\chromedriver-win64\\chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.get(baseUrl);
	  			  driver.manage().window().maximize();
	  			 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);	  		
	  }
	 @AfterMethod
	public void teardown() {
		 driver.close();
	 } 
	 
	 @Test(priority = 1)
	 
	 public void Loginpagedisplay() throws InterruptedException {
	WebElement Loginpage = driver.findElement(By.cssSelector("p[class='text-center']"));
	Loginpage.isDisplayed();

		 
		 //Password
		 WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		 password.sendKeys("12345678");
		 
		 //Checkbox
		 WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/form/div[3]/div[1]/input"));
			if(!checkbox.isSelected())
			{
				checkbox.click();		
			}
		
		// Sign In Button
		WebElement SignButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/form/div[3]/div[2]/button"));
		SignButton.click();
	 }
	 
	 @Test(priority=2)
	 public void LoginWithInvalidDetails() throws InterruptedException {

				 WebElement emailid = driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/form/div[1]/input"));
				 emailid.sendKeys("admin2222@admin.com");
				 
				 //Password
				 WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
				 password.sendKeys("1235555");
				 
				 //Checkbox
				 WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/form/div[3]/div[1]/input"));
					if(!checkbox.isSelected())
					{
						checkbox.click();		
					}
		  			 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);	  		

					WebElement Submit= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/form/div[3]/div[2]/button"));
					Submit.click();
		  			 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);	  		
		  			boolean isMessagePresent = driver.findElements(By.xpath("//div[text()='Email is not registered']")).size() > 0;
		  	        Assert.assertTrue(isMessagePresent);
				

	 }
}
