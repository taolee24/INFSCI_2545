package hw3;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.*;

// User story 2
//As a user, the most important thing is to log in the web site.
//Log in the website to buy products
public class LoginTest {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	@Before
	public void setUp() {
	    driver = new FirefoxDriver();
	    driver.get("http://store.demoqa.com/products-page/your-account/");
	  }
	@After
	public void close() {
	    driver.quit();
}

	//This test is to make sure that if user input a correct username and password
	//The user will log in.
	@Test
	public void loginwith_correctUsernameAndPwd(){
		driver.findElement(By.cssSelector("a.account_icon > span.icon")).click();
	    driver.findElement(By.id("log")).clear();
	    driver.findElement(By.id("log")).sendKeys("taolee");
	    driver.findElement(By.id("pwd")).clear();
	    driver.findElement(By.id("pwd")).sendKeys("13818186731");
	    driver.findElement(By.id("login")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}
	//This test is to make sure that if user input a incorrect username and password
	//The web site will return an error
	@Test
	public void login_with_wrongUsernameAndPwd(){
		WebElement logBox = driver.findElement(By.id("log"));
		logBox.sendKeys("leetao");
		WebElement pwdBox = driver.findElement(By.id("pwd"));
		pwdBox.sendKeys("123");
		WebElement submit = driver.findElement(By.id("login"));
		submit.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement msg = driver.findElement(By.xpath("//*[@id=\"ajax_loginform\"]/p[1]/strong[1]"));
		assertEquals("ERROR", msg.getText());
}
	//This test is to make sure that if user input a correct username and wrong password
	//The web site will return an error
	@Test
	public void login_with_correctUsernameAndwrongPwd(){
		WebElement logBox = driver.findElement(By.id("log"));
		logBox.sendKeys("taolee");
		WebElement pwdBox = driver.findElement(By.id("pwd"));
		pwdBox.sendKeys("123");
		WebElement submit = driver.findElement(By.id("login"));
		submit.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement msg = driver.findElement(By.xpath("//*[@id=\"ajax_loginform\"]/p[1]/strong[1]"));
		assertEquals("ERROR", msg.getText());
	}
}