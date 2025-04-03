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
	
	
	
@Test(priority = 3)
    public void uploadFile() {
        driver.get("https://file-sharing-application.netlify.app/dashboard");
        
        WebElement uploadButton = driver.findElement(By.xpath("//input[@type='file']"));
        uploadButton.sendKeys("C:\\path\\to\\file.txt");
        
        WebElement uploadSuccess = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Upload successful')]")));
        Assert.assertTrue(uploadSuccess.isDisplayed(), "File upload failed");
    }

    @Test(priority = 4)
    public void logout() {
        driver.findElement(By.xpath("//button[normalize-space()='Logout']")).click();
        WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Login']")));
        Assert.assertTrue(loginButton.isDisplayed(), "Logout failed");
    }
 @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
	
	
	
	
	
	
	
