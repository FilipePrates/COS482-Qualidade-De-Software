import axios from 'axios';

import { ICustomerService } from '@/shared/model/customer-service.model';

const baseApiUrl = 'api/customer-services';

export default class CustomerServiceService {
  public find(id: number): Promise<ICustomerService> {
    return new Promise<ICustomerService>((resolve, reject) => {
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
}
