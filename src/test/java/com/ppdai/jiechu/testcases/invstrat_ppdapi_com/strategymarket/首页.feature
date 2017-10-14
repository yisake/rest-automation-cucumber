#language:zh-CN
@策略市场首页
功能:策略市场首页功能
	场景:POST /home/getBannerList
	    当 POST /home/getBannerList时，响应包含data、result和resultMessage字段

	场景:GET /home/getBannerList
	    当 GET /home/getBannerList时，响应包含data、result和resultMessage字段

	场景:POST /home/getSelectionStrategyList
		当 POST /home/getSelectionStrategyList时，应该包含data、result和resultMessage字段

	场景:POST /home/getStatisticsUser
		当 POST /home/getStatisticsUser时，应该包含data、result和resultMessage字段