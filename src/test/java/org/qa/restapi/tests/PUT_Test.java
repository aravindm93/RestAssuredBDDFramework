package org.qa.restapi.tests;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;

public class PUT_Test {
	
	Map<String,String> requestBody = new HashMap<String, String>();
	
	@Test
	public void put_call_test() {
		requestBody.put("name", "aravind");
		requestBody.put("job", "SDET");
		System.out.println(requestBody);
	    JSONObject request = new JSONObject(requestBody);
		System.out.println(request.toJSONString());
		
		given().log().all().body(request.toJSONString())
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.when().log().all().put("https://reqres.in/api/users/2")
		.then().log().all().assertThat()
		.statusCode(200);
		
		
		
	}
	

}
