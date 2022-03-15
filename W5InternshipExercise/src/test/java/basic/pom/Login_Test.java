package basic.pom;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class Login_Test {

	private WebDriver driver;
	
	LogInPage logInPage;
	
	@Before
	public void setUp() throws Exception {
		logInPage = new LogInPage(driver);
		driver = logInPage.chromeDriverConnection();
		logInPage.visit("https://demoqa.com/login");
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	@Test
	public void test() throws InterruptedException {

		for (int x = 0; x < 1; x++) {
			logInPage.logIn();
			logInPage.addBook();
			logInPage.deleteBook();
			Thread.sleep(2000);
		}
	}
}
