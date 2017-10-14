package com.ppdai.jiechu.utils;

import java.io.IOException;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Layout;

public class ThreadlogUtil {

	public class ThreadSeperateFileAppender extends FileAppender{
		
	    public ThreadSeperateFileAppender(){
	    	
	    }
	    
	    public  ThreadSeperateFileAppender(Layout layout, String logname) throws IOException
	    {
	        super(layout,logname);
	    }
	}
}