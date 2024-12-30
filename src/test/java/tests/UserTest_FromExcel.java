package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import endpoints.userEndpoints;
import io.restassured.response.Response;
import payloads.User;
import utilities.DataProviders;

public class UserTest_FromExcel {

	@Test (priority=2,dataProvider="Data",dataProviderClass=DataProviders.class)
	public void createuser(String userID, String userName, String fname, String lname, String useremail, String password, String phone) {
		User userpayload=new User();
		userpayload.setId(Integer.parseInt(userID));
		userpayload.setUsername(userName);
		userpayload.setFirstname(fname);
		userpayload.setLastname(lname);
		userpayload.setEmail(useremail);
		userpayload.setPassword(password);
		userpayload.setPhone(phone);
		
		Response response= userEndpoints.createUser(userpayload);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
	}

	@Test
	(priority=2,dataProvider="UserNames",dataProviderClass=DataProviders.class)
	public void deleteuser(String userName) { 
		Response response = userEndpoints.deleteUser(userName);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
	}	 
}