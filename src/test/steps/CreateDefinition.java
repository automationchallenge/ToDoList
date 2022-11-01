package test.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.github.bonigarcia.wdm.WebDriverManager;
import test.pages.MainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateDefinition  {
	
	WebDriver driver;
	
	MainPage mainPage;
	
	
	

@Given("user launch application")
public void user_launch_application() {
    // Write code here that turns the phrase above into concrete actions
   WebDriverManager.chromedriver().setup();
   driver = new ChromeDriver();
   driver.manage().window().maximize();
   driver.get("https://todomvc.com/examples/vue/");
   mainPage = new MainPage(driver);
  

}

@When("^user add (.*)$")
public void user_add_item(String item) {
    // Write code here that turns the phrase above into concrete actions
	System.out.println("---User add item");
	mainPage.addList(item);
}

@Then("^user verify (.*)$")
public void user_verify_item(String item) {
    // Write code here that turns the phrase above into concrete actions
	System.out.println("---User verify item");
	String actual = mainPage.findListItem(item);
	System.out.println(actual);
}

@And("user validate loaded page")
public void user_validate_loaded_page() {
    // Write code here that turns the phrase above into concrete actions
	mainPage.verifyLoadedPage();
}



}
