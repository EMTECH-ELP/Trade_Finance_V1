import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs'

;@Injectable({
  providedIn: 'root'
})
export class UsersactService {

  
  private apiUrl = 'http://localhost:3000/users'; // Replace with your actual API URL

  constructor(private http: HttpClient) {}

  getUsers(): Observable<any[]> {
    // Replace with actual HTTP request in a real-world application
    return this.http.get<any[]>(this.apiUrl);
  }
}
