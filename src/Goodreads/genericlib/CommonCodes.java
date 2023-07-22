package Goodreads.genericlib;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;

public class CommonCodes {
	
	
	public void alertaccept(WebDriver driver)
	{
		Alert alt=driver.switchTo().alert();
		alt.accept();
	}
    public void navBack(WebDriver driver)
    {
    	Navigation nav = driver.navigate();
		nav.back();
    }
}
