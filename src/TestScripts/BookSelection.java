package TestScripts;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Goodreads.genericlib.GeneralCodes;

public class BookSelection extends GeneralCodes {

	@Test
	public void searchbook() throws EncryptedDocumentException, IOException, InterruptedException {

		WebElement search = driver.findElement(By.xpath("//input[@class='searchBox__input searchBox__input--navbar']"));
		String book = ddc.getDataFromExcel("Sheet1", 0, 0);
		search.sendKeys(book);
		search.submit();
		//Thread.sleep(3000);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + book
				+ "']/../following-sibling::div[@style='float: left']//div[@class='wtrUp wtrLeft']")));
		driver.findElement(By.xpath("//span[text()='" + book
				+ "']/../following-sibling::div[@style='float: left']//div[@class='wtrUp wtrLeft']")).click();
		cc.navBack(driver);
		driver.findElement(By.xpath(
				"//a[@title='Goodreads Home']/../nav//li[@class='siteHeader__topLevelItem']/a[text()='My Books']"))
				.click();
		driver.findElement(By.xpath("//img[@title='Remove from my books']")).click();
		cc.alertaccept(driver);

	}

}
