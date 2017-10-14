package com.ppdai.jiechu.testcases.invstrat_ppdapi_com.strategymarket;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import java.io.File;
import com.ppdai.jiechu.utils.BaseTestCase;
import cucumber.api.java.zh_cn.假如;
import cucumber.api.java.zh_cn.当;
import cucumber.api.java.zh_cn.那么;

public class StepDefinition extends BaseTestCase {
	//http://invstrat.ppdapi.com
	public static String url= "http://172.17.4.75:83";
	
	@当("^POST /financialplanner/getFinancialPlanner时，响应包含data、result$")
	public void post_financialplanner_getFinancialPlanner( ) {
		given().
			config(this.getRestAssuredLogConfig()).
			contentType(ContentType.JSON).
			log().all().
		when().
			post(url+"/financialplanner/getFinancialPlanner").
		then().
			log().all().
			assertThat().statusCode(200).
			assertThat().body("result", equalTo(-1)). 
			assertThat().body("resultMessage", equalTo("非法请求"));
	}
	
	@当("^POST /strategyList/getStrategyList时，响应包含data、result$")
	public void post_strategyList_getStrategyList( ) {
		given().
			config(this.getRestAssuredLogConfig()).
			contentType(ContentType.JSON).
			log().all().
		when().
			post(url+"/strategyList/getStrategyList").
		then().
			log().all().
			assertThat().statusCode(200).
			assertThat().body("result", equalTo(-1)).
			assertThat().body("resultMessage", equalTo("非法请求"));
	}
	
	@当("^POST /user/getUserLoginInf时，响应包含data、result$")
	public void post_user_getUserLoginInf( ) {
		given().
			config(this.getRestAssuredLogConfig()).
			contentType(ContentType.JSON).
			log().all().
		when().
			post(url+"/user/getUserLoginInf").
		then().
			log().all().
			assertThat().statusCode(200).
			assertThat().body("result", equalTo(-2));
	}
	
	@当("^POST /user/getUserMessageCount,响应包含data、result$")
	public void post_user_getUserMessageCount( ) {
		given().
			config(this.getRestAssuredLogConfig()).
			contentType(ContentType.JSON).
			log().all().
		when().
			post(url+"/user/getUserMessageCount").
		then().
			log().all().
			assertThat().statusCode(200).
			assertThat().body("result", equalTo(-1));
	}
	
	@当("^POST /home/getBannerList时，响应包含data、result和resultMessage字段$")
	public void post_home_getbannerlist( ) {
		given().
			config(this.getRestAssuredLogConfig()).
			contentType(ContentType.JSON).
			log().all().
		when().
			post(url+"/home/getBannerList").
		then().
			log().all().
			assertThat().statusCode(200).
			assertThat().body(matchesJsonSchema(new File(this.schemaDir+"common_response.json")));
	}

	@当("^GET /home/getBannerList时，响应包含data、result和resultMessage字段$")
	public void test( ) {
		given().
		config(this.getRestAssuredLogConfig()).
		log().all().
	when().
		get(url+"/home/getBannerList").
	then().log().all().and().
		assertThat().statusCode(200).
		assertThat().body(matchesJsonSchema(new File(this.schemaDir+"common_response.json")));
	}
	
	@当("^POST /home/getSelectionStrategyList时，应该包含data、result和resultMessage字段$")
	public void post_home_getseclection_strategylist( ) {
		given().
		config(this.getRestAssuredLogConfig()).
		log().all().
	when().
		post(url+"/home/getSelectionStrategyList").
	then().log().all().and().
		assertThat().statusCode(200).
		assertThat().body(matchesJsonSchema(new File(this.schemaDir+"common_response.json")));
	}

	@当("^POST /home/getStatisticsUser时，应该包含data、result和resultMessage字段$")
	public void post_home_getStatisticsUser()  {
		given().
		config(this.getRestAssuredLogConfig()).
		log().all().
	when().
		post(url+"/home/getStatisticsUser").
	then().log().all().and().
		assertThat().statusCode(200).
		assertThat().body(matchesJsonSchema(new File(this.schemaDir+"common_response.json")));
	}
}