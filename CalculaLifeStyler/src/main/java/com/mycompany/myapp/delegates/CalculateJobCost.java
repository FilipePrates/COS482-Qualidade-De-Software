package com.mycompany.myapp.delegates;

import com.mycompany.myapp.service.dto.CustomerServiceProcessDTO;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class CalculateJobCost implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        CustomerServiceProcessDTO pi = (CustomerServiceProcessDTO) delegateExecution.getVariable("pi");

        Boolean expenses = pi.getCustomerService().getIsThereExtraExpenses();
        Double paymentValue = pi.getCustomerService().getPaymentValue();
        Double expensesValue = pi.getCustomerService().getExpenseValue();

        if (expenses == true) {
            Double finalValue = paymentValue - expensesValue;
            System.out.println("=================================================");
            System.out.println("The employee must be paid R$" + finalValue + " related to this job!");
            System.out.println("=================================================");
        } else {
            System.out.println("=================================================");
            System.out.println("The employee must be paid R$" + paymentValue + " related to this job!");
            System.out.println("=================================================");
        }
    }
}
