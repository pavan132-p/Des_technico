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
	 WebDriverWait wait;
	
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
	
	
	@Test(priority =3)
	
	public void clickupload() {
		
		driver.findElement(By.xpath("//button[@aria-label='Close']")).click();
		
		driver.findElement(By.xpath("//*[@aria-expanded='false'  or  @aria-expanded='true']")).click();
		driver.findElement(By.xpath("//*[@data-index=\'1\']")).click();
	}
	
	
	@Test(priority=4)
	
	public void uploadfiles() throws InterruptedException {
		// for selecting file 
		driver.findElement(By.xpath("//*[@type=\'file\']")).sendKeys("C:\\Users\\PAVAN\\Downloads\\prince.jpg");
		driver.findElement(By.xpath("//*[@aria-hidden='true']")).click();
		driver.findElement(By.xpath("//*[@placeholder='Set Password']")).sendKeys("Prince132");
		
//		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[normalize-space()='Upload File']")).click();
		driver.findElement(By.xpath("//*[@aria-expanded='false'  or  @aria-expanded='true']")).click();
		driver.findElement(By.xpath("//*[@data-index='0']")).click();
		
		
		Assert.assertTrue(driver.findElement(By.xpath("//*[@class='chakra-text css-xphbs3']")).isDisplayed());
		
	}
	@Test(priority = 5)
	
	public void logout() {
		driver.findElement(By.xpath("//*[@aria-expanded='false'  or  @aria-expanded='true']")).click();
		driver.findElement(By.xpath("//*[@aria-haspopup='menu']")).click();
		
	}
	
                           

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}