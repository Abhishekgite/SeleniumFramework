package testcases;

import java.io.IOException;
//import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.Resources.baseClass2;

import PageObjectModel.HomePageObject;
import PageObjectModel.RegisterationPageObject;

public class RegisterTestCases extends baseClass2 {

	@Test
	public void verifyRegisterationWithValidData() throws IOException, InterruptedException {

		Thread.sleep(3000);
		
		HomePageObject hpo = new HomePageObject(driver);
		hpo.clickonMyAccount().click();
		hpo.clickonregister().click();
		
		

		RegisterationPageObject rop = new RegisterationPageObject(driver);
		
		rop.enterFirstname().clear();
		
		rop.enterFirstname().sendKeys("test");
		rop.enterLastname().clear();
		rop.enterLastname().sendKeys("test123");

		rop.enterEmail().clear();
		rop.enterEmail().sendKeys("test@gmail.com");

		//driver.findElement(By.xpath("")).sendKeys(null);
	}
	@Test
	public void verifyRegisterationWithInValidData() throws IOException, InterruptedException {
		
				Thread.sleep(3000);

				RegisterationPageObject rop = new RegisterationPageObject(driver);
				rop.enterFirstname().sendKeys("test");
				rop.enterLastname().sendKeys("test");

				rop.enterEmail().sendKeys("testgmail.com");

		
	}

}
