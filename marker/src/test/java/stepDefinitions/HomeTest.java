package stepDefinitions;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;

import base.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.HomePage;
import page.LoginPage;

public class HomeTest {

	
	public BaseTest base;
	public HomePage home;
	
	public WebDriver driver;
	
	SoftAssertions softly = new SoftAssertions();
	
	@When("^I add \"([^\"]*)\" items to the cart$")
	public void I_add_5_items_to_the_cart(int count) throws InterruptedException {
		home = new HomePage();
		
		//home.clickOnOkBtn();
		Thread.sleep(5000);
		//Give count value between 1 to 5
		
		home.addItemsToCart(count);
	}
	
	@And("^I remove \"([^\"]*)\" items from the cart$")
	public void I_remove_2_items_from_the_cart(int count) {
		
		home.removeItemsToCart(count);
	}
	
	@Then("^the cart should contain \"([^\"]*)\" items$")
	public void the_cart_should_contain_3_items(String count) {
		
		softly.assertThat(home.pullCountOfCart()).isEqualTo(count);
	    softly.assertAll();
	}
	
	//Scenario 7
	@When("^Navigate to checkout$")
	public void navigate_to_checkout() {
		home = new HomePage();
		home.navigateToCheckout();
		
	}
	
	@Then("^Remove items in checkout$")
	public void remove_items_in_checkout() {
		
		home.removeItemsInCheckout();	
	}
	
	//scenario 8
	@When("^click on checkout button$")
	public void click_on_checkout_button() {
		
		home = new HomePage();
		home.clickOnCheckoutButton();
	}
	
	@And("^Enter firstname, lastname and zipcode$")
	public void enterFirstNameLastNameZipcode() {
	
		home.enterFirstName();
		home.enterLastName();
		home.enterZipCode();
	}
	
	@And("^Click on Continue button$")
	public void click_on_continue_button() {
		
		home.clickOnContinueBtn();
		
	}
	
	@And("^Click finish button$")
	public void click_finish_button() {
		
		home.clickOnFinishBtn();
		
	}
	
	@Then("^a message should appear as \"([^\"]*)\"$")
	public void a_message_should_appear_as(String message) {
		
		
		softly.assertThat(home.pullMessageAsThankYouForYourOrder()).isEqualTo(message);
		softly.assertAll();
		
		
	}
	
}