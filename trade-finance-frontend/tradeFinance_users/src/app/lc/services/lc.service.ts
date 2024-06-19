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
  public createLc(lcData: any, accountNumber :any): Observable<any> {
    const url = `${environment.createApiUrl}/api/v1/LC/create?accountNumber=${accountNumber}`;
    return this.httpClient.post<any>(url, lcData, { headers: { 'Content-Type': 'application/json' } });
  }
  public transferLc(data: any): Observable<any> {
    const url = `${environment.transferApiUrl}/api/v1/LC/transfer/{lcNumber}`;
    return this.httpClient.put<any>(url, data);
  }
  public getAllLCs(): Observable<any> {
    const url = `${environment.getUrl}/api/v1/LC/all`;
    return this.httpClient.get<any>(url)
  }
  public getLcDetailsByLcNumber(): Observable<any> {
    const url = `${environment.getlcNoUrl}/api/v1/LC/lcNumber/{lcNumber}`;    //lcNumber lookup
    return this.httpClient.get<any>(url)
  }
  public ModifyLc(lcData: any): Observable<any> {
    const url = `${environment.putUrl}/api/v1/LC/lcNumber/{lcNumber}`;         //put method to modify Lc details
    return this.httpClient.put<any>(url, lcData)
  }
  public approveLc(lcData: any): Observable<any> {
    const url= '${environment.approveLcApiUrl}/api/v1/LC/approve';
    return this.httpClient.put<any>(url, lcData)
  }
  public deleteLC(lcData: any): Observable<any> {
    const url = '${environment.deleteLcApiUrl}/api/v1/LC/letterOfCredit/{lcNumber}';
    return this.httpClient.delete<any>(url, lcData)
  }


  //shipmentTermsApi
  public getAllShipmentTerms(): Observable<any> {
    const url = `${environment.shipmentTermsApi}/api/v1/shipment_terms`;
    return this.httpClient.get<any>(url)
  }

  // generate LC MT Message
  public getLcMT(): Observable<any> {
    const url =`${environment.generateMtUrl}/generate-mt700/{lcNumber}`;
    return this.httpClient.get<any>(url)
  }
  public patchSearchForm(data: any): void {
    this.searchForm.patchValue({
      lcNumber: data.lcNumber,
      lcType: data.lcType,
      applicableRules: data.applicableRules,
      currencyCode: data.currencyCode,
      phoneNumber: data.phoneNumber,
      amount: data. amount,
      expiryDate: data.expiryDate,
      chargesBornlcNumber: data.chargesBornlcNumber,
      negotiationPeriod: data.negotiationPeriod,
      issueDate: data.issueDate,
      tenor: data.tenor,
      transferable: data.transferable,
      confirm: data.confirm,
      advise: data.advise,
    });
  }

  public emitApplicationForm(data: any): void {
    // Emit an event with application form details
    this.applicationForm.emit(data);
  }

  public closeDialog(): void {
    // Close the dialog
    this.dialogRef.close();
  }
}
