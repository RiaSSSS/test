package PageFactory;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCart {

	@FindBy(css = "ul.nav-main>li:first-child")
	WebElement bttn_ShopAll;

	@FindBy(xpath = "(//a[text()='Active Play'])[2]")
	WebElement bttn_ActivePlay;

	@FindBy(xpath = "//a[text()='Liquid Floor Tiles']")
	WebElement bttn_LiquidFloorTiles;

	@FindBy(xpath = "//button[@class='btn btn-addtocart btn-addtocart-top ml20 btn-sld-red ll-btn-md']")
	WebElement bttn_AddToCart;

	@FindBy(xpath = "(//button[@automation-id='cart_view_modal'])[1]")
	WebElement bttn_Checkout;
	
	@FindBy(xpath = "//select[@class='form-control text-center qty-dropdown']")
	WebElement bttn_Qunatity;

	WebDriver driver;

	public AddToCart(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnShopAllOption() throws InterruptedException {
		click(driver, bttn_ShopAll, 20);
	}

	public void clickOnActivePlayOption() {
		// List<WebElement> subListOfShopAllMenuOptions = bttn_ActivePlay ;

		/*
		 * for (WebElement webelement : subListOfShopAllMenuOption) {
		 * if(webelement.getText().trim().equals("Active Play")) {
		 * webelement.click(); } } //used for to skip the first element found
		 * instead of for each 
		 * for(int
		 * i=0;i<subListOfShopAllMenuOptions.size();i++) {
		 * System.out.println(i+" "+(subListOfShopAllMenuOptions.get(i)).getText
		 * ()); Select dropdown= new select
		 * (subListOfShopAllMenuOptions.get(i));
		 * 
		 * subListOfShopAllMenuOptions.get(20).click();
		 * 
		 * 
		 * //this can be used incase number of elements is more and no time to
		 * count there index }
		 */

		click(driver, bttn_ActivePlay, 10);
	}

	public void clickOnOption() {
		click(driver, bttn_LiquidFloorTiles, 10);
	}

	public void clickOnAddToCart() throws InterruptedException {
		click(driver, bttn_AddToCart, 10);
		Thread.sleep(1000);
	}

	public void clickOnCheckoutButton() {
		click(driver, bttn_Checkout, 10);
	}

	public void verifyCheckoutPage() {
		driver.getPageSource().contains("Checkout");
	}

	public void clickOnScrollBarOption() throws InterruptedException
	{
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,750)", "");
		Thread.sleep(1000);
	}
	public void clickOnQuantityDropdown()
	{
		Select Quantitydrp =new Select(bttn_Qunatity);
		Quantitydrp.selectByVisibleText("3");
	}

	public static void click(WebDriver driver, WebElement element, int timeout) {
		new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.visibilityOf(element));
		element.click();
	}
}
