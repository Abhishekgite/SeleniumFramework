package com.Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

public class baseClass2 {

	public WebDriver driver;

	public void intializeDriver() throws IOException, InterruptedException {

		// To read the data from properties file
		FileInputStream fis = new FileInputStream(
				"C:\\Eclipse Project\\14-Sept2023-Selenium-Project-testng-Framework-Prac\\src\\main\\java\\com\\Resources\\data.properties");

		// To access the properties file
		Properties prop = new Properties();
		prop.load(fis);

		String broswerName = prop.getProperty("broswer");

		if (broswerName.equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();
		}

		else if (broswerName.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();
		}

		else if (broswerName.equalsIgnoreCase("EdgeDriver")) {

			driver = new EdgeDriver();

		}
	}

	@BeforeClass
	public void launchBroswer() throws IOException, InterruptedException {

		intializeDriver();

		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

	}
}
