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
  modifyBill: any;

  
  
  constructor(private httpClient: HttpClient) { }

  //creating new bill
  // public createBill(billData: any, accountNumber :any): Observable<any>{
  //   const url = `${environment.billApiUrl}/api/v1/bills/create`;
  //   return this.httpClient.post<any>(url, billData,{ headers: { 'Content-Type': 'application/json' } });
  // }
  // 

    public createBill(data: any): Observable<any> {      
      const url = `${environment.billApiUrl}/api/v1/bills/create`;
      return this.httpClient.post<any>(url, data);   
 
  }
  public billStatus(billData: any): Observable<any>{
    const url = `${environment.billApiUrl}/api/v1/bills/status/{status}`;
    return this.httpClient.get<any>(url,  billData);
  }
  public returnForReview(billData: any): Observable<any>{
    const url = `${environment.billApiUrl}/api/v1/bills/returned-for-review`;
    return this.httpClient.get<any>(url,  billData);
  }
  public returnForApproval(billData: any): Observable<any>{
    const url = `${environment.billApiUrl}/api/v1/bills/returned-for-approval`;
    return this.httpClient.get<any>(url,  billData);
  }

 public rejectedBill(billData: any): Observable<any>{
    const url = `${environment.billApiUrl}/api/v1/bills/rejected`;
    return this.httpClient.get<any>(url,  billData);
  }
  public pendingBill(billData: any): Observable<any>{
    const url = `${environment.billApiUrl}/api/v1/bills/pending`;
    return this.httpClient.get<any>(url,  billData);
  }
  public approvedBill(billData: any): Observable<any>{
    const url = `${environment.billApiUrl}/api/v1/bills/approved`;
    return this.httpClient.get<any>(url,  billData);
  }
  public allBills(billData: any): Observable<any>{
    const url = `${environment.billApiUrl}/api/v1/bills/all`;
    return this.httpClient.get<any>(url,  billData);
  }
  public getBill(billData: any): Observable<any>{
    const url = `${environment.billApiUrl}/api/v1/bills/{billNumber}`;
    return this.httpClient.get<any>(url,  billData);
  }
  public getBillNumber(billData: any): Observable<any>{
    const url = `${environment.billApiUrl}/api/v1/bills/{billNumber}`;
    return this.httpClient.put<any>(url,  billData);
  }
  public deleteBill(billData: any): Observable<any>{
    const url = `${environment.billApiUrl}/api/v1/bills/{billNumber}`;
    return this.httpClient.delete<any>(url,  billData);
  }

  public rejectBill(billData: any): Observable<any>{
    const url = `${environment.billApiUrl}/api/v1/bills/{billNumber}/reject`;
    return this.httpClient.put<any>(url,  billData);
  }
  public approveBill(billData: any): Observable<any>{
    const url = `${environment.billApiUrl}/api/v1/bills/{billNumber}/approve`;
    return this.httpClient.put<any>(url,  billData);
  }
   public patchSearchForm(data: any): void {
     this.searchForm.patchValue({
       billNumber: data.billNumber,
       billType: data.billType,
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
 
 
