package devops.cap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.openqa.selenium.firefox.FirefoxOptions;

import devops.cap.IntegrationTest;

import org.junit.*;
import static org.junit.Assert.*;

import java.io.File;

import org.junit.experimental.categories.Category;

@Category(IntegrationTest.class)
public class LoginFunctionalTest {

	static WebDriver driver;

	@BeforeClass
	public static void setup() {
	
				FirefoxBinary firefoxBinary = new FirefoxBinary();
        firefoxBinary.addCommandLineOptions("--headless");
        System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary(firefoxBinary);
        
        driver = new FirefoxDriver(firefoxOptions);
	}

	@AfterClass
	public static void cleanUp() {
		driver.quit();
	}

	@Test
	public void loginSuccess() {
        driver.get("http://localhost:6080/Cap_GiftShop");
        WebElement email = driver.findElement(By.name("email"));
        WebElement pass = driver.findElement(By.name("password"));
        WebElement button = driver.findElement(By.xpath("/html/body/form/div/button"));         
        email.sendKeys("m.k@devops.com");
        pass.sendKeys("cicd");
        button.click();
        assertTrue(driver.getPageSource().contains("Logged in successfully..."));
	}
	
	//@Test
	public void loginFail() {
        driver.get("http://localhost:6080/Cap_GiftShop");
        WebElement email = driver.findElement(By.name("email"));
        WebElement pass = driver.findElement(By.name("password"));
        WebElement button = driver.findElement(By.xpath("/html/body/form/div/button"));         
        email.sendKeys("a.p@devops.com");
        pass.sendKeys("1234566666666");
        button.click();
        assertTrue(driver.getPageSource().contains("Invalid username or password, Please try again with valid Credentials."));
	}
	
	@Test
	public void registrationSuccess() {
        driver.get("http://localhost:6080/Cap_GiftShop");
        WebElement firstname = driver.findElement(By.name("firstname"));
        WebElement lastname = driver.findElement(By.name("lastname"));
        WebElement confirmpass = driver.findElement(By.name("confirmpass"));
        WebElement email = driver.findElement(By.name("email"));
        WebElement pass = driver.findElement(By.name("pass"));
        WebElement button = driver.findElement(By.xpath("/html/body/form/div/button"));      
        firstname.sendKeys("fname");
        lastname.sendKeys("lname");
        pass.sendKeys("1234");
        confirmpass.sendKeys("1234");
        email.sendKeys("aa@devops.com");
        button.click();
        assertTrue(driver.getPageSource().contains(" "));
	}
	
	@Test
	public void forgotPasswordSuccess() {
        driver.get("http://localhost:6080/Cap_GiftShop");      
        WebElement confirmpass = driver.findElement(By.name("confirmpassword"));
        WebElement email = driver.findElement(By.name("email"));
        WebElement pass = driver.findElement(By.name("newpassword"));
        WebElement button = driver.findElement(By.xpath("/html/body/form/div/button"));      
        pass.sendKeys("cicd1");
        confirmpass.sendKeys("cicd1");
        email.sendKeys("s.v@devops.com");
        button.click();
        assertTrue(driver.getPageSource().contains(" "));
	}
}


