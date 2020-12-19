package com.demowebshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver= driver;
	}
	
	// Page Object Mechanism
	By uname = By.name("uid");
	By pwd = By.name("password");
	By loginbtn = By.name("btnLogin");
	
		
	public String Title() {
		return driver.getTitle();
	}
	public void enterUsername(String username) {
		driver.findElement(uname).sendKeys(username);
	
	}
	
	public void enterPassword(String password) {
		driver.findElement(pwd).sendKeys(password);
	
	}
	public void clickLogin() {
		driver.findElement(loginbtn).click();
	}
}
