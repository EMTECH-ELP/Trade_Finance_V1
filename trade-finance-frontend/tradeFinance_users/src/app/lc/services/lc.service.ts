import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class LcService {
  
  
  
  constructor(private httpClient: HttpClient) { }



  public createLc(lcData: any): Observable<any>{
    const url = `${environment.apiUrl}/api/v1/LC/create`;
    return this.httpClient.post<any>(url, lcData);
  }

  // public getAllLCs(): Observable<any>{
  //   const url = `${environment.apiUrl}/api/v1/LC/viewAll`;
  //   return this.httpClient.get<any>(url);
  // }
  public transferLc(): Observable<any>{
    const url = `${environment.apiUrl}/api/v1/LC/transfer`;  //To confirm & replace
    return this.httpClient.get<any>(url);
  }
  public getFormDetailsByAccountNumber(accountNumber: string): Observable<any> {
    const url = `${environment.getApiUrl}/api/account/account-details`; // Using environment.getApiUrl for GET
    return this.httpClient.get<any>(url);
  }
  
}
