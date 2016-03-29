package org.bpmnwithactiviti.chapter5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.history.HistoricDetail;
import org.activiti.engine.history.HistoricVariableUpdate;
import org.activiti.engine.test.ActivitiRule;
import org.activiti.engine.test.Deployment;
import org.junit.Rule;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoanRequestTest {

  @Rule
  public ActivitiRule activitiRule = new ActivitiRule("activiti.cfg-mem-fullhistory.xml");

  private static final Logger log = LoggerFactory.getLogger(LoanRequestTest.class);

  @Test
  @Deployment(resources = {"chapter5/loanrequest_firstpart.bpmn20.xml"})
  public void creditCheckTrue() {
    Map<String, Object> processVariables = new HashMap<>();
    processVariables.put("name", "Miss Piggy");
    processVariables.put("income", 100L);
    processVariables.put("loanAmount", 10L);
    processVariables.put("emailAddress", "miss.piggy@localhost");
    log.debug("INCOME!! " + processVariables.get("income"));
    activitiRule.getRuntimeService().startProcessInstanceByKey(
            "loanrequest", processVariables);

    log.debug("INCOME!! " + processVariables.get("income"));

    List<HistoricDetail> historyVariables = activitiRule.getHistoryService()
            .createHistoricDetailQuery()
            .variableUpdates()
            .orderByVariableName()
            .asc()
            .list();

    historyVariables.stream().map((hd) -> (HistoricVariableUpdate) hd).forEach((hvu) -> {
      log.debug("history! " + hvu.getVariableName() + " = " + hvu.getValue());
    });
    assertNotNull(historyVariables);
    assertEquals(7, historyVariables.size());
    HistoricVariableUpdate loanAppUpdate = ((HistoricVariableUpdate) historyVariables.get(5));
    assertEquals("loanApplication", loanAppUpdate.getVariableName());
    LoanApplication la = (LoanApplication) loanAppUpdate.getValue();
    assertEquals(true, la.isCreditCheckOk());
  }

  @Test
  @Deployment(resources = {"chapter5/loanrequest_firstpart.bpmn20.xml"})
  public void mySanity() {
    Map<String, Object> processVariables = new HashMap<>();
    processVariables.put("waah", 1001);
    log.debug("I'm insane!! " + processVariables.get("waah"));

    int num = 2001;
    processVariables.put("num", num);
    assertEquals(num, processVariables.get("num"));
    log.debug("Am I? " + processVariables.get("num"));
  }
}
