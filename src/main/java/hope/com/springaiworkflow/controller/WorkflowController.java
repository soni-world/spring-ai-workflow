package hope.com.springaiworkflow.controller;

import hope.com.springaiworkflow.service.WorkflowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkflowController {

    @Autowired
    WorkflowService workflowService;

    @PostMapping("/workflow")
    public String process(@RequestParam String input){
        return workflowService.chain(input);
    }
}
