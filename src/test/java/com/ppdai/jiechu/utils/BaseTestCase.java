package com.ppdai.jiechu.utils;

import java.lang.reflect.Method;
import java.util.Hashtable;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.TestNGCucumberRunner;
import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;

/**
 * @author 皇甫春峰
 */
public class BaseTestCase {
	public Logger logger;
	public static Hashtable<String,String> loggerTable =new Hashtable<String, String>() ;
	public String seprator = System.getProperty("file.separator");
	public String userDir =  System.getProperty("user.dir")+seprator+"target"+seprator;
	public String logDir =  userDir+"testing-logs"+seprator;
	public String schemaDir=userDir+"test-classes"+seprator+"com"+seprator+"ppdai"+seprator+"jiechu"+seprator+"schemas"+seprator;
    protected TestNGCucumberRunner testNGCucumberRunner;
    protected boolean testNGCucumberFeatureFlag = false; //true执行finish,flase不执行
    public Object[][] scenarios;    
    
	@BeforeSuite(alwaysRun = true)
	public void beforeSuite ( ) {
		FileOpt.createPath(logDir);
	}

	@AfterSuite(alwaysRun = true)
	public void afterSuite ( ) {
		System.out.println("\n-------------------------------------------------------After suite");
		ReportOpt.create(userDir);
	}
    
    @BeforeClass(alwaysRun = true)
    public void beforeClass() throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    	this.scenarios = testNGCucumberRunner.provideScenarios();
    	this.getScenrioes();
    	//Debug proxy 
    	//RestAssured.proxy("127.0.0.1", 8888);
    }
	
    @AfterClass(alwaysRun = true)
    public void afterClass() throws Exception {
    	System.out.println("##After Class");
    }
    
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod (Method method) throws Exception {
		this.getLogger(method);
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterMethod ( ) {
		System.out.println("##After method");
		this.finishCucumber();
		/*
		for (Entry<String, String> entry : BaseTestCase.loggerMap.entrySet()) {			  
		    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());  		  
		}
		for(Map.Entry<String, String> entry: BaseTestCase.loggerTable.entrySet()){
			System.out.println("key---------"+entry.getKey()+"value--------"+entry.getValue());
		}*/
	}
	
	public void runFeatures ( ) {
		this.testNGCucumberFeatureFlag=false;
		this.testNGCucumberRunner.runCukes();
	}
	
	public void finishCucumber() {
		System.out.println(this.testNGCucumberFeatureFlag);
        if (this.testNGCucumberFeatureFlag) {
        	this.testNGCucumberRunner.finish();
        }
	}
	
	//根据线程生成log文件
	public void getLogger ( Method method ) throws Exception {
		String packageName=this.getClass().getPackage().getName();
		String fullName = packageName+"."+this.getClass().getSimpleName()+"_"+method.getName();
		this.logger=(Logger) ThreadLog.getLogger(logDir+fullName+".txt", fullName);	
		this.logger.info("####Start to test: "+fullName);
		BaseTestCase.loggerTable.put(this.getCurrenThreadName(), fullName+".log");
	}

	//Rest assured的log重定向到log文件
	public RestAssuredConfig getRestAssuredLogConfig ( ) {
		//PrintStream fileOutPutStream = new PrintStream(new File(logDir+fullName+".txt"));
		//RestAssured.config=RestAssured.config().logConfig(new LogConfig().defaultStream(fileOutPutStream));
		//System.out.println(RestAssured.config.getLogConfig().isUserConfigured());
		return RestAssured.config().logConfig(new LogConfig().defaultStream(new ToLoggerPrintStream(Logger.getLogger(loggerTable.get(Thread.currentThread().getName()))).getPrintStream()));
	}
		
	public void getScenrioes ( ) {
    	System.out.println("##################"+this.scenarios.length);
    	for(int i=0;i<this.scenarios.length;i++){              
            for(int j=0;j<this.scenarios[i].length;j++){                        
                System.out.print("i:"+i+" j:"+j);
                System.out.print(this.scenarios[i][j].toString());
            }
            System.out.println();
        }		
	}
	
	public String getCurrenThreadName ( ) {
		return Thread.currentThread().getName();
	}
}