import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskRegisterServiceService from './task-register-service.service';
import { TaskRegisterServiceContext } from './task-register-service.model';

@Component
export default class TaskRegisterServiceDetailsComponent extends Vue {
  private taskRegisterServiceService: TaskRegisterServiceService = new TaskRegisterServiceService();
  private taskContext: TaskRegisterServiceContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.taskRegisterServiceService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
