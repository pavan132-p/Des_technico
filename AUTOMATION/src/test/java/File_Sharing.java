import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class File_Sharing {
	
	WebDriver driver;
	
	@BeforeTest
	
	public void setup() {
		
		driver = new ChromeDriver();
		driver.get("https://file-sharing-application.netlify.app/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	@Test(priority = 1)
    public void signUp() {
		driver.findElement(By.xpath("//span[normalize-space()='Signup']")).click();
        driver.findElement(By.xpath("//input[@id='field-:r4:']")).sendKeys("Gandla pavan");
        driver.findElement(By.xpath("//input[@id='field-:r5:']")).sendKeys("pavanprince796@gmail.com");
        driver.findElement(By.xpath("//input[@id='field-:r6:']")) .sendKeys("GPavanprince@132");
        driver.findElement(By.xpath("//button[normalize-space()='Signup']")).click();
        
//        WebElement successMessage = driver.findElement(By.xpath("//p[contains(text(),'Account created successfully')]"));
//        Assert.assertTrue(successMessage.isDisplayed(), "Sign-up was not successful");
    }
	
	@Test(priority = 2)
	
	public void login() throws InterruptedException {
		
		driver.findElement(By.xpath("//span[normalize-space()='Login']")).click();
		driver.findElement(By.xpath("//*[@placeholder='example@gmail.com']")).sendKeys("pavanprince796@gmail.com");
		driver.findElement(By.xpath("//*[@type='password']")).sendKeys("GPavanprince@132");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@class='chakra-button css-rxecov']")).click();
	}
	
	
	
//	@Test(priority =3)
//	
//	public void selectallfiles() throws InterruptedException {
//		
//		//Thread.sleep(5000);
//		driver.findElement(By.xpath("//*[@aria-controls='menu-list-:r5:']")).click();
//		//driver.findElement(By.xpath("//b[@role='menuitem'][@id='menu-list-:r5:-menuitem-:r7:']")).click();
//		
//		
//	}
	 
//	@Test
//	
//	public void TC_01() {
//		
//		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C://Users//PAVAN\\\\Downloads//DDDDD.pdf");
//		driver.findElement(By.xpath("//span[@class='chakra-checkbox__control css-1yld03o']")).click();
//		driver.findElement(By.xpath("//*[@placeholder='Set Password']")).sendKeys("Prince123");
//		driver.findElement(By.xpath("//button[normalize-space()='Upload File']")).click();
//		
//	}
	
	
	
	
	
	
	@AfterTest
	
	public void teardown() {
		
	}
	
	

}
