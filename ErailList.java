package Week4.day2assignment;

import java.awt.List;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailList {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		Click the 'sort on date' checkbooks

		driver.findElement(By.id("chkSelectDateOnly")).click();

//		clear and type in the from station text field

		WebElement ele1 = driver.findElement(By.id("txtStationFrom"));
		ele1.clear();
		ele1.sendKeys("Chennai Egmore");
		Thread.sleep(500);
		ele1.sendKeys(Keys.TAB);

//		clear and type in the to station text field

		WebElement ele2 = driver.findElement(By.id("txtStationTo"));
		ele2.clear();
		ele2.sendKeys("Coimbatore");
		Thread.sleep(500);
		ele2.sendKeys(Keys.TAB);

//		Add a java sleep for 2 seconds

		Thread.sleep(2000);

//		Store all the train names in a list

		int rowCount = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr"))
				.size();

		List trainNames = null;
		for (int i = 1; i <= rowCount; i++) {

			String trains = driver
					.findElement(
							By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr[ " + i + " ]/td[2]"))
					.getText();

			trainNames.add(trains);

		}

//		Get the size of it

		System.out.println("No.of all trains available:" + trainNames.size());

//		Add the list into a new Set

		Set<String> st = new HashSet<String>();

//				And print the size of it

		int size2 = st.size();

		System.out.println("No.of unique trains:" + size2);

		System.out.println("Unique trainlist:" + st);


	}

}
