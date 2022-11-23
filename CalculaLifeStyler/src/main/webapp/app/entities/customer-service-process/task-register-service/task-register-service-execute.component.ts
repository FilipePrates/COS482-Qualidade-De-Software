import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskRegisterServiceService from './task-register-service.service';
import { TaskRegisterServiceContext } from './task-register-service.model';

const validations: any = {
  taskContext: {
    customerServiceProcess: {
      customerService: {
        name: {},
        serviceDate: {},
        orderDescription: {},
        customerName: {},
        employeeName: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class TaskRegisterServiceExecuteComponent extends Vue {
  private taskRegisterServiceService: TaskRegisterServiceService = new TaskRegisterServiceService();
  private taskContext: TaskRegisterServiceContext = {};
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
    });
  }

  public claimTaskInstance(taskInstanceId) {
    this.taskRegisterServiceService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.taskRegisterServiceService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }

  public initRelationships(): void {}
}
