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

//User story 1
//As a user
//I have to register on the web site so that I can buy products
public class RegisterTest {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	@Before
	public void setUp() {
	    driver = new FirefoxDriver();
	    driver.get("http://store.demoqa.com/tools-qa/?action=register");
	  }
	@After
	public void close() {
	    driver.quit();
}
//This test is to assume that if a user use a wrong email address to register
//The web site will show a error
	@Test
	public void register_with_wrongUsernameAndPwd(){
		driver.findElement(By.id("user_login")).clear();
	    driver.findElement(By.id("user_login")).sendKeys("taotaolee");
	    driver.findElement(By.id("user_email")).clear();
	    driver.findElement(By.id("user_email")).sendKeys("taolee_@.com");
	    driver.findElement(By.id("aiowps-captcha-answer")).clear();
	    driver.findElement(By.id("aiowps-captcha-answer")).sendKeys("11");
	    driver.findElement(By.id("wp-submit")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement msg = driver.findElement(By.xpath("//*[@id=\"ajax_registerform\"]/p[1]/strong[1]"));
		assertEquals("ERROR: The email address isn’t correct.", msg.getText());
	}
//This test is to assume that if a user use a registered username to register
//The web site will show error
	@Test
	public void register_with_registeredUsername(){
		driver.findElement(By.id("user_login")).clear();
	    driver.findElement(By.id("user_login")).sendKeys("taolee");
	    driver.findElement(By.id("user_email")).clear();
	    driver.findElement(By.id("user_email")).sendKeys("tal88@pitt.edu");
	    driver.findElement(By.id("aiowps-captcha-answer")).clear();
	    driver.findElement(By.id("aiowps-captcha-answer")).sendKeys("11");
	    driver.findElement(By.id("wp-submit")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement msg = driver.findElement(By.xpath("//*[@id=\"ajax_registerform\"]/p[1]/strong[1]"));
		assertEquals("ERROR: This username is already registered. Please choose another one.", msg.getText());
		}
//This test is to assume that if a user input invalid strings as a username 
//The web site will show error
	@Test
	public void register_with_invalidUsername(){
		driver.findElement(By.id("user_login")).clear();
	    driver.findElement(By.id("user_login")).sendKeys("taolee*&^");
	    driver.findElement(By.id("user_email")).clear();
	    driver.findElement(By.id("user_email")).sendKeys("tal88@pitt.edu");
	    driver.findElement(By.id("aiowps-captcha-answer")).clear();
	    driver.findElement(By.id("aiowps-captcha-answer")).sendKeys("11");
	    driver.findElement(By.id("wp-submit")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement msg = driver.findElement(By.xpath("//*[@id=\"ajax_registerform\"]/p[1]/strong[1]"));
		assertEquals("ERROR: This username is invalid because it uses illegal characters. Please enter a valid username.", msg.getText());
}
}