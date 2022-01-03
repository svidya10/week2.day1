package week2.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase3 {

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

		// Click Leads tab
		driver.findElement(By.linkText("Leads")).click();

		// Click create lead
		driver.findElement(By.linkText("Create Lead")).click();

		// Enter Company name
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(("Testleaf"));

		// Enter First name
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(("Test"));

		// Enter Last name
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(("Leaf"));

		// birthdate
		driver.findElement(By.id("createLeadForm_birthDate")).sendKeys(("10/12/20"));

		// Enter Contact info
		driver.findElement(By.id("createLeadForm_primaryPhoneCountryCode")).sendKeys(("91"));
		driver.findElement(By.id("createLeadForm_primaryPhoneAreaCode")).sendKeys(("044"));
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(("423423434"));
		driver.findElement(By.id("createLeadForm_primaryPhoneExtension")).sendKeys(("123"));
		driver.findElement(By.id("createLeadForm_primaryPhoneAskForName")).sendKeys(("Testleaf"));
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys(("test.testleaf@gmail.com"));
		driver.findElement(By.id("createLeadForm_primaryWebUrl")).sendKeys(("http://leaftaps.com/opentaps/"));

		// Enter primary address
		driver.findElement(By.name("generalToName")).sendKeys(("Testleaf"));
		driver.findElement(By.name("generalAddress1")).sendKeys(("Testleaf"));
		driver.findElement(By.name("generalCity")).sendKeys(("Chennai"));
		driver.findElement(By.name("generalPostalCode")).sendKeys(("600090"));
		driver.findElement(By.name("generalPostalCodeExt")).sendKeys(("1"));

		// dropdown

		WebElement dd1 = driver.findElement(By.id("createLeadForm_generalCountryGeoId"));
		Select dropdown1 = new Select(dd1);
		dropdown1.selectByVisibleText("India");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement dd2 = driver.findElement(By.xpath("//select[@name='generalStateProvinceGeoId']"));
		Select dropdown2 = new Select(dd2);
		dropdown2.selectByValue("IN-TN");

		// print firstname
		WebElement firstname = driver.findElement(By.id("createLeadForm_firstName"));
		String fs = firstname.getAttribute("value");

		System.out.println(fs);

		// click lead button
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();

		// verify title of the page
		String title = driver.getTitle();
		System.out.println(title);
		if(title.contains("View Lead"))
			System.out.println("Title is correct");
		else
			System.out.println("Title is not correct");
	}
}
