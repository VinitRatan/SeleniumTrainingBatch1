package com.selenium.test.cases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class AlertTests {
	WebDriver driver;
	
 
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vinit Ratan\\Downloads\\chromedriver_new\\chromedriver.exe");

      driver=new ChromeDriver();
      driver.get("https://the-internet.herokuapp.com/javascript_alerts");
     // driver.get("https://demoqa.com/alerts");
      driver.manage().window().maximize(); 
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      System.out.println(driver.getTitle());
      Assert.assertEquals(driver.getTitle(), "The Internet");
	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
  
  @Test(priority=1, enabled=false)
  public void rejectAlert() throws InterruptedException {
	  
	 WebElement buttonToNavigateToAlert=driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]"));
	 buttonToNavigateToAlert.click();
	 WebDriverWait wait=new WebDriverWait(driver, 3);
	 wait.until(ExpectedConditions.alertIsPresent());
	 Alert alert=driver.switchTo().alert();
	 String textMessage=alert.getText();
	 Assert.assertEquals(textMessage,"I am a JS prompt");
	 Thread.sleep(5000);
	 alert.dismiss();
  }
  
  @Test(priority=2, enabled=false)
  public void rejectAlertAfterAddingMessage() throws InterruptedException {
	  
	 WebElement buttonToNavigateToAlert=driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]"));
	 buttonToNavigateToAlert.click();
	 WebDriverWait wait=new WebDriverWait(driver, 3);
	 wait.until(ExpectedConditions.alertIsPresent());
	 Alert alert=driver.switchTo().alert();
	 String textMessage=alert.getText();
	 Assert.assertEquals(textMessage,"I am a JS prompt");
	 String messageToBeAdded="This is my first alert";
	 Thread.sleep(1000);
	 alert.sendKeys("This is my first alert");
	 Thread.sleep(5000);
	 alert.dismiss();
  }
  
  @Test(priority=3, enabled=true)
  public void acceptAlertAfterAddingMessage() throws InterruptedException {
	  
	 WebElement buttonToNavigateToAlert=driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]"));
	// buttonToNavigateToAlert.click();
	 Actions action=new Actions(driver);
	 action.moveToElement(buttonToNavigateToAlert).click().build().perform();
	 WebDriverWait wait=new WebDriverWait(driver, 3);
	 wait.until(ExpectedConditions.alertIsPresent());
	 Alert alert=driver.switchTo().alert();
	 String textMessage=alert.getText();
	 Assert.assertEquals(textMessage,"I am a JS prompt");
	 String messageToBeAdded="This is my first alert";
	 Thread.sleep(1000);

	 alert.sendKeys("This is my first alert");
	 Thread.sleep(2000);
	 alert.accept();
	 Thread.sleep(5000);
  }
  
  @Test(priority=4, enabled=false)
  public void acceptAlertAfterAddingMessage2() throws InterruptedException {
	 WebDriverWait wait=new WebDriverWait(driver, 3); 
	 WebElement buttonToNavigateToAlert=driver.findElement(By.xpath("//button[@id='promtButton']"));
	 Thread.sleep(2000);
	 wait.until(ExpectedConditions.elementToBeClickable(buttonToNavigateToAlert));
	 Actions action=new Actions(driver);
	 action.moveToElement(buttonToNavigateToAlert).build().perform();
	 buttonToNavigateToAlert.click();
	 wait.until(ExpectedConditions.alertIsPresent());
	 Alert alert=driver.switchTo().alert();
	 //String textMessage=alert.getText();
	// Assert.assertEquals(textMessage,"I am a JS prompt");
	 String messageToBeAdded="This is my first alert";
	 Thread.sleep(1000);

	 alert.sendKeys("This");
	 Thread.sleep(5000);
	 alert.accept();
  }


}
