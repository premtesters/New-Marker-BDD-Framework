package page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;

public class HomePage {

WebDriver driver;
	
	public HomePage(){
		
		this.driver= BaseTest.getDriver();
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="(//*[@class=\"inventory_list\"]/div/div/div[2]/button)[1]")
	WebElement item1;
	
	@FindBy(xpath="(//*[@class=\"inventory_list\"]/div/div/div[2]/button)[2]")
	WebElement item2;
	
	@FindBy(xpath="(//*[@class=\"inventory_list\"]/div/div/div[2]/button)[3]")
	WebElement item3;
	
	@FindBy(xpath="(//*[@class=\"inventory_list\"]/div/div/div[2]/button)[4]")
	WebElement item4;
	
	@FindBy(xpath="(//*[@class=\"inventory_list\"]/div/div/div[2]/button)[5]")
	WebElement item5;
	
	@FindBy(xpath ="//*[@id=\"shopping_cart_container\"]/a/span")
	WebElement countOfCart;
	
	@FindBy(xpath ="//*[@id=\"shopping_cart_container\"]/a")
	WebElement checkout;
	
	@FindBy(xpath ="(//button[@class=\"btn btn_secondary btn_small cart_button\"])[1]")
	WebElement remove;
	
	@FindBy(xpath ="//*[@id=\"checkout\"]")
	WebElement checkOutBtn;
	
	@FindBy(xpath ="//*[@id=\"first-name\"]")
	WebElement firstName;
	
	@FindBy(xpath ="//*[@id=\"last-name\"]")
	WebElement lastName;
	
	@FindBy(xpath ="//*[@id=\"postal-code\"]")
	WebElement zipCode;
	
	@FindBy(xpath ="//*[@id=\"continue\"]")
	WebElement continueBtn;
	
	@FindBy(xpath ="//*[@id=\"finish\"]")
	WebElement finishBtn;
	
	@FindBy(xpath="//*[@id=\"checkout_complete_container\"]/h2")
	WebElement thanksForOrder;
	
	List<WebElement> items;
	
	public void clickOnOkBtn() {
		
		Alert alert = driver.switchTo().alert();
        alert.accept();
	}
	
	public void addItemsToCart(int count) {
		
		items= new ArrayList<>();
		
		items.add(item1);
		items.add(item2);
		items.add(item3);
		items.add(item4);
		items.add(item5);
		
		for (int i=0;i<count;i++) {
			
			items.get(i).click();
		}
		
		
	}
	
	public void removeItemsToCart(int count) {
		
        for (int i=0;i<count;i++) {
			
			items.get(i).click();
		}
	}
	
	public String pullCountOfCart() {
		
		String count =countOfCart.getText();
		return count;
	}
	
	//Scenario 7
	
	public void navigateToCheckout() {
		
		checkout.click();
	}
	
	public void removeItemsInCheckout() {
		
		remove.click();
		
	}
	
	//Scenario 8
	
	public void clickOnCheckoutButton() {
		
		checkOutBtn.click();
	}
	
	public void  enterFirstName() {
		
		String firstname ="Prem";
		firstName.sendKeys(firstname);
	}
	public void enterLastName() {
		
		String lastname ="Kumar";
		lastName.sendKeys(lastname);
		
	}
	
	public void enterZipCode() {
		
		String zipcode ="RETTERI01";
		zipCode.sendKeys(zipcode);
		
		
	}
	
	public void clickOnContinueBtn() {
		
		continueBtn.click();
	}
	
	public void clickOnFinishBtn() {
		
		finishBtn.click();
	}
	
	public String pullMessageAsThankYouForYourOrder() {
		
		String message =thanksForOrder.getText();
		return message;
	}
}