package com.macro.mall.tiny;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TODO
 *
 * @author TANPENG
 * @version 1.0
 * @date 2021/1/19 16:08
 */

public class Test {

    private static Logger logger = LoggerFactory.getLogger(Test.class.getClass());

    @org.junit.Test
    public void testLog(){
        logger.debug("debug");
        logger.error("error");
    }
}
