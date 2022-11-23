package com.mycompany.myapp.process.customerServiceProcess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer-service-process/task-register-service")
public class TaskRegisterServiceController {

    private final Logger log = LoggerFactory.getLogger(TaskRegisterServiceController.class);

    private final TaskRegisterServiceService taskRegisterServiceService;

    public TaskRegisterServiceController(TaskRegisterServiceService taskRegisterServiceService) {
        this.taskRegisterServiceService = taskRegisterServiceService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskRegisterServiceContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskRegisterServiceContextDTO taskRegisterServiceContext = taskRegisterServiceService.loadContext(id);
        return ResponseEntity.ok(taskRegisterServiceContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<TaskRegisterServiceContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskRegisterServiceContextDTO taskRegisterServiceContext = taskRegisterServiceService.claim(id);
        return ResponseEntity.ok(taskRegisterServiceContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody TaskRegisterServiceContextDTO taskRegisterServiceContext) {
        log.debug(
            "REST request to complete CustomerServiceProcess.TaskRegisterService {}",
            taskRegisterServiceContext.getTaskInstance().getId()
        );
        taskRegisterServiceService.complete(taskRegisterServiceContext);
        return ResponseEntity.noContent().build();
    }
}
