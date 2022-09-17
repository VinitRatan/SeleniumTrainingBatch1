package com.selenium.test.cases;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class FrameTests {
  WebDriver driver;
  
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vinit Ratan\\Downloads\\chromedriver_new\\chromedriver.exe");

      driver=new ChromeDriver();
      driver.get("https://the-internet.herokuapp.com/iframe");
      driver.manage().window().maximize(); 
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      System.out.println(driver.getTitle());
      Assert.assertEquals(driver.getTitle(), "The Internet");
	  
  }
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
  
  @Test
  public void interactWithFrame() throws InterruptedException{
	  driver.switchTo().frame("mce_0_ifr");
	  WebElement inputField=driver.findElement(By.xpath("//body[@id='tinymce']//p"));
	  inputField.clear();
	  inputField.sendKeys("sample frame text");
	  Thread.sleep(5000);
	  driver.switchTo().parentFrame();
	  driver.switchTo().defaultContent();
	  
  }


  
  
}
