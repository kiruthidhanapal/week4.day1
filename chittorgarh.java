package week4.day1;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class chittorgarh {
	public static void main(String[] args) {
		//set up a driver
		WebDriverManager.chromedriver().setup();
		//open the chrome browser
		ChromeDriver driver = new ChromeDriver();
		//maximize the screen
		driver.manage().window().maximize();
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Load an URL
		driver.get("https://www.chittorgarh.com/");
		//Click on stock market
		driver.findElement(By.id("navbtn_stockmarket")).click();
		driver.findElement(By.xpath("(//a[text()= 'NSE Bulk Deals'])[1]")).click();
		List<WebElement> SecurityName = driver
				.findElements(By.xpath("//table[@class='table table-bordered table-condensed table-striped']//td[3]"));
		System.out.println('\n' + "1. Security Names : " + '\n');

		for (int i = 0; i < SecurityName.size(); i++) {
		System.out.println(SecurityName.get(i).getText());
		}

		List<WebElement> list = driver
				.findElements(By.xpath("//table[@class='table table-bordered table-condensed table-striped']//td[3]"));
		List<String> strings = new ArrayList<String>();
		for (WebElement Security : list) {
			strings.add(Security.getText());
		}

		// To ensure whether there are Duplicate Security Names

		System.out.println('\n' + "2. Checking for Duplicate Security Names : " + '\n');

		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String DupSecName : strings) {
			if (map.containsKey(DupSecName)) {
				map.put(DupSecName, map.get(DupSecName) + 1);
			} else {
				map.put(DupSecName, 1);
			}
		}
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() > 1)
				System.out.println('\n' + " Duplicates found : " + entry.getKey());
			else
				System.out.println('\n' + " No Duplicates found : " + entry.getKey());
		}
				
	}

}
