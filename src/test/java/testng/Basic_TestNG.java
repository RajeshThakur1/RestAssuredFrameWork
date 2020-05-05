package testng;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Basic_TestNG {
	
	
	@BeforeClass
	public void OpenUrl() {
	System.out.println("Open URL");
	}
	@BeforeMethod
	public void Login() {
	System.out.println("Login");
	}
	@Test
	public void createCustomer() {
	System.out.println("Create Customer");
	}
	@Test
	public void editCustomer() {
	System.out.println("Edit Customer");
	}
	
	/*
	 * Open URL Login Create Customer Logout Login Edit Customer Logout Close URL
	 */
	@Test(enabled=false)
	public void deleteCustomer() {
	System.out.println("Delete Customer");
	}
	@AfterMethod
	public void Logout() {
	System.out.println("Logout");
	}
	@AfterClass
	public void closeUrl() {
	System.out.println("Close URL");
	
	}
	
	
	
}
