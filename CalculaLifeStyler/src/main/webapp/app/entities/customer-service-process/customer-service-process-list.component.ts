import { Component, Vue, Inject } from 'vue-property-decorator';
import { ICustomerServiceProcess } from '@/shared/model/customer-service-process.model';

import { ProcessDefinition, ProcessDefinitionService } from 'akip-vue-community';

import CustomerServiceProcessService from './customer-service-process.service';

@Component
export default class CustomerServiceProcessListComponent extends Vue {
  @Inject('customerServiceProcessService') private customerServiceProcessService: () => CustomerServiceProcessService;

  private processDefinitionService: ProcessDefinitionService = new ProcessDefinitionService();

  public bpmnProcessDefinitionId: string = 'CustomerServiceProcess';
  public processDefinition: ProcessDefinition = new ProcessDefinition();
  public customerServiceProcessList: ICustomerServiceProcess[] = [];

  public isFetchingProcessDefinition = false;
  public isFetchingProcessInstances = false;

  public mounted(): void {
    this.init();
  }

  public init(): void {
    this.retrieveProcessDefinition();
    this.retrieveProcessInstances();
  }

  public retrieveProcessDefinition() {
    this.isFetchingProcessDefinition = true;
    this.processDefinitionService.find(this.bpmnProcessDefinitionId).then(
      res => {
        this.processDefinition = res;
        this.isFetchingProcessDefinition = false;
      },
      err => {
        this.isFetchingProcessDefinition = false;
      }
    );
  }

  public retrieveProcessInstances(): void {
    this.isFetchingProcessInstances = true;
    this.customerServiceProcessService()
      .retrieve()
      .then(
        res => {
          this.customerServiceProcessList = res.data;
          this.isFetchingProcessInstances = false;
        },
        err => {
          this.isFetchingProcessInstances = false;
        }
      );
  }

  get isFetching(): boolean {
    return this.isFetchingProcessDefinition && this.isFetchingProcessInstances;
  }

  public handleSyncList(): void {
    this.retrieveProcessInstances();
  }

  public previousState(): void {
    this.$router.go(-1);
  }
}
