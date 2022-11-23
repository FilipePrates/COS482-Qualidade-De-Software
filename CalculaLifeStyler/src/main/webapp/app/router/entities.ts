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
// prettier-ignore
const CustomerServiceProcess_TaskRegisterServiceDetails = () => import('@/entities/customer-service-process/task-register-service/task-register-service-details.vue');
// prettier-ignore
const CustomerServiceProcess_TaskRegisterServiceExecute = () => import('@/entities/customer-service-process/task-register-service/task-register-service-execute.vue');
// prettier-ignore
const CustomerServiceProcess_TaskRegisterExpensesDetails = () => import('@/entities/customer-service-process/task-register-expenses/task-register-expenses-details.vue');
// prettier-ignore
const CustomerServiceProcess_TaskRegisterExpensesExecute = () => import('@/entities/customer-service-process/task-register-expenses/task-register-expenses-execute.vue');
// prettier-ignore
const CustomerServiceProcess_TaskRegisterPaymentDetails = () => import('@/entities/customer-service-process/task-register-payment/task-register-payment-details.vue');
// prettier-ignore
const CustomerServiceProcess_TaskRegisterPaymentExecute = () => import('@/entities/customer-service-process/task-register-payment/task-register-payment-execute.vue');
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
  {
    path: '/process-definition/CustomerServiceProcess/task/TaskRegisterService/:taskInstanceId/view',
    name: 'CustomerServiceProcess_TaskRegisterServiceDetails',
    component: CustomerServiceProcess_TaskRegisterServiceDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/CustomerServiceProcess/task/TaskRegisterService/:taskInstanceId/execute',
    name: 'CustomerServiceProcess_TaskRegisterServiceExecute',
    component: CustomerServiceProcess_TaskRegisterServiceExecute,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/CustomerServiceProcess/task/TaskRegisterExpenses/:taskInstanceId/view',
    name: 'CustomerServiceProcess_TaskRegisterExpensesDetails',
    component: CustomerServiceProcess_TaskRegisterExpensesDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/CustomerServiceProcess/task/TaskRegisterExpenses/:taskInstanceId/execute',
    name: 'CustomerServiceProcess_TaskRegisterExpensesExecute',
    component: CustomerServiceProcess_TaskRegisterExpensesExecute,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/CustomerServiceProcess/task/TaskRegisterPayment/:taskInstanceId/view',
    name: 'CustomerServiceProcess_TaskRegisterPaymentDetails',
    component: CustomerServiceProcess_TaskRegisterPaymentDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/CustomerServiceProcess/task/TaskRegisterPayment/:taskInstanceId/execute',
    name: 'CustomerServiceProcess_TaskRegisterPaymentExecute',
    component: CustomerServiceProcess_TaskRegisterPaymentExecute,
    meta: { authorities: [Authority.USER] },
  },
  // jhipster-needle-add-entity-to-router - JHipster will add entities to the router here
];
