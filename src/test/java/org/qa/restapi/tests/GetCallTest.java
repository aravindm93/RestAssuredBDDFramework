package org.qa.restapi.tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetCallTest {
	
	@Test
	public void test_data() {
		given().
		when().
		    get("https://reqres.in/api/user").
		then().
		assertThat().
		statusCode(200).
		and().
		header("Content-Type", equalTo("application/json; charset=utf-8"))
		.and()
		.body("data.id[0]", equalTo(1));

	}
}
