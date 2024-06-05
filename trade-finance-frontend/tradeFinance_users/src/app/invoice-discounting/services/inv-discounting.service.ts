import { Injectable,Inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError} from 'rxjs';
import { catchError } from 'rxjs/operators';
import { environment } from 'src/environments/environment';

import { FormGroup } from '@angular/forms';


@Injectable({
  providedIn: 'root'
})
export class InvDiscountingService {

  private formData: any;
  forms: any;


  private invUrl = 'http://192.168.89.247:9001';

  constructor(private http: HttpClient) {}

   // Method to post applicationForm details

  //  public  postApplicantDetails(data: any): Observable<any> {
  //   const url = `${environment.invUrl}/applicants/create`;
  //   return this.http.post<any>(url, data);
  // }
  public postApplicantDetails(data: any): Observable<any> {
    const url = `${environment.invUrl}/applicants/create`;
    return this.http.post<any>(url, data);
  }
  
  private handleError<T>(operation = 'operation', result?: T): (error: any, caught: Observable<T>) => Observable<T> {
    return (error: any, caught: Observable<T>): Observable<T> => {
      console.error(`${operation}: ${error.message}`); // Log the error
      return throwError(error);
    };
  }
  public  postInvoiceDetails(data: any): Observable<any> {
    const url = `${environment.invUrl}/invoices/create`;
    return this.http.post<any>(url, data);
  }

  public postFundingDetails(data: any): Observable<any> {
    const url = `${environment.invUrl}/fundings/create`;
    return this.http.post<any>(url, data);
  }
  
  public postData(data: any): Observable<any> {      //Posting repayment details
    const url = `${environment.saveUrl}/repayment`;
    return this.http.post<any>(url, data);
  }

  // Method to fetch all forms

  public getAllForms(): Observable<any> {       //FETCH FORMS
    const url = `${environment.invUrl}/invoices/list`;     
    return this.http.get<any>(url)
  }
 // public getAllForms(): Observable<any> {
  //   const url = `${this.invUrl}/invoices/list`;
  //   return this.http.get<any>(url).pipe(
  //     catchError(this.handleError('getAllForms', []))
  //   );
  // }
 
//Full form submission.
public sendData(invoiceData: any, accountNumber :any): Observable<any> {
  const url = `${environment.createInvoiceForm}/api/v1/LC/create?accountNumber=${accountNumber}`;
  return this.http.post<any>(url, invoiceData, { headers: { 'Content-Type': 'application/json' } });
}

 //View invoice by Id
  getData(url:string):Observable<any>{
      return this.http.get(url)              
  }

}



