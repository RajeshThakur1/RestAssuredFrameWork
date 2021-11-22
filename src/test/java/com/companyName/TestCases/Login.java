package com.companyName.TestCases;

import com.companyName.BasePack.TestBase;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;

public class Login extends TestBase
{
    @BeforeClass

    public void sampleGetCall() {
        InitilizeFrameWork();
        RestAssured.baseURI= baseURI;    // As the BaseURI is the Static one so we can call directlly with help of class
        RestAssured.basePath="/user/auth";
        HashMap map = new HashMap();
        map.put("email", "rajeshthakur1r@gmail.com");
        map.put("password", "123456");

        response = RestAssured.given().body(map).header("Content-Type", "application/json").when().post().then().extract().response();
    }

    @Test
    public void verifyStatusCode() {
        SoftAssert soft = new SoftAssert();
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@   Checking the status code  @@@@@@@@@@@@@@@@@@@@@");
        log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@   Checking the status code  @@@@@@@@@@@@@@@@@@@@@");
        int statusCode=response.getStatusCode();
        Assert.assertEquals(statusCode,200,"Status not not getting Matched");
    }



}
