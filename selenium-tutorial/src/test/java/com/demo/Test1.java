package com.demo;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test1 {

	@Test()
	public void demoTestcase() {
		Assertions.assertTrue(true);
	}
	
	@Test()
	public void testingDropdown() throws InterruptedException {
		// setup driver, auto configured

		WebDriver driver = new FirefoxDriver();

		// open browser
		driver.get("http://juliemr.github.io/protractor-demo/");

		// test
		WebElement numele1 = driver.findElement(By.xpath("/html/body/div/div/form/input[1]"));
		WebElement numele2 = driver.findElement(By.xpath("/html/body/div/div/form/input[2]"));

		numele1.sendKeys(Inputs.NUM1);
		numele2.sendKeys(Inputs.NUM2);

		WebElement selectEle = driver.findElement(By.xpath("/html/body/div/div/form/select"));

		List<WebElement> options = selectEle.findElements(By.tagName("option"));

		options.get(3).click();

		// click on go button to find result

		WebElement calcBtn = driver.findElement(By.xpath("/html/body/div/div/form/button"));
		calcBtn.click();
		
		Thread.sleep(5000);
		

		WebElement resElement = driver.findElement(By.xpath("/html/body/div/div/form/h2"));
		System.out.println();
		
//		Assertions.assertTrue(resElement.getText().equals(Inputs.MULTIPLICATION));
		Assertions.assertEquals(Inputs.MULTIPLICATION, resElement.getText());

		driver.close();
	}

}
