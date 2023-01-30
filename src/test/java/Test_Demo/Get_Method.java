package Test_Demo;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Get_Method {
	
//	baseurl="https://reqres.in/";
	
	
	@Test
	public void get_Method() {
		
		given()
		.when().get("https://reqres.in/")
		.then()
		.statusCode(200);
//		.body("data[4].first_name", equalTo("George"))
//		.body("data.first_name",hasItems("George","Rachel"));
	}
	
	@Test
	public void get_Body() {
		
		baseURI="https://reqres.in/api";
		given()
		.get("/users?page=2")
		.then()
		.statusCode(200)
		.body("data[1].id",equalTo(8))
		.log().all();
		
	}

}
