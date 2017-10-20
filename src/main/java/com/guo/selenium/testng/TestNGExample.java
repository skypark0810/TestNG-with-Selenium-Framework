package com.guo.selenium.testng;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.ie.*;
import org.openqa.selenium.interactions.Actions;

public class TestNGExample {
	
  /*TestCase01-search "TestNG" in google */
  @Test
  public void TestCase01() {
	  
	  System.setProperty("webdriver.ie.driver" ,"C:\\Program Files\\IEDriverServer.exe");
		 
       WebDriver driver = new InternetExplorerDriver();
	  driver.get("http://www.google.ca");
	  driver.manage().window().maximize();	   
	  driver.findElement(By.id("lst-ib")).sendKeys("testNG");	
	  driver.findElement(By.xpath("//*[@id='tsf']/DIV[2]/DIV[3]/CENTER/INPUT[1]")).click();    
      driver.quit();	  
  }
  
  /*TestCase02-Seach the information regarding java from Menu navigator in www.oracle.com */
  @Test
  public void TestCase02() throws InterruptedException{
	  
	  try{
	  System.setProperty("webdriver.ie.driver" ,"C:\\Program Files\\IEDriverServer.exe");
	  WebDriver driver = new InternetExplorerDriver();
	  driver.get("http://www.oracle.com");
	  driver.manage().window().maximize();
	
	  Actions action = new Actions(driver);
	  
	  //Mouse over to the "Menu"
	  action.moveToElement(driver.findElement(By.id("u02menulink"))).clickAndHold().perform();
	  driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
	  System.out.println("Open Menu successfully");
	  
	  //Mouse over to "Database and Technologies"  
	 /*	  
	  WebElement database = driver.findElement(By.xpath("//div[@id='u02mmenu']/DIV/UL/LI[3]/A"));
	  action.moveToElement(database).clickAndHold().perform();
	  */
	  action.moveToElement(driver.findElement(By.linkText("Database and Technologies"))).clickAndHold().perform();	  
	  driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
	  System.out.println("Navigate to Database successfully");
	  
	  //Mouse over to "Java"   
	 /* 
	  WebElement java = driver.findElement(By.xpath("//div[@id='u02mmenu']/DIV/UL/LI[3]/DIV/UL/LI[4]/A"));
	  action.moveToElement(java).clickAndHold().build().perform();   
	*/	  
	  action.moveToElement(driver.findElement(By.linkText("Java"))).clickAndHold().build().perform();
          driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
	  System.out.println("Move to Java successfully");
	  
	  //Click the element of "Overview of Java" 
          action.moveToElement(driver.findElement(By.linkText("Overview of Java"))).clickAndHold().perform();
	  driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
	  Thread.sleep(3000);
	  	  
	  String expectedURL ="https://www.oracle.com/java/index.html";
	  String actualURL = driver.getCurrentUrl();
	  Assert.assertEquals(actualURL, expectedURL);
	  
	  driver.quit();
	  }
	  catch (Exception e){
	  e.printStackTrace();
	  }
	  	  
  }
  
  @Test
  public void TestCase03(){
	  System.out.println("This is TestCase03");
  }
  
  @AfterTest
  public void end(){
	  System.out.println("Test ended");
  }
  
}

