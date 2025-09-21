package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.assertj.core.api.SoftAssertions;

import base.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.LoginPage;

public class LoginTest {
	
	public BaseTest base;
	public LoginPage login;
	
	public WebDriver driver;
	
	SoftAssertions softly = new SoftAssertions();
	@Given("^Open login page$")
	public void Open_login_page() throws IOException {
		
		BaseTest.intialization();
		base = new BaseTest();
		driver = BaseTest.getDriver();
		//System.out.println(base.getUrl());
		driver.get("https://www.saucedemo.com");
		driver.manage().window().maximize();
		
		
	}
	
	@Then("^check title of the page$")
	public void check_title_of_the_page() {
		login = new LoginPage();
		//System.out.println("Print --> "+login.pageTitle());
		softly.assertThat(login.pageTitle()).isEqualTo("Swag Labs");
		softly.assertAll();
		
	}
	
	@Then("^check placeholder message for username field$")
	public void check_placeholder_message_for_username_field() {

		softly.assertThat(login.getPlaceholderMessageOfUsername()).isEqualTo("Username");
		softly.assertAll();
		
	}
	
	@Then("^check placeholder message for password field$")
	public void check_placeholder_message_for_password_field() {
		
		softly.assertThat(login.getPlaceholderMessageOfPassword()).isEqualTo("Password");
	    softly.assertAll();
	}
	
	@Then("^check login button in the login page$")
	public void check_login_button_in_the_login_page() {
	
		softly.assertThat(login.getLoginText()).isEqualTo("Login");
		softly.assertAll();
	}
	
	// scenario 2
	@When("^the user enters only the username$")
	public void the_user_enters_only_the_username() {
		
		String username ="standard_user";
		login = new LoginPage();
		login.enterUserName(username);
		
	}
	
	@And("^leaves the password field empty$")
	public void leaves_the_password_field_empty() {
		
		
		login.clearPassword();
		
	}
	
	@And("^clicks the Login button$")
	public void clicks_the_login_button() {
		
		login.clickOnLoginBtn();
	}
	
	@Then("^a message \"([^\"]*)\" should appear$")
	public void a_message_password_is_required_should_appear(String message) throws InterruptedException {
		
		//System.out.println("Message-->"+login.passwordRequiredMessage());
		softly.assertThat(login.passwordRequiredMessage()).isEqualTo(message);
	    softly.assertAll();
	    Thread.sleep(2000);
	    //login.clearPassword();
	    login.closingErrorMessage();
	    
	   // login.clearPassword();
	   Thread.sleep(2000);
	   login.clearUsername();
	    
		
	}
	
	//scenario 3
	@When("^the user enters only the password$")
	public void the_user_enters_only_the_password() throws InterruptedException {
	
		login = new LoginPage();
		Thread.sleep(3000);
		String password="secret_sauc";
		login.enterPassword(password);
		
	}
	
	@And("^leaves the username field empty$")
	public void leaves_the_username_field_empty() {
		
		login.clearUsername();
	}
	
	@Then("^A message \"([^\"]*)\" should appear$")
	public void a_message_Epic_sadface_Username_is_required_should_appear(String message) {
		
		System.out.println("Message-->"+login.passwordRequiredMessage());
		softly.assertThat(login.userNameRequiredMessage()).isEqualTo(message);
	    softly.assertAll();
	}
	
	// Scenario 4
	@When("^enter valid username$")
	public void enter_valid_username() throws InterruptedException {
		
		Thread.sleep(3000);
		String username="standard_user";
		login = new LoginPage();
		login.clearUsername();
		login.enterUserName(username);
		
	}
	
	@And("^enter invalid password$")
	public void enter_invalid_password() {
		
		String invalidPassword ="#@$$#RERER";
		login.enterPassword(invalidPassword);
		login.clickOnLoginBtn();
	}
	
	@Then("^a message should be \"([^\"]*)\"$")
	public void a_message_should_be(String message) {
		
		softly.assertThat(message).isEqualTo("Epic sadface: Username and password do not match any user in this service");
		softly.assertAll();
	}

	//Scenario 5
	@And("^enter valid password$")
	public void enter_valid_password() {
		
		String password ="secret_sauce";
		login = new LoginPage();
		login.clearPassword();
		login.enterPassword(password);
		
	}
	
	@Then("^user able to log into application$")
	public void user_able_to_log_into_application() {
		
		
		softly.assertThat(login.getHomeLogo()).isEqualTo("Swag Labs");
		softly.assertAll();
	}

    

}