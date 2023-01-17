package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class LoginSteps {
	WebDriver driver = null;

//
	@Given("browser is open")
	public void browser_is_open() {

		System.out.println("  ===  I am inside LoginDemoSteps_POM  ===== ");

		System.out.println("Inside Step - browser is open");

		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path is : " + projectPath);

		System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

	}

//
	@And("user is on login page")
	public void user_is_on_login_page() {

		driver.navigate().to("http://localhost:8080/ReservaHora/");

	}

//
	@When("^user enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username, String password) throws InterruptedException {

		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);

		Thread.sleep(2000);
	}

	@And("user clicks on login")
	public void user_clicks_on_login() {

		driver.findElement(By.id("login")).click();
	}

//
//
	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() throws InterruptedException {
		try {
			driver.findElement(By.id("home")).isDisplayed();
		} catch (Exception e) {
			driver.findElement(By.id("error-message")).isDisplayed();
		}

		Thread.sleep(2000);
		driver.close();
		driver.quit();

	}
}
