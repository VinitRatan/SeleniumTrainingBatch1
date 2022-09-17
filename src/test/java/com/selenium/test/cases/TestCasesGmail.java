package com.selenium.test.cases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class TestCasesGmail {
	WebDriver driver;
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vinit Ratan\\Downloads\\chromedriver_new\\chromedriver.exe");

      driver=new ChromeDriver();
      driver.get("https://gmail.com/");
      driver.manage().window().maximize(); 
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      Assert.assertEquals(driver.getTitle(), "Gmail");
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

  @Test
  public void loginGmail() throws InterruptedException {
	  System.out.println("my first test case");
	  WebElement user=driver.findElement(By.id("identifierId"));
	  user.clear();
	  user.sendKeys("ratantutorials");
	  Thread.sleep(2000);
	  WebElement userSubmit=driver.findElement(By.xpath("//span[text()='Next']"));
	  userSubmit.click();
	  Thread.sleep(5000);
	  WebElement password=driver.findElement(By.xpath("//input[contains(@type,'pass')]"));
      password.clear();
      password.sendKeys("anamikaratan");
      Thread.sleep(2000);
      WebElement pwdSubmit=driver.findElement(By.xpath("//span[text()='Next']"));
 
      pwdSubmit.click();
      Thread.sleep(7000);
      String actualField=driver.findElement(By.xpath("//a[contains(@aria-label,'Inbox')]")).getText();
      String expectedFiledName="Inbox";
      Assert.assertTrue(expectedFiledName.equals(expectedFiledName));
      
  }
  
}
