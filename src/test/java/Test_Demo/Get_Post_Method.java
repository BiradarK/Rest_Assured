package Test_Demo;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.util.JSONPObject;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class Get_Post_Method {
	
	@Test
	
	public void get_Method() {
		
		baseURI="https://reqres.in/api";
		given()
		.when().get("/users?page=2")
		.then()
		.statusCode(200)
		.body("data[4].first_name", equalTo("George"))
		.body("data.first_name",hasItems("George","Rachel"))
		.log().all();
		

		
	}
	@Test
	public void post_Method() {
		
		// Post Method Using map
//		Map<String,Object> map=new HashMap<String,Object>();
//		map.put("name","Kiran");
//		map.put("job","Testing");
//		map.put("city","Pune");
//		
//		System.out.println(map);
//		
		
	// Post method using JSON	
		
		JSONObject request = new JSONObject();
		request.put("name","Kiran");
		request.put("job","Testing");
		
		System.out.println(request.toJSONString());

		
		baseURI="https://reqres.in/api";
		 given()
		 .header("content-Type","application/json")
		 .contentType(ContentType.JSON)
		 .accept(ContentType.JSON)
         .body(request.toJSONString())
         .when()
         .post("/users")
         .then()
         .statusCode(201);
		
		
		
		
		
		
	}
	
}
