package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	
	@FindBy(id="signin-popover")
	WebElement bttn_UserProfile;
	
	@FindBy(xpath="//a[@automation-id='sal_signin']/..")
	WebElement bttn_Signin;
	
	@FindBy(id="emailId")
	WebElement txt_username;
	
	@FindBy(name="password")
	WebElement txt_password;
	
	@FindBy(xpath="//button[@automation-id='login_button']")
	WebElement btn_login;
	
	WebDriver driver;
	
	public Login(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnSignInButton() throws InterruptedException
	{
		Thread.sleep(6000);
		bttn_UserProfile.click();
		Thread.sleep(2000);
		bttn_Signin.click();
		Thread.sleep(2000);
	}
	public void enterUserNameAndPassword(String username , String password)
	{
		txt_username.sendKeys(username);
		txt_password.sendKeys(password);
	}
	public void clickOnLoginButton() throws InterruptedException
	{
		btn_login.click();
		Thread.sleep(2000);
	}
	public void verifyUserisOnHomePageAfterLogin() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.getPageSource().contains("Testq");
	}
	public void verifyValidationMessageIsDisplayed() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.getPageSource().contains("Oops! That email and/or password was not found. Please try again.");
	}

}
