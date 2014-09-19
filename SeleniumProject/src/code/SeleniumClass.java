package code;

import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SeleniumClass {
	
	@Test
	public static void mainTest() {
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://wordpress.com/wp-login.php");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//WebElement login_link = driver.findElement(By.linkText("Log In"));
		WebElement  userLogin_txtbox = driver.findElement(By.id("user_login"));
		WebElement userPasswd_txtbox = driver.findElement(By.id("user_pass"));
		WebElement submit_btn = driver.findElement(By.id("wp-submit"));
		WebElement remember_chkbox = driver.findElement(By.id("rememberme"));
		
		//login_link.click();
		
		userLogin_txtbox.clear();
		userLogin_txtbox.sendKeys("monadash");
		
		userPasswd_txtbox.clear();
		userPasswd_txtbox.sendKeys("Secret123$");
		
		remember_chkbox.click();
		
		submit_btn.click();
		
		driver.close();

	}

}
