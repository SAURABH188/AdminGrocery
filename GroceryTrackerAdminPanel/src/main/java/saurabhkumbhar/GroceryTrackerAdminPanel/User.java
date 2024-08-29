package saurabhkumbhar.GroceryTrackerAdminPanel;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class User {
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
  	    WebElement Users = driver.findElement(By.cssSelector("a[href='#/admin/users']"));
  	     Users.click();
  	      driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	  }
	 @AfterMethod
	public void teardown() {
		  driver.close();
}
	 @Test(priority =1 )
	    public void testUserButtonIsDisplayed() throws InterruptedException {
		  	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	        WebElement userButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div/div[1]/div[1]/div[1]"));
	        userButton.isDisplayed();
	    	Thread.sleep(500);
	    }

	    @Test(priority =2 )
	    public void testUserButtonText() {
	        WebElement userButton = driver.findElement(By.cssSelector("div.btn.mt-1"));
	        String buttonText = userButton.getText();
	        Assert.assertEquals("", buttonText);
	    }

	    @Test(priority =3 )
	    public void testUserButtonFontWeight() {
	        WebElement userButton = driver.findElement(By.cssSelector("div.btn.mt-1"));
	        String fontWeight = userButton.getCssValue("font-weight");
	        Assert.assertEquals("500", fontWeight);
	    }

	    @Test(priority =4 )
	    public void testUserButtonClick() {
	        WebElement userButton = driver.findElement(By.cssSelector("div.btn.mt-1"));
	        userButton.click();
	        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/users"));
	    }
	    @Test(priority =5 )
	    public void testSearchInputPresence() {
	        WebElement searchInput = driver.findElement(By.cssSelector("input[aria-label='Search Input']"));
	        assertNotNull("Search input should be present", searchInput);
	    }

	    @Test(priority =6 )
	    public void testSearchInputPlaceholder() {
	        WebElement searchInput = driver.findElement(By.cssSelector("input[aria-label='Search Input']"));
	        String placeholder = searchInput.getAttribute("placeholder");
	        assertEquals("Search By firstname or lastname", "Search By firstname or lastname", placeholder);
	    }

	    @Test(priority =7 )
	    public void testSearchInputType() {
	        WebElement searchInput = driver.findElement(By.cssSelector("input[aria-label='Search Input']"));
	        String type = searchInput.getAttribute("type");
	        assertEquals("search", "search", type);
	    }

	    @Test(priority =8 )
	    public void testSearchInputCssClass() {
	        WebElement searchInput = driver.findElement(By.cssSelector("input[aria-label='Search Input']"));
	        String cssClass = searchInput.getAttribute("class");
	        assertTrue("Input should have class 'form-control'", cssClass.contains("form-control"));
	    }

	    @Test(priority =9 )
	    public void testSearchInputIsEnabled() {
	        WebElement searchInput = driver.findElement(By.cssSelector("input[aria-label='Search Input']"));
	        assertTrue("Search input should be enabled", searchInput.isEnabled());
	    }

	    @Test(priority =10 )
	    public void testSearchInputIsDisplayed() {
	        WebElement searchInput = driver.findElement(By.cssSelector("input[aria-label='Search Input']"));
	        assertTrue("Search input should be displayed", searchInput.isDisplayed());
	    }

	    @Test(priority =11 )
	    public void testSearchInputDefaultValue() {
	        WebElement searchInput = driver.findElement(By.cssSelector("input[aria-label='Search Input']"));
	        String value = searchInput.getAttribute("value");
	        assertEquals("", "", value);
	    }
}
