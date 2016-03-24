package org.bpmnwithactiviti.chapter4.spring;

import org.activiti.engine.delegate.DelegateExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderService {
    private static Logger log = LoggerFactory.getLogger(OrderService.class);
    
    public void validate(DelegateExecution execution) {
        log.debug("validating order for isbn " + execution.getVariable("isbn"));
    }

}
