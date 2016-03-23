package govonca.tbs.simpleactiviti;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.test.ActivitiRule;
import org.activiti.engine.test.Deployment;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Rule;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookOrderTest {
    private static final Logger log = LoggerFactory.getLogger(BookOrderTest.class);

    @Rule
    public ActivitiRule activitiRule = new ActivitiRule("activiti.cfg.xml");

    private void startProcessInstance() {
        Map<String, Object> variableMap = new HashMap<>();
        variableMap.put("isbn", "123456");
        ProcessInstance processInstance =
                 activitiRule.getRuntimeService()
                .startProcessInstanceByKey("bookorder", variableMap);
        assertNotNull(processInstance.getId());
    }
    
    @Test
    @Deployment(resources={"chapter1/bookorder.bpmn20.xml"})
    public void startBookOrder() {
        log.debug("Start book order");
        
        activitiRule.getIdentityService().setAuthenticatedUserId("kermit");
        final TaskService taskService = activitiRule.getTaskService();
        
        // remove tasks already present
        List<Task> availableTaskList = taskService.createTaskQuery()
                .taskName("Work on order").list();
        availableTaskList.stream().forEach((task) -> {
            taskService.complete(task.getId());
        });

        startProcessInstance();
        List<Task> taskList = taskService.createTaskQuery()
                .taskName("Work on order").list();
        assertEquals(1, taskList.size());
        log.debug("found task >" + taskList.get(0).getName() + "<");
        log.debug("End book order");
    }
}
