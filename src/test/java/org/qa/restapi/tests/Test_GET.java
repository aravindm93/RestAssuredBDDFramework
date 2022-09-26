package org.qa.restapi.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;

public class Test_GET {
	
	@Test
	public void test_get_Call() {
		//RestAssured.baseURI = "https://jsonplaceholder.typicode.com/users";
		Response response = get("https://jsonplaceholder.typicode.com/users");
		System.out.println(response.asString());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getTime());
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}
	
	@Test
	public void test_02() {
	    given().get("https://jsonplaceholder.typicode.com/users").then().statusCode(200).body("id[0]", equalTo(2));
	}

}
