package org.qa.restapi.tests;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class RestAPICallTest {
	
	@Test
	public void getUsersTest() {
		given().
		header("Authorization","Bearer 110fbee4-25f5-49db-a376-b41847b24c68")
		.when()
		.get("http://restapi.adequateshop.com/api/users?page=1")
		.then().statusCode(200)
		.and()
		.assertThat()
		.body("totalrecord", equalTo(7995))
		.and()
		.body("data.name[0]",equalTo("Rulo")).log();
	}

}
