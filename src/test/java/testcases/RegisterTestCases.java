package testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Resources.baseClass2;
import com.Resources.constants;

import PageObjectModel.HomePageObject;
import PageObjectModel.RegisterationPageObject;

public class RegisterTestCases extends baseClass2 {

	public static String randomEmail="";
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

		String firstNameErrorMsg = constants.firstNameErrorMsg;

		String lastNameErrorMsg = constants.lastNameErrorMsg;

		sa.assertEquals(rop.CaptureFirstNameErrorMsg().getText(), firstNameErrorMsg);

		sa.assertEquals(rop.CaptureLastNameErrorMsg().getText(), lastNameErrorMsg);

		sa.assertAll();
	}

	public String generateRandomEmail() {

		return System.currentTimeMillis() + "@gmail.com";
	}

	
	@Test(dependsOnMethods ="verifyRegisterationWithBlankData")
	public void verifyRegisterationWithInValidData() throws IOException, InterruptedException {

		Thread.sleep(3000);
		
		
		randomEmail = generateRandomEmail();
		RegisterationPageObject rop = new RegisterationPageObject(driver);
		
		rop.EnterFirstname().clear();
		rop.EnterFirstname().sendKeys(constants.firstname);
		rop.EnterLastname().sendKeys(constants.lastname);

		rop.EnterEmail().sendKeys(randomEmail);

		rop.EnterTelephone().sendKeys(constants.telephone);
		rop.EnterPassword().sendKeys(constants.password);
		rop.EnterPasswordConfirm().sendKeys(constants.confirmpassword);
		rop.ClickOnSubscribe().click();
		rop.ClickOnContinueButton().click();

		SoftAssert sa = new SoftAssert();

		String successURL = constants.successURL;
		sa.assertEquals(driver.getCurrentUrl(), successURL);

		sa.assertAll();
	}

}
