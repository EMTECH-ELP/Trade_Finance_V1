import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';


@Injectable({
  providedIn: 'root'
})
export class InvDiscountingService {
  getFormData() {
    throw new Error('Method not implemented.');
  }

  invUrl: any;



  constructor(
    private http: HttpClient) { }

  
  //   public create invoicediscounting(invoicediscountinData: any): Observable<any>{
  //   const url = `${environment.apiUrl}/create invoice discounting`;
  //   return this.httpClient.post<any>(invUr, invoicediscountinData);
  // }
   




  public postData(data: any): Observable<any> {      //Creating Invoice discounting form
    const url = `${environment.invUrl}/invoices/create`;
    return this.http.post<any>(url, data);   //Replace with correct endpoint
  }

  public getAllForms(): Observable<any> {
    const url = `${environment.getInvUrl}/invoices/list`;     //FETCH FORMS
    return this.http.get<any>(url)
  }

  public submitForm(data: any): Observable<any> {
    const url = `${environment.saveUrl}/repayment`;
    return this.http.post<any>(url, data);               //Saving repayment details
  }

}



