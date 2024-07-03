import { Injectable,Inject } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
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
  // private invoiceforms: form[] = [];
  // private countrieslistUrl = 'http://192.168.88.91:8187/api/v1/Country/all'; 
  // private getCountryByNameUrl = 'http://192.168.88.91:8187/api/v1/Country/getByName';
  // private invUrl = 'http://192.168.89.160:8085';
  private invUrl = environment.invUrl;
  private baseUrl = environment.invUrl;
  constructor(private http: HttpClient) {}

 
  sendData(items: any): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.post<any>(`${environment.invUrl}/applicant/invoiceDetails`, items, { headers });
  }

  public getAllForms(): Observable<any> {       //FETCH FORMS
    const url = `${environment.invUrl}/applicant/Invoice`;     
    return this.http.get<any>(url)
    
  }
 

  // Method to fetch data by Id 
  getDataById(accountNumber: any): Observable<any> {
    const url = `${environment.invUrl}/applicant/accountNumber/${accountNumber}`;
    return this.http.get<any>(url).pipe(
      catchError((error: HttpErrorResponse) => {
        return throwError(error);
      })
    );
  }
//applicant/nationalId/{nationalId}
  getCountries(): Observable<string[]> {
    const url = `${environment.invUrl}/api/v1/Country/all`;  
    return this.http.get<string[]>(environment.getCountry_CityUrl).pipe(
      catchError((error: any) => {
        console.log('Error fetching countries:', error);
        // Return an empty array or a default value as needed
        return of([]);
      })
    );
  }
  

 getCitiesByCountry(countryName: string): Observable<any[]> {
  const url = `${environment.invUrl}/api/v1/Country/getByName'`;  
    return this.http.get<any[]>(`${environment.getCountry_CityUrl}/${countryName}`);
  }
  
  getDataBasedOnDiscountRate(discountRate: number): Observable<any> {
    const url = `${environment.invUrl}/api/fundings/${discountRate}`;
    return this.http.get<any>(url).pipe(
      catchError((error: any) => {
        console.error('Error fetching data:', error);
        throw error; // Rethrow the error or handle as needed
      })
    );
  }
  // Approve by Invoice Number.
  approveInvoice(invoiceNumber: string): Observable<any> {
    const url = `${this.invUrl}/api/invoices/approve/${invoiceNumber}`; // Correctly interpolate the invoiceNumber
    return this.http.put(url, { invoiceNumber });
  }
  updateApplicantStatus(id: number, status: string): Observable<any> {
    const url = `${this.invUrl}/applicant/${id}`;
    return this.http.put(url, { status });
  }
  uploadDocuments(formData: FormData): Observable<any> {
    return this.http.post(this.uploadUrl, formData);
  }
  saveFundingData(){

  }

  public postPaymentData(data: any): Observable<any> {      //Posting repayment details
    const url = `${environment.saveUrl}/repayment`;
    return this.http.post<any>(url, data);
  }
}


