package sStepDefinitons;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import junit.framework.Assert;
 



public class Steps {
	
	WebDriver driver;	
	
	
	@Given("As a user I launch gmail")
	public void as_a_user_i_launch_gmail() {
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Abhi\\selnium\\chromedriver.exe");
		    driver =new ChromeDriver();
			   driver.manage().window().maximize();
			   driver.manage().deleteAllCookies();
		    driver.get("https://www.google.com/intl/en-GB/gmail/about/");		   
	}
		
	@Given("As a user I click on gmail sign")
	public void as_a_user_i_click_on_gmail_sign() {
		driver.findElement(By.xpath("//a[@data-action='sign in']")).click();
	}
	
	@When(":I enter {string} and {string}")
	public void i_enter_and(String username, String password) throws InterruptedException {
		
		//entering mail
		 driver.findElement(By.xpath("//input[@type='email']")).sendKeys(username);
		 driver.findElement(By.xpath("//*[@id='identifierNext']")).click();
		 
		 //entering password with use of explicit wait
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		 WebElement element = wait.until(
		 ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
		 driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		 driver.findElement(By.id("passwordNext")).click();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@When("I click on compose button")
	public void i_click_on_compose_button() {
		 driver.findElement(By.xpath("//div[@class='T-I T-I-KE L3']")).click();
	}
	
	@When("I enter recepient {string} and subject as {string}")
	public void i_enter_recepient_and_subject_as(CharSequence recepient, String Subject) throws InterruptedException {
		
		 Thread.sleep(5000); //(fluent method can be used)
		 WebElement element = driver.findElement(By.xpath("//div[@name='to']/div/div[3]//input"));
		 Actions action = new Actions(driver);
		 action.moveToElement(element).click()
		 .sendKeys(element,recepient).build().perform();
		 Thread.sleep(3000);//waiting in order to take 
		 driver.findElement(By.xpath("//input[@placeholder='Subject']")).sendKeys(Subject);
	}
	
	@When("I click on send button")
	public void i_click_on_send_button() throws InterruptedException {
		 driver.findElement(By.xpath("//div[@aria-label='Send ‪(Ctrl-Enter)‬']")).click();	 
		 Thread.sleep(5000);
	}
	
	@When("I verify email has been sent")
	public void i_verify_email_has_been_sent() throws InterruptedException {
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.findElement(By.xpath("//div[@data-tooltip='Sent']")).click();
		
		 driver.findElement(By.xpath("//div[@gh='tl']//tbody/tr")).click();
		 String title = driver.getTitle();
		 Thread.sleep(3000);//waiting for dynamic text <subject to load>
		 Assert.assertEquals("Automation testing - numbhapsmile@gmail.com - Gmail", title);	 
	}
	
	@After
	public void afterCall(){
	   System.out.println("afterCall3");
	   driver.quit();   
	}
}