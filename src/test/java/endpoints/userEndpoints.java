package endpoints;
import payloads.User;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class userEndpoints {

	public static Response createUser(User payload){
		Response response = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(routes.create_user);
		return response;
	}	
	public static Response readUser(String userName) {
		
		Response response = given()
							.pathParam("username", userName)
							.when()
							.get(routes.get_user);
		return response;
	}	
	public static Response updateUser(String userName,User payload){
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", userName)
				.body(payload)
				.when()
				.put(routes.update_user);
		return response;		
	}	
	public static Response deleteUser(String userName,User payload) {
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", userName)
				.body(payload)
				.when()
				.delete(routes.delete_user);
		return response;
	}	
}