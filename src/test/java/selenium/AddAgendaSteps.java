package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class AddAgendaSteps {
	WebDriver driver = null;

//
	@Given("browser is open1")
	public void browser_is_open1() {

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
	@And("user is on login page1")
	public void user_is_on_login_page1() {

		driver.navigate().to("http://localhost:8080/ReservaHora/");

	}

//
	@When("^user enters (.*) y (.*)$")
	public void user_enters_username_y_password1(String username, String password) throws InterruptedException {

		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);

		Thread.sleep(2000);
	}

	@And("user clicks on login1")
	public void user_clicks_on_login1() {

		driver.findElement(By.id("login")).click();
	}

//
//
	@Then("user is navigated to the home page1")
	public void user_is_navigated_to_the_home_page1() throws InterruptedException {
		driver.findElement(By.id("home")).isDisplayed();

		Thread.sleep(2000);

	}
	
	@And("user navega al formulario registro agenda")
	public void user_clisk_on_agenda() {
		driver.navigate().to("http://localhost:8080/ReservaHora/agenda?accion=add");
	}
	
	@Then("user es redirigido al formulario de registro de agenda")
	public void user_es_redirigido_al_formulario_de_registro_de_agenda() throws InterruptedException{
		driver.findElement(By.id("idMascota")).isDisplayed();
		driver.findElement(By.id("fecha")).isDisplayed();
		
		Thread.sleep(2000);
	}
	
	@When("^user ingresa (.*) y (.*)$")
	public void user_ingresa_idMascota_y_fecha(String idMascota, String fecha) throws InterruptedException {
		driver.findElement(By.id("idMascota")).sendKeys(idMascota);
		driver.findElement(By.id("fecha")).sendKeys(fecha);

		Thread.sleep(2000);
	}
	
	@And("user pulsa en Registrar")
	public void user_pulsa_en_Registrar() throws InterruptedException {
		driver.findElement(By.id("registrar")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("success-message")).isDisplayed();
		
		driver.close();
		driver.quit();
	}
}
