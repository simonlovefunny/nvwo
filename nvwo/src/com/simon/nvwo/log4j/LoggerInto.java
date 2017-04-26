package com.simon.nvwo.log4j;

import org.apache.log4j.Level;

import com.sun.istack.internal.logging.Logger;

//log4j的主要方法
public interface LoggerInto {
	

    // Creation & retrieval methods:
   // public static Logger getRootLogger();
   // public static Logger getLogger(String name);

    // printing methods:
    public void trace(Object message);
    public void debug(Object message);
    public void info(Object message);
    public void warn(Object message);
    public void error(Object message);
    public void fatal(Object message);

    // generic printing method:
    public void log(Level l, Object message);

}
