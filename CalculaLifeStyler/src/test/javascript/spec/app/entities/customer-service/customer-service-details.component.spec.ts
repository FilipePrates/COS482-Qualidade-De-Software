/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import VueRouter from 'vue-router';

import * as config from '@/shared/config/config';
import CustomerServiceDetailComponent from '@/entities/customer-service/customer-service-details.vue';
import CustomerServiceClass from '@/entities/customer-service/customer-service-details.component';
import CustomerServiceService from '@/entities/customer-service/customer-service.service';
import router from '@/router';

const localVue = createLocalVue();
localVue.use(VueRouter);

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('CustomerService Management Detail Component', () => {
    let wrapper: Wrapper<CustomerServiceClass>;
    let comp: CustomerServiceClass;
    let customerServiceServiceStub: SinonStubbedInstance<CustomerServiceService>;

    beforeEach(() => {
      customerServiceServiceStub = sinon.createStubInstance<CustomerServiceService>(CustomerServiceService);

      wrapper = shallowMount<CustomerServiceClass>(CustomerServiceDetailComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: { customerServiceService: () => customerServiceServiceStub },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundCustomerService = { id: 123 };
        customerServiceServiceStub.find.resolves(foundCustomerService);

        // WHEN
        comp.retrieveCustomerService(123);
        await comp.$nextTick();

        // THEN
        expect(comp.customerService).toBe(foundCustomerService);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundCustomerService = { id: 123 };
        customerServiceServiceStub.find.resolves(foundCustomerService);

        // WHEN
        comp.beforeRouteEnter({ params: { customerServiceId: 123 } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.customerService).toBe(foundCustomerService);
      });
    });

    describe('Previous state', () => {
      it('Should go previous state', async () => {
        comp.previousState();
        await comp.$nextTick();

        expect(comp.$router.currentRoute.fullPath).toContain('/');
      });
    });
  });
});
