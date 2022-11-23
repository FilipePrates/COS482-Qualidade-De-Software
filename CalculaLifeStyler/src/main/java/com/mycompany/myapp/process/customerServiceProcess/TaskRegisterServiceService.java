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
public class TaskRegisterServiceService {

    private final TaskInstanceService taskInstanceService;

    private final CustomerServiceService customerServiceService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final CustomerServiceProcessRepository customerServiceProcessRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final TaskRegisterServiceMapper taskRegisterServiceMapper;

    private final CustomerServiceProcessMapper customerServiceProcessMapper;

    public TaskRegisterServiceService(
        TaskInstanceService taskInstanceService,
        CustomerServiceService customerServiceService,
        TaskInstanceRepository taskInstanceRepository,
        CustomerServiceProcessRepository customerServiceProcessRepository,
        TaskInstanceMapper taskInstanceMapper,
        TaskRegisterServiceMapper taskRegisterServiceMapper,
        CustomerServiceProcessMapper customerServiceProcessMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.customerServiceService = customerServiceService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.customerServiceProcessRepository = customerServiceProcessRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.taskRegisterServiceMapper = taskRegisterServiceMapper;
        this.customerServiceProcessMapper = customerServiceProcessMapper;
    }

    public TaskRegisterServiceContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        CustomerServiceProcessDTO customerServiceProcess = customerServiceProcessRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(taskRegisterServiceMapper::toCustomerServiceProcessDTO)
            .orElseThrow();

        TaskRegisterServiceContextDTO taskRegisterServiceContext = new TaskRegisterServiceContextDTO();
        taskRegisterServiceContext.setTaskInstance(taskInstanceDTO);
        taskRegisterServiceContext.setCustomerServiceProcess(customerServiceProcess);

        return taskRegisterServiceContext;
    }

    public TaskRegisterServiceContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(TaskRegisterServiceContextDTO taskRegisterServiceContext) {
        CustomerServiceDTO customerServiceDTO = customerServiceService
            .findOne(taskRegisterServiceContext.getCustomerServiceProcess().getCustomerService().getId())
            .orElseThrow();
        customerServiceDTO.setName(taskRegisterServiceContext.getCustomerServiceProcess().getCustomerService().getName());
        customerServiceDTO.setServiceDate(taskRegisterServiceContext.getCustomerServiceProcess().getCustomerService().getServiceDate());
        customerServiceDTO.setOrderDescription(
            taskRegisterServiceContext.getCustomerServiceProcess().getCustomerService().getOrderDescription()
        );
        customerServiceDTO.setCustomerName(taskRegisterServiceContext.getCustomerServiceProcess().getCustomerService().getCustomerName());
        customerServiceDTO.setEmployeeName(taskRegisterServiceContext.getCustomerServiceProcess().getCustomerService().getEmployeeName());
        customerServiceService.save(customerServiceDTO);
    }

    public void complete(TaskRegisterServiceContextDTO taskRegisterServiceContext) {
        save(taskRegisterServiceContext);
        CustomerServiceProcessDTO customerServiceProcess = customerServiceProcessRepository
            .findByProcessInstanceId(taskRegisterServiceContext.getCustomerServiceProcess().getProcessInstance().getId())
            .map(customerServiceProcessMapper::toDto)
            .orElseThrow();
        taskInstanceService.complete(taskRegisterServiceContext.getTaskInstance(), customerServiceProcess);
    }
}
