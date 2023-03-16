package StepDefinations;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageFactory.AddToCart;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToCartSteps {
	WebDriver driver;
	AddToCart AddToCart;

	@Before
	public void browserSetup() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		// WebDriverWait wait=new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
	}

	@After
	public void teardown() {
		driver.close();
		driver.quit();
	}

	@AfterStep
	public void addScreenshots(Scenario scenario) {
		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
	}

	@Given("user is on home page")
	public void verifyLoginPage() {
		driver.navigate().to("https://wwwtest.lakeshorelearning.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

	}

	@And("user clicks on the shopall menu option")
	public void verifyShopAllMenuOption() throws AWTException, InterruptedException {
		AddToCart = new AddToCart(driver);
		AddToCart.clickOnShopAllOption();
	}

	@And("user clicks on active play option")
	public void verifyActivePlayOption() throws AWTException, InterruptedException {
		AddToCart = new AddToCart(driver);
		AddToCart.clickOnActivePlayOption();
	}

	@And("user clicks on any option")
	public void verifyOption() throws AWTException, InterruptedException {
		AddToCart = new AddToCart(driver);
		AddToCart.clickOnOption();
	}

	@When("user clicks on add to cart")
	public void verifyAddToCartOption() throws AWTException, InterruptedException {
		AddToCart = new AddToCart(driver);
		AddToCart.clickOnAddToCart();
	}

	@And("User clicks on checkout button")
	public void verifyCheckoutButton() throws AWTException, InterruptedException {
		AddToCart = new AddToCart(driver);
		AddToCart.clickOnCheckoutButton();
	}
	@Then("user navigate to checkout page")
	public void verifyUserIsOnCheckoutPage()
	{
		AddToCart = new AddToCart(driver);
		AddToCart.verifyCheckoutPage();
	}
}
