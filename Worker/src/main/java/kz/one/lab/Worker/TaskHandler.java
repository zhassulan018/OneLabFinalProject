package kz.one.lab.Worker;

import client.CatalogFeign;
import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Component;

@Component
@ExternalTaskSubscription("userSearch")
public class TaskHandler implements ExternalTaskHandler {

    @Autowired
    CatalogFeign catalogFeign;

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {

    }
}
