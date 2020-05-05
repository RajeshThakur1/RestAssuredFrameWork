package testng;

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
	
	
	@Test(priority = 1)
	public void verifyStatusCode() {
		SoftAssert soft = new SoftAssert();
		
		log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@   Checking the status code  @@@@@@@@@@@@@@@@@@@@@");
		//System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@   Checking the status code  @@@@@@@@@@@@@@@@@@@@@");
		
		int statusCode=response.getStatusCode();
		soft.assertEquals(statusCode, 200);
		soft.assertAll();
	}
	
	@Test(priority = 2)
	
	public void checkBody() {
		log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@  Checking the Response Body @@@@@@@@@@@@@@@@@@@");
		
		//System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@  Checking the Response Body @@@@@@@@@@@@@@@@@@@");
		
		SoftAssert soft = new SoftAssert();
		String response_Body = response.getBody().asString();
		System.out.println("Response Body:-"+response_Body);
		JsonPath jsonPathEvaluator = response.jsonPath();
		int page_value=jsonPathEvaluator.get("page");
		
		// If in case isf you want to validate the more pameters u can do 
		
		soft.assertEquals(page_value, 1);
		
		soft.assertAll();
		
		
	}
	
	@Test(priority = 3)
	public void check_responseTime() {
		log.warn("This is only for showing the Warning Message ");
		log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Checking the response Time @@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		//System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Checking the response Time @@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		
		long time=response.getTime();
		System.out.println("Response Time :="+time);
	}
	
	
	
	
	
	
	
	
	
	

}
