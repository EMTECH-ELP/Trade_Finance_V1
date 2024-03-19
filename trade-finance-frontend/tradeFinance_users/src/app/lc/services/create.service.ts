import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CreateService {
  private _url = 'http://192.168.89.101:8085/LC'; // URL to which we will post the data

  constructor(private http: HttpClient) { }  

  submit(formData: any): Observable<any> {
    return this.http.post<any>(this._url, formData);
  }
}
