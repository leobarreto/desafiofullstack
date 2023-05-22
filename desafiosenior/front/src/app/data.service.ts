import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';

import { Item } from './Item';
import { environment } from './enviroments/enviroment';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  private baseApiUrl = environment.apiUrl;

  constructor(private http: HttpClient) { }

  getData(): Observable<any> {
    return this.http.get<any>(`${this.baseApiUrl}item/`);
  }

  getDataById(id: any): Observable<any> {
    const headers = { 'content-type': 'application/json' };
    return this.http.get<any>(`${this.baseApiUrl}item/${id}`, { headers });
  }

  create(data: any) {
    const headers = { 'content-type': 'application/json' };

    return this.http.post(`${this.baseApiUrl}item/`, body, { headers }).subscribe(() => {
      alert('Item cadastrado com sucesso');
    });
  }

  update(data: any) {
    const headers = { 'content-type': 'application/json' };
    const body = JSON.stringify(data);

    return this.http.put(`${this.baseApiUrl}item/${data.id}`, body, { headers }).subscribe(() => {
      alert('Item atualizado com sucesso');
    });
  }

  delete(data: any) {
    const headers = { 'content-type': 'application/json' };
    const body = JSON.stringify(data);

    return this.http.delete(`${this.baseApiUrl}item/${data}`, { headers }).subscribe(() => {
      alert('Item excluído com sucesso');
    });
  }

}
