import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskRegisterPaymentService from './task-register-payment.service';
import { TaskRegisterPaymentContext } from './task-register-payment.model';

const validations: any = {
  taskContext: {
    customerServiceProcess: {
      customerService: {
        name: {},
        serviceDate: {},
        customerSatisfaction: {},
        orderDescription: {},
        isThereExtraExpenses: {},
        paymentValue: {},
        paymentDescription: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class TaskRegisterPaymentExecuteComponent extends Vue {
  private taskRegisterPaymentService: TaskRegisterPaymentService = new TaskRegisterPaymentService();
  private taskContext: TaskRegisterPaymentContext = {};
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
    });
  }

  public claimTaskInstance(taskInstanceId) {
    this.taskRegisterPaymentService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.taskRegisterPaymentService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }

  public initRelationships(): void {}
}
