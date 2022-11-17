export interface ICustomerService {
  id?: number;
  startDate?: string | null;
  endDate?: string | null;
  customerName?: string | null;
  employeeName?: string | null;
  customerSatisfaction?: number | null;
  orderDescription?: string | null;
  paymentValue?: number | null;
  paymentDescription?: string | null;
  expenseValue?: number | null;
  expenseDescription?: string | null;
}

export class CustomerService implements ICustomerService {
  constructor(
    public id?: number,
    public startDate?: string | null,
    public endDate?: string | null,
    public customerName?: string | null,
    public employeeName?: string | null,
    public customerSatisfaction?: number | null,
    public orderDescription?: string | null,
    public paymentValue?: number | null,
    public paymentDescription?: string | null,
    public expenseValue?: number | null,
    public expenseDescription?: string | null
  ) {}
}
