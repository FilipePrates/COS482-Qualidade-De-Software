import { Component, Vue, Inject } from 'vue-property-decorator';

import { ICustomerService } from '@/shared/model/customer-service.model';
import CustomerServiceService from './customer-service.service';

@Component
export default class CustomerServiceDetails extends Vue {
  @Inject('customerServiceService') private customerServiceService: () => CustomerServiceService;
  public customerService: ICustomerService = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.customerServiceId) {
        vm.retrieveCustomerService(to.params.customerServiceId);
      }
    });
  }

  public retrieveCustomerService(customerServiceId) {
    this.customerServiceService()
      .find(customerServiceId)
      .then(res => {
        this.customerService = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
