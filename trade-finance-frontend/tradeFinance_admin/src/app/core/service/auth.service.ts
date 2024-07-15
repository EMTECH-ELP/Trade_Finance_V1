import { Injectable } from "@angular/core";
import {
  HttpClient,
  HttpErrorResponse,
  HttpHeaders,
  HttpParams,
} from "@angular/common/http";
import { BehaviorSubject, catchError, map, Observable, of, throwError } from "rxjs";

import { Auth } from "../models/auth";
import { environment } from "src/environments/environment.prod";

import { Router } from "@angular/router";
import { MockSessionService } from "src/app/authentication/signin/mock-session.service";

const httpOptions = {
  headers: new HttpHeaders({ "Content-Type": "application/json" }),
  withCredentials: true,
};

@Injectable({
  providedIn: "root",
})
export class AuthService {
  private userurl = environment.userUrl;
  private httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
  };

  constructor(
    private http: HttpClient, 
    private router: Router, 
    private mockDataService: MockSessionService
  ) {}

  headers = new HttpHeaders().set("Content-Type", "application/json");

  login(data: any): Observable<any> {
    let CREATE_URL = `${environment.baseUrlAdmin}/api/v1/auth/login`;
    return this.http.post(CREATE_URL, data, {
      observe: "response",
      headers: this.headers,
      withCredentials: true,
    }).pipe(
      map((res) => {
        console.log("service login", res);
        return res || {};
      }),
      catchError(this.errorMgmt)
    );
  }

  validateOTP(data: any): Observable<any> {
    const OTP_URL = `${environment.baseUrlAdmin}/api/v1/auth/validateOtp`;
    return this.http.post<any>(OTP_URL, data, {
      observe: "response",
      headers: this.headers,
      withCredentials: true,
    }).pipe(
      map((res) => {
        console.log("otp service", res);
        return res || {};
      }),
      catchError(this.errorMgmt)
    );
  }

  resetPassword(resetPasswordDetails): Observable<{ message: string }> {
    const resetPasswordUrl = `${environment.baseUrlAdmin}/auth/resetPassword`;
    return this.http.post<{ message: string }>(resetPasswordUrl, resetPasswordDetails)
      .pipe(catchError(this.errorMgmt));
  }

  forgotPassword(email): Observable<any> {
    const resetPasswordUrl = `${environment.baseUrlAdmin}/soa/users/forgot-password`;
    return this.http.post<any>(resetPasswordUrl, email)
      .pipe(catchError(this.errorMgmt));
  }

  refreshAccessToken(refreshToken: string): Observable<any> {
    const REFRESH_URL = `${environment.baseUrlAdmin}/api/v1/auth/refreshtoken`;
    let refreshTokenReq = { refreshToken: refreshToken };
    return this.http.post<any>(REFRESH_URL, refreshTokenReq)
      .pipe(catchError(this.errorMgmt));
  }

  logout(refreshToken: string): Observable<any> {
    const LOGOUT_URL = `${environment.baseUrlAdmin}/api/v1/auth/logout`;
    const requestParams = new HttpParams().set('refreshToken', refreshToken);
    return this.http.put<any>(LOGOUT_URL, {}, { params: requestParams })
      .pipe(catchError(this.errorMgmt));
  }

  addNewUser(user: any): Observable<any> {
    return this.http.post<any>(`${environment.userUrl}/auth/admin/addNewUser`, user, this.httpOptions)
      .pipe(catchError(this.errorMgmt));
  }

  getAllUsers(): Observable<any> {
    return this.http.get<any>(`${environment.userUrl}/auth/admin/getAllUsers`)
      .pipe(catchError(this.errorMgmt));
  }

  // Improved error handling
  errorMgmt(error: HttpErrorResponse) {
    let errorMessage = 'Unknown error!';
    if (error.error instanceof ErrorEvent) {
      // Client-side error
      errorMessage = error.error.message;
    } else {
      // Server-side error
      errorMessage = error.message || error.statusText || 'Server error';
    }
    console.error('Error:', errorMessage);
    return throwError(errorMessage);
  }
}
