package com.companyName.BasePack;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import io.restassured.response.Response;
import utills.Property;

public class TestBase {
	
	public static String baseURI;
	
	public static Response response;
	public Logger log;
	
	public TestBase() {
		PropertyConfigurator.configure("log4j.properties");
		log=Logger.getLogger(this.getClass());
		Logger.getRootLogger().setLevel(org.apache.log4j.Level.INFO);
		
		
	}
	
	
	String filePath = "/home/rajesh/eclipse-workspace/BackendTesting/Config/config.properties";
	
	
	public void InitilizeFrameWork() {
		log.info("FrameWork Initilized");
		
		baseURI = Property.getPropertyValue(filePath, "baseURI");
	}
	
	
	

}
