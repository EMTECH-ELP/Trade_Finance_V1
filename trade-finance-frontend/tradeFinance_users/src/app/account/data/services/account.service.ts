import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { environment } from "src/environments/environment.prod";

import { User } from "../types/user";

@Injectable({
  providedIn: "root",
})
export class AccountService {
  constructor(private http: HttpClient) {}

 
  // /soa/otherusers/find/{id}
  getUserById(userId): Observable<User> {
    const getUserByIdUrl = `${environment.baseUrlAdmin}/soa/otherusers/find/${userId}`;

    return this.http.get<User>(getUserByIdUrl);
  }


  updatePassword(user): Observable<{ message: string }> {
    const updatePasswordUrl = `${environment.baseUrlAdmin}/soa/otherusers/changepassword`;

    return this.http.put<{ message: string }>(updatePasswordUrl, user);
  }

  updateProfile(profileBody):Observable<{message:string}>{
    const updatePasswordUrl = `${environment.baseUrlAdmin}/soa/otherusers/updateprofile`;

    return this.http.put<{message: string}>(updatePasswordUrl, profileBody)
  }
}
