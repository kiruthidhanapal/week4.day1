package week4.day1;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HtmlLibrary {
	public static void main(String[] args) {
		//set up a driver
				WebDriverManager.chromedriver().setup();
				//open the chrome browser
				ChromeDriver driver = new ChromeDriver();
				//maximize the screen
				driver.manage().window().maximize();
				driver.get("https://html.com/tags/table/");
                List<WebElement> MarketShare = driver.findElements(By.xpath("(//div[@class='render']//tr[1])[2]//td"));
				System.out.println('\n' + " Market Share Library is : " + '\n');
				List<WebElement> MarketShare1 = driver.findElements(By.xpath("//div[@class='render']//th"));
				for (int i = 0; i < MarketShare.size(); i++) {
					System.out.println(MarketShare1.get(i).getText() + " : " + MarketShare.get(i).getText());
				}
				List<WebElement> AbsoluteUsage = driver.findElements(By.xpath("//div[@class='render']//tr[2]//td"));
				System.out.println('\n' + " Absolute Usage Library is : " + '\n');
				List<WebElement> AbsoluteUsage1 = driver.findElements(By.xpath("//div[@class='render']//th"));
				for (int i = 0; i < AbsoluteUsage.size(); i++) {
					System.out.println(AbsoluteUsage1.get(i).getText() + " : " + AbsoluteUsage.get(i).getText());
				}

	}
}
