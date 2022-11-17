import { ICustomerService } from '@/shared/model/customer-service.model';

export interface ICustomerServiceProcess {
  id?: number;
  processInstance?: any | null;
  customerService?: ICustomerService | null;
}

export class CustomerServiceProcess implements ICustomerServiceProcess {
  constructor(public id?: number, public processInstance?: any | null, public customerService?: ICustomerService | null) {}
}
