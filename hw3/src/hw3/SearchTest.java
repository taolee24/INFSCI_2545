package hw3;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.*;
import java.util.List;

// User story 3
//As a user, I  need to get the product information through searching products

public class SearchTest {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	@Before
	public void setUp() {
	    driver = new FirefoxDriver();
	    driver.get("http://store.demoqa.com");
	  }
	@After
	public void tearDown() throws Exception {
	    driver.quit();
}
// This test is to assume that if a user search the product which only have one type
//The product will be showed only 
	@Test
	public void searchTest_SearchTheOnly() {
		driver.findElement(By.name("s")).clear();
	    driver.findElement(By.name("s")).sendKeys("apple tv");
	    driver.findElement(By.name("s")).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebElement select = driver.findElement(By.xpath("//*[@id='grid_view_products_page_container']/div"));
		List<WebElement> allOptions = select.findElements(By.className("grid_product_info"));
		for (WebElement option : allOptions) {
			WebElement item = option.findElement(By.tagName("a"));
			System.out.println(String.format("%s", item.getText()));
		}
		
	}
//This test is to assume that if a user input the key word which has many products
//All products will be showed on the web site	
@Test
	public void SearchAllProduct() {
	driver.findElement(By.name("s")).clear();
    driver.findElement(By.name("s")).sendKeys("iphone");
    driver.findElement(By.name("s")).sendKeys(Keys.ENTER);
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebElement select = driver.findElement(By.xpath("//*[@id='grid_view_products_page_container']/div"));
		List<WebElement> allOptions = select.findElements(By.className("grid_product_info"));
		for (WebElement option : allOptions) {
			WebElement item = option.findElement(By.tagName("a"));
			System.out.println(String.format("%s", item.getText()));
		}
}
//This test is assume that if a user input products which do not exist
//The web site will show nothing
	@Test
	public void Search_WrongProduct() {
		driver.findElement(By.name("s")).clear();
	    driver.findElement(By.name("s")).sendKeys("pineapple pen");
	    driver.findElement(By.name("s")).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebElement select = null;
		select = driver.findElement(By.xpath("//*[@id='content']/p"));
		System.out.println(select.getText());
		assertEquals(select.getText(), "Sorry, but nothing matched your search criteria. Please try again with some different keywords.");
	}
}