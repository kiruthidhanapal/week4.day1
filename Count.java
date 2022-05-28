package week4.day1;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Count {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//set up a driver
		WebDriverManager.chromedriver().setup();
		//open the chrome browser
		ChromeDriver driver = new ChromeDriver();
		//maximize the screen
		driver.manage().window().maximize();
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Click on stock market
		driver.get("https://html.com/tags/table/");

		//count the number of rows
        List<WebElement> rows1 = driver.findElements(By.xpath("//div[@class='render']//tr"));
		int rows01 = rows1.size();
		List<WebElement> rows2 = driver.findElements(By.xpath("//div[@class='related-pages']//tr"));
		int rows02 = rows2.size();
		int rows = rows01 + rows02;
		System.out.println('\n' + "1. Total  number of rows : " + rows);

		//count the number of cols
        List<WebElement> cols1 = driver.findElements(By.xpath("//div[@class='render']//th"));
		int cols01 = cols1.size();
		List<WebElement> cols2 = driver.findElements(By.xpath("//div[@class='related-pages']//th"));
		int cols02 = cols2.size();
		int cols = cols01 + cols02;
		System.out.println('\n' + "2. Total  number of cols : " + cols);
	}
}
