package eastcoast;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 * @author Kishor Katla
 *
 */
public class epiLoginTest {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		 
		System.setProperty("webdriver.chrome.driver", "E:\\Browsers\\Chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();  
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);		
        driver.get("https://awsrsp.lner.co.uk/");
        System.out.println(driver.getTitle());
                     
    
        driver.findElement(By.id("LoginControl_UserName")).sendKeys("staff");
        driver.findElement(By.id("LoginControl_Password")).sendKeys("preview");
        driver.findElement(By.id("LoginControl_Button1")).click();   
        System.out.println(driver.getTitle());
        driver.findElement(By.id("buylink")).click();   
        driver.manage().deleteAllCookies();
        
        
        
             
        Thread.sleep(15000);
        driver.quit();
        
	}

}
