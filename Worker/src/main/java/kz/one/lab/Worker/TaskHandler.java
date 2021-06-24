package kz.one.lab.Worker;

import client.CatalogFeign;
import model.User;
import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;

@Component
@ExternalTaskSubscription(topicName = "userSearch")
public class TaskHandler implements ExternalTaskHandler {
//
    @Autowired
    CatalogFeign catalogFeign;

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {
        //String email = externalTask.getVariable("email");
        boolean userRegistered = false;
//        User user = catalogFeign.findByEmail("jaasulan@gmail.com");
//        System.out.println(user);
//        if(user != null) userRegistered = true;

        VariableMap variables = Variables.createVariables();
        variables.put("userRegistered", userRegistered);

        externalTaskService.complete(externalTask,variables);
    }
}
