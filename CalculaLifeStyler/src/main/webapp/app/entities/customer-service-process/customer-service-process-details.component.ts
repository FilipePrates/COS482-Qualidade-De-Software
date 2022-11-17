import { Component, Vue, Inject } from 'vue-property-decorator';

import { ICustomerServiceProcess } from '@/shared/model/customer-service-process.model';
import CustomerServiceProcessService from './customer-service-process.service';

@Component
export default class CustomerServiceProcessDetailsComponent extends Vue {
  @Inject('customerServiceProcessService') private customerServiceProcessService: () => CustomerServiceProcessService;
  public customerServiceProcess: ICustomerServiceProcess = {};

  public isFetching: boolean = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.processInstanceId) {
        vm.retrieveCustomerServiceProcess(to.params.processInstanceId);
      }
    });
  }

  public retrieveCustomerServiceProcess(customerServiceProcessId) {
    this.isFetching = true;
    this.customerServiceProcessService()
      .find(customerServiceProcessId)
      .then(
        res => {
          this.customerServiceProcess = res;
          this.isFetching = false;
        },
        err => {
          this.isFetching = false;
        }
      );
  }

  public previousState() {
    this.$router.go(-1);
  }
}
