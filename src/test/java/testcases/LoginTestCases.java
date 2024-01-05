package testcases;

import java.io.IOException;
//import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.Resources.baseClass2;

import PageObjectModel.LoginPageObject;
import PageObjectModel.RegisterationPageObject;

public class LoginTestCases extends baseClass2 {

	@Test
	public void invalidLoginTest() throws IOException, InterruptedException {

		intializeDriver();

		// This driver has scope --> because it coming from base class
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		LoginPageObject lop = new LoginPageObject(driver);
		lop.enteremail().sendKeys("test@gmail.com");
		lop.enterpassword().sendKeys("test@123");
		lop.clickonLogin().click();

		//driver.findElement(By.xpath("")).sendKeys(null);
	}

}
