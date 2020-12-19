package com.demowebshop.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoardPage {
	
	WebDriver driver;
	
	
	public DashBoardPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver = driver;
	}
	
	public String Title() {
		 return driver.getTitle();
	}
	
	By logout = By.xpath("//a[text()='Log out']");
	
	public void clickLogout() {
		driver.findElement(logout).click();
	}
	
	public void clickAlertok() {
		Alert al = driver.switchTo().alert();
		al.accept();
	}

}
