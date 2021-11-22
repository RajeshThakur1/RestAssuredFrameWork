package testng;

import java.util.Properties;

import org.testng.annotations.Test;

import utills.Property;


public class TestClass {
	@Test
	public void testMethod() {
		//Property prop = new Property();
		String filePath = "/Users/rajesh/Desktop/rajesh/RestAssuredFrameWork/Config/config.properties";
		String baseURI=Property.getPropertyValue(filePath, "baseURI");
		System.out.println(baseURI);

	}
	
				
	

}
