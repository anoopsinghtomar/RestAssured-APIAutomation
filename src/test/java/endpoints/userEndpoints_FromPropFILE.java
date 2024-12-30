package endpoints;
import payloads.User;
import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class userEndpoints_FromPropFILE {
	
	static ResourceBundle getURL() { //method to access config.propertiles FILE
		ResourceBundle routes = ResourceBundle.getBundle("config");
		return routes;
	}

	public static Response createUser(User payload){
		
		String create_user = getURL().getString("create_user");
		
		Response response = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(create_user);
		return response;
	}	
	public static Response readUser(String userName) {
		
		String get_user = getURL().getString("get_user");
		
		Response response = given()
							.pathParam("username", userName)
							.when()
							.get(get_user);
		return response;
	}	
	public static Response updateUser(String userName,User payload){
		
		String update_user = getURL().getString("update_user");
		
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", userName)
				.body(payload)
				.when()
				.put(update_user);
		return response;		
	}	
	public static Response deleteUser(String userName,User payload) {
		
		String delete_user = getURL().getString("delete_user");
		
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", userName)
				.body(payload)
				.when()
				.delete(delete_user);
		return response;
	}	
	public static Response deleteUser(String userName) {
		
		String delete_user = getURL().getString("delete_user");
		
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", userName)
			.when()
				.delete(delete_user);
		return response;
	}
}