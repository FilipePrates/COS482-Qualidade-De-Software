package com.mycompany.myapp.process.customerServiceProcess;

import com.mycompany.myapp.service.dto.CustomerServiceProcessDTO;
import org.akip.service.dto.TaskInstanceDTO;

public class TaskRegisterPaymentContextDTO {

    private CustomerServiceProcessDTO customerServiceProcess;
    private TaskInstanceDTO taskInstance;

    public CustomerServiceProcessDTO getCustomerServiceProcess() {
        return customerServiceProcess;
    }

    public void setCustomerServiceProcess(CustomerServiceProcessDTO customerServiceProcess) {
        this.customerServiceProcess = customerServiceProcess;
    }

    public TaskInstanceDTO getTaskInstance() {
        return taskInstance;
    }

    public void setTaskInstance(TaskInstanceDTO taskInstance) {
        this.taskInstance = taskInstance;
    }
}
