package api;

import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion.Static;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ChamadaApi {
	
	public static String idDog = null;
	public static String idCat = null;
	public static String idPlatypus = null;
	Response response;
	
	public void apiCadastroUser() {
		
		RestAssured.baseURI = "https://petstore.swagger.io/v2/user/createWithList";
		Response response = RestAssured.given().relaxedHTTPSValidation().log().all()
				.header("Content-Type","application/json")
				.header("Accept","application/json")
				.body("[\r\n" + 
						"  {\r\n" + 
						"    \"id\": 0,\r\n" + 
						"    \"username\": \"Ana Maia\",\r\n" + 
						"    \"firstName\": \"string\",\r\n" + 
						"    \"lastName\": \"string\",\r\n" + 
						"    \"email\": \"string\",\r\n" + 
						"    \"password\": \"string\",\r\n" + 
						"    \"phone\": \"string\",\r\n" + 
						"    \"userStatus\": 0\r\n" + 
						"  },\r\n" + 
						"{\r\n" + 
						"    \"id\": 0,\r\n" + 
						"    \"username\": \"Rodrigo Mendes\",\r\n" + 
						"    \"firstName\": \"string\",\r\n" + 
						"    \"lastName\": \"string\",\r\n" + 
						"    \"email\": \"string\",\r\n" + 
						"    \"password\": \"string\",\r\n" + 
						"    \"phone\": \"string\",\r\n" + 
						"    \"userStatus\": 0\r\n" + 
						"  },\r\n" + 
						"{\r\n" + 
						"    \"id\": 0,\r\n" + 
						"    \"username\": \"Tatiana Vasconcelos\",\r\n" + 
						"    \"firstName\": \"string\",\r\n" + 
						"    \"lastName\": \"string\",\r\n" + 
						"    \"email\": \"string\",\r\n" + 
						"    \"password\": \"string\",\r\n" + 
						"    \"phone\": \"string\",\r\n" + 
						"    \"userStatus\": 0\r\n" + 
						"  }\r\n" + 
						"]")
				.post();
		response.then().log().all().statusCode(200);
		response.then().log().all();			
		}
	
	public void apiCadastroPets(String category, String name) {
		
		RestAssured.baseURI = "https://petstore.swagger.io/v2/pet";
		Response response = RestAssured.given().relaxedHTTPSValidation().log().all()
				.header("Content-Type","application/json")
				.header("Accept","application/json")
				.body("{\r\n" + 
						"  \"id\": 0,\r\n" + 
						"  \"category\": {\r\n" + 
						"    \"id\": 0,\r\n" + 
						"    \"name\": \""+category+"\"\r\n" + 
						"  },\r\n" + 
						"  \"name\": \""+name+"\",\r\n" + 
						"  \"photoUrls\": [\r\n" + 
						"    \"string\"\r\n" + 
						"  ],\r\n" + 
						"  \"tags\": [\r\n" + 
						"    {\r\n" + 
						"      \"id\": 0,\r\n" + 
						"      \"name\": \"string\"\r\n" + 
						"    }\r\n" + 
						"  ],\r\n" + 
						"  \"status\": \"available\"\r\n" + 
						"}")
				.post();
		
		response.then().log().all().statusCode(200);
		
		switch (category) {
		case "dog":
			idDog = response.then().extract().path("id").toString();
			break;
		
		case "cat":
			idCat = response.then().extract().path("id").toString();
			break;
		
		case "platypus":
			idPlatypus = response.then().extract().path("id").toString();
			break;

		default:
			break;
		}
					
		}
	
	public void apiCompraPet(String category) {

		RestAssured.baseURI = "https://petstore.swagger.io/v2/store/order";
		RequestSpecification response = RestAssured.given().relaxedHTTPSValidation().log().all()
				.header("Content-Type", "application/json").header("Accept", "application/json");

		switch (category) {
		case "dog":
			response.body("{\r\n" + 
					"  \"id\": 0,\r\n" + 						
					"  \"petId\":"+idDog+",\r\n" + 
					"  \"quantity\": 1,\r\n" + 
//					"  \"shipDate\": \"2020-07-11T14:51:25.018Z\",\r\n" + 
					"  \"status\": \"placed\",\r\n" + 
					"  \"complete\": true\r\n" + 
					"}")
			.post();
			break;

		case "cat":
			response.body("{\r\n" + 
					"  \"id\": 0,\r\n" + 						
					"  \"petId\":"+idCat+",\r\n" + 
					"  \"quantity\": 1,\r\n" + 
//					"  \"shipDate\": \"2020-07-11T14:51:25.018Z\",\r\n" + 
					"  \"status\": \"placed\",\r\n" + 
					"  \"complete\": true\r\n" + 
					"}")
			.post();
			break;
			
		case "platypus":		
			response.body("{\r\n" + 
					"  \"id\": 0,\r\n" + 						
					"  \"petId\":"+idPlatypus+",\r\n" + 
					"  \"quantity\": 1,\r\n" + 
//					"  \"shipDate\": \"2020-07-11T14:51:25.018Z\",\r\n" + 
					"  \"status\": \"placed\",\r\n" + 
					"  \"complete\": true\r\n" + 
					"}")
			.post();
			break;

		default:
			break;
		}			
		response.then().log().all().statusCode(200);			
		}

	public void apiAtualizarStatus(String category) {

		String url = "https://petstore.swagger.io/v2/pet";
		RequestSpecification spec = RestAssured.given().relaxedHTTPSValidation().log().all()
				.header("Content-Type", "application/json").header("Accept", "application/json");

		switch (category) {
		case "dog":
			spec.body("{\r\n" + 
					"  \"id\":"+idDog+",\r\n" + 
					"  \"category\": {\r\n" + 
					"    \"id\": 0,\r\n" + 
					"    \"name\": \"string\"\r\n" + 
					"  },\r\n" + 
					"  \"name\": \"doggie\",\r\n" + 
					"  \"photoUrls\": [\r\n" + 
					"    \"string\"\r\n" + 
					"  ],\r\n" + 
					"  \"tags\": [\r\n" + 
					"    {\r\n" + 
					"      \"id\": 0,\r\n" + 
					"      \"name\": \"string\"\r\n" + 
					"    }\r\n" + 
					"  ],\r\n" + 
					"  \"status\": \"approved\"\r\n" + 
					"}")
			.put(url);
			break;

		case "cat":
			spec.body("{\r\n" + 
					"  \"id\":"+idCat+",\r\n" + 
					"  \"category\": {\r\n" + 
					"    \"id\": 0,\r\n" + 
					"    \"name\": \"string\"\r\n" + 
					"  },\r\n" + 
					"  \"name\": \"doggie\",\r\n" + 
					"  \"photoUrls\": [\r\n" + 
					"    \"string\"\r\n" + 
					"  ],\r\n" + 
					"  \"tags\": [\r\n" + 
					"    {\r\n" + 
					"      \"id\": 0,\r\n" + 
					"      \"name\": \"string\"\r\n" + 
					"    }\r\n" + 
					"  ],\r\n" + 
					"  \"status\": \"delivered\"\r\n" + 
					"}")
			.put(url);
			break;
			
		case "platypus":		
			spec.body("{\r\n" + 
					"  \"id\":"+idPlatypus+",\r\n" + 
					"  \"category\": {\r\n" + 
					"    \"id\": 0,\r\n" + 
					"    \"name\": \"string\"\r\n" + 
					"  },\r\n" + 
					"  \"name\": \"doggie\",\r\n" + 
					"  \"photoUrls\": [\r\n" + 
					"    \"string\"\r\n" + 
					"  ],\r\n" + 
					"  \"tags\": [\r\n" + 
					"    {\r\n" + 
					"      \"id\": 0,\r\n" + 
					"      \"name\": \"string\"\r\n" + 
					"    }\r\n" + 
					"  ],\r\n" + 
					"  \"status\": \"approved\"\r\n" + 
					"}")
			.put(url);
			break;

		default:
			break;
		}			
		spec.then().log().all().statusCode(200);			
		}
	
	public void apiBuscaPet(String category) {
		
		String url = "https://petstore.swagger.io/v2/pet/{id}";
		RequestSpecification spec = RestAssured.given()
				.relaxedHTTPSValidation()
				.header("Content-Type","application/json")
				.header("Accept","application/json");
		
		switch (category) {
		case "dog":
			spec
			.pathParam("id",idDog);
			  response = spec
					.when()
			        .get(url);
			break;

		case "cat":
			response = spec
			.pathParam("id",idCat)
			.get(url);
			break;
			
		case "platypus":		
			response = spec
			.pathParam("id",idPlatypus)
			.get(url);
			break;

		default:
			break;
		}
		
		System.out.println("##########################");
		response.then().log().all().statusCode(200);
		System.out.println(response.statusCode());	
		System.out.println(response.then().extract().path("status"));
		System.out.println("##########################");
			
		}

}
