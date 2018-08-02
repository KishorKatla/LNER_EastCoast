package eastcoast;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class HomePageTest {
	WebDriver driver; 

	@BeforeTest
	public void beforeMethod() {
		
		System.setProperty("webdriver.chrome.driver", "E:\\Browsers\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();  
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);		
        driver.get("https://preprod.lner.co.uk/");
        driver.findElement(By.cssSelector(".close.btn")).click();
        System.out.println("1: " +driver.getTitle());
        //driver.findElement(By.id("LoginControl_UserName")).sendKeys("staff");
        //driver.findElement(By.id("LoginControl_Password")).sendKeys("preview");
        //driver.findElement(By.id("LoginControl_Button1")).click();   
	}

	@Test
	public void epiLoginTest() {
		 assertEquals("Cheap Train Tickets, No Booking Fee | LNER",driver.getTitle());
		 System.out.println("2: " +driver.getTitle());
		 driver.manage().deleteAllCookies();
	
	
	}
	
	@Test
	public void myAccountTest() throws InterruptedException {
		Thread.sleep(5000);
		driver.get("https://PreProd.lner.co.uk/buy-tickets/");
		driver.findElement(By.cssSelector(".close.btn")).click();
		
		//BUY TICKETS
		System.out.println("3: " +driver.getTitle());
			
		driver.findElement(By.id("prefx_4589_od")).sendKeys("Leagrave"); 
		driver.findElement(By.id("prefx_4589_dd")).sendKeys("London Blackfriars");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		
		driver.findElement(By.cssSelector(".button.button--promo.js-searchsubmit")).click();
		
		
		//Selecting the FARE
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//div[@id='flexibleTicketsOutbound']/table/tbody/tr/td[2]/div[2]/table/tbody/tr/td[2]")).click();
		
		//Book and Continue
		System.out.println(driver.getTitle());
		driver.findElement(By.cssSelector(".journey-overview__book.button.button--active.journey-overview__book--active")).click();
		driver.findElement(By.name("submitAction")).click();
		
		//My Account Login
		System.out.println(driver.getTitle());
        driver.findElement(By.id("LoginForm_email")).sendKeys("lner.katla@gmail.com");
        driver.findElement(By.id("LoginForm_password")).sendKeys("Test1234$");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        
        //Select Fulfilment Method
        System.out.println(driver.getTitle());
        driver.findElement(By.xpath("//a[@href ='#fulfilmentCollect']")).click();
		
        //Payment Accepting Terms and Conditions 
        driver.findElement(By.cssSelector(".preference-fields__checkbox-label.preference-fields__checkbox-label--small-print.preference-fields__label--small-print")).click();
        driver.findElement(By.cssSelector(".button.accessibility__button.button--promo-large.button__icon-right.button--full-width.preference-fields__continue-to-payment")).click();
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        //Payment Confirmation 
        System.out.println(driver.getTitle());
        
        driver.manage().window().maximize();
        Thread.sleep(5000);
        driver.findElement(By.id("card_cvn")).click();
        driver.findElement(By.id("card_cvn")).sendKeys("123");
        
        driver.findElement(By.cssSelector(".myaccount-form__field")).sendKeys("999");
        driver.findElement(By.cssSelector(".submit.button.button--promo-large.button--has-icon-right.pull-right")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(25000);
//	    
//	    
//	    
//	    
	}	
	
	

	@AfterTest
	public void afterMethod() {
		 driver.quit();
	}

	

}
