import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  url = 'http://localhost:8080'; // URL da sua API

  constructor(private http: HttpClient) { }

  getData(): Observable<any> {
    return this.http.get<any>(`${this.url}/item/`);
  }

  getDataById(id: any): Observable<any> {
    return this.http.get<any>(`${this.url}/item/${id}`);
  }

  create(data: any) {
    const headers = { 'content-type': 'application/json' };
    const body = JSON.stringify(data);

    return this.http.post(`${this.url}/item/`, data, { headers });
  }

  update(data: any) {
    const headers = { 'content-type': 'application/json' };
    const body = JSON.stringify(data);
    // console.log(data);
    return this.http.put(`${this.url}/item/${data.id}`, data, { headers });
  }


}
