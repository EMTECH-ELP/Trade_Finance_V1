import { Injectable,Inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, forkJoin } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { environment } from 'src/environments/environment';



@Injectable({
  providedIn: 'root'
})
export class InvDiscountingService {


  invUrl: any;
  private formData: any;
  forms: any;

  // setFormData(data: any) {
  //   this.formData = data;
  // }

  // getFormData() {
  //   return this.formData;
  // }


  constructor(
    private http: HttpClient) { }

  
  //   public create invoicediscounting(invoicediscountinData: any): Observable<any>{
  //   const url = `${environment.apiUrl}/create invoice discounting`;
  //   return this.httpClient.post<any>(invUr, invoicediscountinData);
  // }
   


  public postAllFormDetails(formData: any): Observable<any> {
    const postApplicantDetails = this.postApplicantDetails(formData);
    const postInvoiceDetails = this.postInvoiceDetails(formData);
    const postData = this.postData(formData);

    return forkJoin({
      applicantResponse: postApplicantDetails,
      invoiceResponse: postInvoiceDetails,
      dataResponse: postData
    }).pipe(
      catchError(error => {
        // Handle errors here
        console.error('Error occurred during form submission:', error);
        throw error;
      })
    );
  }

  public  postApplicantDetails(data: any): Observable<any> {
    const url = `${environment.invUrl}/applicants/create`;
    return this.http.post<any>(url, data);
  }

  public  postInvoiceDetails(data: any): Observable<any> {
    const url = `${environment.invUrl}/invoices/create`;
    return this.http.post<any>(url, data);
  }

  public postData(data: any): Observable<any> {
    const url = `${environment.invUrl}/fundings/create`;
    return this.http.post<any>(url, data);
  }

  // public  postapplicantDetails(data: any): Observable<any> {      //Creating Invoice discounting form
  //   const url = `${environment.invUrl}/applicants/create`;
  //   return this.http.post<any>(url, data);   
  // }
  // public   postinvoiceDetails(data: any): Observable<any> {      //Creating Invoice discounting form
  //   const url = `${environment.invUrl}/invoices/create`;
  //   return this.http.post<any>(url, data);   
  // }

 
  // public postData(data: any): Observable<any> {      //Posting funding details
  //   const url = `${environment.invUrl}/fundings/create`;
  //   return this.http.post<any>(url, data);
  // }

  public getAllForms(): Observable<any> {
    const url = `${environment.invUrl}/invoices/list`;     //FETCH FORMS
    return this.http.get<any>(url)
  }

  public submitForm(data: any): Observable<any> {
    const url = `${environment.saveUrl}/repayment`;
    return this.http.post<any>(url, data);               //Saving repayment details
  }

  getData(url:string):Observable<any>{
      return this.http.get(url)               //View invoice by Id
  }

}



