package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		// Open browser
		ChromeDriver driver = new ChromeDriver();

		// Load url
		driver.get("http://leaftaps.com/opentaps/");

		// maxi
		driver.manage().window().maximize();

		// enter username
		WebElement userName = driver.findElement(By.id("username"));

		userName.sendKeys("DemoCSR");

		// enter password
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		// Login
		driver.findElement(By.className("decorativeSubmit")).click();

		// Click CRM/SFA
		driver.findElement(By.linkText("CRM/SFA")).click();

		// Click Contact tab
		driver.findElement(By.linkText("Contacts")).click();

		// Find Contact
		driver.findElement(By.linkText("Find Contacts")).click();

		// click Email tab
		driver.findElement(By.xpath("//ul[@class='x-tab-strip x-tab-strip-top']/li[3]")).click();

		// Enter email
		driver.findElement(By.name("emailAddress")).sendKeys(("babu@testleaf.com"));

		// Click Find contacts
		driver.findElement(By.xpath("//button[text() = 'Find Contacts']")).click();

		// Close browser
		driver.close();

	}
}
