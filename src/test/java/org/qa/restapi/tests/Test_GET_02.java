package org.qa.restapi.tests;

import org.testng.annotations.Test;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class Test_GET_02 {
	
	@Test
	public void get_call_test() {
		 given()
		 .param("page", 2)
		 .get("https://reqres.in/api/users")
		.then().assertThat().statusCode(200)
		.log().all()
		.body("data[0].first_name", equalTo("Michael"))
		.body("data.first_name",hasItems("Michael","Lindsay","Rachel"));
	}

}
  