/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import CustomerServiceComponent from '@/entities/customer-service/customer-service.vue';
import CustomerServiceClass from '@/entities/customer-service/customer-service.component';
import CustomerServiceService from '@/entities/customer-service/customer-service.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('b-badge', {});
localVue.directive('b-modal', {});
localVue.component('b-button', {});
localVue.component('router-link', {});

const bModalStub = {
  render: () => {},
  methods: {
    hide: () => {},
    show: () => {},
  },
};

describe('Component Tests', () => {
  describe('CustomerService Management Component', () => {
    let wrapper: Wrapper<CustomerServiceClass>;
    let comp: CustomerServiceClass;
    let customerServiceServiceStub: SinonStubbedInstance<CustomerServiceService>;

    beforeEach(() => {
      customerServiceServiceStub = sinon.createStubInstance<CustomerServiceService>(CustomerServiceService);
      customerServiceServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<CustomerServiceClass>(CustomerServiceComponent, {
        store,
        i18n,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          customerServiceService: () => customerServiceServiceStub,
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      customerServiceServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllCustomerServices();
      await comp.$nextTick();

      // THEN
      expect(customerServiceServiceStub.retrieve.called).toBeTruthy();
      expect(comp.customerServices[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
