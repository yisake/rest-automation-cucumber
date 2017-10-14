package com.ppdai.jiechu.testcases.invstrat_ppdapi_com.strategymarket;

import com.ppdai.jiechu.utils.BaseDao;
import static com.ppdai.jiechu.utils.BaseDao.*;
import java.sql.SQLException;

public class DbUtil {
	
	@SuppressWarnings("rawtypes")
	private static BaseDao sqlServer1=new BaseDao(sqlServerClassName,sqlServer1Url,sqlServer1User,sqlServer1Pwd);
	@SuppressWarnings("rawtypes")
	private static BaseDao sqlServer2=new BaseDao(sqlServerClassName,sqlServer2Url,sqlServer2User,sqlServer2Pwd);
	@SuppressWarnings("rawtypes")
	private static BaseDao mysql1=new BaseDao(sqlServerClassName,mysql1Url,mysql1User,mysql1Pwd);
	@SuppressWarnings("rawtypes")
	private static BaseDao mysql2=new BaseDao(sqlServerClassName,mysql2Url,mysql2User,mysql2Pwd);
	
	//升级策略
	public static int updateCate () throws SQLException {
		return DbUtil.sqlServer1.update("");
	}
	
	
}
