package com.saucedemo.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtil {

    public static Logger log = LogManager.getLogger(LoggerUtil.class);
    
    public static void startTestCase(String sTestCaseName){

        log.info("****************************************************************************************");
        log.info("****************************************************************************************");
        log.info("$$$$$$$$$$$$$$$$$$$$$                 "+sTestCaseName+ "       $$$$$$$$$$$$$$$$$$$$$$$$$");
        log.info("****************************************************************************************");
        log.info("****************************************************************************************");
 
    }
 
     //This is to print log for the ending of the test case
    public static void endTestCase(String sTestCaseName){
        log.info("XXXXXXXXXXXXXXXXXXXXXXX             "+"-E---N---D-"+"             XXXXXXXXXXXXXXXXXXXXXX");
        log.info("X");
        log.info("X");
        log.info("X");
        log.info("X");
 
    }

    public static void info(String message) {
        log.info(message);
        }

    public static void warn(String message) {
        log.warn(message);
        }

    public static void error(String message) {
        log.error(message);
        }

    public static void fatal(String message) {
        log.fatal(message);
        }

    public static void debug(String message) {
        log.debug(message);
    }

}
