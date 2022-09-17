package com.selenium.test.cases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NewTest {
  @Test
  public void testCase1() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vinit Ratan\\Downloads\\chromedriver_new\\chromedriver.exe");
	  WebDriver driver= new ChromeDriver();
	 // driver.get("https://www.google.co.in/");
	  
	  driver.navigate().to("https://www.google.co.in/");
	  System.out.println(driver.getTitle());
  }
}
