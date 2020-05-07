package com.companyName.TestCases;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.companyName.BasePack.TestBase;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class SamplePostRequest extends TestBase{

	@BeforeTest
	public void samplePostCall() {
		InitilizeFrameWork();
		RestAssured.baseURI= baseURI;    // As the BaseURI is the Static one so we can call directlly with help of class
		RestAssured.basePath="api/users";
		HashMap map = new HashMap();
		map.put("name", "Rajesh");
		map.put("job", "leader");
		
		response = RestAssured.given().body(map).header("Content-Type", "application/json").when().post().then().extract().response();
		
		
	}

	
	@Test(priority = 1)
	public void verifyStatusCode() {
		SoftAssert soft = new SoftAssert();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@   Checking the status code  @@@@@@@@@@@@@@@@@@@@@");
		log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@   Checking the status code  @@@@@@@@@@@@@@@@@@@@@");
		int statusCode=response.getStatusCode();
		soft.assertEquals(statusCode, 201);
		soft.assertAll();
	}
	
	@Test(priority = 2)
	
	public void checkBody() {
		//System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@  Checking the Response Body @@@@@@@@@@@@@@@@@@@");
		log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@  Checking the Response Body @@@@@@@@@@@@@@@@@@@");
		SoftAssert soft = new SoftAssert();
		String response_Body = response.getBody().asString();
		System.out.println("Response Body:-"+response_Body);
		JsonPath jsonPathEvaluator = response.jsonPath();
		String name = jsonPathEvaluator.get("name");
		String job = jsonPathEvaluator.get("job");
		// If in case isf you want to validate the more pameters u can do 
		
		soft.assertEquals(name, "Rajesh");
		soft.assertEquals(job, "leader");
		
		log.info("User has created Successfully");
		soft.assertAll();
		
		
	}
	
	@Test(priority = 3)
	public void check_responseTime() {
		//System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Checking the response Time @@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Checking the response Time @@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		long time=response.getTime();
		System.out.println("Response Time :="+time);
	}
	
	
	

	
	
	
}
