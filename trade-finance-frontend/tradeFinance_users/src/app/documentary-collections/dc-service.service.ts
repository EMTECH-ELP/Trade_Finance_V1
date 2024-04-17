import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class DcServiceService {
  private apiUrl = 'http://localhost:3000/customers'; // To replace this with backend API endpoint
  constructor(private http: HttpClient) { }


  // Method to fetch customer details based on account number
  getCustomerDetails(accountNumber: string): Observable<any> {
    const url = `${this.apiUrl}/accountNumber/${accountNumber}`;
    return this.http.get<any>(url);
  }

  // To add more API call methods as needed
}
