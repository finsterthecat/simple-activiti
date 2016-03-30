package org.bpmnwithactiviti.chapter5;

import java.util.Date;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateEcorrespondenceCandidate implements JavaDelegate {

    private static final Logger log = LoggerFactory.getLogger(CreateEcorrespondenceCandidate.class);

    @Override
    public void execute(DelegateExecution execution) {
    	log.debug("CreateEcorrespondenceCandidate Start");
        EcorrespondenceCandidate ecc = new EcorrespondenceCandidate();
        ecc.setSubject(execution.getVariable("subject", String.class));
        ecc.setFromName(execution.getVariable("fromName", String.class));
        ecc.setEmailAddress(execution.getVariable("emailAddress", String.class));
        ecc.setReceivedDate(execution.getVariable("receivedDate", Date.class));
        ecc.setOfficial(true);
        ecc.setRecipient("head");
        execution.setVariable("eCorrespondenceCandidate", ecc);
    }
}
