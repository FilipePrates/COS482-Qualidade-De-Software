package com.mycompany.myapp.process.customerServiceProcess;

import com.mycompany.myapp.repository.CustomerServiceProcessRepository;
import com.mycompany.myapp.service.CustomerServiceService;
import com.mycompany.myapp.service.dto.CustomerServiceDTO;
import com.mycompany.myapp.service.dto.CustomerServiceProcessDTO;
import com.mycompany.myapp.service.mapper.CustomerServiceProcessMapper;
import org.akip.repository.TaskInstanceRepository;
import org.akip.service.TaskInstanceService;
import org.akip.service.dto.TaskInstanceDTO;
import org.akip.service.mapper.TaskInstanceMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskRegisterExpensesService {

    private final TaskInstanceService taskInstanceService;

    private final CustomerServiceService customerServiceService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final CustomerServiceProcessRepository customerServiceProcessRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final TaskRegisterExpensesMapper taskRegisterExpensesMapper;

    private final CustomerServiceProcessMapper customerServiceProcessMapper;

    public TaskRegisterExpensesService(
        TaskInstanceService taskInstanceService,
        CustomerServiceService customerServiceService,
        TaskInstanceRepository taskInstanceRepository,
        CustomerServiceProcessRepository customerServiceProcessRepository,
        TaskInstanceMapper taskInstanceMapper,
        TaskRegisterExpensesMapper taskRegisterExpensesMapper,
        CustomerServiceProcessMapper customerServiceProcessMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.customerServiceService = customerServiceService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.customerServiceProcessRepository = customerServiceProcessRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.taskRegisterExpensesMapper = taskRegisterExpensesMapper;
        this.customerServiceProcessMapper = customerServiceProcessMapper;
    }

    public TaskRegisterExpensesContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        CustomerServiceProcessDTO customerServiceProcess = customerServiceProcessRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(taskRegisterExpensesMapper::toCustomerServiceProcessDTO)
            .orElseThrow();

        TaskRegisterExpensesContextDTO taskRegisterExpensesContext = new TaskRegisterExpensesContextDTO();
        taskRegisterExpensesContext.setTaskInstance(taskInstanceDTO);
        taskRegisterExpensesContext.setCustomerServiceProcess(customerServiceProcess);

        return taskRegisterExpensesContext;
    }

    public TaskRegisterExpensesContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(TaskRegisterExpensesContextDTO taskRegisterExpensesContext) {
        CustomerServiceDTO customerServiceDTO = customerServiceService
            .findOne(taskRegisterExpensesContext.getCustomerServiceProcess().getCustomerService().getId())
            .orElseThrow();
        customerServiceDTO.setName(taskRegisterExpensesContext.getCustomerServiceProcess().getCustomerService().getName());
        customerServiceDTO.setServiceDate(taskRegisterExpensesContext.getCustomerServiceProcess().getCustomerService().getServiceDate());
        customerServiceDTO.setExpenseValue(taskRegisterExpensesContext.getCustomerServiceProcess().getCustomerService().getExpenseValue());
        customerServiceDTO.setExpenseDescription(
            taskRegisterExpensesContext.getCustomerServiceProcess().getCustomerService().getExpenseDescription()
        );
        customerServiceService.save(customerServiceDTO);
    }

    public void complete(TaskRegisterExpensesContextDTO taskRegisterExpensesContext) {
        save(taskRegisterExpensesContext);
        CustomerServiceProcessDTO customerServiceProcess = customerServiceProcessRepository
            .findByProcessInstanceId(taskRegisterExpensesContext.getCustomerServiceProcess().getProcessInstance().getId())
            .map(customerServiceProcessMapper::toDto)
            .orElseThrow();
        taskInstanceService.complete(taskRegisterExpensesContext.getTaskInstance(), customerServiceProcess);
    }
}
