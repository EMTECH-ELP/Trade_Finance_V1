import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
 import { Observable } from 'rxjs';
import { Data } from '@angular/router';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class SearchService {

  constructor(private http: HttpClient) { }

  public deleteInvoice(id: string): Observable<any> {
    const url = `${environment.deleteurl}/invoice/${id}`;
    return this.http.delete<any>(url);
  }
  // search(query: string): Observable<any> {
  //   return this.http.get(`API_ENDPOINT?q=${query}`);
  // }
}
