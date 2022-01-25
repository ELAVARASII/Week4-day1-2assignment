package Week4.day1assignment;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Windows {

	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@id='home']")).click();
		
		 Set<String> firstwindow = driver.getWindowHandles();
	     List<String>secondwindow = new ArrayList<String>(firstwindow);
	     driver.switchTo().window(secondwindow.get(1));
	     String title = driver.getTitle();
	     System.out.println(title);
	     driver.switchTo().window(secondwindow.get(0));
	     
	     driver.findElement(By.xpath("//button[contains(text(),'Open Multiple Windows')]")).click();
	     Set<String> window1 = driver.getWindowHandles();
	     List<String>secondwindow1 = new ArrayList<String>(window1);
	     driver.switchTo().window(secondwindow1.get(0));     
	     driver.switchTo().window(secondwindow1.get(1));
	     int size = driver.getWindowHandles().size();
	     System.out.println(size);
	     
		
		 driver.findElement(By.xpath("//button[contains(text(),'Do not close me ')]")).click();
		 Set<String>window2 = driver.getWindowHandles();
	     List<String>secondwindow2 = new ArrayList<String>(window2);
	     driver.switchTo().window(secondwindow2.get(0));
	     driver.switchTo().window(secondwindow2.get(1));
	     driver.close();
	     driver.findElement(By.xpath("//button[contains(text(),'Wait for 5 seconds')]")).click();
	     Thread.sleep(5000);
	     Set<String> window3 = driver.getWindowHandles();
	     List<String>secondwindow3 = new ArrayList<String>(window3);
	     driver.switchTo().window(secondwindow3.get(0));
	     driver.switchTo().window(secondwindow3.get(1));
	     driver.switchTo().window(secondwindow3.get(2));
		driver.close();
		

	}

}
