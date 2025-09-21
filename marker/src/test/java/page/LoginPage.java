package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(){
		
		this.driver= BaseTest.getDriver();
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath="//input[@placeholder='Username']")
	WebElement placeholderMessageUserName;
	
	@FindBy(xpath ="//input[@placeholder='Password']")
	WebElement placeholderMessagePassword;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginButton;
	
	@FindBy(xpath="//*[@id=\"login_button_container\"]/div/form/div[3]/h3")
	WebElement passwordRequiredMessage;
	
	@FindBy(xpath ="//*[@id=\"login_button_container\"]/div/form/div[3]/h3/button")
    WebElement closingErrorMessage;	
	
	@FindBy(xpath ="//*[@id=\"header_container\"]/div[1]/div[2]/div")
	WebElement homeLogo;
	
	public String pageTitle() {
		
		String actual=driver.getTitle();
		return actual;
	}
	
	public String getPlaceholderMessageOfUsername() {
		
		String actual = placeholderMessageUserName.getDomAttribute("placeholder");
		return actual;
	}
	
    public String getPlaceholderMessageOfPassword() {
		
		String actual = placeholderMessagePassword.getDomAttribute("placeholder");
		return actual;
	}
    
    public String getLoginText() {
    	
    	String actual= loginButton.getDomAttribute("value");
    	return actual;
    }
    
    //Scenario 2
    public void enterUserName(String username) {
    	
    	placeholderMessageUserName.sendKeys(username);
    }
    
    public void enterPassword(String password) {
    	
    	placeholderMessagePassword.sendKeys(password);
    }
    
    public void clickOnLoginBtn() {
    	
    	loginButton.click();
    }
    
    public void clearUsername() {
    	
    	placeholderMessageUserName.clear();
    }
    
    public void clearPassword() {
    	
    	placeholderMessagePassword.clear();
    }
    
    public String passwordRequiredMessage() {
    	
    	String actual=passwordRequiredMessage.getText();
    	return actual;
    }
	
    //scenario 3
    public String userNameRequiredMessage() {
    	
    	String actual=passwordRequiredMessage.getText();
    	return actual;
    }
    
    // scenario 4
    public void closingErrorMessage() {
    	
    	closingErrorMessage.click();
    }
    
    public String getHomeLogo() {
    	
    	String text =homeLogo.getText();
    	return text;
    }
	
	
}