import axios from 'axios';
import { TaskRegisterPaymentContext } from './task-register-payment.model';

const baseApiUrl = 'api/customer-service-process/task-register-payment';

export default class TaskRegisterPaymentService {
  public loadContext(taskId: number): Promise<TaskRegisterPaymentContext> {
    return new Promise<TaskRegisterPaymentContext>((resolve, reject) => {
      axios
        .get(`${baseApiUrl}/${taskId}`)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public claim(taskId: number): Promise<TaskRegisterPaymentContext> {
    return new Promise<TaskRegisterPaymentContext>((resolve, reject) => {
      axios
        .get(`${baseApiUrl}/${taskId}/claim`)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public complete(taskRegisterPaymentContext: TaskRegisterPaymentContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, taskRegisterPaymentContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
