package com.ppdai.jiechu.utils;

import java.io.File;
import java.io.IOException;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import com.ppdai.jiechu.utils.ThreadlogUtil.ThreadSeperateFileAppender;

/**
 * 根据线程记录log
 * @author 皇甫春峰
 *
 */
public class ThreadLog {
	
	public static Logger getLogger(String logname,String caseId) throws Exception{
        Logger logger = null;
        ThreadlogUtil tl=new ThreadlogUtil();
        if(LogManager.exists(caseId+".log")!=null) {
        	return LogManager.getLogger(caseId+".log");
            //LogManager.getLoggerRepository().getLogger(caseId+".log").shutdown();
        }
        logger = Logger.getLogger(caseId+".log");
        PatternLayout layout = new PatternLayout("%d{yyyy-MM-dd HH:mm:ss,SSS} [%p] [%t] %m %n");
        
        //判断文件是否存在，存在则删除
        File file = new File(logname);
        if (file.exists()) {
        	file.delete();
        }
                
        // 文件输出
        ThreadSeperateFileAppender R = null;
        try {
            R = tl.new ThreadSeperateFileAppender(layout, logname);
            R.setEncoding("UTF-8");
            R.activateOptions();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        /*// 参数配置, 因为没有找到仅靠配置文件的办法, 只好放在这里设
        R.setAppend(false);
        R.setImmediateFlush(false);
        R.setThreshold(Level.INFO);*/

        // 绑定到Logger
        logger.setLevel(Level.INFO);
        logger.addAppender(R);
        return logger;
    }
}