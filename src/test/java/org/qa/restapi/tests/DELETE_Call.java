package org.qa.restapi.tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class DELETE_Call {
	
	@Test
	public void delete_Test() {
		given().log().all().when().delete("https://jsonplaceholder.typicode.com/posts/1")
		.then().log().all().statusCode(200);
	}
	

}
