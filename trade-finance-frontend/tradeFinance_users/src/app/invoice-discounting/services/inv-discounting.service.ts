import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';


@Injectable({
  providedIn: 'root'
})
export class InvDiscountingService {
  invUrl: any;

 
 

  constructor(private http: HttpClient) { }

  
   
 
  public postData(data: any): Observable<any> {
    const url = `${environment.invUrl}/invoices`;
    return this.http.post<any>(url, data);               //Replace with correct endpoint
  }

  getFormData(): Observable<any> {
    return this.http.get<any>('api/formdata'); // Replace 'api/formdata' with your backend endpoint . Fetch data
  }

  public submitForm(data: any): Observable<any> {
    const url = `${environment.saveUrl}/repayment`;
    return this.http.post<any>(url, data);               //Saving repayment details
  }
  // Implement other methods for other endpoints...
}

