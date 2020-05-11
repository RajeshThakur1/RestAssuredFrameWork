package com.companyName.TestCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.companyName.BasePack.TestBase;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.path.json.exception.JsonPathException;
import io.restassured.response.Response;

public class SampleGet extends TestBase{
	
	@BeforeClass
	
	public void sampleGetCall() {
		InitilizeFrameWork();
		RestAssured.baseURI= baseURI;    // As the BaseURI is the Static one so we can call directlly with help of class
		RestAssured.basePath="/api/users?page=2";
		
		response = RestAssured.given().when().get().then().extract().response();
	}
	
	
	@Test
	public void verifyStatusCode() {
		SoftAssert soft = new SoftAssert();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@   Checking the status code  @@@@@@@@@@@@@@@@@@@@@");
		log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@   Checking the status code  @@@@@@@@@@@@@@@@@@@@@");
		int statusCode=response.getStatusCode();
		AssertJUnit.assertEquals(statusCode, 200);
		soft.assertAll();
	}
	
	@Test
	
	public void checkBody() {
		//System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@  Checking the Response Body @@@@@@@@@@@@@@@@@@@");
		log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@  Checking the Response Body @@@@@@@@@@@@@@@@@@@");
		SoftAssert soft = new SoftAssert();
		String response_Body = response.getBody().asString();
		System.out.println("Response Body:-"+response_Body);
		JsonPath jsonPathEvaluator = response.jsonPath();
		int page_value=jsonPathEvaluator.get("page");
		
		// If in case isf you want to validate the more pameters u can do 
		
		AssertJUnit.assertEquals(page_value, 1);
		
		soft.assertAll();
		
		
	}
	
	@Test
	public void check_responseTime() {
		//System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Checking the response Time @@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Checking the response Time @@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		long time=response.getTime();
		System.out.println("Response Time :="+time);
	}
	
	
	
	
	
	
	
	
	
	

}
