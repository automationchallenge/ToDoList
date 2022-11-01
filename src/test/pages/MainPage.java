package test.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;


public class MainPage {
	
	WebDriver driver;
	
	By title = By.xpath("//*[text()='Vue.js']");
	
	By addtodolist  = By.cssSelector("input.new-todo");
	
	
	public MainPage(WebDriver driver) { this.driver = driver; }
	
	
	public void verifyLoadedPage() {
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(Exception.class);

				@SuppressWarnings("unused")
				WebElement element=wait.until(new Function<WebDriver, WebElement>() {
				
				public WebElement apply(WebDriver driver) {
				if (driver.findElement(title).isDisplayed())
				{
					System.out.println("Element is found");
				}
				return driver.findElement(title);
				}});
			}
	
	public void addList(String item)
	{
		driver.findElement(addtodolist).sendKeys(item);
		driver.findElement(addtodolist).sendKeys(Keys.RETURN);
	}
	
	public String findListItem(String item)
	{
		String value = String.format("//label[text() ='%s']",item);
		String actualitem = driver.findElement(By.xpath(value)).getText();
		return actualitem;
	}
	
}
