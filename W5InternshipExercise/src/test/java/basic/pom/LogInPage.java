package basic.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LogInPage extends Base{
	//login locators
	By userLocator = By.id("userName");
	By passLocator = By.id("password");
	By signInBtnLocator = By.id("login");
	By homePageLocator = By.id("userName-value");
	
	//add book locators
	By publicity = By.xpath("//img[@src='https://ad.plus/adplus-advertising.svg']");
	By gotoStoreInBtnLocator = By.id("gotoStore");
	By bookNumberOne = By.id("see-book-Git Pocket Guide");
	By addButton = By.xpath("//div[@class = 'text-right fullButton']/button");
	By userProfile = By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[3]");
	String bookName = "Git Pocket Guide";
	By booksList = By.xpath("//div[@class='action-buttons']//a");
	
	//delete Book locators
	By deleteFirstBookBtn = By.id("delete-record-undefined");
	By okBtnDeleteBook = By.id("closeSmallModal-ok");
	By LogOutInBtnLocator = By.id("submit");
	
	public LogInPage(WebDriver driver) {
		super(driver);
	}
	//login Thread.sleep(1000);
	public void logIn() throws InterruptedException {
		if (isDisplayed(userLocator)) {
			//click(publicity); // close publicity
			type("JGutierrez", userLocator); //write username
			type("Jsgt1024_!", passLocator); // write password
			Thread.sleep(1000);
			click(signInBtnLocator); // click sign In button
			Thread.sleep(1000);
			
		} else {
			System.out.println("username textbox was not present");
		}
	}
	
	//add book
	public void addBook() throws InterruptedException {
		
			scrollToObject(gotoStoreInBtnLocator);  //scroll to go to Store button
			Thread.sleep(1000);
			click(gotoStoreInBtnLocator);  //click go to Store button
			
			Thread.sleep(1000);
			click(bookNumberOne); // click first book
			Thread.sleep(1000);
			scrollToObject(addButton); //scroll to Add To Your Collection button
			click(publicity);// close publicity
			Thread.sleep(1000);
			click(addButton);// click on Add To Your Collection button
			Thread.sleep(1000);
			closeAlert(); // close popup
			
			scrollToObject(userProfile); // scroll to user profile button
			Thread.sleep(1000);
			click(userProfile); // click user profile button
			Thread.sleep(1000);
			verifyAddedBook(booksList,bookName); //check if the book is in the profile
			Thread.sleep(1000);
	}
	
	public void deleteBook() throws InterruptedException {
		
		click(deleteFirstBookBtn); //click delete book button
		Thread.sleep(1000);
		click(okBtnDeleteBook); // confirm popup
		Thread.sleep(1000);
		closeAlert(); // close popup
		click(LogOutInBtnLocator); // click LogOut button
	}
	
	
	/*
	public String getUserNameDisplayed() {
		if (isDisplayed(userLocator)) {
			return getText(homePageLocator);
		} else {
			return "";
		}
	}
	*/

}

