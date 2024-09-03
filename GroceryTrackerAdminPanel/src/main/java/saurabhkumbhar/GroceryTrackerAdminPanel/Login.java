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
			 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Arsheen Khan\\Selenium_Auto\\javabykiran-Selenium-Softwares (2)\\javabykiran-Selenium-Softwares\\Chrome Drivers\\chromedriver-win64 (3)\\chromedriver-win64");
	        driver = new ChromeDriver();
	        driver.get(baseUrl);
	  			  driver.manage().window().maximize();
	  			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
				

	 public void LoginWithInvalidDetails() throws InterruptedException
	 {
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

		// Sign In Button
		WebElement SignButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/form/div[3]/div[2]/button"));
		SignButton.click();
		Thread.sleep(500);

	 }
	 
	 public void footer()
	 {
		 WebElement terms = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/div[2]/a[1]"));
		 terms.click();
		 driver.navigate().back();
		 
		 WebElement privacy = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/div[2]/a[2]"));
		 privacy.clear();
		 driver.navigate().back();
		 
		 WebElement deleteacc = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/div[2]/a[3]"));
		 deleteacc.click();
		 driver.navigate().back();
		 
		 WebElement contact = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/div[3]/a"));
		 contact.click();
		 driver.navigate().back();
		 
		 
		 
	 }
	 
}
