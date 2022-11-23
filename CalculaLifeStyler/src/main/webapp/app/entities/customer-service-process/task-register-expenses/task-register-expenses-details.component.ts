import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskRegisterExpensesService from './task-register-expenses.service';
import { TaskRegisterExpensesContext } from './task-register-expenses.model';

@Component
export default class TaskRegisterExpensesDetailsComponent extends Vue {
  private taskRegisterExpensesService: TaskRegisterExpensesService = new TaskRegisterExpensesService();
  private taskContext: TaskRegisterExpensesContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.taskRegisterExpensesService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
