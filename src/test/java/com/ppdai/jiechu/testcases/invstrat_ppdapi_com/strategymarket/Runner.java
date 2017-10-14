package com.ppdai.jiechu.testcases.invstrat_ppdapi_com.strategymarket;

import org.testng.annotations.Test;
import com.ppdai.jiechu.utils.BaseTestCase;
import cucumber.api.CucumberOptions;

@CucumberOptions (
		features={"src/test/java/com/ppdai/jiechu/testcases/invstrat_ppdapi_com/strategymarket"},
		plugin = {"json:target/json-report/strategymarket.json"}
		)

@Test(groups="strategymarket")
public class Runner extends BaseTestCase {
	
	public void run() {
		this.runFeatures();
	}
	
}