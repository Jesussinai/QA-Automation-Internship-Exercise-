package basic.pom;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.JavascriptExecutor;


public class Base {

	private WebDriver driver;
	public static WebDriverWait objExplicitWait;

	public Base(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver chromeDriverConnection() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/selenium_driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}

	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}

	public void type(String inputText, By locator) {
		driver.findElement(locator).sendKeys(inputText);
	}

	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}
	
	public void click(By locator) {
		driver.findElement(locator).click();
	}

	public void visit(String url) {
		driver.get(url);
	}
	
	public void scrollToObject(By locator) {
		   JavascriptExecutor js = (JavascriptExecutor) driver;
	        WebElement Element = driver.findElement(locator);
	        js.executeScript("arguments[0].scrollIntoView();", Element);
	}
	
	public void closeAlert() {
		driver.switchTo().alert().accept();
	}
	
	
	public void verifyAddedBook(By locator, String bookName) {
		
		List<WebElement> liBooks = driver.findElements(locator);
		if(liBooks.size()>0) {
			for (WebElement book : liBooks) {
				if(book.getText().equalsIgnoreCase(bookName)){
					System.out.println("The book "+bookName+ " it is in your profile");
				}
			}
		} else {
			System.out.println("The book "+bookName+ " It was not found");
			Assert.fail();
		}
	}
	
	

	public Boolean isDisplayed(By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
}

