  package Test_Demo;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class Put_Patch_Delete_Method {
	
	@Test
	
	public void put_Method() {
		
		JSONObject putbody = new JSONObject();
		putbody.put("name","Kiran");
		putbody.put("job","Testing");
		
		System.out.println(putbody.toJSONString());
		
		baseURI="https://reqres.in/api";
		
		given()
		.header("Content-Type","application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.when()
		.put("/users/2")
		.then()
		.statusCode(200).log().all();
		
		}

	@Test
	public void patch_Method() {
		
		JSONObject patchmethod=new JSONObject();
		
		patchmethod.put("name", "kiran");
		patchmethod.put("job", "Testing");
		
		System.out.println(patchmethod.toJSONString());
		
		baseURI= "https://reqres.in/api";
		
		given()
		.header("Content-Type","application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.when()
		.patch("/users/2")
		.then()
		.statusCode(200).log().all();
		
	}
	
	
	@Test
	public void delete_Method() {
		
		baseURI="https://reqres.in/api";
		
		when()
		.delete("/users/2")
		.then()
		.statusCode(204).log().all();
	}
	
}
