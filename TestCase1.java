package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase1 {

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

		// Create Contact
		driver.findElement(By.linkText("Create Contact")).click();

		// Enter first name
		WebElement firstname = driver.findElement(By.id("firstNameField"));
		firstname.sendKeys("Vidya");

		System.out.println(firstname.getAttribute("value"));

		// Enter last name
		WebElement lastname = driver.findElement(By.id("lastNameField"));
		lastname.sendKeys("Srinivasan");

		System.out.println(lastname.getAttribute("value"));

		// Click Create Contact Button
		driver.findElement(By.className("smallSubmit")).click();

		// Print First Name and Title
		String firstNameText = driver.findElement(By.id("viewContact_firstName_sp")).getText();
		System.out.println("First name string is : " + firstNameText);

		String title = driver.getTitle();
		System.out.println("Browser title is : " + title);

		// Close browser
		driver.close();

	}
}
