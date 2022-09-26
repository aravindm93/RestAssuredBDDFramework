package org.qa.restapi.tests;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Test_POST {
	Map<String,String> requestBody = new HashMap<String, String>();
	
	@Test
	public void post_call_test() {
		requestBody.put("name", "aravind");
		requestBody.put("job", "QA");
		System.out.println(requestBody);
	    JSONObject request = new JSONObject(requestBody);
		System.out.println(request.toJSONString());
		
		given().log().all().body(request.toJSONString())
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.when().log().all().post("https://reqres.in/api/users")
		.then().log().all().assertThat()
		.statusCode(201);
		
		
		
	}
	

}
