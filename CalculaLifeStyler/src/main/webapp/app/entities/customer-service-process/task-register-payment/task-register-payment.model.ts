import { ICustomerServiceProcess } from '@/shared/model/customer-service-process.model';

export class TaskRegisterPaymentContext {
  taskInstance?: any = {};
  customerServiceProcess?: ICustomerServiceProcess = {};
}
