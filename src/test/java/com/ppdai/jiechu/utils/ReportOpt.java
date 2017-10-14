package com.ppdai.jiechu.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

/**
 * 生成cucumber-report的html报告
 * @author 皇甫春峰
 *
 */
public class ReportOpt {
	
	/**
	 * 
	 * @param path
	 * @return 
	 */
	public static List<String> getFileList (String strPath) {
		List<String> filelist = new ArrayList<String>();
        File dir = new File(strPath);
        File[] files = dir.listFiles(); // 该文件目录下文件全部放入数组
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                String fileName = files[i].getName();
                if (files[i].isDirectory()) { // 判断是文件还是文件夹
                    getFileList(files[i].getAbsolutePath()); // 获取文件绝对路径
                } else if (fileName.endsWith("json")) { // 判断文件名是否以.json结尾
                    String strFileName = files[i].getAbsolutePath();
                    System.out.println("---" + strFileName);
                    filelist.add(strFileName);
                } else {
                    continue;
                }
            }
        }
        return filelist;
    }
	
	public static void create (String userDir) {
		File reportOutputDirectory = new File(userDir+"cucumber-html-report");
		List<String> jsonFiles = new ArrayList<>();
		jsonFiles= getFileList(userDir+"json-report");
		//jsonFiles.add("cucumber-report-1.json");
		//jsonFiles.add("cucumber-report-2.json");

		String buildNumber = "1";
		String projectName = "cucumberProject";
		boolean runWithJenkins = false;
		boolean parallelTesting = false;

		Configuration configuration = new Configuration(reportOutputDirectory, projectName);
		// optional configuration
		configuration.setParallelTesting(parallelTesting);
		configuration.setRunWithJenkins(runWithJenkins);
		configuration.setBuildNumber(buildNumber);
		// addidtional metadata presented on main page
		configuration.addClassifications("Platform", "Windows");
		configuration.addClassifications("Browser", "Firefox");
		configuration.addClassifications("Branch", "release/1.0");

		ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
		reportBuilder.generateReports();
		//Reportable result = reportBuilder.generateReports();
	}	
}