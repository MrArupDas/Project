package Goodreads.genericlib;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class GeneralCodes {
	public WebDriver driver;
	public DataDrivenCodes ddc = new DataDrivenCodes();
	public CommonCodes cc = new CommonCodes();

	@BeforeClass(alwaysRun = true)
	public void launchBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@BeforeMethod(alwaysRun = true)
	public void login() throws IOException {
		driver.get(ddc.getDataFromProperties("url"));
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Sign in with email')]")).click();
		driver.findElement(By.id("ap_email")).sendKeys(ddc.getDataFromProperties("email"));
		driver.findElement(By.id("ap_password")).sendKeys(ddc.getDataFromProperties("pwd"));
		driver.findElement(By.id("signInSubmit")).click();
	}

	@AfterMethod(alwaysRun = true)
	public void logout() {
		driver.findElement(By.xpath("//div[@class='dropdown dropdown--profileMenu']")).click();
		driver.findElement(By.xpath(
				"//div[@class='siteHeader__subNav siteHeader__subNav--profile gr-box gr-box--withShadowLarge']//a[text()='Sign out']"))
				.click();
	}

	@AfterClass(alwaysRun = true)
	public void close() {
		driver.close();

	}
}
