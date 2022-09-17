package com.selenium.test.cases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class WindowSwitchTests {
	WebDriver driver;
	
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vinit Ratan\\Downloads\\chromedriver_new\\chromedriver.exe");

      driver=new ChromeDriver();
      driver.get("https://www.naukri.com/");
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
  
  @Test(enabled=false)
  public void windowSwitcTest() throws InterruptedException {
	  WebElement viewAllCompany=driver.findElement(By.xpath("//div[@class='premium-swiper-wrap']//following-sibling::a[text()='View all companies']"));
	  viewAllCompany.click();
	  Set<String> windows=driver.getWindowHandles();
	  Iterator<String> itr=windows.iterator();
	  String parentWindow=driver.getWindowHandle();
	  while(itr.hasNext()){
		  
		  if(itr.next()!=parentWindow){
			 String childWindow=itr.next();
			  driver.switchTo().window(childWindow);
			  Thread.sleep(4000);
			  String actualTitle=driver.findElement(By.xpath("//div[@class='companyListingTitle']")).getText();
		      String expected="Featured companies actively hiring";
		      
		      System.out.println(actualTitle);
		      
		      Assert.assertEquals(expected, actualTitle);
		  
		  }
		  
	  }
  }
  
  @Test
  public void windowSwitchParentWindowTest() throws InterruptedException {
	  WebElement viewAllCompany=driver.findElement(By.xpath("//div[@class='premium-swiper-wrap']//following-sibling::a[text()='View all companies']"));
	  viewAllCompany.click();
	  Set<String> windows=driver.getWindowHandles();
	  Iterator<String> itr=windows.iterator();
	  String parentWindow=driver.getWindowHandle();
	  while(itr.hasNext()){
		  
		  if(itr.next()!=parentWindow){
			 String childWindow=itr.next();
			  driver.switchTo().window(childWindow);
			  Thread.sleep(4000);
			  String actualTitle=driver.findElement(By.xpath("//div[@class='companyListingTitle']")).getText();
		      String expected="Featured companies actively hiring";
		      
		      System.out.println(actualTitle);
		      
		      Assert.assertEquals(expected, actualTitle);
		  
		  }
		  
		 // driver.switchTo().window(parentWindow);
		  
		  driver.switchTo().defaultContent();
		  Thread.sleep(4000);
		  WebElement register=driver.findElement(By.xpath("//a[@title='Jobseeker Register']"));
		  register.click();
		  Thread.sleep(4000);
		  String actualRegisterPageTitle=driver.findElement(By.xpath("//h1[contains(@class,'global-title')]")).getText();
		  String expectedRegisterPageTitle="Find a job & grow your career";
	      System.out.println(actualRegisterPageTitle);
	      Assert.assertEquals(expectedRegisterPageTitle, actualRegisterPageTitle);
	  
	  }
  }

}
