package CucumberJava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Cucumberclass {

	WebDriver driver = null;
	@Given("browser is open")
	public void browser_is_open()
	{
	    System.out.println("Inside Step-Browser Is Open");
	    System.setProperty("webdriver.gecko.marionette", "D:\\ADM\\myartifact\\src\\test\\resources\\Drivers\\geckodriver.exe");
	    driver = new FirefoxDriver();
	    driver.manage().window().maximize();
	}

	@And("user is on login page")
	public void user_is_on_login_page() throws Exception
	{
	   driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	   Thread.sleep(3000);
	}

	@When("user enters username and password")
	public void user_enters_username_and_password() throws Throwable
	{
	    driver.findElement(By.name("username")).sendKeys("Admin");
	    driver.findElement(By.name("password")).sendKeys("admin123");
	    Thread.sleep(3000);
	   
	}

	@And("User click on login")
	public void user_click_on_login() 
	{
		 driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	}

	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() throws Exception
	{
		driver.findElement(By.id("app")).isDisplayed();
		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}

}
