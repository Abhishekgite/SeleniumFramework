package testcases;

import java.io.IOException;
//import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.Resources.baseClass2;

import PageObjectModel.HomePageObject;
import PageObjectModel.LoginPageObject;
import PageObjectModel.RegisterationPageObject;

public class LoginTestCases extends baseClass2 {

	@Test
	public void invalidLoginTest() throws IOException, InterruptedException {

		Thread.sleep(3000);

		HomePageObject hpo = new HomePageObject(driver);
		hpo.clickonMyAccount().click();
		hpo.clickonLogin().click();

		LoginPageObject lop = new LoginPageObject(driver);
		lop.enteremail().sendKeys("test@gmail.com");
		lop.enterpassword().sendKeys("test@123");
		lop.clickonLogin().click();

		// driver.findElement(By.xpath("")).sendKeys(null);
	}

}
