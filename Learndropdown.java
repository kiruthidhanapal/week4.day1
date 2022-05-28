package week4.day1;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Learndropdown {
public static void main(String[] args) {
		
		//set up a driver 
		WebDriverManager.chromedriver().setup();
		
		//open the chrome browser
		ChromeDriver driver = new ChromeDriver();
		
		//Load an URL
		driver.get("http://leaftaps.com/opentaps/control/login;jsessionid=5FEC3768790D4730CB48B83DFB93F580.jvm1");
		
		//maximize the screen
		driver.manage().window().maximize();
		
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Login into the leaftaps URL
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa", Keys.ENTER);
		//the ENTER keys is used for to enter the "ENTER Button
		
		//CRMSFA "click" it's used to click the button
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		//Leads taps click
		driver.findElement(By.linkText("Leads")).click();
		//Create Lead click
		driver.findElement(By.linkText("Create Lead")).click();
		//Handling drop down useing the select class
		//1.Find the drop down element
		WebElement sourceDropdown = driver.findElement(By.id("createLeadForm_dataSourceId"));
		//2.Access the select class... new Select(sourceDropdown)-this is select the webElement drop down-that is sourceDropdown.
		 Select select1 = new Select(sourceDropdown);
		 //3.Select the value from the drop down
		 select1.selectByIndex(4); 
		 WebElement marketingCampaignDropdown = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		 Select select2 = new Select(marketingCampaignDropdown);
		 select2.selectByVisibleText("Car and Driver");
		 //select2.selectByValue("9001");
		 List<WebElement> options = select2.getOptions();
		 for(WebElement eachOption : options) {
			 System.out.println(eachOption.getText());
		 }
		 WebElement industryDropdown = driver.findElement(By.id("createLeadForm_industryEnumId"));
		 Select select3 = new Select(industryDropdown);
		select3.selectByIndex(3);
		select3.selectByValue("IND_HARDWARE");
		 List<WebElement> option = select3.getOptions();
		 for(WebElement eachOption : options) {
			 System.out.println(eachOption.getText());
		 }
		WebElement ownershipDropdown = driver.findElement(By.id("createLeadForm_ownershipEnumId"));
		 Select select4 = new Select(ownershipDropdown);
		 select4.selectByIndex(6);
			
	}
}
