package com.demowebshop.pages;

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

}
