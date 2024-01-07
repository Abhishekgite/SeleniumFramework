package testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Resources.baseClass2;

import PageObjectModel.HomePageObject;
import PageObjectModel.RegisterationPageObject;

public class RegisterTestCases extends baseClass2 {

	@Test
	public void verifyRegisterationWithBlankData() throws IOException, InterruptedException {

		Thread.sleep(3000);

		HomePageObject hpo = new HomePageObject(driver);
		hpo.clickonMyAccount().click();
		hpo.clickonregister().click();

		RegisterationPageObject rop = new RegisterationPageObject(driver);

		rop.EnterFirstname().clear();
		rop.EnterFirstname().sendKeys("");
		rop.EnterLastname().clear();
		rop.EnterLastname().sendKeys("");

		rop.EnterEmail().clear();
		rop.EnterEmail().sendKeys("");
		
		rop.EnterTelephone().sendKeys("");
		rop.EnterPassword().sendKeys("");
		rop.EnterPasswordConfirm().sendKeys("");
		rop.ClickOnSubscribe().click();
		rop.AcceptPrivacyPolicy().click();
		rop.ClickOnContinueButton().click();

		
		SoftAssert sa = new SoftAssert();
		
		String firstNameErrorMsg = "First Name must be between 1 and 32 characters!";
		
		String lastNameErrorMsg = "Last Name must be between 1 and 32 characters!";
		
		sa.assertEquals(rop.CaptureFirstNameErrorMsg().getText(), firstNameErrorMsg);
		
		sa.assertEquals(rop.CaptureLastNameErrorMsg().getText(), lastNameErrorMsg);
	
		sa.assertAll();
	}

	@Test 
	public void verifyRegisterationWithInValidData() throws IOException, InterruptedException {

		Thread.sleep(3000);

		RegisterationPageObject rop = new RegisterationPageObject(driver);
		rop.EnterFirstname().sendKeys("test");
		rop.EnterLastname().sendKeys("test");

		rop.EnterEmail().sendKeys("te123@gmail.com");
		
		
		rop.EnterTelephone().sendKeys("12345678");
		rop.EnterPassword().sendKeys("test123");
		rop.EnterPasswordConfirm().sendKeys("test123");
		rop.ClickOnSubscribe().click();
		rop.ClickOnContinueButton().click();

	}

}
