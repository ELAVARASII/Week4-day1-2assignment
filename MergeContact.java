package Week4.day1assignment;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
	    driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
	    driver.findElement(By.id("password")).sendKeys("crmsfa");
	    driver.findElement(By.className("decorativeSubmit")).click();
	    driver.findElement(By.linkText("CRM/SFA")).click();
	    driver.findElement(By.linkText("Contacts")).click();
	    driver.findElement(By.xpath("//a[contains(text(),'Merge Contacts')]")).click();
	    WebElement find1 = driver.findElement(By.id("ComboBox_partyIdFrom"));
	    find1.sendKeys("Elavarasi");
	    find1.sendKeys(Keys.TAB);
	    WebElement find2 = driver.findElement(By.id("ComboBox_partyIdTo"));
	    find2.sendKeys("Saba");
	    driver.findElement(By.xpath("//a[text()='Merge']")).click();
	    Thread.sleep(5000);
	    Alert alert = driver.switchTo().alert();
	    alert.accept();
	    String title = driver.getTitle();
System.out.println(title);
	}

}
