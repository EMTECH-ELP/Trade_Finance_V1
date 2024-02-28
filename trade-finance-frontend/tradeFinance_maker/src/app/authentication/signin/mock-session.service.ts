import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MockSessionService {

  constructor(private http: HttpClient) {}

  getSessionData(): Observable<any> {
    const sessionFileUrl = 'assets/session.txt'; // Adjust the path based on your project structure

    // Simulate reading the file content
    return this.http.get(sessionFileUrl);
  }
}
