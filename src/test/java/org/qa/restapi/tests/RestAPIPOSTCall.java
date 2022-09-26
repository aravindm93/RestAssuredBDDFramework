package org.qa.restapi.tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.http.*;
import org.apache.http.HttpStatus;

public class RestAPIPOSTCall {
	String jsonBody = "{\r\n" + 
			"	\"name\":\"Rohith\",\r\n" + 
			"	\"email\":\"Rohith.Nair@gmail.com\",\r\n" + 
			"	\"location\":\"India\"\r\n" + 
			"}";
	
	@Test
	public void addUserTest() {
		given().header("Authorization","Bearer 110fbee4-25f5-49db-a376-b41847b24c68").accept(ContentType.JSON)
		.contentType("application/json")
		.body(jsonBody)
		.when().post("http://restapi.adequateshop.com/api/users")
		.then()
		.assertThat()
		.statusCode(201)
		.statusLine("HTTP/1.1 201 Created")
		.body("name", equalTo("Rohith"))
		.body("email", equalTo("Rohith.nair@gmail.com"))
		.header("Content-Type", "application/json; charset=utf-8");
		
		
		
	}

}
