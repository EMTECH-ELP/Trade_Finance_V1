import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class TransferService {
  _url = '';
  constructor(private _http: HttpClient) { }

  transfer(userData: any){
    return this._http.post<any>(this._url, userData)
  }
 
}
