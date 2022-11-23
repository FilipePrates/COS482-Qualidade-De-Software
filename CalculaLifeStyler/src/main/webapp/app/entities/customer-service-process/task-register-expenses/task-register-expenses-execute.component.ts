import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskRegisterExpensesService from './task-register-expenses.service';
import { TaskRegisterExpensesContext } from './task-register-expenses.model';

const validations: any = {
  taskContext: {
    customerServiceProcess: {
      customerService: {
        name: {},
        serviceDate: {},
        expenseValue: {},
        expenseDescription: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class TaskRegisterExpensesExecuteComponent extends Vue {
  private taskRegisterExpensesService: TaskRegisterExpensesService = new TaskRegisterExpensesService();
  private taskContext: TaskRegisterExpensesContext = {};
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
    });
  }

  public claimTaskInstance(taskInstanceId) {
    this.taskRegisterExpensesService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.taskRegisterExpensesService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }

  public initRelationships(): void {}
}
