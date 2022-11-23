package com.mycompany.myapp.process.customerServiceProcess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer-service-process/task-register-expenses")
public class TaskRegisterExpensesController {

    private final Logger log = LoggerFactory.getLogger(TaskRegisterExpensesController.class);

    private final TaskRegisterExpensesService taskRegisterExpensesService;

    public TaskRegisterExpensesController(TaskRegisterExpensesService taskRegisterExpensesService) {
        this.taskRegisterExpensesService = taskRegisterExpensesService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskRegisterExpensesContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskRegisterExpensesContextDTO taskRegisterExpensesContext = taskRegisterExpensesService.loadContext(id);
        return ResponseEntity.ok(taskRegisterExpensesContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<TaskRegisterExpensesContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskRegisterExpensesContextDTO taskRegisterExpensesContext = taskRegisterExpensesService.claim(id);
        return ResponseEntity.ok(taskRegisterExpensesContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody TaskRegisterExpensesContextDTO taskRegisterExpensesContext) {
        log.debug(
            "REST request to complete CustomerServiceProcess.TaskRegisterExpenses {}",
            taskRegisterExpensesContext.getTaskInstance().getId()
        );
        taskRegisterExpensesService.complete(taskRegisterExpensesContext);
        return ResponseEntity.noContent().build();
    }
}
