package code;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TesNGDataProvider {
	WebDriver driver = new FirefoxDriver();

	@BeforeTest
	public void setup()
	{
		driver.get("https://wordpress.com/wp-login.php");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	 

  @Test(dataProvider="UserCredentialList")
  public void UserLogin(String Name, String Passwd) {
	  System.out.println("User Name: " + Name + " User Password: " +Passwd);
	  
	 
		
		//WebElement login_link = driver.findElement(By.linkText("Log In"));
		WebElement  userLogin_txtbox = driver.findElement(By.id("user_login"));
		WebElement userPasswd_txtbox = driver.findElement(By.id("user_pass"));
		WebElement submit_btn = driver.findElement(By.id("wp-submit"));
		WebElement remember_chkbox = driver.findElement(By.id("rememberme"));
		
		
		
		userLogin_txtbox.clear();
		userLogin_txtbox.sendKeys(Name);
		
		userPasswd_txtbox.clear();
		userPasswd_txtbox.sendKeys(Passwd);
		
		remember_chkbox.click();
		
		submit_btn.click();
		
		
  }
  
  @AfterTest
  public void tearDown()
  {
	driver.close();
  }
  
  @DataProvider(name="UserCredentialList")
	public Object[][]  list()
	{
		Object[][] cred = new Object[3][2];
		
		cred[0][0] = "Monalisha";
		cred[0][1] = "Dash";
		
		cred[1][0] = "Vandana";
		cred[1][1] = "Gadhawe";
		
		cred[2][0] = "Himanshu";
		cred[2][1] = "Katiyar";
		return cred;
		
	}
}
