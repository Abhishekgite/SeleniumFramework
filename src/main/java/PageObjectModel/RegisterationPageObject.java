package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterationPageObject {

	public WebDriver driver; // WebDriver is declared globally and it is declared as null

	private By firstname = By.xpath("//input[@name='firstname']");

	private By lastname = By.xpath("//input[@name='lastname']");

	private By email = By.xpath("//input[@name='email']");

	// driver 2 took the scope of driver from register test cases class
	
	public RegisterationPageObject(WebDriver driver2) {
		
		// TODO Auto-generated constructor stub
		
		this.driver=driver2;
	}

	public WebElement enterFirstname() {

		return driver.findElement(firstname);
	}

	public WebElement enterLastname() {

		return driver.findElement(lastname);
	}

	public WebElement enterEmail() {

		return driver.findElement(email);
	}

}
