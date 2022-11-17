import { Authority } from '@/shared/security/authority';
/* tslint:disable */
// prettier-ignore

// prettier-ignore
const CustomerService = () => import('@/entities/customer-service/customer-service.vue');
// prettier-ignore
const CustomerServiceDetails = () => import('@/entities/customer-service/customer-service-details.vue');
// prettier-ignore
const CustomerServiceProcessDetails = () => import('@/entities/customer-service-process/customer-service-process-details.vue');
// prettier-ignore
const CustomerServiceProcessList = () => import('@/entities/customer-service-process/customer-service-process-list.vue');
// prettier-ignore
const CustomerServiceStartFormInit = () => import('@/entities/customer-service-process/customer-service-start-form-init.vue');
// jhipster-needle-add-entity-to-router-import - JHipster will import entities to the router here

export default [
  {
    path: '/customer-service',
    name: 'CustomerService',
    component: CustomerService,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/customer-service/:customerServiceId/view',
    name: 'CustomerServiceView',
    component: CustomerServiceDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/CustomerServiceProcess/instance/:processInstanceId/view',
    name: 'CustomerServiceProcessView',
    component: CustomerServiceProcessDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/CustomerServiceProcess/instances',
    name: 'CustomerServiceProcessList',
    component: CustomerServiceProcessList,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/CustomerServiceProcess/init',
    name: 'CustomerServiceStartFormInit',
    component: CustomerServiceStartFormInit,
    meta: { authorities: [Authority.USER] },
  },
  // jhipster-needle-add-entity-to-router - JHipster will add entities to the router here
];
