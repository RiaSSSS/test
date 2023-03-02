package StepDefinations;
import java.awt.AWTException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageFactory.Login;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.TakesScreenshot;
import java.time.Duration;

public class LoginSteps {

	WebDriver driver;
	Login login;
	
	@Before
	public void browserSetup()
	{
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");
		driver=new ChromeDriver();
		//WebDriverWait wait=new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
	}
	@After
	public void teardown()
	{
		driver.close();
		driver.quit();
	}
	@AfterStep
	 public void addScreenshots(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			final byte[] screenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
	}
	
@Given ("user is on login page")
	public void verifyLoginPage()
	{
		driver.navigate().to("https://wwwtest.lakeshorelearning.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
	}
	 
	@And ("user clicks on login button")
	public void verifyloginButton() throws AWTException, InterruptedException
	{
		login=new Login(driver);
		login.clickOnSignInButton();
	}
	@When ("^user enters (.*) and (.*)$")
	public void verifyEnterCredential(String username , String password)
	{
		login=new Login(driver);
		login.enterUserNameAndPassword(username, password);
	}
	@And ("click on  login button")
	public void verifyLoginButton() throws InterruptedException
	{
		login=new Login(driver);
		login.clickOnLoginButton();
	}
	@Then ("user navigated to the home page")
	public void verifyNavigatetoHomePage() throws InterruptedException
	{
		login=new Login(driver);
		login.verifyUserisOnHomePageAfterLogin();
	}
	@Then ("validation message should be displayed")
	public void verifyValidationMessage() throws InterruptedException
	{
		login=new Login(driver);
		login.verifyValidationMessageIsDisplayed();
	}
}
