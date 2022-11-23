import axios from 'axios';
import { TaskRegisterExpensesContext } from './task-register-expenses.model';

const baseApiUrl = 'api/customer-service-process/task-register-expenses';

export default class TaskRegisterExpensesService {
  public loadContext(taskId: number): Promise<TaskRegisterExpensesContext> {
    return new Promise<TaskRegisterExpensesContext>((resolve, reject) => {
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

  public claim(taskId: number): Promise<TaskRegisterExpensesContext> {
    return new Promise<TaskRegisterExpensesContext>((resolve, reject) => {
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

  public complete(taskRegisterExpensesContext: TaskRegisterExpensesContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, taskRegisterExpensesContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
