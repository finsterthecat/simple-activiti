package org.activiti.designer.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.io.FileInputStream;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.test.ActivitiRule;
import org.junit.Rule;
import org.junit.Test;

public class ProcessTestEcorrespondenceTriage {

	private String filename = "C:\\Users\\BrouwerTo\\Documents\\NetBeansProjects\\SimpleActiviti\\src\\main\\resources\\chapter5\\correspondencetriage2.bpmn";

	@Rule
	public ActivitiRule activitiRule = new ActivitiRule("activiti.cfg-test3.xml");
	//public ActivitiRule activitiRule = new ActivitiRule();

	@Test
	public void startProcess() throws Exception {
		RepositoryService repositoryService = activitiRule.getRepositoryService();
		repositoryService.createDeployment().addInputStream("ecorrespondenceTriage.bpmn20.xml",
				new FileInputStream(filename)).deploy();
		RuntimeService runtimeService = activitiRule.getRuntimeService();
		Map<String, Object> variableMap = new HashMap<String, Object>();
		variableMap.put("subject", "Activiti");
		variableMap.put("fromName", "Activiti");
		variableMap.put("emailAddress", "Activiti");
		variableMap.put("receivedDate", new Date());
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("ecorrespondenceTriage", variableMap);
		assertNotNull(processInstance.getId());
		System.out.println("id " + processInstance.getId() + " "
				+ processInstance.getProcessDefinitionId());
	}
}