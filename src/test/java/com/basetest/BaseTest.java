package com.basetest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.base.Base;

public class BaseTest extends Base{
	
	@BeforeMethod
	public void setUp() {
		launchApp();
	}
	
	@AfterMethod
	public void tearDown() {
		
	}

}
