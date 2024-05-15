import { Injectable } from "@angular/core";
import {
  HttpClient,
  HttpErrorResponse,
  HttpHeaders,
  HttpParams,
} from "@angular/common/http";
import {
  BehaviorSubject,
  catchError,
  map,
  Observable,
  of,
  throwError,
} from "rxjs";

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
// /auth/signin
export class AuthService {

  private authUrl = environment.authUrl;
  resetUrl: any;
  hasLoggedIn: any;
 
  constructor(private http: HttpClient, private router: Router, private mockDataService: MockSessionService) {}

  headers = new HttpHeaders().set("Content-Type", "application/json");
  isFirstLogin(): boolean {
    if (!this.hasLoggedIn) {
      this.hasLoggedIn = true;
      return true;
    }
    return false;
  }

  // login(): Observable<any> {
  //   return this.mockDataService.getSessionData().pipe(
  //     map((sessionData: any) => {

        // Use the session data in your authentication logic

      //   const mockedResponse = {
      //     body: {
      //       statusCode: 200,
      //       entity: sessionData.entity, // Assuming 'entity' is the key in your session data
      //       message: sessionData.message || 'Mocked authentication successful'
      //     }
      //   };

      //   return mockedResponse;
      // }),
      // catchError((error: any) => {
        // Handle error loading session data (e.g., file not found)
  //       console.error('Error loading session data:', error);
  //       return of({
  //         body: {
  //           statusCode: 500, // Adjust the status code as needed
  //           message: 'Error loading session data'
  //         }
  //       });
  //     })
  //   );
  // }
  

// Uncomment the code below when consuming endpoints. Then comment out the above,from login to catch error
  
  login(data: any): Observable<any> {
    // const url = `${this.authUrl}/login`;
    // const data = { email, password };
    // const headers = new HttpHeaders().set('Content-Type', 'application/json');

    let CREATE_URL = `${environment.authUrl}/api/v1/auth/login`;
    return this.http
      .post(CREATE_URL, data, {
        observe: "response",
        headers: this.headers,
        withCredentials: true,
      })
      .pipe(
        map((res) => {

          return res || {};
        })
      );
  }

  validateOTP(data: any): Observable<any> {
    const OTP_URL = `${environment.OTPUrl}/api/v1/auth/validateOtp`;

    return this.http.post<any>(OTP_URL, data, {
      observe: "response",
      headers: this.headers,
      withCredentials: true,
    })
    .pipe(
      map((res) => {
        console.log("otp service", res)
        return res || {};
      }));
  }

  resetPassword(resetPasswordDetails): Observable<{ message: string }> {
    const resetPasswordUrl = `${environment.resetUrl}/auth/resetPassword`;

    return this.http.post<{ message: string }>(
      resetPasswordUrl,
      resetPasswordDetails
    );
  }



  // public  resetPassword(resetPasswordDetails: any): Observable< {
  //   entity: boolean;
  //   statusCode: number;
  //   body: any; message: string }>  {
  //   const resetPasswordUrl = `${environment.resetUrl}/auth/resetPassword`;

  //   return this.http.post<any>{ entity: boolean; statusCode: number; body: any; message: string;}>(
  //     resetPasswordUrl,
  //     resetPasswordDetails
  //   );
  //   } 
    
  
  forgotPassword(email): Observable<any> {
    const resetPasswordUrl = `${environment.authUrl}/soa/users/forgot-password`;

    return this.http.post<any>(resetPasswordUrl, email);
  }


  refreshAccessToken(refreshToken: string): Observable<any> {
    // Endpoint URL for refreshing the access token
    const REFRESH_URL = `${environment.authUrl}/api/v1/auth/refreshtoken`;

    console.log("Checking for: ", refreshToken)

    let refreshTokenReq ={refreshToken: refreshToken} 

    return this.http.post<any>(REFRESH_URL, refreshTokenReq);
  }

  logout(refreshToken: string): Observable<any> {
    const LOGOUT_URL = `${environment.authUrl}/api/v1/auth/logout`;

    // Define request parameters including the refresh token
    const requestParams = new HttpParams().set('refreshToken', refreshToken);

    // Make the PUT request to log out using the refresh token
    return this.http.put<any>(LOGOUT_URL, {}, {params: requestParams });
  }






  // Error handling
  errorMgmt(error: HttpErrorResponse) {
    let errorMessage = "";
    if (error.error instanceof ErrorEvent) {
      // Get client-side error
      errorMessage = error.error.message;
    } else {
      // Get server-side error
      errorMessage = `${error.error.message}`;
    }
    return throwError(errorMessage);
  }
}
