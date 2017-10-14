package com.ppdai.jiechu.lib;

import com.ppdai.jiechu.utils.PropUtil;

public class CustomerConfigReader {
	public static PropUtil confPropUtil = new PropUtil("config/server.properties");
	public static String agent_rest_api_addr = confPropUtil.get("agent_rest_api_addr");
	public static String rest_api_addr= confPropUtil.get("rest_api_addr");
	public static String buyer_mobile= confPropUtil.get("buyer_mobile");	
	public static String buyer_password=confPropUtil.get("buyer_password");
	public static String seller_mobile=confPropUtil.get("seller_mobile");
	public static String seller_password=confPropUtil.get("seller_password");
	public static String device_type=confPropUtil.get("device_type");
	public static String device_name=confPropUtil.get("device_name");
	public static String app_version=confPropUtil.get("app_version");
	public static String city_id=confPropUtil.get("city_id");
	public static String env=confPropUtil.get("env");

}