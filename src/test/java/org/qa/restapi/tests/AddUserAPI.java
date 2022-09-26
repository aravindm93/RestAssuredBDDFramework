package org.qa.restapi.tests;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.json.JSONObject;

public class AddUserAPI {
	
	
	@Test
	public void addUserTest() {
		JSONObject json = new JSONObject();
		
		json.put("name", "Ajay");
		json.put("email", "ajay187f@gmail.com");
		json.put("location", "India");
		 
		String resp = given().log().all().header("Authorization","Bearer 110fbee4-25f5-49db-a376-b41847b24c68")
		.accept(ContentType.JSON).contentType("application/json")
		.body(json.toString())
		.when().log().all().post("http://restapi.adequateshop.com/api/users")
		.then().assertThat()
		.statusCode(201)
		.and()
		.statusLine("HTTP/1.1 201 Created")
		.body("name", equalTo("Ajay"))
		.body("email", equalTo("ajay187f@gmail.com"))
		.header("Content-Type", "application/json; charset=utf-8").toString();
		
		System.out.println(resp);
		
	}

}
