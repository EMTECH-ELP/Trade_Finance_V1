import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.prod';
// import { url } from 'inspector';

@Injectable({
  providedIn: 'root'
})
export class UserManagementService {

  private privilegeUrl = environment.privilegeApiUrl;; // Replace with your backend API URL

  constructor(private http: HttpClient) { }


  submitPrivilege(privilegeData: any): Observable<any> {
    const url = `${environment.privilegeApiUrl}/api/privileges`
    return this.http.post<any>(url, privilegeData);
  }
  submitRole(privilegeData: any): Observable<any> {
    const url = `${environment.privilegeApiUrl}/api/roles`
    return this.http.post<any>(url, privilegeData);
  }

  getPrivileges(): Observable<any> {
    const url = `${environment.privilegeApiUrl}/api/privileges`;
    return this.http.get<any>(url);
  }


  getRoles():Observable<any> {
    const url = `${environment.privilegeApiUrl}/api/roles`;
    return this.http.get<any>(url);
  }
}
