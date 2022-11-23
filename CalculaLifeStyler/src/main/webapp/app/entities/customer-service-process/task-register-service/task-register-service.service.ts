import axios from 'axios';
import { TaskRegisterServiceContext } from './task-register-service.model';

const baseApiUrl = 'api/customer-service-process/task-register-service';

export default class TaskRegisterServiceService {
  public loadContext(taskId: number): Promise<TaskRegisterServiceContext> {
    return new Promise<TaskRegisterServiceContext>((resolve, reject) => {
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

  public claim(taskId: number): Promise<TaskRegisterServiceContext> {
    return new Promise<TaskRegisterServiceContext>((resolve, reject) => {
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

  public complete(taskRegisterServiceContext: TaskRegisterServiceContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, taskRegisterServiceContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
