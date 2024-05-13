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
  modifyLc: any;

  constructor(private httpClient: HttpClient) { }
//Creating a new LC
  public createLc(lcData: any): Observable<any>{
    const url = `${environment.createApiUrl}/api/v1/LC/create`;
    return this.httpClient.post<any>(url, lcData, { headers: { 'Content-Type': 'application/json'}});
  }

  public transferLc(): Observable<any>{
    const url = `${environment.createApiUrl}/api/v1/LC/transfer`;
    return this.httpClient.get<any>(url);
  }
  public getAllLCs(): Observable<any> {
    const url = `${environment.getUrl}/api/v1/LC/all`;
return this.httpClient.get<any>(url)
  }
  public getLcDetailsByLcNumber() : Observable<any> {
    const url = `${environment.getlcNoUrl}/api/v1/LC/lcNumber/{lcNumber}`;    //lcNumber lookup
    return this.httpClient.get<any>(url)
  }
  // public ModifyLc(lcData: any) : Observable<any> {
  //   const url = `${environment.putUrl}/api/v1/LC/lcNumber/{lcNumber}`;         //put method to modify Lc details
  //   return this.httpClient.put<any>(url, lcData)
  // }
 }
