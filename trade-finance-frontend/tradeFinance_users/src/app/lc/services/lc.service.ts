import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class LcService {
  applicationForm: any;
  searchForm: any;
  accountNumber: any;
  dialogRef: any;

  constructor(private httpClient: HttpClient) { }

  public createLc(lcData: any): Observable<any>{
    const url = `${environment.apiUrl}/api/v1/LC/create`;
    return this.httpClient.post<any>(url, lcData);
  }

  public transferLc(): Observable<any>{
    const url = `${environment.apiUrl}/api/v1/LC/transfer`;
    return this.httpClient.get<any>(url);
  }
  
 }
