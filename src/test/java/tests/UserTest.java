package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import endpoints.userEndpoints;
import io.restassured.response.Response;
import payloads.User;

public class UserTest {
	Faker faker;
	User userpayload;
	
	@BeforeClass
	public void setupData() {
		faker = new Faker();
		userpayload = new User();
		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setUsername(faker.name().username());
		userpayload.setFirstname(faker.name().firstName());
		userpayload.setLastname(faker.name().lastName());
		userpayload.setEmail(faker.internet().emailAddress());
		userpayload.setPassword(faker.internet().password());
		userpayload.setPhone(faker.phoneNumber().phoneNumber());
	}
	
	@Test (priority=1)
	public void createuser() {
		Response response= userEndpoints.createUser(userpayload);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
	}
	
	@Test (priority=2)
	public void updateuser() {
		Response response = userEndpoints.updateUser("myuser", userpayload);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
	}
	
	@Test (priority=3)
	public void getuser() {
		Response response = userEndpoints.readUser("myuser");
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
	}
	
	@Test (priority=4)
	public void deleteuser() {
		Response response = userEndpoints.deleteUser("myname", userpayload);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
	}
}