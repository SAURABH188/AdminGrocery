package saurabhkumbhar.GroceryTrackerAdminPanel;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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
	    @Test(priority =12 )
	    public void testUserTableIsDisplayed() {
	        WebElement table = driver.findElement(By.cssSelector("table.table"));
	        Assert.assertTrue(table.isDisplayed());
	    }

	    @Test(priority =13 )
	    public void testNumberOfUsersDisplayed() {
	        WebElement tableBody = driver.findElement(By.cssSelector("tbody"));
	        int userCount = tableBody.findElements(By.tagName("tr")).size();
	        Assert.assertEquals(5, userCount);
	    }

	    @Test(priority =14 )
	    public void testUserProfileImageIsDisplayed() {
	        WebElement userProfileImage = driver.findElement(By.xpath("//tr[1]//td[2]//img"));
	        Assert.assertTrue(userProfileImage.isDisplayed());
	    }

	    @Test(priority =15 )
	    public void testUserNameIsCorrect() {
	        WebElement userName = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div/div[1]/div[2]/div/table/tbody/tr[1]/td[3]"));
	        userName.isDisplayed();
	        System.out.println("UserName is displayed" + userName);
	        }

	    @Test(priority =16 )
	    public void testUserEmailIsCorrect() {
	        WebElement userEmail = driver.findElement(By.xpath("//tr[1]//td[4]"));
	        userEmail.isDisplayed();
	   
	    }

	    @Test(priority =17 )
	    public void testUserAddressIsCorrect() {
	        WebElement userAddress = driver.findElement(By.xpath("//tr[1]//td[5]"));
	        userAddress.isDisplayed();
	    }

	    @Test(priority =18 )
	    public void testUserMobileNumberIsCorrect() {
	        WebElement userMobile = driver.findElement(By.xpath("//tr[1]//td[6]"));
	        userMobile.isDisplayed();
	    }

	    @Test(priority =19 )
	    public void testUserSubscriptionStatusIsCorrect() {
	        WebElement userSubscription = driver.findElement(By.xpath("//tr[1]//td[7]/span"));
	        userSubscription.isDisplayed();
	    }

	    @Test(priority =20 )
	    public void testEditButtonIsDisplayed() {
	        WebElement editButton = driver.findElement(By.xpath("//tr[1]//button[contains(@class, 'btn-primary')]"));
	        Assert.assertTrue(editButton.isDisplayed());
	    }

	    @Test(priority =21 )
	    public void testDeleteButtonIsDisplayed() {
	        WebElement deleteButton = driver.findElement(By.xpath("//tr[1]//button[contains(@class, 'btn-danger')]"));
	        deleteButton.isDisplayed();
	    }
	    @Test(priority =22 )
	    public void testProfileImage() {
	        WebElement Viewtab = driver.findElement(By.cssSelector("tbody tr:nth-child(2) td:nth-child(8) button:nth-child(1)"));
	        Viewtab.click();
	    	WebElement profileImage = driver.findElement(By.cssSelector("img[style*='width: 140px']"));
	        Assert.assertTrue(profileImage.isDisplayed());
	    }

	    @Test(priority =23 )
	    public void testUserName() {
	    	 WebElement Viewtab = driver.findElement(By.cssSelector("tbody tr:nth-child(2) td:nth-child(8) button:nth-child(1)"));
		        Viewtab.click();
	        WebElement userName = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div/div[1]/div[2]/div/div/div/div[2]/p[2]"));
	        Assert.assertEquals("Komal QAAA", userName.getText());
	    }

	    @Test(priority =24 )
	    public void testUserEmail() {
	    	 WebElement Viewtab = driver.findElement(By.cssSelector("tbody tr:nth-child(2) td:nth-child(8) button:nth-child(1)"));
		        Viewtab.click();
	        WebElement userEmail = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div/div[1]/div[2]/div/div/div/div[3]/p[2]"));
	        Assert.assertEquals("komal233@yopmail.com", userEmail.getText());
	    }

	    @Test(priority =25 )
	    public void testUserMobileNo() {
	    	 WebElement Viewtab = driver.findElement(By.cssSelector("tbody tr:nth-child(2) td:nth-child(8) button:nth-child(1)"));
		        Viewtab.click();
	        WebElement userMobileNo = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div/div[1]/div[2]/div/div/div/div[4]/p[2]"));
	        Assert.assertEquals("9595801099556699949494994944", userMobileNo.getText());
	    }

	    @Test(priority =26 )
	    public void testUserAddress() {
	    	 WebElement Viewtab = driver.findElement(By.cssSelector("tbody tr:nth-child(2) td:nth-child(8) button:nth-child(1)"));
		        Viewtab.click();
	        WebElement userAddress = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div/div[1]/div[2]/div/div/div/div[5]/p[2]"));
	        Assert.assertEquals("Nothing", userAddress.getText());
	    }

	    @Test(priority =27 )
	    public void testUserSubscription() {
	    	 WebElement Viewtab = driver.findElement(By.cssSelector("tbody tr:nth-child(2) td:nth-child(8) button:nth-child(1)"));
		        Viewtab.click();
	        WebElement userSubscription = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div/div[1]/div[2]/div/div/div/div[6]/p[2]/span"));
	        Assert.assertEquals("Inactive", userSubscription.getText());
	    }

	    @Test(priority =28 )
	    public void testPlanValidity() {
	    	 WebElement Viewtab = driver.findElement(By.cssSelector("tbody tr:nth-child(2) td:nth-child(8) button:nth-child(1)"));
		        Viewtab.click();
	        WebElement planValidity = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div/div[1]/div[2]/div/div/div/div[7]/p[2]"));
	        Assert.assertEquals("0 month", planValidity.getText());
	    }

	    @Test(priority =29 )
	    public void testCreatedAt() {
	    	 WebElement Viewtab = driver.findElement(By.cssSelector("tbody tr:nth-child(2) td:nth-child(8) button:nth-child(1)"));
		        Viewtab.click();
	        WebElement createdAt = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div/div[1]/div[2]/div/div/div/div[8]/p[2]"));
	        Assert.assertEquals("2024-08-28 12:41:49", createdAt.getText());
	    }

	    @Test(priority =30 )
	    public void testLastUpdate() {
	    	 WebElement Viewtab = driver.findElement(By.cssSelector("tbody tr:nth-child(2) td:nth-child(8) button:nth-child(1)"));
		        Viewtab.click();
	        WebElement lastUpdate = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div/div[1]/div[2]/div/div/div/div[9]/p[2]"));
	        Assert.assertEquals("2024-08-28 12:44:48", lastUpdate.getText());
	    }
	    @Test(priority =31 )
	    public void testAge() {
	    	 WebElement Viewtab = driver.findElement(By.cssSelector("tbody tr:nth-child(2) td:nth-child(8) button:nth-child(1)"));
		        Viewtab.click();
	        WebElement ageElement = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div/div[3]/div[2]/div/div/div/div[1]/p[2]"));
	        String age = ageElement.getText();
	        Assert.assertEquals("60", age);
	    }

	    @Test(priority =32)
	    public void testGender() {
	    	 WebElement Viewtab = driver.findElement(By.cssSelector("tbody tr:nth-child(2) td:nth-child(8) button:nth-child(1)"));
		        Viewtab.click();
	        WebElement genderElement = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div/div[3]/div[2]/div/div/div/div[2]/p[2]"));
	        String gender = genderElement.getText();
	        Assert.assertEquals("60", gender);
	    }

	    @Test(priority =33)
	    public void testBudget() {
	    	 WebElement Viewtab = driver.findElement(By.cssSelector("tbody tr:nth-child(2) td:nth-child(8) button:nth-child(1)"));
		        Viewtab.click();
	        WebElement budgetElement = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div/div[3]/div[2]/div/div/div/div[3]/p[2]"));
	        String budget = budgetElement.getText();
	        Assert.assertEquals("500", budget);
	    }

	    @Test(priority =34)
	    public void testDietType() {
	    	 WebElement Viewtab = driver.findElement(By.cssSelector("tbody tr:nth-child(2) td:nth-child(8) button:nth-child(1)"));
		        Viewtab.click();
	        WebElement dietTypeElement = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div/div[3]/div[2]/div/div/div/div[4]/p[2]"));
	        String dietType = dietTypeElement.getText();
	        Assert.assertEquals("Omnivorous", dietType);
	    }

	    @Test(priority =35)
	    public void testLikeCooking() {
	    	 WebElement Viewtab = driver.findElement(By.cssSelector("tbody tr:nth-child(2) td:nth-child(8) button:nth-child(1)"));
		        Viewtab.click();
	        WebElement likeCookingElement = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div/div[3]/div[2]/div/div/div/div[5]/p[2]"));
	        String likeCooking = likeCookingElement.getText();
	        Assert.assertEquals("Yes", likeCooking);
	    }

	    @Test(priority =36)
	    public void testNumberOfChildren() {
	    	 WebElement Viewtab = driver.findElement(By.cssSelector("tbody tr:nth-child(2) td:nth-child(8) button:nth-child(1)"));
		        Viewtab.click();
	        WebElement childrenElement = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div/div[3]/div[2]/div/div/div/div[6]/p[2]"));
	        String children = childrenElement.getText();
	        Assert.assertEquals("2", children);
	    }

	    @Test(priority =37)
	    public void testNumberOfAdults() {
	    	 WebElement Viewtab = driver.findElement(By.cssSelector("tbody tr:nth-child(2) td:nth-child(8) button:nth-child(1)"));
		        Viewtab.click();
	        WebElement adultsElement = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div/div[3]/div[2]/div/div/div/div[7]/p[2]"));
	        String adults = adultsElement.getText();
	        Assert.assertEquals("5", adults);
	    }

	    @Test(priority =38)
	    public void testHoursSpentOnCooking() {
	    	 WebElement Viewtab = driver.findElement(By.cssSelector("tbody tr:nth-child(2) td:nth-child(8) button:nth-child(1)"));
		        Viewtab.click();
	        WebElement hoursElement = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div/div[3]/div[2]/div/div/div/div[8]/p[2]"));
	        String hours = hoursElement.getText();
	        Assert.assertEquals("3", hours);
	    }

	    @Test(priority =39)
	    public void testOnDiet() {
	    	 WebElement Viewtab = driver.findElement(By.cssSelector("tbody tr:nth-child(2) td:nth-child(8) button:nth-child(1)"));
		        Viewtab.click();
		        WebElement element = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div/div[3]/div[1]/div[1]"));
		        JavascriptExecutor js = (JavascriptExecutor) driver;
		        js.executeScript("arguments[0].scrollIntoView(true);", element);
	        WebElement onDietElement = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div/div[3]/div[2]/div/div/div/div[9]/p[2]"));
	        onDietElement.isDisplayed();
	    }

	    @Test(priority =40)
	    public void testFamilyOnDiet() {
	    	 WebElement Viewtab = driver.findElement(By.cssSelector("tbody tr:nth-child(2) td:nth-child(8) button:nth-child(1)"));
		        Viewtab.click();
		        WebElement element = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div/div[3]/div[1]/div[1]"));
		        JavascriptExecutor js = (JavascriptExecutor) driver;
		        js.executeScript("arguments[0].scrollIntoView(true);", element);
	        WebElement familyOnDietElement = driver.findElement(By.xpath("//strong[text()='Family on diet']/following-sibling::p"));
	        familyOnDietElement.isDisplayed();
	    }

	    @Test(priority =41)
	    public void testPreferredFood() {
	    	 WebElement Viewtab = driver.findElement(By.cssSelector("tbody tr:nth-child(2) td:nth-child(8) button:nth-child(1)"));
		        Viewtab.click();
		        WebElement element = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div/div[3]/div[1]/div[1]"));
		        JavascriptExecutor js = (JavascriptExecutor) driver;
		        js.executeScript("arguments[0].scrollIntoView(true);", element);
	        WebElement preferredFoodElement = driver.findElement(By.xpath("//strong[text()='Prefer food ']/following-sibling::p"));
	        preferredFoodElement.isDisplayed();
	    }

	    @Test(priority =42)
	    public void testCreatedAtt() {
	    	 WebElement Viewtab = driver.findElement(By.cssSelector("tbody tr:nth-child(2) td:nth-child(8) button:nth-child(1)"));
		        Viewtab.click();
		        WebElement element = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div/div[3]/div[1]/div[1]"));
		        JavascriptExecutor js = (JavascriptExecutor) driver;
		        js.executeScript("arguments[0].scrollIntoView(true);", element);
	        WebElement createdAtElement = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div/div[3]/div[2]/div/div/div/div[12]/p[2]"));
	        createdAtElement.isDisplayed();
	    }
	    @Test(priority =43)
	    public void EditUserDetail1() throws InterruptedException {
	    	 Thread.sleep(3000);
	    
	        JavascriptExecutor js = (JavascriptExecutor) driver;


	        js.executeScript("window.scrollBy(0,15000)");
		        
		        Thread.sleep(3000);
	WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"resultPerPage\"]"));
	dropdown.click();
	 Thread.sleep(3000);
	 
		WebElement Select10 = driver.findElement(By.xpath("//*[@id=\"resultPerPage\"]/option[2]"));
		Select10.click();
		Thread.sleep(3000);

        JavascriptExecutor jss = (JavascriptExecutor) driver;

    
        jss.executeScript("window.scrollBy(0,500)");
    	Thread.sleep(3000);
			WebElement Viewtab = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div/div[1]/div[2]/div/table/tbody/tr[7]/td[8]/button[1]"));
			Viewtab.click();
		        Thread.sleep(3000);
		   	 WebElement Edittab = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div/div[1]/div[1]/div[2]"));
			   	Edittab.click();
			    Thread.sleep(3000);
			    
		        WebElement Name = driver.findElement(By.xpath("//*[@id=\"name\"]"));
			    Name.clear();
			    Name.sendKeys("QA");
			    Thread.sleep(3000);
			
	//Test Cases is not developed at full extends
		        }
			
		    	 
	    }
	    

