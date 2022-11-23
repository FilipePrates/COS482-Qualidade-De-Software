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
public class TaskRegisterPaymentService {

    private final TaskInstanceService taskInstanceService;

    private final CustomerServiceService customerServiceService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final CustomerServiceProcessRepository customerServiceProcessRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final TaskRegisterPaymentMapper taskRegisterPaymentMapper;

    private final CustomerServiceProcessMapper customerServiceProcessMapper;

    public TaskRegisterPaymentService(
        TaskInstanceService taskInstanceService,
        CustomerServiceService customerServiceService,
        TaskInstanceRepository taskInstanceRepository,
        CustomerServiceProcessRepository customerServiceProcessRepository,
        TaskInstanceMapper taskInstanceMapper,
        TaskRegisterPaymentMapper taskRegisterPaymentMapper,
        CustomerServiceProcessMapper customerServiceProcessMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.customerServiceService = customerServiceService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.customerServiceProcessRepository = customerServiceProcessRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.taskRegisterPaymentMapper = taskRegisterPaymentMapper;
        this.customerServiceProcessMapper = customerServiceProcessMapper;
    }

    public TaskRegisterPaymentContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        CustomerServiceProcessDTO customerServiceProcess = customerServiceProcessRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(taskRegisterPaymentMapper::toCustomerServiceProcessDTO)
            .orElseThrow();

        TaskRegisterPaymentContextDTO taskRegisterPaymentContext = new TaskRegisterPaymentContextDTO();
        taskRegisterPaymentContext.setTaskInstance(taskInstanceDTO);
        taskRegisterPaymentContext.setCustomerServiceProcess(customerServiceProcess);

        return taskRegisterPaymentContext;
    }

    public TaskRegisterPaymentContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(TaskRegisterPaymentContextDTO taskRegisterPaymentContext) {
        CustomerServiceDTO customerServiceDTO = customerServiceService
            .findOne(taskRegisterPaymentContext.getCustomerServiceProcess().getCustomerService().getId())
            .orElseThrow();
        customerServiceDTO.setName(taskRegisterPaymentContext.getCustomerServiceProcess().getCustomerService().getName());
        customerServiceDTO.setServiceDate(taskRegisterPaymentContext.getCustomerServiceProcess().getCustomerService().getServiceDate());
        customerServiceDTO.setCustomerSatisfaction(
            taskRegisterPaymentContext.getCustomerServiceProcess().getCustomerService().getCustomerSatisfaction()
        );
        customerServiceDTO.setOrderDescription(
            taskRegisterPaymentContext.getCustomerServiceProcess().getCustomerService().getOrderDescription()
        );
        customerServiceDTO.setPaymentValue(taskRegisterPaymentContext.getCustomerServiceProcess().getCustomerService().getPaymentValue());
        customerServiceDTO.setPaymentDescription(
            taskRegisterPaymentContext.getCustomerServiceProcess().getCustomerService().getPaymentDescription()
        );
        customerServiceService.save(customerServiceDTO);
    }

    public void complete(TaskRegisterPaymentContextDTO taskRegisterPaymentContext) {
        save(taskRegisterPaymentContext);
        CustomerServiceProcessDTO customerServiceProcess = customerServiceProcessRepository
            .findByProcessInstanceId(taskRegisterPaymentContext.getCustomerServiceProcess().getProcessInstance().getId())
            .map(customerServiceProcessMapper::toDto)
            .orElseThrow();
        taskInstanceService.complete(taskRegisterPaymentContext.getTaskInstance(), customerServiceProcess);
    }
}
