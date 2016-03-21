package govonca.tbs.simpleactiviti;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.BeforeClass;
import org.junit.Test;

public class BookOrderTest {
    private static RuntimeService runtimeService;
    private static IdentityService identityService;
    private static TaskService taskService;
    
    @BeforeClass
    public static void init() {
        ProcessEngine processEngine = ProcessEngineConfiguration
                .createProcessEngineConfigurationFromResourceDefault()
               .buildProcessEngine();

        RepositoryService repositoryService = processEngine.getRepositoryService();
        identityService = processEngine.getIdentityService();
        taskService = processEngine.getTaskService();
        repositoryService.createDeployment()
                .addClasspathResource("chapter1/bookorder.bpmn20.xml")
                .deploy();
        runtimeService = processEngine.getRuntimeService();
    }
    
    @Test
    public void startBookOrder() {

        // remove tasks already present
        List<Task> availableTaskList = taskService.createTaskQuery()
                .taskName("Work on order").list();
        availableTaskList.stream().forEach((task) -> {
            taskService.complete(task.getId());
        });

        Map<String, Object> variableMap = new HashMap<>();
        variableMap.put("isbn", "123456");
        identityService.setAuthenticatedUserId("kermit");
        ProcessInstance processInstance = runtimeService
                .startProcessInstanceByKey("bookorder", variableMap);
        assertNotNull(processInstance.getId());
        List<Task> taskList = taskService.createTaskQuery()
                .taskName("Work on order").list();
        assertEquals(1, taskList.size());
        System.out.println("found task " + taskList.get(0).getName());
    }
}
