export interface ICustomerService {
  id?: number;
  name?: string | null;
  serviceDate?: Date | null;
  customerName?: string | null;
  employeeName?: string | null;
  customerSatisfaction?: boolean | null;
  orderDescription?: string | null;
  paymentValue?: number | null;
  paymentDescription?: string | null;
  expenseValue?: number | null;
  expenseDescription?: string | null;
}

export class CustomerService implements ICustomerService {
  constructor(
    public id?: number,
    public name?: string | null,
    public serviceDate?: Date | null,
    public customerName?: string | null,
    public employeeName?: string | null,
    public customerSatisfaction?: boolean | null,
    public orderDescription?: string | null,
    public paymentValue?: number | null,
    public paymentDescription?: string | null,
    public expenseValue?: number | null,
    public expenseDescription?: string | null
  ) {
    this.customerSatisfaction = this.customerSatisfaction ?? false;
  }
}
