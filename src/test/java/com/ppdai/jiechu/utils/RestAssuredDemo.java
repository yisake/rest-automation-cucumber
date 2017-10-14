package com.ppdai.jiechu.utils;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

/**
 * 加载测试类，运行testng
 * @author 皇甫春峰
 *
 */
public class RestAssuredDemo {
	
	public static void main (String args [] ) throws Exception {
		restAssuredTest(1);
	}
	
	public static void restAssuredTest( int sw ) throws FileNotFoundException {
    	
    	switch (sw) {
	    	case 1:
	    		String test="{\r\n" + 
	    				"   \"data\" : {\r\n" + 
	    				"       \"user1\" : {\r\n" + 
	    				"            \"userId\" : \"my-id1\",\r\n" + 
	    				"            \"href\" : \"http://localhost:8080/my-id1\"\r\n" + 
	    				"       },\r\n" + 
	    				"       \"user2\" : {\r\n" + 
	    				"            \"userId\" : \"my-id2\",\r\n" + 
	    				"            \"href\" : \"http://localhost:8080/my-id2\"\r\n" + 
	    				"       },\r\n" + 
	    				"   }\r\n" + 
	    				"}";
		    	//Get请求参数，带入地址中
		    	given().
		    		proxy("localhost", 8888).
			        param("param1", "value1").
			        formParam("param2", "value2").
			        log().all().
			    when().
		        	post("http://127.0.0.1:5000/hello").then().log().all();
		    	break;
		    	
	    	case 2:
		    	//Post请求，带入form表单中
		    	given().
					proxy("localhost", 8888).
			        param("param1", "value1").
			        param("param2", "value2").
			     when().
		    		get("http://127.0.0.1:5000/user/hf");
		    	break;
		    	
	    	case 3:
	        	//Post请求,queryParam带入url中
	        	given().
	    			proxy("localhost", 8888).
	    			formParam("param1", "value1").
	    			queryParam("param2", "value2").
	            when().
	            	post("http://127.0.0.1:5000/user/hf");
	        	break;
	        	
	    	case 4:
	    		//多值参数,get请求为url参数,http://127.0.0.1:5000/hello?key=value1&key=value2，post请求为text
	        	given().
	    			proxy("localhost", 8888).
	    			param("key","value1","value2").
	    		when().
	            	post("http://127.0.0.1:5000/hello");
	        	break;
	        	
	    	case 5:
	    		//路径参数
	        	given().
	    			proxy("localhost", 8888).
	    		when().
	            	post("http://127.0.0.1:5000/user/{name}","huangfu");	
	        	/**
	        	given().
	    			proxy("localhost", 8888).
					pathParam("hotelId", "My Hotel").
        			pathParam("roomNumber", 23).	    			
	    		when().
	            	post("http://127.0.0.1:5000/user/{hotelId}/{roomNumber}","huangfu");		        	 
	        	 */
	    		break;
	    		
	    	case 6:
	    		//cookie
	    		Cookie cookie1 = new Cookie.Builder("username", "John").setComment("comment 1").build();
	    		Cookie cookie2 = new Cookie.Builder("token", "1234").setComment("comment 2").build();
	    		Cookies cookies = new Cookies(cookie1, cookie2);	    		
	        	given().
	    			proxy("localhost", 8888).
	    			cookies(cookies).
	    		when().
	            	post("http://127.0.0.1:5000/user/{name}","huangfu");		    		
	        	break;
	        	
	    	case 7:
	    		//header 添加到header中
	        	given().
	    			proxy("localhost", 8888).
	    			headers("MyHeader", "Something", "MyOtherHeader", "SomethingElse").
	    		when().
	            	get("http://127.0.0.1:5000/user/{name}","huangfu");		        	
	        	break;
	        	
	    	case 8:
	    		//content-type
	        	given().
	    			proxy("localhost", 8888).
	    			headers("MyHeader", "Something", "MyOtherHeader", "SomethingElse").
	    			contentType(ContentType.JSON).
	    		when().
	            	get("http://127.0.0.1:5000/user/{name}","huangfu");		        	
	        	break;
	        
	    	case 9:
	    		//请求内容
	        	given().
	    			proxy("localhost", 8888).
	    			headers("MyHeader", "Something", "MyOtherHeader", "SomethingElse").
	    			contentType(ContentType.JSON).
	    			body("some body").
	    		when().
	            	get("http://127.0.0.1:5000/user/{name}","huangfu");
	        	break;
	        
	    	case 10:
	    		//验证响应内容
	        	given().
	    			proxy("localhost", 8888).
	    			headers("MyHeader", "Something", "MyOtherHeader", "SomethingElse").
	    			contentType(ContentType.JSON).
	    			body("some body").
	    		when().
	            	get("http://127.0.0.1:5000/hello").then().
	            assertThat().cookie("cookies1","cookie1value").and().
	            assertThat().statusCode(200).and().
	            assertThat().header("header1", "value1").and().
	            assertThat().contentType(ContentType.JSON).
	        	assertThat().body(equalTo("something"));
	    		break;
	       
	    	case 11:
	    		given().
	    			proxy("127.0.0.1", 8888).
	    			log().all().
	    		when().
	    			post("http://127.0.0.1:5000/test2"). 
	    		then().
	    			assertThat().
	    			body(containsString("11")).
	    			body(matchesJsonSchema(new File("./test.json"))).
	    			//body("greeting.firstName", equalTo("John"), "greeting.lastName", equalTo("Doe")).
	    			log().all();
	    		break;
	    		
	    	default:
	        	PrintStream fileOutPutStream = new PrintStream(new File("test.txt"));
	        	Response response = given().proxy("localhost", 8888).
	        		config(RestAssured.config().logConfig(new LogConfig().defaultStream(fileOutPutStream))).
	        		param("x","y").
	        	expect().
	        		body("store.book[0].author", equalTo("Nigel Rees")).
	        		statusCode(200).
	        	when().
	        		post("http://127.0.0.1:5000/hello").
	        	then().
	    			body("store.book[0].author", equalTo("Nigel Rees")).
	    			statusCode(200).
	    		extract().
	    	        response();
	        	
	        	// 获取所有 headers 信息
	        	response.getHeaders();
	        	// 获取单个 header 信息
	        	response.getHeader("headerName");
	        	// 获取所有 cookie 键值对
	        	response.getCookies();
	        	// 获取单个 cookie 信息
	        	 response.getCookie("cookieName");
	        	// 获取状态行信息
	        	response.getStatusLine();
	        	// 获取状态码信息
	        	response.getStatusCode();
	        	break;
    	}
	}
	
	public void restAssureRes ( ) {
		//发送请求
    	System.out.println("##################before method");
    	Response res=post("http://127.0.0.1:5000/hello");
    	System.out.println("##################after method");
    	System.out.println(res.getStatusCode());
    	System.out.println(res.getHeaders().toString());
    	System.out.println(res.getStatusLine());
    	System.out.println(res.print());
    	System.out.println(res.getBody().print());
	}
}