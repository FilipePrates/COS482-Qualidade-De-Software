import { Component, Vue, Inject } from 'vue-property-decorator';

import { ICustomerServiceProcess, CustomerServiceProcess } from '@/shared/model/customer-service-process.model';

import { ProcessInstance, ProcessDefinitionService } from 'akip-vue-community';

import { CustomerService } from '@/shared/model/customer-service.model';
import CustomerServiceProcessService from './customer-service-process.service';

const validations: any = {
  customerServiceProcess: {
    customerService: {
      name: {},
      serviceDate: {},
    },
  },
};

@Component({
  validations,
})
export default class CustomerServiceStartFormInitComponent extends Vue {
  @Inject('customerServiceProcessService') private customerServiceProcessService: () => CustomerServiceProcessService;

  private processDefinitionService: ProcessDefinitionService = new ProcessDefinitionService();

  public bpmnProcessDefinitionId: string = 'CustomerServiceProcess';
  public customerServiceProcess: ICustomerServiceProcess = new CustomerServiceProcess();

  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      vm.initCustomerServiceStartForm();
      vm.initRelationships();
    });
  }

  created(): void {
    this.currentLanguage = this.$store.getters.currentLanguage;
    this.$store.watch(
      () => this.$store.getters.currentLanguage,
      () => {
        this.currentLanguage = this.$store.getters.currentLanguage;
      }
    );
  }

  public save(): void {
    this.isSaving = true;

    this.customerServiceProcessService()
      .create(this.customerServiceProcess)
      .then(param => {
        this.isSaving = false;
        this.$router.go(-1);
        const message = this.$t('calculaLifeStylerApp.customerServiceStartForm.created', { param: param.id });
        this.$root.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: 'Success',
          variant: 'success',
          solid: true,
          autoHideDelay: 5000,
        });
      });
  }

  public initCustomerServiceStartForm(): void {
    this.customerServiceProcess.customerService = new CustomerService();
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {
    this.processDefinitionService.find(this.bpmnProcessDefinitionId).then(res => {
      this.customerServiceProcess.processInstance = new ProcessInstance();
      this.customerServiceProcess.processInstance.processDefinition = res;
    });
  }
}
