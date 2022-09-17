package com.selenium.test.cases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class SelectTests {
	WebDriver driver;
	
  
  
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vinit Ratan\\Downloads\\chromedriver_new\\chromedriver.exe");

      driver=new ChromeDriver();
      driver.get("https://www.tutorialspoint.com/selenium/selenium_automation_practice.htm#");
     // driver.get("https://demoqa.com/alerts");
      driver.manage().window().maximize(); 
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      System.out.println(driver.getTitle());
      //Assert.assertEquals(driver.getTitle(), "The Internet");
  }

  @AfterMethod
  public void afterMethod() {
	 driver.quit(); 
	 
  }
  
  @Test
  public void slectAndAction() throws InterruptedException {
	  Thread.sleep(10000);
	  Actions action=new Actions(driver);
	  WebElement fName=driver.findElement(By.xpath("//input[@name='firstname']"));
	  
	 // action.moveByOffset(30,80).build().perform();
	  Thread.sleep(5000);
	  action.keyDown(Keys.SHIFT).build().perform();
	  action.sendKeys(fName, "vinit").build().perform();
	  action.keyUp(Keys.SHIFT).build().perform();
	  
	  // action.moveToElement(button).click(button).build().perform();
	 
	  WebElement selectLocator=driver.findElement(By.xpath("//select[@name='continents']"));
	  Select select=new Select(selectLocator);
	  select.selectByVisibleText("Europe");
	  Thread.sleep(5000);
  }
  

}
