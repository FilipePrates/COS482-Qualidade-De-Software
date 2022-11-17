import { mixins } from 'vue-class-component';

import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { ICustomerService } from '@/shared/model/customer-service.model';

import CustomerServiceService from './customer-service.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class CustomerService extends Vue {
  @Inject('customerServiceService') private customerServiceService: () => CustomerServiceService;
  private removeId: number = null;

  public customerServices: ICustomerService[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllCustomerServices();
  }

  public clear(): void {
    this.retrieveAllCustomerServices();
  }

  public retrieveAllCustomerServices(): void {
    this.isFetching = true;

    this.customerServiceService()
      .retrieve()
      .then(
        res => {
          this.customerServices = res.data;
          this.isFetching = false;
        },
        err => {
          this.isFetching = false;
        }
      );
  }

  public handleSyncList(): void {
    this.clear();
  }

  public closeDialog(): void {
    (<any>this.$refs.removeEntity).hide();
  }
}
