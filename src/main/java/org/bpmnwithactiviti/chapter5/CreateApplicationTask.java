package org.bpmnwithactiviti.chapter5;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateApplicationTask implements JavaDelegate {

    private static final Logger log = LoggerFactory.getLogger(CreateApplicationTask.class);

    @Override
    public void execute(DelegateExecution execution) {
        log.debug("execute with execution=" + execution);
        log.debug("execute with name=" + execution.getVariable("name"));
        log.debug("execute with creditcheckok1=" + execution.getVariable("creditCheckOk"));
        LoanApplication la = new LoanApplication();
        la.setCreditCheckOk((Boolean) execution.getVariable("creditCheckOk"));
        la.setCustomerName((String) execution.getVariable("name"));
        la.setIncome((Long) execution.getVariable("income"));
        la.setRequestedAmount((Long) execution.getVariable("loanAmount"));
        la.setEmailAddress((String) execution.getVariable("emailAddress"));
        execution.setVariable("loanApplication", la);
    }
}
