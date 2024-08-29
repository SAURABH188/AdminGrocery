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

public class Products {
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
	  	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
  	    WebElement Products = driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > nav:nth-child(2) > ul:nth-child(1) > li:nth-child(4) > a:nth-child(1) > p:nth-child(2)"));
  	  Products.click();
  	      driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS); 
	  }
	 @AfterMethod
	public void teardown() {
		  driver.close();
}
	 @Test(alwaysRun = true)
	 //Test Case 1
	    public void testProductsHeaderVisibility() {
	        WebElement productsHeader = driver.findElement(By.linkText("Products"));
	        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS); 
	        Assert.assertTrue(productsHeader.isDisplayed());
	        Assert.assertEquals("Products", productsHeader.getText());
	    }

	    @Test(alwaysRun = true)
	    //Test Case 2
	    public void testSearchBoxVisibility() {
	        WebElement searchBox = driver.findElement(By.cssSelector(".search-box"));
	        Assert.assertTrue(searchBox.isDisplayed());
	    }

	    @Test(alwaysRun = true)
	    //Test Case 3
	    public void testSearchInputField() {
	        WebElement searchInput = driver.findElement(By.cssSelector("input[aria-label='Search Input']"));
	        Assert.assertTrue(searchInput.isDisplayed());
	        Assert.assertEquals("Search by Genre", searchInput.getAttribute("placeholder"));
	    }

	    @Test(alwaysRun = true)
	    //Test Case 4
	    public void testSearchInputFieldType() {
	        WebElement searchInput = driver.findElement(By.cssSelector("input[aria-label='Search Input']"));
	        Assert.assertEquals("search", searchInput.getAttribute("type"));
	    }

	    @Test(alwaysRun = true)
	    //Test Case 5
	    public void testSearchInputFieldInitialValue() {
	        WebElement searchInput = driver.findElement(By.cssSelector("input[aria-label='Search Input']"));
	        Assert.assertEquals("", searchInput.getAttribute("value"));
	    }

	    @Test(alwaysRun = true)
	    //Test Case 6
	    public void testSearchInputFieldFunctionality() {
	        WebElement searchInput = driver.findElement(By.cssSelector("input[aria-label='Search Input']"));
	        searchInput.sendKeys("Fiction");
	        Assert.assertEquals("Fiction", searchInput.getAttribute("value"));
	    }

	    @Test(alwaysRun = true)
	    //Test Case 7
	    public void testSearchButtonVisibility() {
	        WebElement searchButton = driver.findElement(By.cssSelector(".input-group-text"));
	        Assert.assertTrue(searchButton.isDisplayed());
	    }

}
