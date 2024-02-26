package mpack;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OneTest {

	@Test
	public static void mOne() throws InterruptedException {
		WebDriverManager.chromedriver().clearDriverCache().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://demo.dealsdray.com/");
		
		
		//-------------------------------Login using credentials----------------------------------
		driver.findElement(By.name("username")).sendKeys("prexo.mis@dealsdray.com");
		driver.findElement(By.name("password")).sendKeys("prexo.mis@dealsdray.com");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		
		
		driver.findElement(By.xpath("//span[text()='chevron_right']")).click();
		driver.findElement(By.xpath("//span[text()='Orders']")).click();
		driver.findElement(By.xpath("//button[text()='Add Bulk Orders']")).click();
		
		//----------------------------------upload file-----------------------------------------------
		WebElement file = driver.findElement(By.xpath("//input[@type='file']"));
		file.sendKeys("C:\\Users\\lucky\\Downloads\\demo-data.xlsx");
		driver.findElement(By.xpath("//button[text()='Import']")).click();
		driver.findElement(By.xpath("//button[text()='Validate Data']")).click();
		
		Thread.sleep(3000);
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
}
