package com.crm.qa.demo.APITestCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import com.crm.qa.BaseClass.TestBase;

public class APIDemo extends TestBase {
	
	@BeforeSuite
    public void setUpSuite(){
        System.out.println("I am in Before Suite");
    }

    @BeforeTest
    public void setUpTestEnvironment(){
        System.out.println(" I am in Before Test Environment");
    }

    @BeforeMethod
    public void setUpMethod(){
        baseURI="http://localhost:3000";
        System.out.println("I am in before method");
    }

    @Test
    public void apost(){

        given().
                header("Content-Type","application/json").
                body("{\n" +
                        "    \"first_name\": \"Sachin\",\n" +
                        "    \"last_name\": \"Tendulkar\",\n" +
                        "    \"email\": \"Sachin@gmail.com\"} ").
                log().all().
        when().
                post("/employees").
        then().
                log().all().assertThat().statusCode(201);
    }


    @Test
    public void get(){

        given().
                header("Content-Type","application/json").
                log().all().
                when().
                get("/employees").
                then().
                log().all().assertThat().statusCode(200);
    }


    @Test
    public void put() {
        given().header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"first_name\": \"Kohli\",\n" +
                        "    \"last_name\": \"King\",\n" +
                        "    \"email\": \"Kohli@gmail.com\"\n" +
                        "    \n" +
                        "}\n").
                log().all().
                when().
                put("/employees/2").
                then().log().all().
                assertThat().statusCode(200);
    }

    @Test
    public void getAfterPut(){

        given().
                header("Content-Type","application/json").
                log().all().
                when().
                get("/employees").
                then().
                log().all().assertThat().statusCode(200);
    }
    
    @AfterMethod
    public void tearDownMethod(){
        System.out.println("I am in After method");
    }

    @AfterTest
    public void tearDownTest(){
        System.out.println(" I am in after test environemnt");
    }

    @AfterSuite
    public void tearDown(){
        System.out.println(" I am in After Suite");
    }

}
