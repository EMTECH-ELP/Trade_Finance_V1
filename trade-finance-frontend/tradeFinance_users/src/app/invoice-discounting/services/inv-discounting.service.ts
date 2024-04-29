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
    const url = `${environment.invUrl}/endpoint`;
    return this.http.post<any>(url, data);   //Replace with correct endpoint
  }

  // Implement other methods for other endpoints...
}

