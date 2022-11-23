package com.mycompany.myapp.process.customerServiceProcess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer-service-process/task-register-payment")
public class TaskRegisterPaymentController {

    private final Logger log = LoggerFactory.getLogger(TaskRegisterPaymentController.class);

    private final TaskRegisterPaymentService taskRegisterPaymentService;

    public TaskRegisterPaymentController(TaskRegisterPaymentService taskRegisterPaymentService) {
        this.taskRegisterPaymentService = taskRegisterPaymentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskRegisterPaymentContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskRegisterPaymentContextDTO taskRegisterPaymentContext = taskRegisterPaymentService.loadContext(id);
        return ResponseEntity.ok(taskRegisterPaymentContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<TaskRegisterPaymentContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskRegisterPaymentContextDTO taskRegisterPaymentContext = taskRegisterPaymentService.claim(id);
        return ResponseEntity.ok(taskRegisterPaymentContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody TaskRegisterPaymentContextDTO taskRegisterPaymentContext) {
        log.debug(
            "REST request to complete CustomerServiceProcess.TaskRegisterPayment {}",
            taskRegisterPaymentContext.getTaskInstance().getId()
        );
        taskRegisterPaymentService.complete(taskRegisterPaymentContext);
        return ResponseEntity.noContent().build();
    }
}
