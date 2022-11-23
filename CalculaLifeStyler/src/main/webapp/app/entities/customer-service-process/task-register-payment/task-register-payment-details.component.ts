import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskRegisterPaymentService from './task-register-payment.service';
import { TaskRegisterPaymentContext } from './task-register-payment.model';

@Component
export default class TaskRegisterPaymentDetailsComponent extends Vue {
  private taskRegisterPaymentService: TaskRegisterPaymentService = new TaskRegisterPaymentService();
  private taskContext: TaskRegisterPaymentContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.taskRegisterPaymentService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
