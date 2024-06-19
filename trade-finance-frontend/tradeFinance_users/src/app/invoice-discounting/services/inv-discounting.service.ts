import { Injectable,Inject } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError} from 'rxjs';
import { catchError,map, tap } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { of } from 'rxjs';
import { FormGroup } from '@angular/forms';


@Injectable({
  providedIn: 'root'
})
export class InvDiscountingService {
  [x: string]: any;

  private formData: any;
  forms: any;
  applicationForm: any;
  selectedCountry:any;

  private countrieslistUrl = 'http://192.168.88.91:8187/api/v1/Country/all'; 
  private getCountryByNameUrl = 'http://192.168.88.91:8187/api/v1/Country/getByName';
  // private invUrl = 'http://192.168.89.160:8085';
  private invUrl = environment.invUrl;
  constructor(private http: HttpClient) {}

   // Method to post Full details
  //  sendData(applicationForm: any) {
  //   // Check if applicationForm is defined and is an object
  //   if (!applicationForm || typeof applicationForm!== 'object') {
  //     throw new Error('Invalid applicationForm data');
  //   }

  //   // Convert applicationForm to JSON string
  //   const jsonString = JSON.stringify(applicationForm);

  //   // Set Content-Type header explicitly
  //   const headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  //   // Make the HTTP POST request
  //   return this.http.post(this.invUrl, jsonString, { headers });
  // }
  //  public  sendData(body: any): Observable<any> {
  //   const headers = { 'Content-Type': 'application/json' };
  //   // const url = `${environment.invUrl}/applicant/invoiceDetails`;
  //   return this.http.post('http://192.168.89.160:8085/applicant/invoiceDetails', body, { headers });
  // }
  // public postApplicantDetails(data: any): Observable<any> {
  //   const url = `${environment.invUrl}/applicants/create`;
  //   return this.http.post<any>(url, data);
  // }
  sendData(items: any): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.post<any>(`${environment.invUrl}/applicant/invoiceDetails`, items, { headers });
  }
  // private handleError<T>(operation = 'operation', result?: T): (error: any, caught: Observable<T>) => Observable<T> {
  //   return (error: any, caught: Observable<T>): Observable<T> => {
  //     console.error(`${operation}: ${error.message}`); // Log the error
  //     return throwError(error);
  //   };
  // }
  // public  postInvoiceDetails(data: any): Observable<any> {
  //   const url = `${environment.invUrl}/invoices/create`;
  //   return this.http.post<any>(url, data);
  // }

  // public postFundingDetails(data: any): Observable<any> {
  //   const url = `${environment.invUrl}/fundings/create`;
  //   return this.http.post<any>(url, data);
  // }
  


  // Method to fetch all forms

  public getAllForms(): Observable<any> {       //FETCH FORMS
    const url = `${environment.invUrl}/applicant/Invoice`;     
    return this.http.get<any>(url)
    
  }
 // public getAllForms(): Observable<any> {
  //   const url = `${this.invUrl}/applicant/Invoice`;
  //   return this.http.get<any>(url).pipe(
  //     catchError(this.handleError('getAllForms', []))
  //   );
  // }
 
//Full form submission.
// public sendData(invoiceData: any, accountNumber :any): Observable<any> {
//   const url = `${environment.createInvoiceForm}/api/v1/LC/create?accountNumber=${accountNumber}`;
//   return this.http.post<any>(url, invoiceData, { headers: { 'Content-Type': 'application/json' } });
// }

 //View invoice by Id
 getDataById(id: number): Observable<any> {
  console.log('Data received:', id);
  return this.http.get<any>(`${environment.invUrl}/applicant/${id}`);
}


  getCountries(): Observable<string[]> {
    return this.http.get<string[]>(this.countrieslistUrl).pipe(
      catchError((error: any) => {
        console.log('Error fetching countries:', error);
        // Return an empty array or a default value as needed
        return of([]);
      })
    );
  }
  

 getCitiesByCountry(countryName: string): Observable<any[]> {
    return this.http.get<any[]>(`${this.getCountryByNameUrl}/${countryName}`);
  }
  
  getDataBasedOnDiscountRate(discountRate: number): Observable<any> {
    // Replace 'your-backend-api-url' with your actual backend API endpoint
    const url = `your-backend-api-url?discountRate=${discountRate}`;

    return this.http.get<any>(url)
      .pipe(
        catchError((error: any) => {
          console.error('Error fetching data:', error);
          throw error; // Rethrow the error or handle as needed
        })
      );
  }

  saveFundingData(){

  }

  public postPaymentData(data: any): Observable<any> {      //Posting repayment details
    const url = `${environment.saveUrl}/repayment`;
    return this.http.post<any>(url, data);
  }
}


