package Week4.day1assignment;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleAlert {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Alert.html");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[contains(text(),'Alert Box')]")).click();
		Thread.sleep(3000); 
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		driver.findElement(By.xpath("//button[contains(text(),'Confirm Box')]")).click();
		Thread.sleep(3000);
		Alert alert2 = driver.switchTo().alert();
		alert2.dismiss();
		
		
		driver.findElement(By.xpath("//button[contains(text(),'Prompt Box')]")).click();
		Thread.sleep(3000);
		Alert alert3 = driver.switchTo().alert();
		alert3.sendKeys("Elaavarasi Palanivel");
		alert3.accept();
		
		driver.findElement(By.xpath("//button[contains(text()='Sweet Alert')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='OK']")).click();
	}

}
