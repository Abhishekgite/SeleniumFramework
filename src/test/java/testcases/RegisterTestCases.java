package testcases;

import java.io.IOException;
//import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.Resources.baseClass2;
import PageObjectModel.RegisterationPageObject;

public class RegisterTestCases extends baseClass2 {

	@Test
	public void verifyRegisterationWithValidData() throws IOException, InterruptedException {

		intializeDriver();

		// This driver has scope --> because it coming from base class
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		RegisterationPageObject rop = new RegisterationPageObject(driver);
		rop.enterFirstname().sendKeys("test");
		rop.enterLastname().sendKeys("test123");

		rop.enterEmail().sendKeys("test@gmail.com");

		//driver.findElement(By.xpath("")).sendKeys(null);
	}
	@Test
	public void verifyRegisterationWithInValidData() throws IOException, InterruptedException {
		
		intializeDriver();
		// This driver has scope --> because it coming from base class
				driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

				RegisterationPageObject rop = new RegisterationPageObject(driver);
				rop.enterFirstname().sendKeys("test");
				rop.enterLastname().sendKeys("test");

				rop.enterEmail().sendKeys("test@gmail.com");

		
	}

}
