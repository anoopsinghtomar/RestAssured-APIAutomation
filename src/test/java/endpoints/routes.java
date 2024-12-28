package endpoints;

public class routes {
	//Swagger URI - https://petstore.swagger.io/
	public static String base_url = "https://petstore.swagger.io/v2";
	//user module
	public static String get_user = base_url + "/user/{username}";
	public static String get_userlogin = base_url + "/user/login";
	public static String get_userLogout = base_url + "/user/logout";
	public static String create_user = base_url + "/user";
	public static String create_userArray = base_url + "/user/createWithArray";
	public static String create_userList = base_url + "/user/createWithList";
	public static String update_user = base_url + "/user/{username}";
	public static String delete_user = base_url + "/user/{username}";	
}	