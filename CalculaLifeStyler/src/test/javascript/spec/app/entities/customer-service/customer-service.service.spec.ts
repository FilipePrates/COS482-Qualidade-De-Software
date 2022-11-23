/* tslint:disable max-line-length */
import axios from 'axios';
import sinon from 'sinon';
import dayjs from 'dayjs';

import { DATE_FORMAT } from '@/shared/date/filters';
import CustomerServiceService from '@/entities/customer-service/customer-service.service';
import { CustomerService } from '@/shared/model/customer-service.model';

const error = {
  response: {
    status: null,
    data: {
      type: null,
    },
  },
};

const axiosStub = {
  get: sinon.stub(axios, 'get'),
  post: sinon.stub(axios, 'post'),
  put: sinon.stub(axios, 'put'),
  patch: sinon.stub(axios, 'patch'),
  delete: sinon.stub(axios, 'delete'),
};

describe('Service Tests', () => {
  describe('CustomerService Service', () => {
    let service: CustomerServiceService;
    let elemDefault;
    let currentDate: Date;

    beforeEach(() => {
      service = new CustomerServiceService();
      currentDate = new Date();
      elemDefault = new CustomerService(0, 'AAAAAAA', currentDate, 'AAAAAAA', 'AAAAAAA', false, 'AAAAAAA', 0, 'AAAAAAA', 0, 'AAAAAAA');
    });

    describe('Service methods', () => {
      it('should find an element', async () => {
        const returnedFromService = Object.assign(
          {
            serviceDate: dayjs(currentDate).format(DATE_FORMAT),
          },
          elemDefault
        );
        axiosStub.get.resolves({ data: returnedFromService });

        return service.find(123).then(res => {
          expect(res).toMatchObject(elemDefault);
        });
      });

      it('should not find an element', async () => {
        axiosStub.get.rejects(error);
        return service
          .find(123)
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should return a list of CustomerService', async () => {
        const returnedFromService = Object.assign(
          {
            name: 'BBBBBB',
            serviceDate: dayjs(currentDate).format(DATE_FORMAT),
            customerName: 'BBBBBB',
            employeeName: 'BBBBBB',
            customerSatisfaction: true,
            orderDescription: 'BBBBBB',
            paymentValue: 1,
            paymentDescription: 'BBBBBB',
            expenseValue: 1,
            expenseDescription: 'BBBBBB',
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            serviceDate: currentDate,
          },
          returnedFromService
        );
        axiosStub.get.resolves([returnedFromService]);
        return service.retrieve().then(res => {
          expect(res).toContainEqual(expected);
        });
      });

      it('should not return a list of CustomerService', async () => {
        axiosStub.get.rejects(error);

        return service
          .retrieve()
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });
    });
  });
});
