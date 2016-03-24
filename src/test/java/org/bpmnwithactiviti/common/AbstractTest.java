package org.bpmnwithactiviti.common;

import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Deprecated
public abstract class AbstractTest {
    private static final Logger log = LoggerFactory.getLogger(AbstractTest.class);

    @BeforeClass
    public static void routeLoggingToSlf4j() {
        log.info("No need for AbstractTest class anymore!");
    }

}
