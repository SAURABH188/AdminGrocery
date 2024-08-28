package saurabhkumbhar.GroceryTrackerAdminPanel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Homepage {
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
	  	    WebElement Email = driver.findElement(By.cssSelector("#text"));
	  	    WebElement Password = driver.findElement(By.cssSelector("#password"));
	  	    WebElement SignIn = driver.findElement(By.cssSelector("button[type='submit']"));
	  	  Email.sendKeys("admin@admin.com");
	  	Password.sendKeys("12345678");
	  	SignIn.click();
	 
	  }
	 @AfterMethod
	public void teardown() {
		  driver.close();
	}
 @Test(priority = 1)
	 
	 public void Homepagedisplay() throws InterruptedException {
	WebElement Homepage = driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > h3:nth-child(1)"));
	Homepage.isDisplayed();
	Thread.sleep(500);
	Thread.sleep(500);
	Thread.sleep(500); 
	 }
 @Test(priority = 2)
 public void testTotalUsersCard() {
     WebElement totalUsersCard = driver.findElement(By.xpath("//div[contains(@class, 'bg-info')]//h2"));
     totalUsersCard.isDisplayed();
 }

 @Test(priority = 3)
 public void testTotalListsCard() {
     WebElement totalListsCard = driver.findElement(By.xpath("//div[contains(@class, 'bg-success')]//h2"));
     totalListsCard.isDisplayed();
 }

 @Test(priority = 4)
 public void testTotalProductsCard() {
     WebElement totalProductsCard = driver.findElement(By.xpath("//div[contains(@class, 'bg-primary')]//h2"));
     totalProductsCard.isDisplayed();
 }

 @Test(priority = 5)
 public void testTotalSubscribedUsersCard() {
     WebElement totalSubscribedUsersCard = driver.findElement(By.xpath("//div[contains(@class, 'bg-danger')]//h2"));
     totalSubscribedUsersCard.isDisplayed();
 }

 @Test(priority = 6)
 public void testMoreInfoLinks() {
	 	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
     WebElement moreInfoUsers = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div/div/div[1]/div[3]"));
     moreInfoUsers.isDisplayed();

     WebElement moreInfoLists = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div/div/div[2]/div[3]"));
     Assert.assertTrue(moreInfoLists.isDisplayed());

     WebElement moreInfoProducts = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div/div/div[3]/div[3]"));
     Assert.assertTrue(moreInfoProducts.isDisplayed());

     WebElement moreInfoSubscribedUsers = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div/div/div[4]/div[3]"));
     Assert.assertTrue(moreInfoSubscribedUsers.isDisplayed());
 }

}
