import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class BillsService {
  applicationForm: any;
  searchForm: any;
  accountNumber: any;
  dialogRef: any;

  constructor(private httpClient: HttpClient) { }

  public createBill(billData: any): Observable<any>{
    const url = `${environment.apiUrl}/api/v1/bill/create`;
    return this.httpClient.post<any>(url, billData);
  }

  public viewbill(): Observable<any>{
    const url = `${environment.apiUrl}/api/v1/bill/view`;
    return this.httpClient.get<any>(url);
  }
 }

 

 
