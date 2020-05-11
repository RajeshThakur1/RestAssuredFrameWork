package com.companyName.TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.companyName.BasePack.TestBase;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class SamplePostRequest extends TestBase{

	@BeforeClass
	public void samplePostCall() {
		InitilizeFrameWork();
		RestAssured.baseURI= baseURI;    // As the BaseURI is the Static one so we can call directlly with help of class
		RestAssured.basePath="api/users";
		HashMap map = new HashMap();
		map.put("name", "Rajesh");
		map.put("job", "leader");
		
		response = RestAssured.given().body(map).header("Content-Type", "application/json").when().post().then().extract().response();
		
		
	}

	
	@Test
	public void verifyStatusCode() {
		SoftAssert soft = new SoftAssert();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@   Checking the status code  @@@@@@@@@@@@@@@@@@@@@");
		log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@   Checking the status code  @@@@@@@@@@@@@@@@@@@@@");
		int statusCode=response.getStatusCode();
		AssertJUnit.assertEquals(statusCode, 201);
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
		String name = jsonPathEvaluator.get("name");
		String job = jsonPathEvaluator.get("job");
		// If in case isf you want to validate the more pameters u can do 
		
		AssertJUnit.assertEquals(name, "Rajesh");
		AssertJUnit.assertEquals(job, "leader");
		
		log.info("User has created Successfully");
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
