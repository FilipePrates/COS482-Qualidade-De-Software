import axios from 'axios';

import { ICustomerServiceProcess } from '@/shared/model/customer-service-process.model';

const baseApiUrl = 'api/customer-service-processes';

export default class CustomerServiceProcessService {
  public find(id: number): Promise<ICustomerServiceProcess> {
    return new Promise<ICustomerServiceProcess>((resolve, reject) => {
      axios
        .get(`${baseApiUrl}/${id}`)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public retrieve(): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .get(baseApiUrl)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public create(entity: ICustomerServiceProcess): Promise<ICustomerServiceProcess> {
    return new Promise<ICustomerServiceProcess>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}`, entity)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
